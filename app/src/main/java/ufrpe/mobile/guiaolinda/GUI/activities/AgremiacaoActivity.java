package ufrpe.mobile.guiaolinda.GUI.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Agremiacao;

public class AgremiacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agremiacoes);

        List<Agremiacao> mAgremiacao = LocalLab.get().getAgremiacoes();
        int agremiacaoId = getIntent().getExtras().getInt("AGREMIACAO_ID");
        Agremiacao mHomenageado = mAgremiacao.get(agremiacaoId);

        TextView mNomeTextView = findViewById(R.id.data_agremiacao);
        mNomeTextView.setText(mHomenageado.getData());

        TextView mInfoTextView = findViewById(R.id.info_agremiacoes);
        mInfoTextView.setText(String.format("%s", mHomenageado.getDadosBloco()));

    }
}