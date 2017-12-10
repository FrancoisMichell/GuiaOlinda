package ufrpe.mobile.guiaolinda.GUI.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.GUI.activities.EventActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.Inicio;
import ufrpe.mobile.guiaolinda.GUI.activities.MapsActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.SobreActivity;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Carnaval;

public class SeasonListFragment extends Fragment {
    public final String EVENT_ID = "EVENT_ID";
    private RecyclerView mEventRecyclerView;
    private EventAdapter mAdapter;
    private LocalLab localLab;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("carnaval");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        TextView v = view.findViewById(R.id.categoria_evento);
        v.setText("Blocos");

        mEventRecyclerView = view.findViewById(R.id.event_recycler_view);
        mEventRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        FloatingActionButton buttonTopo = view.findViewById(R.id.botaoEventoTopo);
        buttonTopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager lManager = (LinearLayoutManager) mEventRecyclerView.getLayoutManager();
                lManager.scrollToPositionWithOffset(0, 0);
            }
        });

        if (readFromFile().isEmpty() || readFromFile().equals("")) {
            gerarBlocos();
        } else {
            int id = 0;
            String[] aux = String.valueOf(readFromFile()).split("/n");
            if (localLab.getCarnavais().size() == 0) {
                for (String anAux : aux) {
                    String[] aux2 = anAux.split("#");
                    localLab.createCarnaval(id++, aux2[0], aux2[1], aux2[2], aux2[3]);
                }
            }
        }
        updateUI();
        return view;
    }

    private void gerarBlocos() {
        final ProgressDialog dialog = ProgressDialog.show(getContext(), "",
                "Loading...", true);
        dialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                geraBlocos();
                updateUI();
                dialog.dismiss();
            }
        }, 5000);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_eventos, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.home:
                intent = new Intent(getActivity(), Inicio.class);
                startActivity(intent);
                return true;

            case R.id.mapa:
                intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
                return true;

            case R.id.sobre:
                intent = new Intent(getActivity(), SobreActivity.class);
                startActivity(intent);
                return true;

            case R.id.atualizar:
                gerarBlocos();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.localLab = LocalLab.get();

        setHasOptionsMenu(true);
    }

    public void geraBlocos() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                localLab.flushCarnavais();
                int id = 0;
                ArrayList<String> aux;
                StringBuilder str = new StringBuilder();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    aux = new ArrayList<>();
                    for (int i = 0; i < ds.getChildrenCount(); i++) {
                        aux.add(ds.child(Integer.toString(i)).getValue().toString());
                        str.append(ds.child(Integer.toString(i)).getValue().toString()).append('#');
                    }
                    str.append("/n");
                    localLab.createCarnaval(id++, aux.get(0), aux.get(1), aux.get(2), aux.get(3));
                    aux.clear();
                }
                mAdapter.notifyDataSetChanged();
                writeToFile(str.toString(), getContext());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("carnaval.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile() {

        String ret = "";

        try {
            InputStream inputStream = getContext().openFileInput("carnaval.txt");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString;
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();

            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    private void updateUI() {
        List<Carnaval> blocos;
        blocos = localLab.getCarnavais();
        if (mAdapter == null) {
            mAdapter = new EventAdapter(blocos);
            mEventRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNomeTextView;
        private TextView mLocalTextView;
        private TextView mDataTextView;
        private TextView mHorarioTextView;

        private Carnaval mEvento;

        EventHolder(LayoutInflater inflater, ViewGroup parent) {
            //TODO alterar layout
            super(inflater.inflate(R.layout.list_item_evento, parent, false));
            itemView.setOnClickListener(this);

            //TODO alterar de evento para bloco
            mNomeTextView = itemView.findViewById(R.id.nome_evento);
            mLocalTextView = itemView.findViewById(R.id.local_evento);
            mDataTextView = itemView.findViewById(R.id.data_evento);
            mHorarioTextView = itemView.findViewById(R.id.horario_evento);
        }

        void bind(Carnaval bloco) {
            mEvento = bloco;
            mNomeTextView.setText(mEvento.getNome());
            mLocalTextView.setText(mEvento.getLocal());
            mDataTextView.setText(mEvento.getData());
            mHorarioTextView.setText(mEvento.getHorário());
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), EventActivity.class);
            intent.putExtra(EVENT_ID, mEvento.getId());
            startActivity(intent);
        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHolder> {
        private List<Carnaval> mblocos;

        EventAdapter(List<Carnaval> blocos) {
            mblocos = blocos;
        }

        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new EventHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position) {
            Carnaval bloco = mblocos.get(position);
            holder.bind(bloco);
        }

        @Override
        public int getItemCount() {
            return mblocos.size();
        }
    }
}