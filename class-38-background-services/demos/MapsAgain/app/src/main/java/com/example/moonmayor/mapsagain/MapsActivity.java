package com.example.moonmayor.mapsagain;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback, GoogleMap.OnMapClickListener, View.OnTouchListener {
    private int CURRENT_MAP_TYPE_INDEX = 1;
    int[] MAP_TYPES = {
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_HYBRID,
            GoogleMap.MAP_TYPE_TERRAIN,
            GoogleMap.MAP_TYPE_SATELLITE,
    };

    @BindView(R.id.fragmentHolder) public LinearLayout mFragmentHolder;
    private GoogleMap mMap;

    private boolean isSatellite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ButterKnife.bind(this);

        if (mMap != null) {
            loadPreferences();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        savePreferences();
    }

    public void savePreferences() {
        SharedPreferences prefs = getSharedPreferences(
                "com.example.moonmayor.mapsagain",
                Context.MODE_PRIVATE
        );

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("mapType", CURRENT_MAP_TYPE_INDEX);
        editor.putFloat("lat", (float) mMap.getCameraPosition().target.latitude);
        editor.putFloat("long", (float) mMap.getCameraPosition().target.longitude);
        editor.putFloat("zoom", mMap.getCameraPosition().zoom);
        editor.commit();
    }

    public void loadPreferences() {
        SharedPreferences prefs = getSharedPreferences(
                "com.example.moonmayor.mapsagain",
                Context.MODE_PRIVATE
        );
        CURRENT_MAP_TYPE_INDEX = prefs.getInt("mapType", GoogleMap.MAP_TYPE_NORMAL);

        float lat = prefs.getFloat("lat", 44);
        float longg = prefs.getFloat("long", -122);
        float zoom = prefs.getFloat("zoom", 4);

        setMapType();
        mMap.moveCamera(CameraUpdateFactory.zoomTo(zoom));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, longg)));
    }

    @OnClick(R.id.toggleSatellite)
    public void toggleSatellite() {
        CURRENT_MAP_TYPE_INDEX++;
        CURRENT_MAP_TYPE_INDEX = CURRENT_MAP_TYPE_INDEX % MAP_TYPES.length;
        setMapType();
    }

    public void setMapType() {
        mMap.setMapType(MAP_TYPES[CURRENT_MAP_TYPE_INDEX]);
    }

    @OnClick(R.id.zoomout)
    public void zoomOut() {
        float zoom = mMap.getCameraPosition().zoom;
        setZoom(zoom - 1);
    }

    @OnClick(R.id.zoomin)
    public void zoomIn() {
        float zoom = mMap.getCameraPosition().zoom;
        setZoom(zoom + 1);
    }

    public void setZoom(float zoom) {
        mMap.moveCamera(CameraUpdateFactory.zoomTo(zoom));
    }

    @OnClick(R.id.goToSeattle)
    public void goToSeattle() {
        LatLng seattle = new LatLng(47, -122);
        mMap.addMarker(new MarkerOptions().position(seattle).title("Seattle"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seattle));
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
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        mFragmentHolder.setOnTouchListener(this);

        loadPreferences();
    }

    public void search() {
        // key — Your application's API key. This key identifies your application. See Get a key for more information.
        // input — The text input specifying which place to search for (for example, a name, address, or phone number).
        // inputtype — The type of input. This can be one of either textquery or phonenumber. Phone numbers must be in international format (prefixed by a plus sign ("+"), followed by the country code, then the phone number itself). See E.164 ITU recommendation for more information.
        String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json";
        url += "?key=AIzaSyD0gFueQZAjSv_nAcLYQmqKLC5aSGUq8yg";
        url += "?input=pizza";
        url += "?inputtype=textquery";

        RequestQueue queue = Volley.newRequestQueue(this);
    }

    private LatLng start;
    private LatLng end;
    private boolean isChoosingStart = false;
    private boolean isChoosingEnd = false;

    @OnClick(R.id.chooseStart)
    public void chooseStart() {
        isChoosingStart = true;
        isChoosingEnd = false;
    }

    @OnClick(R.id.chooseEnd)
    public void chooseEnd() {
        isChoosingEnd = true;
        isChoosingStart = false;
    }

    @BindView(R.id.startLocation) EditText startText;
    @BindView(R.id.endLocation) EditText endText;

    @Override
    public void onMapClick(LatLng latLng) {
        Log.d("LATLNG", latLng.latitude + "," + latLng.longitude);

        if (isChoosingStart) {
            start = latLng;
            startText.setText(latLng.toString());
            isChoosingStart = false;
        }
        if (isChoosingEnd) {
            end = latLng;
            endText.setText(latLng.toString());
            isChoosingEnd = false;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d("MOTION_EVENT", "down");
        } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("MOTION_EVENT", "move");
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            Log.d("MOTION_EVENT", "up");
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("hi", "action: " + event.getAction());
        return false;
    }
}
