package ufrpe.mobile.guiaolinda.GUI.fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.GUI.activities.EventActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.MapsActivity;
import ufrpe.mobile.guiaolinda.GUI.activities.SobreActivity;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Evento;

@SuppressLint("ValidFragment")
public class EventListFragment extends Fragment {
    public final String EVENT_ID = "EVENT_ID";
    private RecyclerView mEventRecyclerView;
    private EventAdapter mAdapter;
    private LocalLab localLab;

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

        FloatingActionButton buttonTopo = (FloatingActionButton) view.findViewById(R.id.botaoTopo);
        buttonTopo.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayoutManager lManager = (LinearLayoutManager) mEventRecyclerView.getLayoutManager();
                lManager.scrollToPositionWithOffset(0, 0);
            }
        });

        if(localLab.getEventos().size() == 0) {
            geraEventos();
            final ProgressDialog dialog = ProgressDialog.show(getContext(), "",
                    "Loading...", true);
            dialog.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    updateUI();
                    dialog.dismiss();
                }
            }, 5000);
        }
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
        menuInflater.inflate(R.menu.fragment_local_list, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch(item.getItemId()){
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
        this.localLab = LocalLab.get();

        setHasOptionsMenu(true);
    }

    public void geraEventos() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                localLab.flushEvents();
                int id = 0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ArrayList<String> aux = new ArrayList<>();
                    for (int i = 0; i < ds.getChildrenCount(); i++) {
                        aux.add(ds.child(Integer.toString(i)).getValue().toString());
                    }
                    localLab.createEvent(id++, aux.get(0), aux.get(1), aux.get(2), aux.get(3), aux.get(4),aux.get(5), aux.get(6), aux.get(7));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void updateUI() {
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
        private TextView mDataTextView;
        private TextView mHorarioTextView;

        private Evento mEvento;

        EventHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_evento, parent, false));
            itemView.setOnClickListener(this);

            mLocalImageView = (ImageView) itemView.findViewById(R.id.imagem_evento);
            mNomeTextView = (TextView) itemView.findViewById(R.id.nome_evento);
            mLocalTextView = (TextView) itemView.findViewById(R.id.local_evento);
            mDataTextView = (TextView) itemView.findViewById(R.id.data_evento);
            mHorarioTextView = (TextView) itemView.findViewById(R.id.horario_evento);
        }

        void bind(Evento evento){
            mEvento = evento;
            Picasso.with(getContext()).load(mEvento.getImagem()).into(mLocalImageView);
            mNomeTextView.setText(mEvento.getNomeEvento());
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