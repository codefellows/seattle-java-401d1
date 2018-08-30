package com.example.moonmayor.livemaps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.LOCATION_SERVICE;

public class MapsFragment extends Fragment implements LocationListener, OnMapReadyCallback {

    private static final int REQUEST_PERMISSION_GRANT = 1;
    private GoogleMap mMap;
    private LocationManager locationManager;
    private LatLng mCurrentLocation;

    private final int LOCATION_REFRESH_TIME = 1;
    private final int LOCATION_REFRESH_DISTANCE = 1;

    private String key;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_maps, container, false);

        ButterKnife.bind(this, root);

        // if the fragment is inside a two-pane activity key comes from bundle
        // if the fragment is started from it's activity key comes from an intent
        if (getArguments()!= null && getArguments().containsKey("id")) {
            key = getArguments().getString("id");
        } else if (getActivity().getIntent() != null) {
            key = getActivity().getIntent().getStringExtra("id");
        }

        // googled: findfragmentbyid in fragment
        // https://stackoverflow.com/a/44547364/735468
        // emphasis on getChildFragmentManager
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getGPSPermissions();

        return root;
    }

    private void attachDBListener() {
        // googled: get intent inside fragment
        // https://stackoverflow.com/a/14746744
        final Intent data = getActivity().getIntent();

        FirebaseDatabase.getInstance().getReference("errands")
                .child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Errand errand = Errand.fromSnapshot(dataSnapshot);

                mMap.addMarker(
                        new MarkerOptions().title("start").position(errand.start)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                );
                mMap.addMarker(
                        new MarkerOptions().title("end").position(errand.end)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                );

                int padding = 200;
                LatLngBounds bounds = new LatLngBounds(errand.start, errand.end);
                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getGPSPermissions() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            initializeLocationListener();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
            }, REQUEST_PERMISSION_GRANT);
        }

    }

    @SuppressLint("MissingPermission")
    private void initializeLocationListener() {
        LocationListener listener = this;
        locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                LOCATION_REFRESH_TIME, LOCATION_REFRESH_DISTANCE, listener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_GRANT && grantResults[0] == RESULT_OK &&
            requestCode == REQUEST_PERMISSION_GRANT && grantResults[1] == RESULT_OK) {
            initializeLocationListener();
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
        mMap = googleMap;
        attachDBListener();
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        mCurrentLocation = latLng;
    }

    @OnClick(R.id.goToMyLocation)
    public void goToMyLocation() {
        if (mCurrentLocation != null) {
            int padding = 200;
            LatLngBounds bounds = LatLngBounds.builder().include(mCurrentLocation).build();
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d("GPS", "gps turned on");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d("GPS", "gps turned off");
    }
}
