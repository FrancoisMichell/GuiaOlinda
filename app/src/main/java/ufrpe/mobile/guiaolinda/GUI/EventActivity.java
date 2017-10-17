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

    private List<Evento> mEventos;
    private Evento mEvento;

    private ImageView mEventoImageView;
    private TextView mNomeTextView;
    private TextView mInfoTextView;
    private TextView mDataTextView;
    private TextView mLocalTextView;
    private TextView mValorTextView;
    private TextView mHorarioTextView;
    private TextView mAtracoesTextView;

    private int eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mEventos = LocalLab.get().getEventos();
        eventId = getIntent().getExtras().getInt("mopa");
        mEvento = mEventos.get(eventId);

        mEventoImageView = (ImageView)findViewById(R.id.event_image);
        Picasso.with(getBaseContext()).load(mEvento.getImagem()).into(mEventoImageView);

        mNomeTextView = (TextView)findViewById(R.id.nome_evento);
        mNomeTextView.setText(mEvento.getNomeEvento());

        mInfoTextView = (TextView)findViewById(R.id.info_evento);
        mInfoTextView.setText(String.format("    %s", mEvento.getInfo()));

        mDataTextView = (TextView)findViewById(R.id.data_evento);
        mDataTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.time,0,0,0);
        mDataTextView.setText(String.format("    %s", mEvento.getData()));

        mLocalTextView = (TextView)findViewById(R.id.local_evento);
        mLocalTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.address,0,0,0);
        mLocalTextView.setText(String.format("    %s", mEvento.getLocal()));

        mValorTextView = (TextView)findViewById(R.id.valor_evento);
        mValorTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.cash,0,0,0);
        mValorTextView.setText(String.format("    %s", mEvento.getValor()));

        mHorarioTextView = (TextView)findViewById(R.id.horario_evento);
        mHorarioTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.time,0,0,0);
        mHorarioTextView.setText(String.format("    %s", mEvento.getHorário()));

        mAtracoesTextView = (TextView)findViewById(R.id.atracoes_evento);
        mAtracoesTextView.setText(String.format("    %s", mEvento.getAtracoes()));
    }
}
