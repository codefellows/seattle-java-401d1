package com.example.moonmayor.androidlists;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StarfleetPersonnelDetailActivity extends StarfleetRosterActivity {

    public Fragment createFragment() {
        return new StarfleetPersonnelDetailFragment();
    }
}
