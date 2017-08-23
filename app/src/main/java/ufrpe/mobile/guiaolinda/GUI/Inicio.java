package ufrpe.mobile.guiaolinda.GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                criaIntent("Eventos");
            }
        });
    }

    private void criaIntent(String tipoLocal){
        Intent intent = new Intent(Inicio.this, LocalListActivity.class);
        intent.putExtra(CATEGORIA_ITENS, tipoLocal);
        startActivity(intent);
    }
}