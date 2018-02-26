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
import android.widget.Toast;

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
import ufrpe.mobile.guiaolinda.GUI.activities.InicioActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.LocalPagerActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.MapsActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.SobreActivity;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Local;

public class LocalListFragment extends Fragment {
    private RecyclerView mLocalRecyclerView;
    private LocalAdapter mAdapter;
    private LocalLab localLab;

    private String categoria;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("masterSheet");

    public LocalListFragment(String tipo) {
        setCategoria(tipo);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_local_list, container, false);

        TextView v = view.findViewById(R.id.categoria);
        v.setText(String.format("%s", getCategoria()));

        mLocalRecyclerView = view.findViewById(R.id.local_recycler_view);
        mLocalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        FloatingActionButton buttonTopo = view.findViewById(R.id.botaoLocalTopo);
        buttonTopo.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayoutManager lManager = (LinearLayoutManager) mLocalRecyclerView.getLayoutManager();
                lManager.scrollToPositionWithOffset(0, 0);
            }
        });

        if (readFromFile().isEmpty() || readFromFile().equals("")) {
            gerarLocais();
        } else {
            int id = 0;
            String[] aux = String.valueOf(readFromFile()).split("/n");
            if (localLab.getEventos().size() == 0) {
                for (String anAux : aux) {
                    String[] aux2 = anAux.split("#");
                    localLab.createLocal(id++, aux2[0], aux2[1], aux2[2], aux2[3], aux2[4]);
                }
            }
        }
        updateUI();
        return view;
    }
    private void gerarLocais() {
        final ProgressDialog dialog = ProgressDialog.show(getContext(), "",
                "Loading...", true);
        dialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                geraLocais();
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
        menuInflater.inflate(R.menu.fragment_local_list, menu);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }

    public void geraLocais() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                localLab.flushEvents();
                int id = 0;
                ArrayList<String> aux;
                StringBuilder str = new StringBuilder();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    aux = new ArrayList<>();
                    for (int i = 0; i < ds.getChildrenCount(); i++) {
                        aux.add(ds.child(Integer.toString(i)).getValue().toString());
                        str.append(ds.child(Integer.toString(i)).getValue().toString()).append('#');
                        Toast toast = Toast.makeText(getContext(), (int) ds.getChildrenCount(), Toast.LENGTH_LONG);
                        toast.show();
                    }
                    str.append("/n");
                    localLab.createLocal(id++, aux.get(0), aux.get(1), aux.get(2), aux.get(3), aux.get(4));
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
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("locais.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile() {

        String ret = "";

        try {
            InputStream inputStream = getContext().openFileInput("locais.txt");

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
        LocalLab localLab = LocalLab.get();
        List<Local> locais;

        switch (getCategoria()) {
            case "Gastronomia":
                locais = localLab.getmLocals();
                break;
            case "Hospedagem":
                locais = localLab.getHospedagens();
                break;
            case "Igrejas":
                locais = localLab.getIgrejas();
                break;
            case "Monumentos":
                locais = localLab.getMonumentos();
                break;
            default:
                locais = localLab.getLocais();
                break;
        }
        if (mAdapter == null) {
            mAdapter = new LocalAdapter(locais);
            mLocalRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private class LocalHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNomeTextView;
        private TextView mFoneTextView;
        private ImageView mLocalImageView;

        private Local mLocal;

        LocalHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_local, parent, false));
            itemView.setOnClickListener(this);

            mNomeTextView = itemView.findViewById(R.id.nome_lugar);
            mFoneTextView = itemView.findViewById(R.id.fone_lugar);
            mLocalImageView = itemView.findViewById(R.id.imagem_lugar);
        }

        void bind(Local local) {
            mLocal = local;
            mNomeTextView.setText(mLocal.get_nome_local().toLowerCase());
            mFoneTextView.setText(mLocal.getTelefone());
            mLocalImageView.setImageResource(mLocal.getImagem());
        }

        @Override
        public void onClick(View view) {
            Intent intent = LocalPagerActivity.newIntent(getActivity(), mLocal.getId(), getCategoria());
            startActivity(intent);
        }
    }

    private class LocalAdapter extends RecyclerView.Adapter<LocalHolder> {
        private List<Local> mLocais;

        LocalAdapter(List<Local> locais) {
            mLocais = locais;
        }

        @Override
        public LocalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new LocalHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(LocalHolder holder, int position) {
            Local local = mLocais.get(position);
            holder.bind(local);
        }

        @Override
        public int getItemCount() {
            return mLocais.size();
        }
    }
}
