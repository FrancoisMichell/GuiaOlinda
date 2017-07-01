package ufrpe.mobile.guiaolinda;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

public class LocalLab {
    private static LocalLab sLocalLab;
    private ArrayList<Local> mLocais;

    private LocalLab(Context context) {
        mLocais = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            Local local = new Local();
            local.set_nome_local("Blues Bar Restaurante e Pizzaria");
            local.setEndereco("Rua do Bonfim, 66 – Carmo");
            local.setTelefone("Fone: (81) 3429.8272");
            local.setFax("Fone: (81) 3429.8272");
            local.setSite("Site: www.bluespizzaria.com.br");
            local.setEmail("e-mail: bluesbar@hotmail.com");
            mLocais.add(local);
        }
    }

    public static LocalLab get(Context context){
        if(sLocalLab == null) {
            sLocalLab = new LocalLab(context);
        }
        return sLocalLab;
    }

    public ArrayList<Local> getLocais(){
        return mLocais;
    }

    public Local getLocal(UUID id) {
        for (Local l : mLocais){
            if(l.getId().equals(id))
                return l;
        }
        return null;
    }

}
