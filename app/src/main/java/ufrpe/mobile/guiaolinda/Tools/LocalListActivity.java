package ufrpe.mobile.guiaolinda.Tools;

import android.support.v4.app.Fragment;

import ufrpe.mobile.guiaolinda.GUI.EventListFragment;
import ufrpe.mobile.guiaolinda.GUI.LocalListFragment;

public class LocalListActivity extends SingleFragmentActivity {
    private static final String CATEGORIA_ITENS = "categoria";
    @Override
    protected Fragment createFragment() {

        String tipo = getIntent().getExtras().getString(CATEGORIA_ITENS);

        if(tipo.equals("Eventos"))
            return new EventListFragment();
        else
            return new LocalListFragment(tipo);
    }
}
