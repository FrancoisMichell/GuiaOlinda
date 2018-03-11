package ufrpe.mobile.guiaolinda.GUI.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Evento;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        List<Evento> mEventos = LocalLab.get().getEventos();
        int eventId = getIntent().getExtras().getInt("EVENT_ID");
        Evento mEvento = mEventos.get(eventId);

        ImageView mEventoImageView = findViewById(R.id.event_image);
//        Picasso.with(getBaseContext()).load(mEvento.getImagem()).into(mEventoImageView);
        if (mEvento.getImagem().equals("-"))
            Picasso.with(getBaseContext()).load(R.drawable.semfoto).into(mEventoImageView);
        else {
            if (mEvento.getImagem().isEmpty()) {
                Picasso.with(getBaseContext()).load(R.drawable.semfoto).into(mEventoImageView);
            } else {
                Picasso.with(getBaseContext()).load(mEvento.getImagem()).into(mEventoImageView);
                if (mEventoImageView.getDrawable() == null) {
                    Picasso.with(getBaseContext()).load(R.drawable.semfoto).into(mEventoImageView);
                }
            }
        }

        TextView mNomeTextView = findViewById(R.id.nome_evento);
        mNomeTextView.setText(mEvento.getNomeEvento());

        TextView mInfoTextView = findViewById(R.id.info_evento);
        mInfoTextView.setText(String.format("    %s", mEvento.getInfo()));

        TextView mDataTextView = findViewById(R.id.data_evento);
        mDataTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.calendar, 0, 0, 0);
        mDataTextView.setText(String.format("    %s", mEvento.getData()));

        TextView mLocalTextView = findViewById(R.id.local_evento);
        mLocalTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.address, 0, 0, 0);
        mLocalTextView.setText(String.format("    %s", mEvento.getLocal()));

        TextView mValorTextView = findViewById(R.id.valor_evento);
        mValorTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.cash, 0, 0, 0);
        mValorTextView.setText(String.format("    %s", mEvento.getValor()));

        TextView mHorarioTextView = findViewById(R.id.horario_evento);
        mHorarioTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.time, 0, 0, 0);
        mHorarioTextView.setText(String.format("    %s", mEvento.getHorário()));

        TextView mAtracoesTextView = findViewById(R.id.atracoes_evento);
        mAtracoesTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.star, 0, 0, 0);
        mAtracoesTextView.setText(String.format("    %s", mEvento.getAtracoes()));
    }
}