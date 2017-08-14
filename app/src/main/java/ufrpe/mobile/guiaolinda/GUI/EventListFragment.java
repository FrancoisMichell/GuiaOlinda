package ufrpe.mobile.guiaolinda.GUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Evento;

@SuppressLint("ValidFragment")
public class EventListFragment extends Fragment {
    private RecyclerView mEventRecyclerView;
    private EventAdapter mAdapter;
    private LocalLab localLab;
    private boolean inicio;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("masterSheet");

    public EventListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        TextView v = (TextView) view.findViewById(R.id.categoria_evento);
        v.setText("Eventos");

        mEventRecyclerView = (RecyclerView) view.findViewById(R.id.event_recycler_view);
        mEventRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.fragment_event_list, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.sobre:
                Intent intent = new Intent(getActivity(), SobreActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.localLab = LocalLab.get(getActivity());

        setHasOptionsMenu(true);
    }

    public void geraEventos() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                localLab.flushEvents();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ArrayList<String> aux = new ArrayList<>();
                    for (int i = 0; i < ds.getChildrenCount(); i++) {
                        aux.add(ds.child(Integer.toString(i)).getValue().toString());
                    }
                    localLab.createEvent(R.drawable.prefeitura_olinda, aux.get(0), aux.get(1), aux.get(2), aux.get(3));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void updateUI() {
        //geraEventos();
        List<Evento> eventos;

        eventos = localLab.getEventos();

        if (mAdapter == null) {
            mAdapter = new EventAdapter(eventos);
            mEventRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mLocalImageView;
        private TextView mNomeTextView;
        private TextView mLocalTextView;
        private TextView mHorarioTextView;
        private TextView mAtracoesTextView;

        private Evento mEvento;

        EventHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_evento, parent, false));
            itemView.setOnClickListener(this);

            mLocalImageView = (ImageView) itemView.findViewById(R.id.imagem_evento);
            mNomeTextView = (TextView) itemView.findViewById(R.id.nome_evento);
            mLocalTextView = (TextView) itemView.findViewById(R.id.local_evento);
            mHorarioTextView = (TextView) itemView.findViewById(R.id.horario_evento);
            mAtracoesTextView = (TextView) itemView.findViewById(R.id.atracoes_evento);
        }

        void bind(Evento evento){
            mEvento = evento;
            mNomeTextView.setText(mEvento.getNomeEvento());
            mLocalTextView.setText(mEvento.getLocal());
            mHorarioTextView.setText(mEvento.getHorário());
            mAtracoesTextView.setText(mEvento.getAtracoes());
            mLocalImageView.setImageResource(mEvento.getImagem());
        }

        @Override
        public void onClick(View view) {
           // Intent intent = LocalPagerActivity.newIntent(getActivity(), mLocal.getId(), getCategoria());
            //startActivity(intent);
        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHolder> {
        private List<Evento> mEventos;

        EventAdapter(List<Evento> eventos){
            mEventos = eventos;
        }

        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new EventHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position) {
            Evento evento = mEventos.get(position);
            holder.bind(evento);
        }

        @Override
        public int getItemCount() {
            return mEventos.size();
        }
    }
}
