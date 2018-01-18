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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.GUI.activities.HomenageadosActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.InicioActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.MapsActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.SobreActivity;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Homenageados;

public class HomenageadosListFragment extends Fragment {
    public final String HOMENAGEADO_ID = "HOMENAGEADO_ID";
    private RecyclerView mEventRecyclerView;
    private HomenageadosAdapter mAdapter;
    private LocalLab localLab;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Homenageados");

    public HomenageadosListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homenageados_list, container, false);

        TextView v = view.findViewById(R.id.tela_homenageados);
        v.setText("Homenageados");

        mEventRecyclerView = view.findViewById(R.id.event_recycler_view);
        mEventRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        FloatingActionButton buttonTopo = view.findViewById(R.id.botaoEventoTopo);
        buttonTopo.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayoutManager lManager = (LinearLayoutManager) mEventRecyclerView.getLayoutManager();
                lManager.scrollToPositionWithOffset(0, 0);
            }
        });

        if (readFromFile().isEmpty() || readFromFile().equals("")) {
            gerarHomenageados();
        } else {
            int id = 0;
            String[] aux = String.valueOf(readFromFile()).split("/n");
            if (localLab.getHomenageados().size() == 0) {
                for (String anAux : aux) {
                    if(anAux.contains("/%")){
                        anAux = anAux.replaceAll("/%", "\n");
                    }
                    String[] aux2 = anAux.split("#");
                    localLab.createHomenageados(id++, aux2[0], aux2[1], aux2[2]);
                }
            }
        }
        updateUI();
        return view;
    }

    private void gerarHomenageados() {
        final ProgressDialog dialog = ProgressDialog.show(getContext(), "",
                "Loading...", true);
        dialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                geraHomenageados();
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
                intent = new Intent(getActivity(), InicioActivity.class);
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
                gerarHomenageados();
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

    public void geraHomenageados() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                localLab.flushHomenageados();
                int id = 0;
                ArrayList<String> aux;
                StringBuilder str = new StringBuilder();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    aux = new ArrayList<>();
                    for (int i = 0; i < ds.getChildrenCount(); i++) {
                        String data = ds.child(Integer.toString(i)).getValue().toString();
                        aux.add(data);
                        str.append(data.replaceAll("\n", "/%")).append('#');
                    }
                    str.append("/n");
                    localLab.createHomenageados(id++, aux.get(0), aux.get(1), aux.get(2));
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
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("homenageados.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile() {

        String ret = "";

        try {
            InputStream inputStream = getContext().openFileInput("homenageados.txt");

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
            Log.e("Homenageados activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("Homenageados activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    private void updateUI() {
        List<Homenageados> homenageados;
        homenageados = localLab.getHomenageados();
        if (mAdapter == null) {
            mAdapter = new HomenageadosAdapter(homenageados);
            mEventRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class HomenageadosHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mLocalImageView;
        private TextView mNomeTextView;

        private Homenageados mHomenageados;

        HomenageadosHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_homenageado, parent, false));
            itemView.setOnClickListener(this);

            mLocalImageView = itemView.findViewById(R.id.imagem_homenageado);
            mNomeTextView = itemView.findViewById(R.id.nome_homenageado);

        }

        void bind(Homenageados homenageados) {
            mHomenageados = homenageados;
            Picasso.with(getContext()).load(mHomenageados.getImagem()).into(mLocalImageView);
            mNomeTextView.setText(mHomenageados.getNomeHomenageados());

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), HomenageadosActivity.class);
            intent.putExtra(HOMENAGEADO_ID, mHomenageados.getHomenageados_Id());
            startActivity(intent);
        }
    }

    private class HomenageadosAdapter extends RecyclerView.Adapter<HomenageadosHolder> {
        private List<Homenageados> mHomenageados;

        HomenageadosAdapter(List<Homenageados> homenageados) {
            mHomenageados = homenageados;
        }

        @Override
        public HomenageadosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new HomenageadosHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(HomenageadosHolder holder, int position) {
            Homenageados homenageados = mHomenageados.get(position);
            holder.bind(homenageados);
        }

        @Override
        public int getItemCount() {
            return mHomenageados.size();
        }
    }
}