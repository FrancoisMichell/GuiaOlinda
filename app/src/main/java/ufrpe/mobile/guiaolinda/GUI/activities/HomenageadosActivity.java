package ufrpe.mobile.guiaolinda.GUI.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Homenageados;

public class HomenageadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homenageados);

        List<Homenageados> mHomenageados = LocalLab.get().getHomenageados();
        int homenageadosId = getIntent().getExtras().getInt("HOMENAGEADO_ID");
        Homenageados mHomenageado = mHomenageados.get(homenageadosId);

        ImageView mEventoImageView = findViewById(R.id.homenageados_image);
        Picasso.with(getBaseContext()).load(mHomenageado.getImagem()).into(mEventoImageView);

        TextView mNomeTextView = findViewById(R.id.nome_homenageados);
        mNomeTextView.setText(mHomenageado.getNomeHomenageados());

        TextView mInfoTextView = findViewById(R.id.info_homenageado);
        mInfoTextView.setText(String.format("    %s", mHomenageado.getTexto()));


    }
}