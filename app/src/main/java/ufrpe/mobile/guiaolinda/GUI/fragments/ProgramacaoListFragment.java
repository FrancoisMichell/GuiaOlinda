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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.GUI.activities.InicioActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.MapsActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.ProgramacaoActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.SobreActivity;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Programacao;

public class ProgramacaoListFragment extends Fragment {
    public final String PROGRAMACAO_ID = "PROGRAMACAO_ID";
    private RecyclerView mProgramacaoRecyclerView;
    private ProgramacaoAdapter mAdapter;
    private LocalLab localLab;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Programação");

    public ProgramacaoListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_programacoes_list, container, false);

        TextView v = view.findViewById(R.id.categoria_programacao);
        v.setText("Programação");

        mProgramacaoRecyclerView = view.findViewById(R.id.programacoes_recycler_view);
        mProgramacaoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        FloatingActionButton buttonTopo = view.findViewById(R.id.botaoEventoTopo);
        buttonTopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager lManager = (LinearLayoutManager) mProgramacaoRecyclerView.getLayoutManager();
                lManager.scrollToPositionWithOffset(0, 0);
            }
        });

        if (readFromFile().isEmpty() || readFromFile().equals("")) {
            gerarProgramacoes();
        } else {
            int id = 0;
            String[] aux = String.valueOf(readFromFile()).split("/n");
            if (localLab.getProgramacoes().size() == 0) {
                for (String anAux : aux) {
                    if(anAux.contains("/%")){
                        anAux = anAux.replace("/%", "\n");
                    }
                    String[] aux2 = anAux.split("#");
                    localLab.createProgramacao(id++, aux2[0], aux2[1]);
                }
            }
        }
        updateUI();
        return view;
    }

    private void gerarProgramacoes() {
        final ProgressDialog dialog = ProgressDialog.show(getContext(), "",
                "Loading...", true);
        dialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                geraProgramacoes();
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
                gerarProgramacoes();
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

    public void geraProgramacoes() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                localLab.flushProgramacao();
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

                    localLab.createProgramacao(id++, aux.get(0), aux.get(1));
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
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("programacao.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile() {

        String ret = "";

        try {
            InputStream inputStream = getContext().openFileInput("programacao.txt");

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    private void updateUI() {
        List<Programacao> programacoes;
        programacoes = localLab.getProgramacoes();
        if (mAdapter == null) {
            mAdapter = new ProgramacaoAdapter(programacoes);
            mProgramacaoRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ProgramacaoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mProgImageView;
        private TextView mPoloTextView;

        private Programacao mProgramacao;

        ProgramacaoHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_programacoes, parent, false));
            itemView.setOnClickListener(this);

            mProgImageView = itemView.findViewById(R.id.imagem_programacao);
            mPoloTextView = itemView.findViewById(R.id.nome_polo);

        }

        void bind(Programacao programacao) {
            mProgramacao = programacao;
            Picasso.with(getContext()).load(R.drawable.olinda_turismo).into(mProgImageView);
            mPoloTextView.setText(mProgramacao.getPolo());
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), ProgramacaoActivity.class);
            intent.putExtra(PROGRAMACAO_ID, mProgramacao.getId());
            startActivity(intent);
        }
    }

    private class ProgramacaoAdapter extends RecyclerView.Adapter<ProgramacaoHolder> {
        private List<Programacao> mProgramacoes;

        ProgramacaoAdapter(List<Programacao> programacao) {
            mProgramacoes = programacao;
        }

        @Override
        public ProgramacaoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new ProgramacaoHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ProgramacaoHolder holder, int position) {
            Programacao programacao = mProgramacoes.get(position);
            holder.bind(programacao);
        }

        @Override
        public int getItemCount() {
            return mProgramacoes.size();
        }
    }
}