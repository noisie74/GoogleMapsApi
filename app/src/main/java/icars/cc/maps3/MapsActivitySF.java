package icars.cc.maps3;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivitySF extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng sanFran;
    public static final String KEY = "Key";
    private int key;
    private int mapZoom = 12;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_sf);

        setFragment();

    }

    private void setFragment(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        key = getIntent().getIntExtra(KEY, 0);

        if (key == 0) {

            sanFran = new LatLng(37.77, -122.41);
            mMap.addMarker(new MarkerOptions().position(sanFran).title("Marker in San Francisco"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sanFran, mapZoom));

        }

    }
}
