package com.example.moonmayor.livemaps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.fragment_container, getFragment())
                .commit();
    }

    abstract Fragment getFragment();
}
