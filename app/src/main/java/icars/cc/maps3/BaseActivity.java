package icars.cc.maps3;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private MapFragment mapFragment;
    private GoogleMap map;
    private LatLng nycCoordinates;
    private LatLng sfCoordinates;
    private int mapZoom = 12;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private String sfTitle = "San Francisco";
    private String nycTitle = "New York";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setViews();
        setMapFragment();
        setCoordinates();

    }

    private void setMapFragment() {
        mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {

        this.map = map;
        this.map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
    }

    private void setViews() {

        setToolBar();
        setDrawer();
        setNavigationView();

    }

    private void setToolBar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setDrawer() {
        setDrawerLayout();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setDrawerLayout() {

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    }

    private void setNavigationView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        setDrawerLayout();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void setCoordinates(){
        sfCoordinates = new LatLng(37.77, -122.41);
        nycCoordinates = new LatLng(40.773, -73.975);
    }

    private void findCity(LatLng latLng, String toolBarTitle){
        map.addMarker(new MarkerOptions().position(latLng).title("Marker in New York"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, mapZoom));
        toolbar.setTitle(toolBarTitle);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.sf) {

            findCity(sfCoordinates,sfTitle);

        } else if (id == R.id.nyc) {

            findCity(nycCoordinates,nycTitle);

        }

        setDrawerLayout();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
