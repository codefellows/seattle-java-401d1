package com.example.moonmayor.livemaps;

import android.support.v4.app.Fragment;

public class MapsActivity extends SingleFragmentActivity {
    public Fragment getFragment() {
        return new MapsFragment();
    }
}
