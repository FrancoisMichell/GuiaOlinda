package ufrpe.mobile.guiaolinda;

import android.content.Context;

import org.json.JSONArray;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

public class LocalLab {
    private static LocalLab sLocalLab;
    private ArrayList<Local> mLocais;

    private LocalLab(Context context) {
        /*mLocais = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            Local local = new Local();
            local.set_nome_local("Blues Bar Restaurante e Pizzaria");
            local.setEndereco("Rua do Bonfim, 66 – Carmo");
            local.setTelefone("Fone: (81) 3429.8272");
            local.setFax("Fone: (81) 3429.8272");
            local.setSite("Site: www.bluespizzaria.com.br");
            local.setEmail("e-mail: bluesbar@hotmail.com");
            mLocais.add(local);
        }*/
        createLocais();

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

    public ArrayList<Local> createLocais() {
        mLocais = new ArrayList<Local>();

        Local l1 = new Local();
        l1.setEmail("sol_rayasilva@hotmail.com");
        l1.setHorario("dom, a partir das 14h");
        l1.set_nome_local("Bar do Déo");
        l1.setTipo("gastronomia");
        l1.setEndereco("Rua São João, 345 – Carmo");
        l1.setTelefone("(81) 9999.4722");
        l1.setSite("");
        mLocais.add(l1);

        Local l2 = new Local();
        l2.setEmail("");
        l2.setHorario("qua a seg");
        l2.set_nome_local("Beijupirá");
        l2.setTipo("gastronomia");
        l2.setEndereco("Rua Saldanha Marinho, s/n (ao lado da Igreja da Misericórdia) – Amparo");
        l2.setTelefone("(81) 3439.6691 / 9734.1144");
        l2.setSite("");
        mLocais.add(l2);

        Local l3 = new Local();
        l3.setEmail("bluesbar@hotmail.com");
        l3.setHorario("ter a dom, das 18h às 1h");
        l3.set_nome_local("Blues Bar Restaurante e Pizzaria");
        l3.setTipo("gastronomia");
        l3.setEndereco("Rua do Bonfim, 66 – Carmo");
        l3.setTelefone("(81) 3429.8272");
        l3.setSite("www.bluespizzaria.com.br");
        mLocais.add(l3);

        Local l4 = new Local();
        l4.setEmail("");
        l4.setHorario("todos os dias, das 9h às 23h");
        l4.set_nome_local("Bodega de Véio");
        l4.setTipo("gastronomia");
        l4.setEndereco("Rua do Amparo, 212 – Amparo");
        l4.setTelefone("(81) 3429.0185");
        l4.setSite("");
        mLocais.add(l4);

        Local l5 = new Local();
        l5.setEmail("");
        l5.setHorario("todos os dias, das 8h às 20h");
        l5.set_nome_local("Café do Carmo");
        l5.setTipo("gastronomia");
        l5.setEndereco("Praça do Carmo, loja 5A");
        l5.setTelefone("(81) 3439.7449");
        l5.setSite("");
        mLocais.add(l5);

        Local l6 = new Local();
        l6.setEmail("alberguedeolinda@alberguedeolinda.com.br");
        l6.setHorario("");
        l6.set_nome_local("Albergue de Olinda");
        l6.setTipo("hospedagem");
        l6.setEndereco("Rua do Sol, 233 – Carmo");
        l6.setTelefone("(81) 3429.1592 / (81) 3439.1913");
        l6.setSite("www.alberguedeolinda.com.br");
        mLocais.add(l6);

        Local l7 = new Local();
        l7.setEmail("sitiodocarmo@sitiodocarmo.com.br");
        l7.setHorario("");
        l7.set_nome_local("Albergue Sítio do Carmo");
        l7.setTipo("hospedagem");
        l7.setEndereco("Rua Justino Gonçalves, 75 – Carmo");
        l7.setTelefone("(81) 3429.2567 / 9206.4473");
        l7.setSite("www.sitiodocarmo.com.br");
        mLocais.add(l7);

        Local l8 = new Local();
        l8.setEmail("casaraofortim@yahoo.com.br");
        l8.setHorario("");
        l8.set_nome_local("Casarão do Fortim");
        l8.setTipo("hospedagem");
        l8.setEndereco("Rua do Sol, 151 – Carmo");
        l8.setTelefone("(81) 3439.7124 / (81) 3326.9572");
        l8.setSite("www.pousadadofortim.com.br");
        mLocais.add(l8);

        Local l9 = new Local();
        l9.setEmail("reservas@pousadasaofrancisco.com.br");
        l9.setHorario("");
        l9.set_nome_local("Hotel Pousada São Francisco");
        l9.setTipo("hospedagem");
        l9.setEndereco("Rua do Sol, 127 – Carmo");
        l9.setTelefone("(81) 3429.2109 / (81) 3429.1418");
        l9.setSite("www.pousadasaofrancisco.com.br");
        mLocais.add(l9);

        Local l10 = new Local();
        l10.setEmail("7colinas@hotel7colinas.com.br");
        l10.setHorario("");
        l10.set_nome_local("Hotel 7 Colinas");
        l10.setTipo("hospedagem");
        l10.setEndereco("Ladeira de São Francisco, 307 – Carmo");
        l10.setTelefone("(81) 3493.7766");
        l10.setSite("www.hotel7colinas.com.br");
        mLocais.add(l10);

        Local l11 = new Local();
        l11.setEmail("");
        l11.setHorario("domingo, às 10h");
        l11.set_nome_local("Igreja de Nossa Senhora do Amparo");
        l11.setTipo("igreja");
        l11.setEndereco("Rua do Amparo, s/n – Amparo");
        l11.setTelefone("(81) 3429-7339 / 3305-1045");
        l11.setSite("");
        mLocais.add(l11);

        Local l12 = new Local();
        l12.setEmail("");
        l12.setHorario("de terça a sexta-feira, das 14h às 17h");
        l12.set_nome_local("Igreja de Nossa Senhora de Guadalupe");
        l12.setTipo("igreja");
        l12.setEndereco("Praça Miguel Canuto, s/n – Guadalupe");
        l12.setTelefone("(81) 3429.1914");
        l12.setSite("");
        mLocais.add(l12);

        Local l13 = new Local();
        l13.setEmail("");
        l13.setHorario("");
        l13.set_nome_local("Igreja da Misericórdia");
        l13.setTipo("igreja");
        l13.setEndereco("Rua Bispo Coutinho, s/n, Alto da Sé");
        l13.setTelefone("(81) 3494.9100");
        l13.setSite("");
        mLocais.add(l13);

        Local l14 = new Local();
        l14.setEmail("");
        l14.setHorario("de segunda a sábado, de 9h às 12h30 e das 14h às 17h30");
        l14.set_nome_local("Convento de São Francisco / Igreja de Nossa Senhora das Neves");
        l14.setTipo("igreja");
        l14.setEndereco("Rua de São Francisco, 280 – Carmo");
        l14.setTelefone("(81) 3429.0517");
        l14.setSite("");
        mLocais.add(l14);

        Local l15 = new Local();
        l15.setEmail("");
        l15.setHorario("");
        l15.set_nome_local("Igreja de Nossa Senhora da Boa Hora");
        l15.setTipo("igreja");
        l15.setEndereco("Rua da Boa Hora, s/n – Amparo");
        l15.setTelefone("");
        l15.setSite("");
        mLocais.add(l15);

        Local l16 = new Local();
        l16.setEmail("");
        l16.setHorario("");
        l16.set_nome_local("Arquivo Municipal de Olinda");
        l16.setTipo("monumento");
        l16.setEndereco("Rua de São Bento, 153 – Varadouro");
        l16.setTelefone("");
        l16.setSite("");
        mLocais.add(l16);

        Local l17 = new Local();
        l17.setEmail("");
        l17.setHorario("de segunda a sexta-feira, das 8h às 17h");
        l17.set_nome_local("Biblioteca Pública de Olinda");
        l17.setTipo("monumento");
        l17.setEndereco("Av. Liberdade, s/n – Carmo");
        l17.setTelefone("(81) 3305-1157");
        l17.setSite("");
        mLocais.add(l17);

        Local l18 = new Local();
        l18.setEmail("");
        l18.setHorario("todos os dias, das 14h às 17h");
        l18.set_nome_local("Caixa D'Água");
        l18.setTipo("monumento");
        l18.setEndereco("Rua Bispo Coutinho, s/n – Alto da Sé");
        l18.setTelefone("");
        l18.setSite("");
        mLocais.add(l18);

        Local l19 = new Local();
        l19.setEmail("");
        l19.setHorario("");
        l19.set_nome_local("Casa de João Fernandes Vieira");
        l19.setTipo("monumento");
        l19.setEndereco("Rua de São Bento, s/n – Varadouro");
        l19.setTelefone("");
        l19.setSite("");
        mLocais.add(l19);

        Local l20 = new Local();
        l20.setEmail("");
        l20.setHorario("");
        l20.set_nome_local("CEMO (Centro de Educação Musical de Olinda)");
        l20.setTipo("monumento");
        l20.setEndereco("Complexo Rodoviário de Salgadinho – Santa Tereza");
        l20.setTelefone("(81) 3241.5065");
        l20.setSite("");
        mLocais.add(l20);

        return mLocais;

    }

    public ArrayList<Local> getGastronomicos() {
        ArrayList<Local> gastronomicos = new ArrayList<Local>();
        for (int i = 0; i < mLocais.size(); i++) {
            Local l = new Local();
            if ( mLocais.get(i).getTipo() == "gastronomia" ) {
                gastronomicos.add( mLocais.get(i) );
            }
        }
        return gastronomicos;
    }

    public ArrayList<Local> getHospedagens() {
        ArrayList<Local> hospedagens = new ArrayList<Local>();
        for (int i = 0; i < mLocais.size(); i++) {
            Local l = new Local();
            if ( mLocais.get(i).getTipo() == "hospedagem" ) {
                hospedagens.add( mLocais.get(i) );
            }
        }
        return hospedagens;
    }

    public ArrayList<Local> getIgrejas() {
        ArrayList<Local> igrejas = new ArrayList<Local>();
        for (int i = 0; i < mLocais.size(); i++) {
            Local l = new Local();
            if ( mLocais.get(i).getTipo() == "igreja" ) {
                igrejas.add( mLocais.get(i) );
            }
        }
        return igrejas;
    }

    public ArrayList<Local> getMonumentos() {
        ArrayList<Local> monumentos = new ArrayList<Local>();
        for (int i = 0; i < mLocais.size(); i++) {
            Local l = new Local();
            if ( mLocais.get(i).getTipo() == "monumento" ) {
                monumentos.add( mLocais.get(i) );
            }
        }
        return monumentos;
    }

    public Local getLocal(UUID id) {
        for (Local l : mLocais){
            if(l.getId().equals(id))
                return l;
        }
        return null;
    }

}
