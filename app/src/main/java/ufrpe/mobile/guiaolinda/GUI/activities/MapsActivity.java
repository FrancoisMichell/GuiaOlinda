package ufrpe.mobile.guiaolinda.GUI.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Local;
import ufrpe.mobile.guiaolinda.Tools.GlobalVariables;

import static ufrpe.mobile.guiaolinda.Services.LocalFragment.ARG_LOCAL_ID;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    LocalLab localLab = LocalLab.get();
    ArrayList<Local> locais;
    GlobalVariables globalVariables;
    private int localId;
    private boolean hasExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        globalVariables = (GlobalVariables) getApplicationContext();
        locais = getListLocais(globalVariables.getMapa_filtrado());

        if (getIntent().hasExtra(ARG_LOCAL_ID)) {
            hasExtra = true;
            localId = getIntent().getExtras().getInt(ARG_LOCAL_ID);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private ArrayList<Local> getListLocais(String filtro) {
        ArrayList<Local> locals;

        switch (filtro) {
            case "1":
                locals = localLab.getLocals("Gastronomia");
                if (locals.size() == 0) {
                    locals = localLab.getGastronomicos();
                }
                break;
            case "2":
                locals = localLab.getLocals("Hospedagem");
                if (locals.size() == 0) {
                    locals = localLab.getHospedagens();
                }
                break;
            case "3":
                locals = localLab.getLocals("Igrejas");
                if (locals.size() == 0) {
                    locals = localLab.getIgrejas();
                }
                break;
            case "4":
                locals = localLab.getLocals("Monumentos");
                if (locals.size() == 0) {
                    locals = localLab.getMonumentos();
                }
                break;
            default:
                locals = localLab.getLocais();
                break;
        }
        return locals;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        setTitle("Guia de Olinda");
        inflater.inflate(R.menu.maps_list, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId()) {
            case R.id.home:
                startActivity(getParentActivityIntent());
                break;
            case R.id.mapa_gastronomia:
                globalVariables.setMapa_filtrado("1");
                break;
            case R.id.mapa_hospedagem:
                globalVariables.setMapa_filtrado("2");
                break;
            case R.id.mapa_igrejas:
                globalVariables.setMapa_filtrado("3");
                break;
            case R.id.mapa_monumentos:
                globalVariables.setMapa_filtrado("4");
                break;
            case R.id.mapa_todos:
                globalVariables.setMapa_filtrado("0");
                break;
        }
        intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        startActivity(intent);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            globalVariables.setMapa_filtrado("0");
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        for (int i = 0; i < locais.size(); i++) {
            Local local = locais.get(i);

            // Add a marker in newLocal and move the camera
            LatLng newLocal = new LatLng(local.getLatitude(), local.getLongitude());

            googleMap.addMarker(new MarkerOptions().position(newLocal).title(local.get_nome_local())
                    .icon(BitmapDescriptorFactory.defaultMarker(getColor(local))));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(newLocal));
        }

        if (hasExtra) {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(locais.get(localId).getLatitude(),
                    locais.get(localId).getLongitude()), 20.0f));
        } else {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-7.9908060, -34.8416290), 13.0f));
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
        }
    }

    private float getColor(Local local) {
        float color = 0;
        switch (local.getTipo()) {
            case "Gastronomia":
                color = BitmapDescriptorFactory.HUE_ORANGE;
                break;
            case "Hospedagem":
                color = BitmapDescriptorFactory.HUE_VIOLET;
                break;
            case "Igreja":
                color = BitmapDescriptorFactory.HUE_YELLOW;
                break;
            case "Monumento":
                color = BitmapDescriptorFactory.HUE_AZURE;
                break;
        }
        return color;
    }
}