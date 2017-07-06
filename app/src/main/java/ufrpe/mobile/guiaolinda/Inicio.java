package ufrpe.mobile.guiaolinda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends Activity {

    private Button bt_gastronomia;
    private Button bt_hotelaria;
    private Button bt_igrejas;
    private Button bt_monumentos;

    private static final String CATEGORIA_ITENS = "categoria";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicio);

        bt_gastronomia = (Button) findViewById(R.id.bt_gastronomia);
        bt_gastronomia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("gastro");
            }
        });

        bt_hotelaria = (Button) findViewById(R.id.bt_hotelaria);
        bt_hotelaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("hosped");
            }
        });

        bt_igrejas = (Button) findViewById(R.id.bt_igrejas);
        bt_igrejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("igrejas");
            }
        });

        bt_monumentos = (Button) findViewById(R.id.bt_monumentos);
        bt_monumentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("monumentos");
            }
        });
    }


    private void criaIntent(String tipoLocal){
        Intent intent = new Intent(Inicio.this, LocalListActivity.class);
        intent.putExtra(CATEGORIA_ITENS, tipoLocal);
        startActivity(intent);
    }
}
