package com.example.moonmayor.androidlists;

import android.support.v4.app.Fragment;

public class StarfleetRosterActivity extends ThemedSingleFragmentActivity {
    @Override
    public int getHeaderDrawableId() {
       return R.drawable.star_trek;
    }

    @Override
    public Fragment createFragment() {
        return new StarfleetRosterFragment();
    }
}
