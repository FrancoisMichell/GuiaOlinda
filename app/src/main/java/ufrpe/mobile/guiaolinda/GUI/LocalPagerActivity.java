package ufrpe.mobile.guiaolinda.GUI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Local;
import ufrpe.mobile.guiaolinda.Services.LocalFragment;

public class LocalPagerActivity extends AppCompatActivity {
    private static final String EXTRA_LOCAL_ID = "com.bignerdranch.android.criminanintent.crime_id";
    private static final String CATEGORIA_ITENS = "categoria";
    private List<Local> mLocais;
    private String categoria;


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static Intent newIntent(Context packageContext, UUID localId, String categoria){
        Intent intent = new Intent(packageContext, LocalPagerActivity.class);
        intent.putExtra(EXTRA_LOCAL_ID, localId);
        intent.putExtra(CATEGORIA_ITENS, categoria);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_local_pager);

        UUID localId = (UUID) getIntent().getSerializableExtra(EXTRA_LOCAL_ID);

        setCategoria(getIntent().getExtras().getString(CATEGORIA_ITENS));

        ViewPager mViewPager = (ViewPager) findViewById(R.id.local_view_pager);
        switch (categoria) {
            case "Gastronomia":
                mLocais = LocalLab.get().getGastronomicos();
                break;
            case "Hospedagem":
                mLocais = LocalLab.get().getHospedagens();
                break;
            case "Igrejas":
                mLocais = LocalLab.get().getIgrejas();
                break;
            case "Monumentos":
                mLocais = LocalLab.get().getMonumentos();
                break;
            case "Eventos":
                mLocais = LocalLab.get().getLocais();
            default:
                mLocais = LocalLab.get().getLocais();
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Local local = mLocais.get(position);
                    return LocalFragment.newInstance(local.getId());
            }

            @Override
            public int getCount() {
                return mLocais.size();
            }
        });
        for (int i = 0; i < mLocais.size(); i++) {
            if (mLocais.get(i).getId().equals(localId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
