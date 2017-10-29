package ufrpe.mobile.guiaolinda.GUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Evento;

public class EventActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        List<Evento> mEventos = LocalLab.get().getEventos();
        int eventId = getIntent().getExtras().getInt("EVENT_ID");
        Evento mEvento = mEventos.get(eventId);

        ImageView mEventoImageView = (ImageView) findViewById(R.id.event_image);
        Picasso.with(getBaseContext()).load(mEvento.getImagem()).into(mEventoImageView);

        TextView mNomeTextView = (TextView) findViewById(R.id.nome_evento);
        mNomeTextView.setText(mEvento.getNomeEvento());

        TextView mInfoTextView = (TextView) findViewById(R.id.info_evento);
        mInfoTextView.setText(String.format("    %s", mEvento.getInfo()));

        TextView mDataTextView = (TextView) findViewById(R.id.data_evento);
        mDataTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.calendar, 0, 0, 0);
        mDataTextView.setText(String.format("    %s", mEvento.getData()));

        TextView mLocalTextView = (TextView) findViewById(R.id.local_evento);
        mLocalTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.address,0,0,0);
        mLocalTextView.setText(String.format("    %s", mEvento.getLocal()));

        TextView mValorTextView = (TextView) findViewById(R.id.valor_evento);
        mValorTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.cash,0,0,0);
        mValorTextView.setText(String.format("    %s", mEvento.getValor()));

        TextView mHorarioTextView = (TextView) findViewById(R.id.horario_evento);
        mHorarioTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.time,0,0,0);
        mHorarioTextView.setText(String.format("    %s", mEvento.getHorário()));

        TextView mAtracoesTextView = (TextView) findViewById(R.id.atracoes_evento);
        mAtracoesTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.star, 0, 0, 0);
        mAtracoesTextView.setText(String.format("    %s", mEvento.getAtracoes()));
    }
}
