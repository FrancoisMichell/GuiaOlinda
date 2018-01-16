package ufrpe.mobile.guiaolinda.Tools;

import android.support.v4.app.Fragment;

import ufrpe.mobile.guiaolinda.GUI.fragments.AgremiacaoListFragment;
import ufrpe.mobile.guiaolinda.GUI.fragments.HomenageadosListFragment;
import ufrpe.mobile.guiaolinda.GUI.fragments.LocalListFragment;
import ufrpe.mobile.guiaolinda.GUI.fragments.ProgramacaoListFragment;

public class CarnavalListActivity extends SingleFragmentActivity {
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
            case "Programação":
                return new ProgramacaoListFragment();
            case "Agremiações":
                return new AgremiacaoListFragment();
            case "Homenageados":
                return new HomenageadosListFragment();
            default:
                return new LocalListFragment(tipo);
        }
    }
}
