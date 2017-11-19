package ufrpe.mobile.guiaolinda.GUI.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
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
import java.util.UUID;

import ufrpe.mobile.guiaolinda.DB.LocalLab;
import ufrpe.mobile.guiaolinda.R;
import ufrpe.mobile.guiaolinda.Services.Local;

import static ufrpe.mobile.guiaolinda.Services.LocalFragment.ARG_LOCAL_ID;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    LocalLab localLab = LocalLab.get();
    ArrayList<Local> locais = localLab.getLocais();
    private UUID localId;
    private boolean hasExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if(getIntent().hasExtra(ARG_LOCAL_ID)){
            hasExtra = true;
            localId = (UUID) getIntent().getSerializableExtra(ARG_LOCAL_ID);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
            case R.id.mapa:
                intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                return true;

            case R.id.sobre:
                intent = new Intent(this, SobreActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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


        for (int i = 0; i < locais.size(); i++){
            Local local = locais.get(i);

            // Add a marker in newLocal and move the camera
            LatLng newLocal = new LatLng(local.getLatitude(),local.getLongitude());

            googleMap.addMarker(new MarkerOptions().position(newLocal).title(local.get_nome_local())
                    .icon(BitmapDescriptorFactory.defaultMarker(getColor(local))));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(newLocal));
        }

        if(hasExtra) {

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(localLab.getLocal(localId).getLatitude(),
                    localLab.getLocal(localId).getLongitude()),20.0f));
        }else {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-7.9908060, -34.8416290), 13.0f));
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
        }
    }

    private float getColor(Local local) {
        float color = 0;
        switch (local.getTipo()){
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