package icars.cc.maps3;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityNYC extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static final String KEY = "Key";
    private int key;
    private LatLng nyc;
    private int mapZoom = 12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_nyc);
        setFragment();
    }

    private void setFragment() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        key = getIntent().getIntExtra(KEY, 1);

        if (key == 1) {

            nyc = new LatLng(40.773, -73.975);
            mMap.addMarker(new MarkerOptions().position(nyc).title("Marker in New York"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nyc, mapZoom));

        }
    }
}
