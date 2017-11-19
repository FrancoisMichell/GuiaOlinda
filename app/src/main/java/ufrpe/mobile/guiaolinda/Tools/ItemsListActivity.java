package ufrpe.mobile.guiaolinda.Tools;

import android.support.v4.app.Fragment;

import ufrpe.mobile.guiaolinda.GUI.fragments.EventListFragment;
import ufrpe.mobile.guiaolinda.GUI.fragments.LocalListFragment;

public class ItemsListActivity extends SingleFragmentActivity {
    private static final String CATEGORIA_ITENS = "categoria";

    String tipo;
    boolean success;

    @Override
    protected Fragment createFragment() {

        final GlobalVariables globalVariables = (GlobalVariables) getApplicationContext();

        try {
            tipo = getIntent().getExtras().getString(CATEGORIA_ITENS);
            success = true;
        } catch (Exception e) {
            success = false;
        }
        if (!success) {
            tipo = globalVariables.getCategoria();
        }

        if (tipo != null && tipo.equals("Eventos"))
            return new EventListFragment();
        else
            return new LocalListFragment(tipo);
    }
}