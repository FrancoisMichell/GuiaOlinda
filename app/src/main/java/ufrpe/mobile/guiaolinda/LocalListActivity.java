package ufrpe.mobile.guiaolinda;

import android.support.v4.app.Fragment;

public class LocalListActivity extends SingleFragmentActivity {
    private static final String CATEGORIA_ITENS = "categoria";
    @Override
    protected Fragment createFragment() {

        String tipo = getIntent().getExtras().getString(CATEGORIA_ITENS);

        return new LocalListFragment(tipo);
    }
}
