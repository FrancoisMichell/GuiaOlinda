package ufrpe.mobile.guiaolinda.DB;

import android.content.Context;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Evento;
import ufrpe.mobile.guiaolinda.Services.Local;

public class LocalLab {
    private static LocalLab sLocalLab;
    private ArrayList<Local> mLocais;
    private ArrayList<Evento> mEventos = new ArrayList<Evento>();

    private LocalLab(Context context) {
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

    private ArrayList<Local> createLocais() {
        mLocais = new ArrayList<>();

        Local l1 = new Local();
        l1.setEmail("sol_rayasilva@hotmail.com");
        l1.setHorario("dom, a partir das 14h");
        l1.set_nome_local("Bar do Déo");
        l1.setTipo("Gastronomia");
        l1.setEndereco("Rua São João, 345 – Carmo");
        l1.setTelefone("(81) 9999.4722");
        l1.setSite("");
        l1.setLatitude(-8.0109760);
        l1.setLongitude(-34.8543760);
        l1.setImagem(R.drawable.bar_do_deo);
        mLocais.add(l1);

        Local l2 = new Local();
        l2.setEmail("");
        l2.setHorario("qua a seg");
        l2.set_nome_local("Beijupirá");
        l2.setTipo("Gastronomia");
        l2.setEndereco("Rua Saldanha Marinho, s/n (ao lado da Igreja da Misericórdia) – Amparo");
        l2.setTelefone("(81) 3439.6691 / 9734.1144");
        l2.setSite("");
        l2.setLatitude(-8.0129999);
        l2.setLongitude(-34.8527842);
        l2.setImagem(R.drawable.beijupira);
        mLocais.add(l2);

        Local l4 = new Local();
        l4.setEmail("");
        l4.setHorario("todos os dias, das 9h às 23h");
        l4.set_nome_local("Bodega de Véio");
        l4.setTipo("Gastronomia");
        l4.setEndereco("Rua do Amparo, 212 – Amparo");
        l4.setTelefone("(81) 3429.0185");
        l4.setSite("");
        l4.setLatitude(-8.0128140);
        l4.setLongitude(-34.8532530);
        l4.setImagem(R.drawable.bodega_do_veio);
        mLocais.add(l4);

        Local l5 = new Local();
        l5.setEmail("");
        l5.setHorario("todos os dias, das 8h às 20h");
        l5.set_nome_local("Café do Carmo");
        l5.setTipo("Gastronomia");
        l5.setEndereco("Praça do Carmo, loja 5A");
        l5.setTelefone("(81) 3439.7449");
        l5.setSite("");
        l5.setLatitude(-8.0166130);
        l5.setLongitude(-34.8483060);
        l5.setImagem(R.drawable.cafe_do_carmo);
        mLocais.add(l5);

        Local l6 = new Local();
        l6.setEmail("alberguedeolinda@alberguedeolinda.com.br");
        l6.setHorario("");
        l6.set_nome_local("Albergue de Olinda");
        l6.setTipo("Hospedagem");
        l6.setEndereco("Rua do Sol, 233 – Carmo");
        l6.setTelefone("(81) 3429.1592 / (81) 3439.1913");
        l6.setSite("www.alberguedeolinda.com.br");
        l6.setLatitude(-8.0153200);
        l6.setLongitude(-34.8465250);
        l6.setImagem(R.drawable.albergue_de_olinda);
        mLocais.add(l6);

        Local l7 = new Local();
        l7.setEmail("sitiodocarmo@sitiodocarmo.com.br");
        l7.setHorario("");
        l7.set_nome_local("Albergue Sítio do Carmo");
        l7.setTipo("Hospedagem");
        l7.setEndereco("Rua Justino Gonçalves, 75 – Carmo");
        l7.setTelefone("(81) 3429.2567 / 9206.4473");
        l7.setSite("www.sitiodocarmo.com.br");
        l7.setLatitude(-8.0180590);
        l7.setLongitude(-34.8493630);
        l7.setImagem(R.drawable.albergue_sitio_do_carmo);
        mLocais.add(l7);

        Local l8 = new Local();
        l8.setEmail("casaraofortim@yahoo.com.br");
        l8.setHorario("");
        l8.set_nome_local("Casarão do Fortim");
        l8.setTipo("Hospedagem");
        l8.setEndereco("Rua do Sol, 151 – Carmo");
        l8.setTelefone("(81) 3439.7124 / (81) 3326.9572");
        l8.setSite("www.pousadadofortim.com.br");
        l8.setLatitude(-8.0158340);
        l8.setLongitude(-34.8470590);
        l8.setImagem(R.drawable.casarao_fortim_olinda);
        mLocais.add(l8);

        Local l9 = new Local();
        l9.setEmail("reservas@pousadasaofrancisco.com.br");
        l9.setHorario("");
        l9.set_nome_local("Hotel Pousada São Francisco");
        l9.setTipo("Hospedagem");
        l9.setEndereco("Rua do Sol, 127 – Carmo");
        l9.setTelefone("(81) 3429.2109 / (81) 3429.1418");
        l9.setSite("www.pousadasaofrancisco.com.br");
        l9.setLatitude(-8.0160060);
        l9.setLongitude(-34.8473190);
        l9.setImagem(R.drawable.semfoto);
        mLocais.add(l9);

        Local l10 = new Local();
        l10.setEmail("7colinas@hotel7colinas.com.br");
        l10.setHorario("");
        l10.set_nome_local("Hotel 7 Colinas");
        l10.setTipo("Hospedagem");
        l10.setEndereco("Ladeira de São Francisco, 307 – Carmo");
        l10.setTelefone("(81) 3493.7766");
        l10.setSite("www.hotel7colinas.com.br");
        l10.setLatitude(-8.0146000);
        l10.setLongitude(-34.8476570);
        l10.setImagem(R.drawable.hotel_7_colinas);
        mLocais.add(l10);

        Local l11 = new Local();
        l11.setEmail("");
        l11.setHorario("domingo, às 10h");
        l11.set_nome_local("Igreja de Nossa Senhora do Amparo");
        l11.setTipo("Igreja");
        l11.setEndereco("Rua do Amparo, s/n – Amparo");
        l11.setTelefone("(81) 3429-7339 / 3305-1045");
        l11.setSite("");
        l11.setLatitude(-8.0118936);
        l11.setLongitude(-34.8535799);
        l11.setImagem(R.drawable.igreja_nossa_senhora_do_amparo);
        mLocais.add(l11);

        Local l12 = new Local();
        l12.setEmail("");
        l12.setHorario("de terça a sexta-feira, das 14h às 17h");
        l12.set_nome_local("Igreja de Nossa Senhora de Guadalupe");
        l12.setTipo("Igreja");
        l12.setEndereco("Praça Miguel Canuto, s/n – Guadalupe");
        l12.setTelefone("(81) 3429.1914");
        l12.setSite("");
        l12.setLatitude(-8.0087020);
        l12.setLongitude(-34.8568900);
        l12.setImagem(R.drawable.igreja_nossa_senhora_de_guadalupe);
        mLocais.add(l12);

        Local l13 = new Local();
        l13.setEmail("");
        l13.setHorario("");
        l13.set_nome_local("Igreja da Misericórdia");
        l13.setTipo("Igreja");
        l13.setEndereco("Rua Bispo Coutinho, s/n, Alto da Sé");
        l13.setTelefone("(81) 3494.9100");
        l13.setSite("");
        l13.setLatitude(-7.9882390);
        l13.setLongitude(-34.8406200);
        l13.setImagem(R.drawable.igreja_da_misericodia);
        mLocais.add(l13);

        Local l14 = new Local();
        l14.setEmail("");
        l14.setHorario("de segunda a sábado, de 9h às 12h30 e das 14h às 17h30");
        l14.set_nome_local("Convento de São Francisco / Igreja de Nossa Senhora das Neves");
        l14.setTipo("Igreja");
        l14.setEndereco("Rua de São Francisco, 280 – Carmo");
        l14.setTelefone("(81) 3429.0517");
        l14.setSite("");
        l14.setLatitude(-8.0138376);
        l14.setLongitude(-34.8475987);
        l14.setImagem(R.drawable.convento_sao_francisco);
        mLocais.add(l14);

        Local l15 = new Local();
        l15.setEmail("");
        l15.setHorario("");
        l15.set_nome_local("Igreja de Nossa Senhora da Boa Hora");
        l15.setTipo("Igreja");
        l15.setEndereco("Rua da Boa Hora, s/n – Amparo");
        l15.setTelefone("");
        l15.setSite("");
        l15.setLatitude(-8.0158964);
        l15.setLongitude(-34.8543525);
        l15.setImagem(R.drawable.igreja_nossa_senhora_boa_hora);
        mLocais.add(l15);

        Local l16 = new Local();
        l16.setEmail("");
        l16.setHorario("");
        l16.set_nome_local("Arquivo Municipal de Olinda");
        l16.setTipo("Monumento");
        l16.setEndereco("Rua de São Bento, 153 – Varadouro");
        l16.setTelefone("");
        l16.setSite("");
        l16.setLatitude(-8.0179050);
        l16.setLongitude(-34.8523210);
        l16.setImagem(R.drawable.arquivo_municipal);
        mLocais.add(l16);

        Local l17 = new Local();
        l17.setEmail("");
        l17.setHorario("de segunda a sexta-feira, das 8h às 17h");
        l17.set_nome_local("Biblioteca Pública de Olinda");
        l17.setTipo("Monumento");
        l17.setEndereco("Av. Liberdade, s/n – Carmo");
        l17.setTelefone("(81) 3305-1157");
        l17.setSite("");
        l17.setLatitude(-8.0164310);
        l17.setLongitude(-34.8488630);
        l17.setImagem(R.drawable.bilbioteca_publica);
        mLocais.add(l17);

       /* NÃO LOCALIZADO!
        Local l18 = new Local();
        l18.setEmail("");
        l18.setHorario("todos os dias, das 14h às 17h");
        l18.set_nome_local("Caixa D'Água");
        l18.setTipo("Monumento");
        l18.setEndereco("Rua Bispo Coutinho, s/n – Alto da Sé");
        l18.setTelefone("");
        l18.setSite("");
        l18.setLatitude();
        l18.setLongitude();
        mLocais.add(l18);


        Local l19 = new Local();
        l19.setEmail("");
        l19.setHorario("");
        l19.set_nome_local("Casa de João Fernandes Vieira");
        l19.setTipo("Monumento");
        l19.setEndereco("Rua de São Bento, s/n – Varadouro");
        l19.setTelefone("");
        l19.setSite("");
        l19.setLatitude();
        l19.setLongitude();
        mLocais.add(l19);
        */

        Local l20 = new Local();
        l20.setEmail("");
        l20.setHorario("");
        l20.set_nome_local("CEMO (Centro de Educação Musical de Olinda)");
        l20.setTipo("Monumento");
        l20.setEndereco("Av. Pan Nordestina, s/n - Salgadinho");
        l20.setTelefone("(81) 3241.5065");
        l20.setSite("");
        l20.setLatitude(-8.0257900);
        l20.setLongitude(-34.8644270);
        l20.setImagem(R.drawable.cemo);
        mLocais.add(l20);

        Local l21 = new Local();
        l21.setEmail("casadenoca@terra.com.br");
        l21.setHorario("todos os dias, das 11h às 0h");
        l21.set_nome_local("CEMO (Casa de noca )");
        l21.setTipo("Gastronomia");
        l21.setEndereco("Rua Bertioga, 243 – Cidade Alta");
        l21.setTelefone("(81) 3249.1040");
        l21.setSite("");
        l21.setLatitude(-8.0257900);
        l21.setLongitude(-34.8644270);
        l21.setImagem(R.drawable.casa_de_noca);
        mLocais.add(l21);

        Local l22 = new Local();
        l22.setEmail("casamaloca@casamaloca.com.br");
        l22.setHorario("todos os dias, das 8h às 23h");
        l22.set_nome_local("CEMO (Casa Maloca )");
        l22.setTipo("Gastronomia");
        l22.setEndereco("Rua do Amparo, 183 – Amparo");
        l22.setTelefone("(81) 3242.7811");
        l22.setSite("");
        l22.setLatitude(-8.0257900);
        l22.setLongitude(-34.8644270);
        l22.setImagem(R.drawable.casamaloca);
        mLocais.add(l22);

        Local l23 = new Local();
        l23.setEmail("leonardosleal@hotmail.com");
        l23.setHorario("todos os dias, das 11h às 23h");
        l23.set_nome_local("CEMO (Creperia de Olinda )");
        l23.setTipo("Gastronomia");
        l23.setEndereco("Praça Conselheiro João Alfredo, 168 – Carmo");
        l23.setTelefone("(81) 3229.2935");
        l23.setSite("");
        l23.setLatitude(-8.0257900);
        l23.setLongitude(-34.8644270);
        l23.setImagem(R.drawable.creperia_de_olinda);
        mLocais.add(l23);

        Local l24 = new Local();
        l24.setEmail("kamillarangel@hotmail.com ");
        l24.setHorario("ter a qui, das 12h30 às 16h;" +
            "sex e sáb 12h30 às 16h e 19h30 às 0h / dom, das 12h às 17h");
        l24.set_nome_local("CEMO (Due )");
        l24.setTipo("Gastronomia");
        l24.setEndereco("Rua Manoel Borba, 350 – Varadouro");
        l24.setTelefone("(81) 3229.2956");
        l24.setSite("");
        l24.setLatitude(-8.0257900);
        l24.setLongitude(-34.8644270);
        l24.setImagem(R.drawable.restaurante_due);
        mLocais.add(l24);

        Local l25 = new Local();
        l25.setEmail("galeria@estacao4cantos.com.br");
        l25.setHorario("seg a qui, das 11h às 21h;" +
            "sex e sáb, das 11h às 22h / dom, das 15h às 20h");
        l25.set_nome_local("CEMO (Estação Quatro Cantos (Café) )");
        l25.setTipo("Gastronomia");
        l25.setEndereco("Rua Prudente de Morais, 440 – Carmo");
        l25.setTelefone("(81) 3429.7575");
        l25.setSite("");
        l25.setLatitude(-8.0257900);
        l25.setLongitude(-34.8644270);
        l25.setImagem(R.drawable.estacao_quatro_cantos);
        mLocais.add(l25);

        Local l26 = new Local();
        l26.setEmail("");
        l26.setHorario("");
        l26.set_nome_local("CEMO (Pousada Alquimia )");
        l26.setTipo("Hospedagem");
        l26.setEndereco("Rua Prudente de Morais, 292 – Carmo");
        l26.setTelefone("(81) 3429.1457");
        l26.setSite("");
        l26.setLatitude(-8.0257900);
        l26.setLongitude(-34.8644270);
        l26.setImagem(R.drawable.pousada_alquimia);
        mLocais.add(l26);

        Local l27 = new Local();
        l27.setEmail("info@pousadaaltoastral.com");
        l27.setHorario("");
        l27.set_nome_local("CEMO (Pousada Alto Astral)");
        l27.setTipo("Hospedagem");
        l27.setEndereco("Rua 13 de Maio, 305 – Varadouro");
        l27.setTelefone("(81) 3439.3453");
        l27.setSite("");
        l27.setLatitude(-8.0257900);
        l27.setLongitude(-34.8644270);
        l27.setImagem(R.drawable.pousada_alto_astral);
        mLocais.add(l27);

        Local l28 = new Local();
        l28.setEmail("contato@pousadabaobadeolinda.com.br");
        l28.setHorario("");
        l28.set_nome_local("CEMO (Pousada Baoba)");
        l28.setTipo("Hospedagem");
        l28.setEndereco("Rua do Sol, 147 – Carmo");
        l28.setTelefone("(81) 3429.0459");
        l28.setSite("");
        l28.setLatitude(-8.0257900);
        l28.setLongitude(-34.8644270);
        l28.setImagem(R.drawable.pousada_baoba);
        mLocais.add(l28);

        Local l29 = new Local();
        l29.setEmail("casadechica@gmail.com");
        l29.setHorario("");
        l29.set_nome_local("CEMO (Pousada de Chica)");
        l29.setTipo("Hospedagem");
        l29.setEndereco("Rua 27 de janeiro,43 – Carmo");
        l29.setTelefone("(81) 3429.1698");
        l29.setSite("");
        l29.setLatitude(-8.0257900);
        l29.setLongitude(-34.8644270);
        l29.setImagem(R.drawable.pousada_casa_chica);
        mLocais.add(l29);

        Local l30 = new Local();
        l30.setEmail("");
        l30.setHorario("");
        l30.set_nome_local("Hotel Castelo Real");
        l30.setTipo("Hospedagem");
        l30.setEndereco("Rua Dr. Luiz Ribeiro, 120 – Jardim Fragoso / Olinda");
        l30.setTelefone("(81) 3429 2765");
        l30.setSite("");
        l30.setLatitude(-8.0257900);
        l30.setLongitude(-34.8644270);
        l30.setImagem(R.drawable.hotel_castelo_real);
        mLocais.add(l30);

        Local l31 = new Local();
        l31.setEmail("");
        l31.setHorario("de segunda a sexta-feira, das 8h às 11h, e das 13h às 17h.");
        l31.set_nome_local("CEMO (Igreja de Nossa Senhora do Rosário dos Homens Pretos)");
        l31.setTipo("Igreja");
        l31.setEndereco("Largo do Bonsucesso, 45 – Bonsucesso.");
        l31.setTelefone("(81) 3439.2495");
        l31.setSite("");
        l31.setLatitude(-8.0257900);
        l31.setLongitude(-34.8644270);
        l31.setImagem(R.drawable.igreja_rosario_homens_pretos);
        mLocais.add(l31);

        Local l32 = new Local();
        l32.setEmail("");
        l32.setHorario("de segunda a sexta-feira, das 7h às 22h.");
        l32.set_nome_local("CEMO (Igreja de Santa Cruz dos Milagres)");
        l32.setTipo("Igreja");
        l32.setEndereco(" Praça dos Milagres, s/n.");
        l32.setTelefone("(81)3439.0406");
        l32.setSite("");
        l32.setLatitude(-8.0257900);
        l32.setLongitude(-34.8644270);
        l32.setImagem(R.drawable.igreja_santa_cruz_milagres);
        mLocais.add(l32);

        Local l33 = new Local();
        l33.setEmail("");
        l33.setHorario("");
        l33.set_nome_local("CEMO (Igreja de São João Batista dos Militares)");
        l33.setTipo("Igreja");
        l33.setEndereco(" Avenida da Saudade, s/n – Amparo.");
        l33.setTelefone("(81) 3429.9349");
        l33.setSite("");
        l33.setLatitude(-8.0257900);
        l33.setLongitude(-34.8644270);
        l33.setImagem(R.drawable.igreja_sao_joao_batista_militares);
        mLocais.add(l33);

        Local l34 = new Local();
        l34.setEmail("");
        l34.setHorario(" todos os dias, das 9h às 11h");
        l34.set_nome_local("CEMO (Igreja de São José dos Pescadores ou Ribamar)");
        l34.setTipo("Igreja");
        l34.setEndereco("Rua do sol s/n carmo.");
        l34.setTelefone("(81)3429.3156");
        l34.setSite("");
        l34.setLatitude(-8.0257900);
        l34.setLongitude(-34.8644270);
        l34.setImagem(R.drawable.igreja_sao_jose_pescadores_ribamar);
        mLocais.add(l34);

        Local l35 = new Local();
        l35.setEmail("");
        l35.setHorario("quinta-feira, das 9h às 12h.");
        l35.set_nome_local("CEMO (Igreja de São Pedro Apóstolo)");
        l35.setTipo("Igreja");
        l35.setEndereco("Rua do sol s/n carmo.");
        l35.setTelefone("(81)3429.3156");
        l35.setSite("");
        l35.setLatitude(-8.0257900);
        l35.setLongitude(-34.8644270);
        l35.setImagem(R.drawable.igreja_sao_pedro_apostolo);
        mLocais.add(l35);

        Local l36 = new Local();
        l36.setEmail("");
        l36.setHorario("sábado, das 15h às 18h");
        l36.set_nome_local("CEMO (Igreja de São Sebastião)");
        l36.setTipo("Igreja");
        l36.setEndereco("Rua XV de Novembro, s/n – Varadouro.");
        l36.setTelefone("");
        l36.setSite("");
        l36.setLatitude(-8.0257900);
        l36.setLongitude(-34.8644270);
        l36.setImagem(R.drawable.igreja_sao_sebastiao);
        mLocais.add(l36);

        Local l37 = new Local();
        l37.setEmail("");
        l37.setHorario(" segunda-feira, das 15h às 18h; terça-feira, das 6h às 9h e das 15h às 18h; e domingo, das 7h às 11h.");
        l37.set_nome_local("CEMO (Igreja do Bom Jesus do Bonfim)");
        l37.setTipo("Igreja");
        l37.setEndereco("Travessa do Bonfim, s/n – Carmo.");
        l37.setTelefone("(");
        l37.setSite("");
        l37.setLatitude(-8.0257900);
        l37.setLongitude(-34.8644270);
        l37.setImagem(R.drawable.igreja_bom_jesus_bonfim);
        mLocais.add(l37);

        Local l38 = new Local();
        l38.setEmail("");
        l38.setHorario(" terça a sábado, das 9h às 17h.");
        l38.set_nome_local("CEMO (Igreja do Carmo)");
        l38.setTipo("Igreja");
        l38.setEndereco("Praça do Carmo, s/n – Carmo.");
        l38.setTelefone("(81)3494.7573");
        l38.setSite("");
        l38.setLatitude(-8.0257900);
        l38.setLongitude(-34.8644270);
        l38.setImagem(R.drawable.igreja_do_carmo);
        mLocais.add(l38);

        Local l39 = new Local();
        l39.setEmail("");
        l39.setHorario(" todos os dias, das 9h às 11h");
        l39.set_nome_local("CEMO (Igreja de São José dos Pescadores ou Ribamar)");
        l39.setTipo("Hospedagem");
        l39.setEndereco("Rua do sol s/n carmo.");
        l39.setTelefone("(81)3429.3156");
        l39.setSite("");
        l39.setLatitude(-8.0257900);
        l39.setLongitude(-34.8644270);
        l39.setImagem(R.drawable.igreja_sao_jose_pescadores_ribamar);
        mLocais.add(l39);

        Local l40 = new Local();
        l40.setEmail("");
        l40.setHorario("");
        l40.set_nome_local("CEMO (CEMO (Coreto da Praça da Preguiça)");
        l40.setTipo("Monumentos");
        l40.setEndereco(" Avenida Liberdade, s/n – Carmo.");
        l40.setTelefone("(");
        l40.setSite("");
        l40.setLatitude(-8.0257900);
        l40.setLongitude(-34.8644270);
        l40.setImagem(R.drawable.coreto_praca_preguica);
        mLocais.add(l40);

        Local l41 = new Local();
        l41.setEmail("");
        l41.setHorario("");
        l41.set_nome_local("CEMO (CEMO (Farol de Olinda)");
        l41.setTipo("Monumentos");
        l41.setEndereco("Amaro Branco..");
        l41.setTelefone("(");
        l41.setSite("");
        l41.setLatitude(-8.0257900);
        l41.setLongitude(-34.8644270);
        l41.setImagem(R.drawable.farol);
        mLocais.add(l41);


        Local l42 = new Local();
        l42.setEmail("");
        l42.setHorario("");
        l42.set_nome_local("CEMO (CEMO (Fortim de São Francisco (Fortim do Queijo))");
        l42.setTipo("Monumentos");
        l42.setEndereco(" Rua do Sol – Carmo.");
        l42.setTelefone("(");
        l42.setSite("");
        l42.setLatitude(-8.0257900);
        l42.setLongitude(-34.8644270);
        l42.setImagem(R.drawable.forte_sao_francisco);
        mLocais.add(l42);



        Local l43 = new Local();
        l43.setEmail("");
        l43.setHorario("");
        l43.set_nome_local("CEMO (CEMO (Conjunto da Maxambomba)");
        l43.setTipo("Monumentos");
        l43.setEndereco("Praça do Carmo, s/n – Carmo.");
        l43.setTelefone("(");
        l43.setSite("");
        l43.setLatitude(-8.0257900);
        l43.setLongitude(-34.8644270);
        l43.setImagem(R.drawable.estacao_maxambomba);
        mLocais.add(l43);

        Local l44 = new Local();
        l44.setEmail("");
        l44.setHorario("");
        l44.set_nome_local("CEMO (CEMO (Mercado Eufrásio Barbosa)");
        l44.setTipo("Monumentos");
        l44.setEndereco("Av. Joaquim Nabuco, s/n – Varadouro.");
        l44.setTelefone("( (81) 3429-3599");
        l44.setSite("");
        l44.setLatitude(-8.0257900);
        l44.setLongitude(-34.8644270);
        l44.setImagem(R.drawable.mercado_eufrasio);
        mLocais.add(l44);

        Local l45 = new Local();
        l45.setEmail("");
        l45.setHorario("");
        l45.set_nome_local("CEMO (CEMO (Mercado da Ribeira)");
        l45.setTipo("Monumentos");
        l45.setEndereco("Rua Bernardo Vieira de Melo, s/n – Ribeira.");
        l45.setTelefone("(");
        l45.setSite("");
        l45.setLatitude(-8.0257900);
        l45.setLongitude(-34.8644270);
        l45.setImagem(R.drawable.mercado_ribeira);
        mLocais.add(l45);

        Local l46 = new Local();
        l46.setEmail("");
        l46.setHorario("de terça-feira a domingo, das 16h às 20h.");
        l46.set_nome_local("CEMO (CEMO (Observatório Astronômico)");
        l46.setTipo("Monumentos");
        l46.setEndereco(" Rua Bispo Coutinho, s/n – Alto da Sé.");
        l46.setTelefone("(");
        l46.setSite("");
        l46.setLatitude(-8.0257900);
        l46.setLongitude(-34.8644270);
        l46.setImagem(R.drawable.observatorio);
        mLocais.add(l46);


        Local l47 = new Local();
        l47.setEmail("galeria@estacao4cantos.com.br");
        l47.setHorario("");
        l47.set_nome_local("CEMO (CEMO (Estação Quatro Cantos (Café))");
        l47.setTipo("Gastromia");
        l47.setEndereco("Rua Prudente de Morais, 440 – Carmo");
        l47.setTelefone("((81) 3429.7575");
        l47.setSite("");
        l47.setLatitude(-8.0257900);
        l47.setLongitude(-34.8644270);
        l47.setImagem(R.drawable.estacao_quatro_cantos);
        mLocais.add(l47);

        Local l48 = new Local();
        l48.setEmail("reserva@pousadadoamparo.com.br");
        l48.setHorario(" seg a sex, das 18h às 23h30;sáb e dom, das 12h às 17h e das 18h às 23h30");
        l48.set_nome_local("CEMO (CEMO (Flor do Coco Pousada do Amparo)");
        l48.setTipo("Gastronomia");
        l48.setEndereco("Rua do Amparo, 199 – Amparo.");
        l48.setTelefone("((81) 3439.1749");
        l48.setSite("");
        l48.setLatitude(-8.0257900);
        l48.setLongitude(-34.8644270);
        l48.setImagem(R.drawable.pousada_amparo_fachada);
        mLocais.add(l48);

        Local l49 = new Local();
        l49.setEmail("");
        l49.setHorario("dom a seg, das 12h às 20h / sáb, das 12h às 16h");
        l49.set_nome_local("CEMO (CEMO (Casa Iaça)");
        l49.setTipo("Gastronomia");
        l49.setEndereco("Rua Prudente de Morais, 351 – Carmo");
        l49.setTelefone("(");
        l49.setSite("");
        l49.setLatitude(-8.0257900);
        l49.setLongitude(-34.8644270);
        l49.setImagem(R.drawable.casa_iaca);
        mLocais.add(l49);

        return mLocais;

    }

    public ArrayList<Local> getGastronomicos() {
        ArrayList<Local> gastronomicos = new ArrayList<>();
        for (Local local: mLocais) {
            if (Objects.equals(local.getTipo(), "Gastronomia")) {
                gastronomicos.add( local );
            }
        }
        return gastronomicos;
    }

    public ArrayList<Local> getHospedagens() {
        ArrayList<Local> hospedagens = new ArrayList<>();
        for (int i = 0; i < mLocais.size(); i++) {
            Local l = new Local();
            if (Objects.equals(mLocais.get(i).getTipo(), "Hospedagem")) {
                hospedagens.add( mLocais.get(i) );
            }
        }
        return hospedagens;
    }

    public ArrayList<Local> getIgrejas() {
        ArrayList<Local> Igrejas = new ArrayList<Local>();
        for (int i = 0; i < mLocais.size(); i++) {
            Local l = new Local();
            if (Objects.equals(mLocais.get(i).getTipo(), "Igreja")) {
                Igrejas.add( mLocais.get(i) );
            }
        }
        return Igrejas;
    }

    public ArrayList<Local> getMonumentos() {
        ArrayList<Local> Monumentos = new ArrayList<>();
        for (int i = 0; i < mLocais.size(); i++) {
            Local l = new Local();
            if (Objects.equals(mLocais.get(i).getTipo(), "Monumento")) {
                Monumentos.add( mLocais.get(i) );
            }
        }
        return Monumentos;
    }

    public Local getLocal(UUID id) {
        for (Local l : mLocais){
            if(l.getId().equals(id))
                return l;
        }
        return null;
    }

    public void createEvent(int imagem, String nome,  String local, String horario, String atracoes){

        Evento evento = new Evento();
        evento.setImagem(imagem);
        evento.setNomeEvento(nome);
        evento.setLocal(local);
        evento.setHorário(horario);
        evento.setAtracoes(atracoes);
        mEventos.add(evento);
    }

    public ArrayList<Evento> getEventos(){
        return mEventos;
    }

    public void flushEvents(){
        this.mEventos.clear();
    }

}
