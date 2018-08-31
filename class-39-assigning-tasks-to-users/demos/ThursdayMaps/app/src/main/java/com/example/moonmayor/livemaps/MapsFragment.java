package com.example.moonmayor.livemaps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.support.v4.app.FragmentManager;
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

import static android.content.Context.LOCATION_SERVICE;

public class MapsFragment extends Fragment
        implements OnMapReadyCallback, LocationListener {

    private static final int REQUEST_PERMISSION_GRANT = 1;
    private GoogleMap mMap;
    private LocationManager locationManager;
    private LatLng mCurrentLocation;

    int LOCATION_REFRESH_TIME = 1;
    int LOCATION_REFRESH_DISTANCE = 1;

    private String databaseKey;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.activity_maps, container, false);

        Intent data = getActivity().getIntent();
        Bundle arguments = getArguments();
        if (data != null && data.hasExtra("key")) {
            databaseKey = data.getStringExtra("key");
        } else if (arguments != null && arguments.containsKey("key")) {
           databaseKey = arguments.getString("key");
        }


        ButterKnife.bind(this, view);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        checkPermissions();
        return view;
    }

    private void checkPermissions() {
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

    private void attachFirebaseListener() {
        if (databaseKey == null) {
            return;
        }

        FirebaseDatabase.getInstance().getReference("errands")
        .child(databaseKey).addListenerForSingleValueEvent(new ValueEventListener() {
              @Override
              public void onDataChange(DataSnapshot dataSnapshot) {
                  Errand errand = Errand.fromSnapshot(dataSnapshot);
                  mMap.addMarker(
                          new MarkerOptions().title("start").position(errand.start)
                          .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                  );
                  mMap.addMarker(new MarkerOptions().title("end").position(errand.end));

                  LatLngBounds bounds = LatLngBounds.builder()
                          .include(errand.start)
                          .include(errand.end)
                          .build();
                  int padding = 300;
                  mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
              }

              @Override
              public void onCancelled(DatabaseError databaseError) {

              }
        });
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
        if (requestCode == REQUEST_PERMISSION_GRANT && grantResults[0] == Activity.RESULT_OK &&
            requestCode == REQUEST_PERMISSION_GRANT && grantResults[1] == Activity.RESULT_OK) {
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        attachFirebaseListener();
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        mCurrentLocation = latLng;
    }

    @OnClick(R.id.goToMyLocation)
    public void goToMyLocation() {
        if (mCurrentLocation != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mCurrentLocation));
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
