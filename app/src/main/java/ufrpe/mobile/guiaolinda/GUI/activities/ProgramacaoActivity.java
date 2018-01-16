package ufrpe.mobile.guiaolinda.GUI.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Programacao;
import ufrpe.mobile.guiaolinda.Tools.GlobalVariables;

public class ProgramacaoActivity extends AppCompatActivity {

    GlobalVariables globalVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacoes);
        globalVariables = (GlobalVariables) getApplicationContext();

        ArrayList<Programacao> mProgramacoes = LocalLab.get().getProgramacoes();
        int progId = getIntent().getExtras().getInt("PROGRAMACAO_ID");
        Programacao programacao = mProgramacoes.get(progId);

        TextView mPoloTextView = findViewById(R.id.nome_programacoes);
        mPoloTextView.setText(programacao.getPolo());

        TextView mProgTextView = findViewById(R.id.info_programacoes);
        mProgTextView.setText(String.format("    %s", programacao.getAtracoes()));

    }
}