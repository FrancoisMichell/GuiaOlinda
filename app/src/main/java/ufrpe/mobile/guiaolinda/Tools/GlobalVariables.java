package ufrpe.mobile.guiaolinda.Tools;

import android.app.Application;

public class GlobalVariables extends Application {

    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
