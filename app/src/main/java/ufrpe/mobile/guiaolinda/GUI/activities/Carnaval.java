package ufrpe.mobile.guiaolinda.GUI.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Tools.GlobalVariables;
import ufrpe.mobile.guiaolinda.Tools.ItemsListActivity;

public class Carnaval extends Activity {

    private static final String CATEGORIA_ITENS = "categoria";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final GlobalVariables globalVariables = (GlobalVariables) getApplicationContext();

        setContentView(R.layout.tela_carnaval);

        Button bt_programacao = findViewById(R.id.bt_programacao);
        bt_programacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("Gastronomia", globalVariables);
            }
        });

        Button bt_agremiacao = findViewById(R.id.bt_agremiacao);
        bt_agremiacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("Hospedagem", globalVariables);
            }
        });

        Button bt_homenageados = findViewById(R.id.bt_homenageados);
        bt_homenageados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaIntent("Igrejas", globalVariables);
            }
        });

    }

    private void criaIntent(String tipoLocal, GlobalVariables globalVariables) {
        Intent intent = new Intent(Carnaval.this, ItemsListActivity.class);
        intent.putExtra(CATEGORIA_ITENS, tipoLocal);
        globalVariables.setCategoria(tipoLocal);
        startActivity(intent);
    }
}