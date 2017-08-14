package ufrpe.mobile.guiaolinda.GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Tools.LocalListActivity;

public class Inicio extends Activity {

    private static final String CATEGORIA_ITENS = "categoria";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicio);

        Button bt_gastronomia = (Button) findViewById(R.id.bt_gastronomia);
        bt_gastronomia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("Gastronomia");
            }
        });

        Button bt_hotelaria = (Button) findViewById(R.id.bt_hotelaria);
        bt_hotelaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("Hospedagem");
            }
        });

        Button bt_igrejas = (Button) findViewById(R.id.bt_igrejas);
        bt_igrejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("Igrejas");
            }
        });

        Button bt_monumentos = (Button) findViewById(R.id.bt_monumentos);
        bt_monumentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("Monumentos");
            }
        });

        Button bt_eventos = (Button) findViewById(R.id.bt_eventos);
        bt_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geraEventos();
                criaIntent("Eventos");
            }
        });
    }
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("masterSheet");
    private LocalLab localLab = LocalLab.get(getBaseContext());

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

    private void criaIntent(String tipoLocal){
        Intent intent = new Intent(Inicio.this, LocalListActivity.class);
        intent.putExtra(CATEGORIA_ITENS, tipoLocal);
        startActivity(intent);
    }
}