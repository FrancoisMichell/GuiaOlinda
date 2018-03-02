package ufrpe.mobile.guiaolinda.Tools;

import android.support.v4.app.Fragment;

import ufrpe.mobile.guiaolinda.GUI.fragments.AgremiacaoListFragment;
import ufrpe.mobile.guiaolinda.GUI.fragments.EventListFragment;
import ufrpe.mobile.guiaolinda.GUI.fragments.GastronomiaListFragment;
import ufrpe.mobile.guiaolinda.GUI.fragments.HomenageadosListFragment;

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

        switch (tipo) {
            case "Eventos":
                return new EventListFragment();
            case "Gastronomia":
                return new GastronomiaListFragment(tipo);
            case "Hospedagem":
                return new GastronomiaListFragment(tipo);
            case "Igrejas":
                return new GastronomiaListFragment(tipo);
            case "Monumentos":
                return new GastronomiaListFragment(tipo);
            case "Agremiações":
                return new AgremiacaoListFragment();
            case "Homenageados":
                return new HomenageadosListFragment();
            default:
                return new GastronomiaListFragment("Gastronomia");
        }
    }
}