package ufrpe.mobile.guiaolinda;

import android.support.v4.app.Fragment;

public class LocalListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LocalListFragment();
    }
}
