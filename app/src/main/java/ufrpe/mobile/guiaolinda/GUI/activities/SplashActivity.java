package ufrpe.mobile.guiaolinda.GUI.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ufrpe.mobile.guiaolinda.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostraInicio();
            }
        }, 2000);
    }

    public void mostraInicio() {
        Intent intent = new Intent(SplashActivity.this, Inicio.class);
        startActivity(intent);
        finish();
    }
}
