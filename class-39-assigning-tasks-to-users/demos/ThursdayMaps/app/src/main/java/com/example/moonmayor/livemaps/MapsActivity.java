package com.example.moonmayor.livemaps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MapsActivity extends SingleFragmentActivity {
    @Override
    public Fragment getFragment() {
        return new MapsFragment();
    }
}
