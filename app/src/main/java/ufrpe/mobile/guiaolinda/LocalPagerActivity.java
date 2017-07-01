package ufrpe.mobile.guiaolinda;

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

public class LocalPagerActivity extends AppCompatActivity {
    private static final String EXTRA_LOCAL_ID = "com.bignerdranch.android.criminanintent.crime_id";
    private ViewPager mViewPager;
    private List<Local> mLocais;

    public static Intent newIntent(Context packageContext, UUID localId){
        Intent intent = new Intent(packageContext, LocalPagerActivity.class);
        intent.putExtra(EXTRA_LOCAL_ID, localId);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_pager);

        UUID localId = (UUID) getIntent().getSerializableExtra(EXTRA_LOCAL_ID);

        mViewPager = (ViewPager) findViewById(R.id.local_view_pager);
        mLocais = LocalLab.get(this).getLocais();
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
