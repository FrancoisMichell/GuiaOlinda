package ufrpe.mobile.guiaolinda.GUI.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Local;

public class GastronomiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia);
        int eventId = getIntent().getExtras().getInt("AGREMIACAO_ID");
        String tipo = getIntent().getExtras().getString("TIPO_LOCAL");

        List<Local> mLocals = LocalLab.get().getLocals(tipo);
        Local mLocal = mLocals.get(eventId);

        ImageView mEventoImageView = findViewById(R.id.gastronomia_image);
        if (mLocal.getImage().equals("-"))
            Picasso.with(getBaseContext()).load(R.drawable.semfoto).into(mEventoImageView);
        else {
            Picasso.with(getBaseContext()).load(mLocal.getImage()).into(mEventoImageView);
        }

        TextView mNameField = findViewById(R.id.gastronomia_name);
        if (!mLocal.get_nome_local().equals("-")) {
            mNameField.setText(mLocal.get_nome_local().toLowerCase());
        } else {
            mNameField.setVisibility(View.GONE);
        }

/*        TextView mDescriptionField = (TextView) v.findViewById(R.id.descricao);
        if(!mLocal.getEndereco().equals("") || mLocal){
            mDescriptionField.setText("Descrição");
        }else {
            mDescriptionField.setVisibility(View.GONE);
        }*/

        TextView mAddressField = findViewById(R.id.gastronomia_endereco);
        if (!mLocal.getEndereco().equals("-")) {
            mAddressField.setText(String.format("     %s", mLocal.getEndereco()));
            mAddressField.setCompoundDrawablesWithIntrinsicBounds(R.drawable.address, 0, 0, 0);
        } else {
            mAddressField.setVisibility(View.GONE);
        }

        TextView mTaxField = findViewById(R.id.gastronomia_entrada);
        mTaxField.setCompoundDrawablesWithIntrinsicBounds(R.drawable.cash, 0, 0, 0);
        if (mLocal.getPreco() == null || mLocal.getPreco().equals("-")) {
            mTaxField.setText("     Gratuito");
        } else {
            mTaxField.setText(String.format("     %s", mLocal.getPreco()));
        }

        TextView mFoneField = findViewById(R.id.gastronomia_fone);
        if (!mLocal.getTelefone().equals("-")) {
            mFoneField.setText(String.format("    %s", mLocal.getTelefone()));
            mFoneField.setCompoundDrawablesWithIntrinsicBounds(R.drawable.phone, 0, 0, 0);
        } else {
            mFoneField.setVisibility(View.GONE);
        }

        TextView mFaxField = findViewById(R.id.gastronomia_funcionamento);
        if (!mLocal.getHorario().equals("-")) {
            mFaxField.setText(String.format("    %s", mLocal.getHorario()));
            mFaxField.setCompoundDrawablesWithIntrinsicBounds(R.drawable.time, 0, 0, 0);
        } else {
            mFaxField.setVisibility(View.GONE);
        }

        TextView mSiteField = findViewById(R.id.gastronomia_site);
        if (!mLocal.getSite().equals("-")) {
            mSiteField.setText(String.format("    %s", mLocal.getSite()));
            mSiteField.setCompoundDrawablesWithIntrinsicBounds(R.drawable.site, 0, 0, 0);
        } else {
            mSiteField.setVisibility(View.GONE);
        }


        TextView mEmailField = findViewById(R.id.gastronomia_email);
        if (!mLocal.getEmail().equals("-")) {
            mEmailField.setText(String.format("   %s", mLocal.getEmail()));
            mEmailField.setCompoundDrawablesWithIntrinsicBounds(R.drawable.email, 0, 0, 0);
        } else {
            mEmailField.setVisibility(View.GONE);
        }
        /*Button goToMaps = (Button) findViewById(R.id.go_to_maps);
        goToMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocalFragment.this.getActivity(), MapsActivity.class);
                intent.putExtra(ARG_LOCAL_ID, mLocal.getId());
                startActivity(intent);
            }
        });*/
    }
}