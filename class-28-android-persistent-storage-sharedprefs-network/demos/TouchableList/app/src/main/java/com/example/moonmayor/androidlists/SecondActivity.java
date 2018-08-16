package com.example.moonmayor.androidlists;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends ThemedSingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new SecondFragment();
    }
}
