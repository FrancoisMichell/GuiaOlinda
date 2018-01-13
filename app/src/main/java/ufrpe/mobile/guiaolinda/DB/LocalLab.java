package ufrpe.mobile.guiaolinda.DB;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Carnaval;
import ufrpe.mobile.guiaolinda.Services.Evento;
import ufrpe.mobile.guiaolinda.Services.Homenageados;
import ufrpe.mobile.guiaolinda.Services.Local;

public class LocalLab {
    private static LocalLab sLocalLab;
    private ArrayList<Local> mLocais;
    private ArrayList<Evento> mEventos = new ArrayList<>();
    private ArrayList<Homenageados> mHomenageados = new ArrayList<>();
    private ArrayList<Carnaval> mCarnaval = new ArrayList<>();

    private LocalLab() {
        createLocais();
    }

    public static LocalLab get() {
        if (sLocalLab == null) {
            sLocalLab = new LocalLab();
        }
        return sLocalLab;
    }

    public ArrayList<Local> getLocais() {
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
        l9.setImagem(R.drawable.hotel_pousada_sao_francisco);
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
        l11.setLatitude(-8.0119006);
        l11.setLongitude(-34.8535775);
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
        l12.setLatitude(-8.0085230);
        l12.setLongitude(-34.8568720);
        l12.setImagem(R.drawable.igreja_nossa_senhora_de_guadalupe);
        mLocais.add(l12);

        Local l13 = new Local();
        l13.setEmail("");
        l13.setHorario("");
        l13.set_nome_local("Igreja de Nossa Senhora da Misericórdia");
        l13.setTipo("Igreja");
        l13.setEndereco("Rua Bispo Coutinho, s/n, Alto da Sé");
        l13.setTelefone("(81) 3494.9100");
        l13.setSite("");
        l13.setLatitude(-8.0129702);
        l13.setLongitude(-34.8522564);
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
        l15.setLatitude(-8.0158805);
        l15.setLongitude(-34.8543575);
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
        l20.setImagem(R.drawable.centro_de_ducacao_musical_de_olinda);
        mLocais.add(l20);

        Local l21 = new Local();
        l21.setEmail("casadenoca@terra.com.br");
        l21.setHorario("todos os dias, das 11h às 0h");
        l21.set_nome_local("Casa de noca");
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
        l22.set_nome_local("Casa Maloca ");
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
        l23.set_nome_local("Creperia de Olinda ");
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
        l24.set_nome_local("Due");
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
        l25.set_nome_local("Estação Quatro Cantos (Café)");
        l25.setTipo("Gastronomia");
        l25.setEndereco("Rua Prudente de Morais, 440 – Carmo");
        l25.setTelefone("(81) 3429.7575");
        l25.setSite("");
        l25.setLatitude(-8.0257900);
        l25.setLongitude(-34.8644270);
        l25.setImagem(R.drawable.estacao_quatro_cantos_cafe);
        mLocais.add(l25);

        Local l26 = new Local();
        l26.setEmail("");
        l26.setHorario("");
        l26.set_nome_local("Pousada Alquimia");
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
        l27.set_nome_local("Pousada Alto Astral");
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
        l28.set_nome_local("Pousada Baoba");
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
        l29.set_nome_local("Pousada de Chica");
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
        l31.set_nome_local("Igreja de Nossa Senhora do Rosário dos Homens Pretos");
        l31.setTipo("Igreja");
        l31.setEndereco("Largo do Bonsucesso, 45 – Bonsucesso.");
        l31.setTelefone("(81) 3439.2495");
        l31.setSite("");
        l31.setLatitude(-8.0101981);
        l31.setLongitude(-34.8536060);
        l31.setImagem(R.drawable.igreja_rosario_homens_pretos);
        mLocais.add(l31);

        Local l32 = new Local();
        l32.setEmail("");
        l32.setHorario("de segunda a sexta-feira, das 7h às 22h.");
        l32.set_nome_local("Igreja de Santa Cruz dos Milagres");
        l32.setTipo("Igreja");
        l32.setEndereco("Praça dos Milagres, s/n.");
        l32.setTelefone("(81)3439.0406");
        l32.setSite("");
        l32.setLatitude(-8.0222770);
        l32.setLongitude(-34.8524407);
        l32.setImagem(R.drawable.igreja_santa_cruz_milagres);
        mLocais.add(l32);

        Local l33 = new Local();
        l33.setEmail("");
        l33.setHorario("");
        l33.set_nome_local("Igreja de São João Batista dos Militares");
        l33.setTipo("Igreja");
        l33.setEndereco(" Avenida da Saudade, s/n – Amparo.");
        l33.setTelefone("(81) 3429.9349");
        l33.setSite("");
        l33.setLatitude(-8.0102572);
        l33.setLongitude(-34.8549066);
        l33.setImagem(R.drawable.igreja_sao_joao_batista_militares);
        mLocais.add(l33);

        Local l34 = new Local();
        l34.setEmail("");
        l34.setHorario(" todos os dias, das 9h às 11h");
        l34.set_nome_local("Igreja de São José dos Pescadores ou Ribamar");
        l34.setTipo("Igreja");
        l34.setEndereco("Rua do sol s/n carmo.");
        l34.setTelefone("(81)3429.3156");
        l34.setSite("");
        l34.setLatitude(-8.0148504);
        l34.setLongitude(-34.8458823);
        l34.setImagem(R.drawable.igreja_sao_jose_pescadores_ribamar);
        mLocais.add(l34);

        Local l35 = new Local();
        l35.setEmail("");
        l35.setHorario("Igreja em restauração");
        l35.set_nome_local("Igreja de São Pedro Apóstolo");
        l35.setTipo("Igreja");
        l35.setEndereco("Praça Conselheiro João Alfredo - Carmo");
        l35.setTelefone("(81)3493-1874");
        l35.setSite("");
        l35.setLatitude(-8.0167253);
        l35.setLongitude(-34.8511471);
        l35.setImagem(R.drawable.igreja_sao_pedro_apostolo);
        mLocais.add(l35);

        Local l36 = new Local();
        l36.setEmail("");
        l36.setHorario("sábado, das 15h às 18h");
        l36.set_nome_local("Igreja de São Sebastião");
        l36.setTipo("Igreja");
        l36.setEndereco("Rua XV de Novembro, s/n – Varadouro.");
        l36.setTelefone("");
        l36.setSite("");
        l36.setLatitude(-8.0192431);
        l36.setLongitude(-34.8537508);
        l36.setImagem(R.drawable.igreja_sao_sebastiao);
        mLocais.add(l36);

        Local l37 = new Local();
        l37.setEmail("");
        l37.setHorario(" segunda-feira, das 15h às 18h; terça-feira, das 6h às 9h e das 15h às 18h; e domingo, das 7h às 11h.");
        l37.set_nome_local("Igreja do Bom Jesus do Bonfim");
        l37.setTipo("Igreja");
        l37.setEndereco("R. Pedro Monteiro, s/n - Carmo");
        l37.setTelefone("");
        l37.setSite("");
        l37.setLatitude(-8.0144788);
        l37.setLongitude(-34.8514418);
        l37.setImagem(R.drawable.igreja_bom_jesus_bonfim);
        mLocais.add(l37);

        Local l38 = new Local();
        l38.setEmail("");
        l38.setHorario("Terça à sábado das 9h às 12h. Sábado das 14h às 17h. Domingo das 10h às 18h.");
        l38.set_nome_local("Igreja do Carmo");
        l38.setTipo("Igreja");
        l38.setEndereco("Praça do Carmo, s/n – Carmo.");
        l38.setTelefone("(81)3494.7573");
        l38.setSite("");
        l38.setLatitude(-8.0171635);
        l38.setLongitude(-34.8492111);
        l38.setImagem(R.drawable.igreja_do_carmo);
        mLocais.add(l38);

        Local l39 = new Local();
        l39.setEmail("");
        l39.setHorario(" todos os dias, das 9h às 11h");
        l39.set_nome_local("Igreja de São José dos Pescadores ou Ribamar");
        l39.setTipo("Igrejas");
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
        l40.set_nome_local("CEMO (Coreto da Praça da Preguiça)");
        l40.setTipo("Monumentos");
        l40.setEndereco(" Avenida Liberdade, s/n – Carmo.");
        l40.setTelefone("");
        l40.setSite("");
        l40.setLatitude(-8.0257900);
        l40.setLongitude(-34.8644270);
        l40.setImagem(R.drawable.coreto_praca_preguica);
        mLocais.add(l40);

        Local l41 = new Local();
        l41.setEmail("");
        l41.setHorario("");
        l41.set_nome_local("Farol de Olinda");
        l41.setTipo("Monumentos");
        l41.setEndereco("Amaro Branco..");
        l41.setTelefone("");
        l41.setSite("");
        l41.setLatitude(-8.0257900);
        l41.setLongitude(-34.8644270);
        l41.setImagem(R.drawable.farol);
        mLocais.add(l41);


        Local l42 = new Local();
        l42.setEmail("");
        l42.setHorario("");
        l42.set_nome_local("Fortim de São Francisco (Fortim do Queijo)");
        l42.setTipo("Monumentos");
        l42.setEndereco(" Rua do Sol – Carmo.");
        l42.setTelefone("");
        l42.setSite("");
        l42.setLatitude(-8.0257900);
        l42.setLongitude(-34.8644270);
        l42.setImagem(R.drawable.fortim_sao_francisco);
        mLocais.add(l42);


        Local l43 = new Local();
        l43.setEmail("");
        l43.setHorario("");
        l43.set_nome_local("Conjunto da Maxambomba");
        l43.setTipo("Monumentos");
        l43.setEndereco("Praça do Carmo, s/n – Carmo.");
        l43.setTelefone("");
        l43.setSite("");
        l43.setLatitude(-8.0257900);
        l43.setLongitude(-34.8644270);
        l43.setImagem(R.drawable.estacao_maxambomba);
        mLocais.add(l43);

        Local l44 = new Local();
        l44.setEmail("");
        l44.setHorario("");
        l44.set_nome_local("Mercado Eufrásio Barbosa");
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
        l45.set_nome_local("Mercado da Ribeira");
        l45.setTipo("Monumentos");
        l45.setEndereco("Rua Bernardo Vieira de Melo, s/n – Ribeira.");
        l45.setTelefone("");
        l45.setSite("");
        l45.setLatitude(-8.0257900);
        l45.setLongitude(-34.8644270);
        l45.setImagem(R.drawable.mercado_ribeira);
        mLocais.add(l45);

        Local l46 = new Local();
        l46.setEmail("");
        l46.setHorario("de terça-feira a domingo, das 16h às 20h.");
        l46.set_nome_local("Observatório Astronômico");
        l46.setTipo("Monumentos");
        l46.setEndereco(" Rua Bispo Coutinho, s/n – Alto da Sé.");
        l46.setTelefone("");
        l46.setSite("");
        l46.setLatitude(-8.0257900);
        l46.setLongitude(-34.8644270);
        l46.setImagem(R.drawable.observatorio);
        mLocais.add(l46);

        Local l48 = new Local();
        l48.setEmail("reserva@pousadadoamparo.com.br");
        l48.setHorario(" seg a sex, das 18h às 23h30;sáb e dom, das 12h às 17h e das 18h às 23h30");
        l48.set_nome_local("Flor do Coco Pousada do Amparo");
        l48.setTipo("Gastronomia");
        l48.setEndereco("Rua do Amparo, 199 – Amparo.");
        l48.setTelefone("((81) 3439.1749");
        l48.setSite("");
        l48.setLatitude(-8.0257900);
        l48.setLongitude(-34.8644270);
        l48.setImagem(R.drawable.pousada_amparo);
        mLocais.add(l48);

        Local l49 = new Local();
        l49.setEmail("");
        l49.setHorario("dom a seg, das 12h às 20h / sáb, das 12h às 16h");
        l49.set_nome_local("Casa Iaça");
        l49.setTipo("Gastronomia");
        l49.setEndereco("Rua Prudente de Morais, 351 – Carmo");
        l49.setTelefone("");
        l49.setSite("");
        l49.setLatitude(-8.0257900);
        l49.setLongitude(-34.8644270);
        l49.setImagem(R.drawable.casa_iaca);
        mLocais.add(l49);

        Local l50 = new Local();
        l50.setEmail("");
        l50.setHorario("Segunda à sábado 8h às 12h e 14h às 16h. Domingos das 6h às 15h. ");
        l50.set_nome_local("IGREJA DO SÃO SALVADOR DO MUNDO (CATEDRAL DA SÉ)");
        l50.setTipo("Igreja");
        l50.setEndereco("ALTO DA SÉ, S/N. CIDADE ALTA, ");
        l50.setTelefone("");
        l50.setSite("");
        l50.setLatitude(-8.0138883);
        l50.setLongitude(-34.8490512);
        l50.setImagem(R.drawable.igreja_sao_salvador_do_mundo_igreja_se);
        mLocais.add(l50);

        Local l51 = new Local();
        l51.setEmail("");
        l51.setHorario("Segunda à sábado 8h às 12h e 14h às 16h. Domingos das 6h às 15h. ");
        l51.set_nome_local("IGREJA DE NOSSA SENHORA DO DESTERRO E CONVENTO DE SANTA TEREZA");
        l51.setTipo("Igreja");
        l51.setEndereco("Avenida Olinda, 570 - Santa Tereza");
        l51.setTelefone("(81) 3429-3686");
        l51.setSite("");
        l51.setLatitude(-8.0219562);
        l51.setLongitude(-34.8592905);
        l51.setImagem(R.drawable.igreja_nossa_senhora_do_desterro_e_convento_santa_tereza);
        mLocais.add(l51);


        Local l52 = new Local();
        l52.setEmail("");
        l52.setHorario("Sem abertura para visitação.");
        l52.set_nome_local("IGREJA E CONVENTO DE NOSSA SENHORA DA CONCEIÇÃO");
        l52.setTipo("Igreja");
        l52.setEndereco("RUA BISPO COUTINHO (LARGO DA MISERICÓRDIA), S/N, CARMO");
        l52.setTelefone("(81) 3429-3108");
        l52.setSite("");
        l52.setLatitude(-8.0118139);
        l52.setLongitude(-34.8515215);
        l52.setImagem(R.drawable.igreja_convento_nossa_senhora_da_conceicao);
        mLocais.add(l52);

        Local l53 = new Local();
        l53.setEmail("");
        l53.setHorario("Todos os dias das 8h30 às 11h e das 14h30 às 16h40");
        l53.set_nome_local("IGREJA E MOSTEIRO DE NOSSA SENHORA DO MONTE");
        l53.setTipo("Igreja");
        l53.setEndereco("PRAÇA DE NOSSA SENHORA DO MONTE, S/N");
        l53.setTelefone("(81) 3429-0317");
        l53.setSite("");
        l53.setLatitude(-8.0048226);
        l53.setLongitude(-34.8504426);
        l53.setImagem(R.drawable.igreja_mosteiro_nossa_senhora_monte);
        mLocais.add(l53);

        Local l54 = new Local();
        l54.setEmail("");
        l54.setHorario("Todos os dias das 5h30 às 11h30 e das 14h às 18h00. Cantos Gregorianos: aos domingos às 10h.");
        l54.set_nome_local("BASÍLICA E MOSTEIRO DE SÃO BENTO");
        l54.setTipo("Igreja");
        l54.setEndereco("RUA DE SÃO BENTO, S/N, VARADOURO");
        l54.setTelefone("(81) 3316-3290");
        l54.setSite("");
        l54.setLatitude(-8.0199202);
        l54.setLongitude(-34.8520052);
        l54.setImagem(R.drawable.basilica_mosteiro_sao_bento);
        mLocais.add(l54);

        Local l55 = new Local();
        l55.setEmail("");
        l55.setHorario("Sem abertura para visitação");
        l55.set_nome_local("SEMINÁRIO DE OLINDA - IGREJA DE NOSSA SENHORA DAS GRAÇAS");
        l55.setTipo("Igreja");
        l55.setEndereco("RUA BISPO COUTINHO, S/N, ALTO DA SÉ");
        l55.setTelefone("(81) 3429-0627 / 3429-5349");
        l55.setSite("");
        l55.setLatitude(-8.0127734);
        l55.setLongitude(-34.8479129);
        l55.setImagem(R.drawable.seminario_olinda_igreja_nossa_senhora_gracas);
        mLocais.add(l55);


        Local l56 = new Local();
        l56.setEmail("");
        l56.setHorario("");
        l56.set_nome_local("BICA DE SÃO PEDRO");
        l56.setTipo("Monumento");
        l56.setEndereco("RUA CORONEL HENRIQUE DIAS, VARADOURO");
        l56.setTelefone("");
        l56.setSite("");
        l56.setLatitude(-8.0174813);
        l56.setLongitude(-34.8536867);
        l56.setImagem(R.drawable.bica_sao_pedro);
        mLocais.add(l56);

        Local l57 = new Local();
        l57.setEmail("");
        l57.setHorario("");
        l57.set_nome_local("BICA DO ROSÁRIO");
        l57.setTipo("Monumento");
        l57.setEndereco("ESTRADA DO BONSUCESSO, BONSUCESSO");
        l57.setTelefone("");
        l57.setSite("");
        l57.setLatitude(-8.0098574);
        l57.setLongitude(-34.8529673);
        l57.setImagem(R.drawable.bica_rosario);
        mLocais.add(l57);

        Local l58 = new Local();
        l58.setEmail("");
        l58.setHorario("");
        l58.set_nome_local("BICA DOS 4 CANTOS");
        l58.setTipo("Monumento");
        l58.setEndereco("RUA BICA DOS QUATRO CANTOS, AMPARO");
        l58.setTelefone("");
        l58.setSite("");
        l58.setLatitude(-8.0138963);
        l58.setLongitude(-34.8532753);
        l58.setImagem(R.drawable.bica_quatro_cantos);
        mLocais.add(l58);

        Local l59 = new Local();
        l59.setEmail("");
        l59.setHorario("");
        l59.set_nome_local("SOBRADO MOURISCO DA RUA DO AMPARO");
        l59.setTipo("Monumento");
        l59.setEndereco("RUA DO AMPARO, Nº 28, AMPARO");
        l59.setTelefone("");
        l59.setSite("");
        l59.setLatitude(-8.0143530);
        l59.setLongitude(-34.8530110);
        l59.setImagem(R.drawable.sobrado_mourisco_rua_amparo);
        mLocais.add(l59);

        Local l61 = new Local();
        l61.setEmail("");
        l61.setHorario("");
        l61.set_nome_local("SOBRADO MOURISCO DA PRAÇA DE SÃO PEDRO");
        l61.setTipo("Monumento");
        l61.setEndereco("PRAÇA CONSELHEIRO JOÃO ALFREDO, Nº 07, CARMO");
        l61.setTelefone("");
        l61.setSite("");
        l61.setLatitude(-8.0166792);
        l61.setLongitude(-34.8507882);
        l61.setImagem(R.drawable.sobrado_mourisco_praca_sao_pedro);
        mLocais.add(l61);

        Local l62 = new Local();
        l62.setEmail("");
        l62.setHorario("Museu em reforma");
        l62.set_nome_local("MAC - MUSEU DE ARTE CONTEMPOR NEA");
        l62.setTipo("Monumento");
        l62.setEndereco("RUA 13 DE MAIO, S/N");
        l62.setTelefone("(81) 3184-3153");
        l62.setSite("");
        l62.setLatitude(-8.0162660);
        l62.setLongitude(-34.8532900);
        l62.setImagem(R.drawable.museu_arte_conteporanea);
        mLocais.add(l62);

        Local l63 = new Local();
        l63.setEmail("");
        l63.setHorario("De terça-feira a Domingo  das 10h às 17h");
        l63.setPreco("R$ 5,00 (inteira) e R$ 2,50 (meia)");
        l63.set_nome_local("MASPE - MUSEU DE ARTE SACRA DE PERNAMBUCO");
        l63.setTipo("Monumento");
        l63.setEndereco("R. BISPO COUTINHO, 726, CARMO-ALTO DA SÉ");
        l63.setTelefone("81 3184-3154");
        l63.setSite("");
        l63.setLatitude(-8.0133252);
        l63.setLongitude(-34.8502790);
        l63.setImagem(R.drawable.museu_arte_sacra_pernambuco);
        mLocais.add(l63);

        Local l64 = new Local();
        l64.setEmail("");
        l64.setHorario("De Segunda-feira a sexta-feira das 9h às 17h.");
        l64.setPreco("R$ 2,00 . Grupo escolar de escola municipal ou estadual com visita AGENDADA e crianças até 6 anos não pagam.");
        l64.set_nome_local("MUSEU DO MAMELUNGO");
        l64.setTipo("Monumento");
        l64.setEndereco("RUA DE SÃO BENTO, 344");
        l64.setTelefone("(81) 3493-2753");
        l64.setSite("");
        l64.setLatitude(-8.0163083);
        l64.setLongitude(-34.8524190);
        l64.setImagem(R.drawable.museu_mamelungo);
        mLocais.add(l64);

        Local l65 = new Local();
        l65.setEmail("");
        l65.setHorario("De terça-feira a sexta-feira das 9h às 13h e das 14h às 17h. Sábados e domingos das 14h às 17h");
        l65.setPreco("R$ 2,00 (inteira) e R$ 1,00 (meia) para estudante. Grupo escolar de escola municipal " +
                "   ou estadual com visita AGENDADA, criança até 12 anos e idoso acima de 65 anos não pagam.");
        l65.set_nome_local("MUSEU REGIONAL DE OLINDA");
        l65.setTipo("Monumento");
        l65.setEndereco("RUA DO AMPARO, 128");
        l65.setTelefone("(81) 3184-3159");
        l65.setSite("");
        l65.setLatitude(-8.0133513);
        l65.setLongitude(-34.8529317);
        l65.setImagem(R.drawable.museu_regional_de_olinda);
        mLocais.add(l65);

        Local l66 = new Local();
        l66.setEmail("");
        l66.setHorario("");
        l66.setPreco("");
        l66.set_nome_local("PASSO DA SÉ");
        l66.setTipo("Monumento");
        l66.setEndereco("Rua Bispo Coutinho, Alto da Sé.");
        l66.setTelefone("");
        l66.setSite("");
        l66.setLatitude(-8.0135678);
        l66.setLongitude(-34.8495823);
        l66.setImagem(R.drawable.passo_da_se);
        mLocais.add(l66);

        Local l67 = new Local();
        l67.setEmail("");
        l67.setHorario("");
        l67.setPreco("");
        l67.set_nome_local("PASSO DO SENHOR APRESENTADO AO POVO");
        l67.setTipo("Monumento");
        l67.setEndereco("RUA 27 DE JANEIRO, CARMO.");
        l67.setTelefone("");
        l67.setSite("");
        l67.setLatitude(-8.0174345);
        l67.setLongitude(-34.8516603);
        l67.setImagem(R.drawable.passo_senhor_apresentado_ao_povo);
        mLocais.add(l67);

        Local l68 = new Local();
        l68.setEmail("");
        l68.setHorario("");
        l68.setPreco("");
        l68.set_nome_local("PASSO DO AMPARO");
        l68.setTipo("Monumento");
        l68.setEndereco("RUA SALDANHA MARINHO, AMPARO.");
        l68.setTelefone("");
        l68.setSite("");
        l68.setLatitude(-8.0122190);
        l68.setLongitude(-34.8531570);
        l68.setImagem(R.drawable.passo_do_amparo);
        mLocais.add(l68);

        Local l69 = new Local();
        l69.setEmail("");
        l69.setHorario("");
        l69.setPreco("");
        l69.set_nome_local("PASSO DOS 4 CANTOS");
        l69.setTipo("Monumento");
        l69.setEndereco("QUATRO CANTOS, CARMO.");
        l69.setTelefone("");
        l69.setSite("");
        l69.setLatitude(-7.9907152);
        l69.setLongitude(-34.8416273);
        l69.setImagem(R.drawable.passo_quatro_cantos);
        mLocais.add(l69);

        Local l70 = new Local();
        l70.setEmail("");
        l70.setHorario("");
        l70.setPreco("");
        l70.set_nome_local("ARQUIVO MUNICIPAL DE OLINDA");
        l70.setTipo("Monumento");
        l70.setEndereco("RUA DE SÃO BENTO, N° 153, CEP: 53.000-000.");
        l70.setTelefone("(81) 3439-9629");
        l70.setSite("");
        l70.setLatitude(-8.0179182);
        l70.setLongitude(-34.8523718);
        l70.setImagem(R.drawable.arquivo_municipal);
        mLocais.add(l70);

        Local l71 = new Local();
        l71.setEmail("");
        l71.setHorario("");
        l71.setPreco("");
        l71.set_nome_local("BIBLIOTECA PÚBLICA DE OLINDA");
        l71.setTipo("Monumento");
        l71.setEndereco("AV. LIBERDADE, N° 100, CEP: 53.000-000.");
        l71.setTelefone("(81) 3305-1157");
        l71.setSite("");
        l71.setLatitude(-8.0163460);
        l71.setLongitude(-34.8488390);
        l71.setImagem(R.drawable.biblioteca_publica_de_olinda);
        mLocais.add(l71);

        Local l72 = new Local();
        l72.setEmail("");
        l72.setHorario("");
        l72.setPreco("");
        l72.set_nome_local("CAIXA D’ÁGUA E ELEVADOR PANOR MICO DA SÉ");
        l72.setTipo("Monumento");
        l72.setEndereco("RUA BISPO COUTINHO, ALTO DA SÉ, S/ N");
        l72.setTelefone("(81) 3439-4595");
        l72.setSite("");
        l72.setLatitude(-8.0134266);
        l72.setLongitude(-34.8499292);
        l72.setImagem(R.drawable.caixa_de_agua_e_elevador_panoramico_da_se);
        mLocais.add(l72);

        Local l73 = new Local();
        l73.setEmail("");
        l73.setHorario("Sem abertura para visitação.");
        l73.setPreco("");
        l73.set_nome_local("FAROL DE OLINDA");
        l73.setTipo("Monumento");
        l73.setEndereco("RUA DO FAROL, S/N, CEP: 53.000-000.");
        l73.setTelefone("(81) 3424-7111");
        l73.setSite("");
        l73.setLatitude(-8.0113019);
        l73.setLongitude(-34.8472850);
        l73.setImagem(R.drawable.farol);
        mLocais.add(l73);

        Local l74 = new Local();
        l74.setEmail("");
        l74.setHorario("");
        l74.setPreco("");
        l74.set_nome_local("FORTIM DE SÃO FRANCISCO (FORTIM DO QUEIJO)");
        l74.setTipo("Monumento");
        l74.setEndereco("AV. MINISTRO MARCOS FREIRE, S/N, CARMO, CEP: 53.000-000.");
        l74.setTelefone("");
        l74.setSite("");
        l74.setLatitude(-8.0157343);
        l74.setLongitude(-34.8463897);
        l74.setImagem(R.drawable.fortim_sao_francisco);
        mLocais.add(l74);

        Local l75 = new Local();
        l75.setEmail("");
        l75.setHorario("9h às 17h.");
        l75.setPreco("");
        l75.set_nome_local("MERCADO DA RIBEIRA");
        l75.setTipo("Monumento");
        l75.setEndereco("RUA BERNARDO VIEIRA DE MELO, N° 50, CEP: 53.000-000.");
        l75.setTelefone("");
        l75.setSite("");
        l75.setLatitude(-8.0156741);
        l75.setLongitude(-34.8524902);
        l75.setImagem(R.drawable.mercado_ribeira);
        mLocais.add(l75);

        Local l76 = new Local();
        l76.setEmail("");
        l76.setHorario("Mercado em restauração.");
        l76.setPreco("");
        l76.set_nome_local("MERCADO EUFRÁSIO BARBOSA");
        l76.setTipo("Monumento");
        l76.setEndereco("LARGO DO VARADOURO, S/N, CEP: 53.000-000.");
        l76.setTelefone("");
        l76.setSite("");
        l76.setLatitude(-8.0156741);
        l76.setLongitude(-34.8524902);
        l76.setImagem(R.drawable.mercado_eufrasio);
        mLocais.add(l76);

        Local l77 = new Local();
        l77.setEmail("");
        l77.setHorario("");
        l77.setPreco("");
        l77.set_nome_local("MERCADO DE ARTESANATO DO ALTO DA SÉ");
        l77.setTipo("Monumento");
        l77.setEndereco("RUA BISPO COUTINHO DE BAIXO, S/N, ALTO DA SÉ, CEP: 53.000-000.");
        l77.setTelefone("(81) 3499-1988");
        l77.setSite("");
        l77.setLatitude(-8.0136258);
        l77.setLongitude(-34.8502678);
        l77.setImagem(R.drawable.mercado_artesanato_do_alto_da_se);
        mLocais.add(l77);

        Local l78 = new Local();
        l78.setEmail("");
        l78.setHorario("De segunda-feira a sexta-feira das 15h às 18h. Sábados e domingos das 16h às 18h.");
        l78.setPreco("A entrada é gratuita.");
        l78.set_nome_local("OBSERVATÓRIO");
        l78.setTipo("Monumento");
        l78.setEndereco("RUA BISPO COUTINHO, ALTO DA SÉ, CEP: 53.000-000.");
        l78.setTelefone("(81) 3183-5531");
        l78.setSite("");
        l78.setLatitude(-8.0133295);
        l78.setLongitude(-34.8507464);
        l78.setImagem(R.drawable.observatorio);
        mLocais.add(l78);

        Local l79 = new Local();
        l79.setEmail("");
        l79.setHorario("");
        l79.setPreco("");
        l79.set_nome_local("RUÍNAS DO SENADO");
        l79.setTipo("Monumento");
        l79.setEndereco("RUA BERNARDO VIEIRA DE MELO, CARMO.");
        l79.setTelefone("");
        l79.setSite("");
        l79.setLatitude(-8.0155582);
        l79.setLongitude(-34.8523396);
        l79.setImagem(R.drawable.ruinas_do_senado);
        mLocais.add(l79);

//------------------------------------------------------------------------------------------------//

        Local l81 = new Local();
        l81.set_nome_local("Pousada dos Quatro Cantos");
        l81.setTipo("Hospedagem");
        l81.setEndereco("Rua Prudente de Moraes, 441 – Carmo");
        l81.setHorario("");
        l81.setTelefone("(81) 3429.0220");
        l81.setSite("www.pousada4cantos.com.br");
        l81.setEmail("hotel@pousada4cantos.com.br");
        l81.setImagem(R.drawable.pousada_dos_quatro_cantos);
        l81.setLatitude(-8.0149710);
        l81.setLongitude(-34.8526928);
        mLocais.add(l81);

        Local l82 = new Local();
        l82.set_nome_local("Pousada Duarte Coelho");
        l82.setTipo("Hospedagem");
        l82.setEndereco("Rua Coronel João Lapa, 162 – Varadouro");
        l82.setHorario("");
        l82.setTelefone("(81) 9226.6853 / 9444.0107");
        l82.setSite("www.pousadaduartecoelho.com.br");
        l82.setEmail("contato@pousadaduartecoelho.com.br");
        l82.setImagem(R.drawable.pousada_duarte_coelho);
        l82.setLatitude(-8.0180587);
        l82.setLongitude(-34.8529307);
        mLocais.add(l82);

        Local l83 = new Local();
        l83.set_nome_local("Pousada Marin dos Caetés");
        l83.setTipo("Hospedagem");
        l83.setEndereco("Av. Sigismundo Gonçalves, 732 – Carmo");
        l83.setHorario("");
        l83.setTelefone("(81) 3429.1532 /  3493.1556 / 8773.8803");
        l83.setSite("www.pousadamarindoscaetes.com.br");
        l83.setEmail("contato@pousadamarindoscaetes.com.br");
        l83.setLatitude(-8.0178423);
        l83.setLongitude(-34.8481497);
        l83.setImagem(R.drawable.pousada_marin_dos_caetes);
        mLocais.add(l83);

        Local l84 = new Local();
        l84.set_nome_local("Pousada D’Olinda");
        l84.setTipo("Hospedagem");
        l84.setEndereco("Rua Prudente de Moraes, 178 – Carmo");
        l84.setHorario("");
        l84.setTelefone("(81) 3494.2559 / 3493.6011");
        l84.setSite("www.pousadadolinda.com.br");
        l84.setEmail("sbai@pousadadolinda.com.br");
        l84.setImagem(R.drawable.pousada_d_olinda);
        l84.setLatitude(-8.0163050);
        l84.setLongitude(-34.8508140);
        mLocais.add(l84);

        Local l85 = new Local();
        l85.set_nome_local("Pousada São Pedro");
        l85.setTipo("Hospedagem");
        l85.setEndereco("Rua 27 de Janeiro, 95 – Carmo");
        l85.setHorario("");
        l85.setTelefone("(81) 3439.9546");
        l85.setSite("www.pousadapedro.com");
        l85.setEmail("arantes@pousadapedro.com");
        l85.setLatitude(-8.0171594);
        l85.setLongitude(-34.8513811);
        l85.setImagem(R.drawable.pousada_sao_pedro);
        mLocais.add(l85);

        Local l86 = new Local();
        l86.set_nome_local("Pousada Varadouro");
        l86.setTipo("Hospedagem");
        l86.setEndereco("Rua 15 de Novembro, 98 – Varadouro");
        l86.setHorario("");
        l86.setTelefone("(81) 3439.1163");
        l86.setEmail("pousadadolindavaradouro@hotmail.com");
        l86.setImagem(R.drawable.pousada_de_olinda_varadouro);
        l86.setLatitude(-8.0193660);
        l86.setLongitude(-34.8535210);
        l86.setSite("");
        mLocais.add(l86);

        Local l87 = new Local();
        l87.set_nome_local("Flat Quatro Rodas");
        l87.setEmail("");
        l87.setSite("");
        l87.setTipo("Hospedagem");
        l87.setEndereco("Avenida José Augusto Moreira, 2200 – Casa Caiada");
        l87.setHorario("");
        l87.setTelefone("(81) 3087.8100");
        l87.setImagem(R.drawable.flat_quatro_rodas_de_olinda);
        l87.setLatitude(-7.9779920);
        l87.setLongitude(-34.8349960);
        mLocais.add(l87);

        Local l88 = new Local();
        l88.set_nome_local("Hotel 5 Sóis");
        l88.setTipo("Hospedagem");
        l88.setEndereco("Avenida Ministro Marcos Freire, 633 – Bairro Novo / Olinda");
        l88.setHorario("");
        l88.setTelefone("(81) 3429.1347");
        l88.setSite("www.hotel5sois.com.br");
        l88.setEmail("hotel5sois@hotmail.com");
        l88.setImagem(R.drawable.hotel_cinco_sois);
        l88.setLatitude(-8.0065220);
        l88.setLongitude(-34.8405490);
        mLocais.add(l88);

        Local l89 = new Local();
        l89.set_nome_local("Hotel Costeiro");
        l89.setTipo("Hospedagem");
        l89.setEndereco("Avenida Ministro Marcos Freire, 681 – Bairro Novo");
        l89.setHorario("");
        l89.setTelefone("(81) 3429.4877");
        l89.setSite("www.costeiro.com.br");
        l89.setEmail("costeiro@costeiro.com.br");
        l89.setImagem(R.drawable.hotel_costeiro_olinda);
        l89.setLatitude(-8.0059070);
        l89.setLongitude(-34.8404940);
        mLocais.add(l89);

        Local l90 = new Local();
        l90.set_nome_local("Hotel Lazer Piaba de Ouro");
        l90.setTipo("Hospedagem");
        l90.setEndereco("Av. Chã da Mangabeira, 40 - Tabajara");
        l90.setTelefone("(81) 3437.2205");
        l90.setSite("www.lazerpiabadeouro.com");
        l90.setEmail("lazerpiabadeouro@bol.com.br");
        l90.setImagem(R.drawable.hotel_piaba_ouro);
        l90.setLatitude(-7.9689550);
        l90.setLongitude(-34.8730430);
        mLocais.add(l90);

        Local l91 = new Local();
        l91.set_nome_local("Hotel Samburá");
        l91.setTipo("Hospedagem");
        l91.setEndereco("Avenida Ministro Marcos Freire, 1551 – Bairro Novo");
        l91.setHorario("");
        l91.setTelefone("(81) 3429.3466 / 3429 3077");
        l91.setSite("www.samburahotel.com.br");
        l91.setEmail("hotelsambura@bol.com.br");
        l91.setImagem(R.drawable.hotel_sambura);
        l91.setLatitude(-7.9981430);
        l91.setLongitude(-34.8391190);
        mLocais.add(l91);

        Local l93 = new Local();
        l93.set_nome_local("Pousada do Turista");
        l93.setTipo("Hospedagem");
        l93.setEndereco("Av. Ministro Marcos Freire, 989 – Bairro Novo");
        l93.setHorario("");
        l93.setTelefone("(81) 3439.3717");
        l93.setSite("");
        l93.setEmail("pousadadoturista1964@oi.com.br");
        l93.setImagem(R.drawable.pousada_do_turista);
        l93.setLatitude(-8.0032420);
        l93.setLongitude(-34.8398820);
        mLocais.add(l93);

        Local l94 = new Local();
        l94.set_nome_local("Hotel Castelo Real");
        l94.setTipo("Hospedagem");
        l94.setEndereco("Rua Dr. Luiz Ribeiro, 120 – Jardim Fragoso");
        l94.setHorario("");
        l94.setTelefone("(81) 3429 2765");
        l94.setEmail("");
        l94.setImagem(R.drawable.hotel_castelo_real);
        l94.setSite("");
        l94.setLatitude(-7.9862970);
        l94.setLongitude(-34.8531380);
        mLocais.add(l94);

        Local l96 = new Local();
        l96.set_nome_local("Hotel Novo Praia Norte");
        l96.setTipo("Hospedagem");
        l96.setEndereco("R. Maria Luiza, 137 - Salgadinho");
        l96.setHorario("");
        l96.setTelefone("(81) 3241-2720");
        l96.setEmail("");
        l96.setImagem(R.drawable.motel_praia_norte);
        l96.setSite("");
        l96.setLatitude(-8.0305510);
        l96.setLongitude(-34.8681590);
        mLocais.add(l96);

        Local l97 = new Local();
        l97.set_nome_local("Hotel Seichelles");
        l97.setTipo("Hospedagem");
        l97.setEndereco("Avenida Pan Nordestina, 731 – Varadouro");
        l97.setHorario("");
        l97.setTelefone("(81) 3439 2044");
        l97.setEmail("");
        l97.setImagem(R.drawable.motel_seichelles);
        l97.setSite("");
        l97.setLatitude(-8.0129070);
        l97.setLongitude(-34.8599030);
        mLocais.add(l97);

        Local l98 = new Local();
        l98.set_nome_local("Status Hotel");
        l98.setTipo("Hospedagem");
        l98.setEndereco("Av. Pan Nordestina, 3248 - Varadouro");
        l98.setSite("www.statushotel.com.br");
        l98.setHorario("");
        l98.setTelefone("(81) 3439-9999");
        l98.setEmail("");
        l98.setImagem(R.drawable.status_hotel);
        l98.setLatitude(-7.9913479);
        l98.setLongitude(-34.8548450);
        mLocais.add(l98);

        Local m14 = new Local();
        m14.set_nome_local("Licoteria Noctívagos");
        m14.setTipo("Gastronomia");
        m14.setEmail("");
        m14.setEndereco("Rua 13 de Maio, 3 – Carmo");
        m14.setTelefone("(81) 3439.6248");
        m14.setHorario("Funcionamento: ter, qui e sáb, das 16h às 21h / sex, 17h às 0h");
        m14.setImagem(R.drawable.licoteria_noctivagos);
        m14.setSite("");
        m14.setLatitude(-8.0171530);
        m14.setLongitude(-34.8525110);
        mLocais.add(m14);

        Local m15 = new Local();
        m15.set_nome_local("Maison do Bonfim");
        m15.setTipo("Gastronomia");
        m15.setEndereco("Rua do Bonfim, 115 – Carmo");
        m15.setTelefone("(81) 3429.1674");
        m15.setHorario("Funcionamento: seg, a par;tir das 18h / ter, das 12h às ");
        m15.setHorario("qua a dom, das 12h às 16h e das 18h às 0h");
        m15.setSite("www.maisondobomfim.com.br");
        m15.setEmail("e-mail: lujeffmaison@hotmail.com");
        m15.setImagem(R.drawable.maison_do_bonfim);
        m15.setSite("");
        m15.setLatitude(-8.0158730);
        m15.setLongitude(-34.8497840);
        mLocais.add(m15);

        Local m17 = new Local();
        m17.set_nome_local("Mourisco");
        m17.setTipo("Gastronomia");
        m17.setEmail("");
        m17.setEndereco("Praça Conselheiro João Alfredo, 7 – Carmo");
        m17.setTelefone("(81) 3429.1390");
        m17.setHorario("Funcionamento: todos os dias, das 12h às 15h");
        m17.setImagem(R.drawable.mourisco_restaurante);
        m17.setSite("");
        m17.setLatitude(-8.0166792);
        m17.setLongitude(-34.8507882);
        mLocais.add(m17);

        Local m18 = new Local();
        m18.set_nome_local("Oficina do Sabor");
        m18.setTipo("Gastronomia");
        m18.setEmail("");
        m18.setEndereco("Rua do Amparo, 335 – Amparo");
        m18.setTelefone("(81)3429.3331");
        m18.setHorario("Funcionamento: ter a Sab, das 12h às 16h  e das 18h às 0dom, das 12h às 17h");
        m18.setSite("www.oficinadosabor.com");
        m18.setImagem(R.drawable.oficina_do_sabor);
        m18.setSite("");
        m18.setLatitude(-8.0118360);
        m18.setLongitude(-34.8538800);
        mLocais.add(m18);

        Local m19 = new Local();
        m19.set_nome_local("Olinda Art e Grill");
        m19.setTipo("Gastronomia");
        m19.setEmail("");
        m19.setEndereco("Rua Bispo Coutinho, 35 – Carmo");
        m19.setTelefone("(81) 3429.9406");
        m19.setHorario("Funcionamento: ter a dom, das 12h às 23h");
        m19.setImagem(R.drawable.olinda_art_grill);
        m19.setSite("");
        m19.setLatitude(-8.0139600);
        m19.setLongitude(-34.8499780);
        mLocais.add(m19);

        Local m20 = new Local();
        m20.set_nome_local("Olinda Sítio das Artes");
        m20.setTipo("Gastronomia");
        m20.setEndereco("Rua Bispo Coutinho, 780 – Carmo");
        m20.setTelefone("(81) 3429.2166");
        m20.setHorario("Funcionamento: ter a sáb, das 11h30 às 23h e dom, das às 16h");
        m20.setSite("www.olindasitiodasartes.com.br");
        m20.setEmail("e-mail: olindasitiodasartes@bol.com.br");
        m20.setImagem(R.drawable.sitio_das_artes);
        m20.setSite("");
        m20.setLatitude(-8.0128990);
        m20.setLongitude(-34.8508840);
        mLocais.add(m20);

        Local m21 = new Local();
        m21.set_nome_local("Panela Cheia");
        m21.setTipo("Gastronomia");
        m21.setEmail("");
        m21.setEndereco("Rua Henrique Dias – Varadouro");
        m21.setTelefone("(81) 8867.1521");
        m21.setHorario("Funcionamento: qua a dom, das 19h às 23h");
        m21.setImagem(R.drawable.restaurante_panela_cheia);
        m21.setSite("");
        m21.setLatitude(-8.0175150);
        m21.setLongitude(-34.8536510);
        mLocais.add(m21);

        Local m22 = new Local();
        m22.set_nome_local("Restaurante Patuá Delicias do Mar");
        m22.setTipo("Gastronomia");
        m22.setEndereco("R. de São Bento - Carmo");
        m22.setTelefone("(81) 3055.0833");
        m22.setHorario("Funcionamento: qua a dom, das 12h às 16h e das 19h às 23");
        m22.setSite("www.restaurantepatua.com");
        m22.setEmail("e-mail: chefe@restaurantepatua.com");
        m22.setImagem(R.drawable.patua);
        m22.setSite("");
        m22.setLatitude(-8.0155200);
        m22.setLongitude(-34.8528660);
        mLocais.add(m22);

        Local m23 = new Local();
        m23.set_nome_local("Trattoria Don Francesco");
        m23.setTipo("Gastronomia");
        m23.setEndereco("Rua Prudente Moraes, 358 – Carmo");
        m23.setTelefone("(81) 3429.3852");
        m23.setHorario("Funcionamento: seg a sex, das 11h às 15h e das 18h30 às 23h sáb, das 18h30 às 0h");
        m23.setEmail("e-mail: donfrancescotrattoria@uol.com.br");
        m23.setImagem(R.drawable.trattoria_don_francesco);
        m23.setSite("");
        m23.setLatitude(-8.0152570);
        m23.setLongitude(-34.8520510);
        mLocais.add(m23);

        Local m24 = new Local();
        m24.set_nome_local("Tribuna Sabores Ibéricos");
        m24.setTipo("Gastronomia");
        m24.setEmail("");
        m24.setEndereco("Rua de São Bento, 210 – Varadouro");
        m24.setTelefone("(81) 3439.1577");
        m24.setHorario("Funcionamento: ter a dom, das 11h às 16h e de 18h às 23h");
        m24.setImagem(R.drawable.tribuna_sabores_ibericos);
        m24.setSite("");
        m24.setLatitude(-8.0174830);
        m24.setLongitude(-34.8521820);
        mLocais.add(m24);

        Local m25 = new Local();
        m25.set_nome_local("Xinxim da Baiana");
        m25.setTipo("Gastronomia");
        m25.setEmail("");
        m25.setEndereco("Praça do Carmo, 742 – Carmo");
        m25.setTelefone("(81) 8634.3330");
        m25.setHorario("Funcionamento: ter a dom, a partir das 18h até o último cliente");
        m25.setImagem(R.drawable.xixim_da_baiana);
        m25.setSite("");
        m25.setLatitude(-8.0177620);
        m25.setLongitude(-34.8481090);
        mLocais.add(m25);

        Local m26 = new Local();
        m26.set_nome_local("Caldinho do Dogão");
        m26.setTipo("Gastronomia");
        m26.setEmail("");
        m26.setEndereco("Travessa Municipal, 27 – Carmo");
        m26.setTelefone("(81) 3439.1317");
        m26.setHorario("Funcionamento: ter a sex, ;a partir das 17h até o último cliente");
        m26.setHorario("sab, a partir das 10h / dom, das 10h às 21h");
        m26.setSite("www.caldinhododogao.com.br");
        m26.setImagem(R.drawable.caldinho_do_dogao);
        m26.setSite("");
        m26.setLatitude(-8.0145150);
        m26.setLongitude(-34.8452640);
        mLocais.add(m26);

        Local m27 = new Local();
        m27.set_nome_local("Marola Bar e Restaurante");
        m27.setTipo("Gastronomia");
        m27.setEndereco("Travessa General Dantas Barreto, 66 – Carmo");
        m27.setTelefone("(81) 3429.7079");
        m27.setHorario("Funcionamento: seg, das 16h às 0h / ter a qua, das 10h às 0h");
        m27.setHorario("qui a sáb, das 10h às 2h / dom, das 10h às 20h");
        m27.setEmail("marola.bar@terra.com.br / bkawe@hotmail.com");
        m27.setImagem(R.drawable.marola_bar_restaurante);
        m27.setSite("");
        m27.setLatitude(-8.0139780);
        m27.setLongitude(-34.8440010);
        mLocais.add(m27);

        Local m28 = new Local();
        m28.set_nome_local("Capitania Forneria e Mar");
        m28.setTipo("Gastronomia");
        m28.setEndereco("Rua Eduardo de Moraes, 25 – Bairro Novo");
        m28.setTelefone("(81) 3429.8970");
        m28.setHorario("Funcionamento: seg a qui, a partir das 18h / sex a dom a partir das 12h");
        m28.setEmail("e-mail: capitaniaforneriaemar@uol.com.br");
        m28.setImagem(R.drawable.capitania_forneria_mar1);
        m28.setSite("");
        m28.setLatitude(-7.9954440);
        m28.setLongitude(-34.8386240);
        mLocais.add(m28);

        Local m30 = new Local();
        m30.set_nome_local("Marisqueira");
        m30.setTipo("Gastronomia");
        m30.setEndereco("Av. Ministro Marcos Freire, 521 – Bairro Novo");
        m30.setTelefone("(81) 3429.4432");
        m30.setHorario("Funcionamento: seg a qua, das 10h às 0h / qui a dom, as 10h às 3h");
        m30.setEmail("e-mail: marisqueiraolinda@gmail.com");
        m30.setImagem(R.drawable.restaurante_marisqueira);
        m30.setSite("");
        m30.setLatitude(-8.0073500);
        m30.setLongitude(-34.8409970);
        mLocais.add(m30);

        Local m31 = new Local();
        m31.set_nome_local("Espigão Restaurante");
        m31.setTipo("Gastronomia");
        m31.setEndereco("Av. Ministro Marcos Freire, 569 – Bairro Novo");
        m31.setTelefone("(81) 3493.1395 ou 3439.7030");
        m31.setHorario("Funcionamento: dom a qui, das 9h às 1h / sex e sáb a partir das 9h");
        m31.setEmail("e-mail: espiagao@orladeolinda.com.br");
        m31.setImagem(R.drawable.restaurante_espigao);
        m31.setSite("");
        m31.setLatitude(-8.0070861);
        m31.setLongitude(-34.8407753);
        mLocais.add(m31);

        Local m32 = new Local();
        m32.set_nome_local("Boteco Bagacinho");
        m32.setTipo("Gastronomia");
        m32.setEmail("");
        m32.setEndereco("Av. Ministro Marcos Freire, 729 – Bairro Novo");
        m32.setTelefone("(81) 3439.5515");
        m32.setHorario("Funcionamento: ter. à dom., das 11h até o último cliente");
        m32.setImagem(R.drawable.bagacinho);
        m32.setSite("");
        m32.setLatitude(-8.0075296);
        m32.setLongitude(-34.8408893);
        mLocais.add(m32);

        Local m34 = new Local();
        m34.set_nome_local("Itapoã bar e restaurante");
        m34.setTipo("Gastronomia");
        m34.setEmail("");
        m34.setEndereco("Av. Ministro Marcos Freire, 847 – Bairro Novo");
        m34.setTelefone("(81) 3429.1713 / 3429.8874");
        m34.setHorario("Funcionamento: todos os dias, das 8h às 1h");
        m34.setImagem(R.drawable.restaurante_itapoa);
        m34.setSite("");
        m34.setLatitude(-8.0041940);
        m34.setLongitude(-34.8399800);
        mLocais.add(m34);

        Local m36 = new Local();
        m36.set_nome_local("Bar do Guaiamum");
        m36.setTipo("Gastronomia");
        m36.setEndereco("Av. Marcos Freire, 1023 – Bairro Novo");
        m36.setTelefone("(81) 3429.3383");
        m36.setHorario("Funcionamento: todos os dias, das 9h às 0h");
        m36.setEmail("e-mail: liac_veronica@yahoo.com.br");
        m36.setImagem(R.drawable.bar_do_guaiamum);
        m36.setSite("");
        m36.setLatitude(-8.0028280);
        m36.setLongitude(-34.8397790);
        mLocais.add(m36);

        Local m38 = new Local();
        m38.set_nome_local("Bar e Restaurante Tia Deta");
        m38.setTipo("Gastronomia");
        m38.setEmail("");
        m38.setEndereco("Av. Ministro Marcos Freire, 1255 – Bairro Novo");
        m38.setTelefone("(81) 3493. 0028");
        m38.setHorario("Funcionamento: todos os dias, das 11h às 0h");
        m38.setImagem(R.drawable.bar_e_restaurante_tia_deta);
        m38.setSite("");
        m38.setLatitude(-8.0008150);
        m38.setLongitude(-34.8394360);
        mLocais.add(m38);

        Local m39 = new Local();
        m39.set_nome_local("Restaurante Portal de Olinda");
        m39.setTipo("Gastronomia");
        m39.setEndereco("Av. Ministro Marcos Freire, 1333 – Bairro Novo");
        m39.setTelefone("(81) 3429.2941");
        m39.setHorario("Funcionamento: todos os dias, das 11h às 2h");
        m39.setEmail("e-mail: anaejairo@hotmail.com");
        m39.setImagem(R.drawable.portal_de_olinda);
        m39.setSite("");
        m39.setLatitude(-8.0040570);
        m39.setLongitude(-34.8417210);
        mLocais.add(m39);

        Local m41 = new Local();
        m41.set_nome_local("Samburá");
        m41.setTipo("Gastronomia");
        m41.setEndereco("Av. Ministro Marcos Freire, 1541 – Bairro Novo");
        m41.setTelefone("(81) 3429.3466");
        m41.setHorario("Funcionamento: seg a dom, das 11h30 às 23h");
        m41.setSite("www.hotelsambura.com.br");
        m41.setEmail("e-mail: hotelsambura@bol.com.br");
        m41.setImagem(R.drawable.sambura_olinda);
        m41.setSite("");
        m41.setLatitude(-7.9981440);
        m41.setLongitude(-34.8391160);
        mLocais.add(m41);


        Local m43 = new Local();
        m43.set_nome_local("Estrela do Mar");
        m43.setTipo("Gastronomia");
        m43.setEndereco("Av. Ministro Marcos Freire, 1691 – Bairro Novo");
        m43.setTelefone("(81) 3439.3040");
        m43.setHorario("Funcionamento: seg à qui, das 11h às 1h / sex e Sab, das 11h às 3h / dom, das 11h às 0h");
        m43.setSite("www.estreladomar-pe.com.br");
        m43.setEmail("e-mail: atendimento@estreladomar-pe.com.br");
        m43.setImagem(R.drawable.estrela_do_mar);
        m43.setSite("");
        m43.setLatitude(-7.9969710);
        m43.setLongitude(-34.8387560);
        mLocais.add(m43);

        Local m44 = new Local();
        m44.set_nome_local("Bar e Restaurante Gameleira Regional");
        m44.setTipo("Gastronomia");
        m44.setEndereco("Av. Ministro Marcos Freire, 1747 – Bairro Novo");
        m44.setTelefone("(81) 3429.8091");
        m44.setHorario("Funcionamento: todos os dias, das 9h às 0h");
        m44.setSite("www.gameleiraregional.com.br");
        m44.setEmail("e-mail: gameleiraregional@hotmail.com");
        m44.setImagem(R.drawable.bar_e_restaurante_gameleira);
        m44.setSite("");
        m44.setLatitude(-7.9966950);
        m44.setLongitude(-34.8387070);
        mLocais.add(m44);

        return mLocais;

    }

    public ArrayList<Local> getGastronomicos() {
        ArrayList<Local> gastronomicos = new ArrayList<>();
        for (Local local : mLocais) {
            if (Objects.equals(local.getTipo(), "Gastronomia")) {
                gastronomicos.add(local);
            }
        }
        return gastronomicos;
    }

    public ArrayList<Local> getHospedagens() {
        ArrayList<Local> hospedagens = new ArrayList<>();
        for (int i = 0; i < mLocais.size(); i++) {
            new Local();
            if (Objects.equals(mLocais.get(i).getTipo(), "Hospedagem")) {
                hospedagens.add(mLocais.get(i));
            }
        }
        return hospedagens;
    }

    public ArrayList<Local> getIgrejas() {
        ArrayList<Local> Igrejas = new ArrayList<>();
        for (int i = 0; i < mLocais.size(); i++) {
            new Local();
            if (Objects.equals(mLocais.get(i).getTipo(), "Igreja")) {
                Igrejas.add(mLocais.get(i));
            }
        }
        return Igrejas;
    }

    public ArrayList<Local> getMonumentos() {
        ArrayList<Local> Monumentos = new ArrayList<>();
        for (int i = 0; i < mLocais.size(); i++) {
            new Local();
            if (Objects.equals(mLocais.get(i).getTipo(), "Monumento")) {
                Monumentos.add(mLocais.get(i));
            }
        }
        return Monumentos;
    }

    public Local getLocal(UUID id) {
        for (Local l : mLocais) {
            if (l.getId().equals(id))
                return l;
        }
        return null;
    }

    public void createCarnaval(int event_id, String nome, String data,
                               String horario, String local) {

        Carnaval carnaval = new Carnaval();
        carnaval.setId(event_id);
        carnaval.setNome(nome);
        carnaval.setData(data);
        carnaval.setHorário(horario);
        carnaval.setLocal(local);
        mCarnaval.add(carnaval);
    }

    public ArrayList<Carnaval> getCarnavais() {
        return mCarnaval;
    }

    public void flushCarnavais() {
        this.mCarnaval.clear();
    }

    public void createEvent(int event_id, String imagem, String nome, String informacoes, String data,
                            String local, String valor, String horario, String atracoes) {

        Evento evento = new Evento();
        evento.setId(event_id);
        evento.setInfo(informacoes);
        evento.setImagem(imagem);
        evento.setNomeEvento(nome);
        evento.setData(data);
        evento.setLocal(local);
        evento.setValor(valor);
        evento.setHorário(horario);
        evento.setAtracoes(atracoes);
        mEventos.add(evento);
    }
    public void createHomenageados(int homenageados_Id, String imagem, String nomeHomenageados, String texto) {

        Homenageados homenageados = new Homenageados();
        homenageados.setHomenageados_Id(homenageados_Id);
        homenageados.setNomeHomenageados(nomeHomenageados);
        homenageados.setImagem(imagem);
        homenageados.setTexto(texto);
        mHomenageados.add(homenageados);
    }

    public ArrayList<Evento> getEventos() {
        return mEventos;
    }
    public ArrayList<Homenageados> getHomenageados() {
        return mHomenageados;
    }

    public void flushEvents() {
        this.mEventos.clear();
    }
}