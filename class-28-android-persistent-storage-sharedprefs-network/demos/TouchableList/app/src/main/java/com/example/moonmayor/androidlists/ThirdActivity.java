package com.example.moonmayor.androidlists;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends ThemedSingleFragmentActivity {
    @Override
    public int getHeaderDrawableId() {
        return R.drawable.golden_gardens;
    }

    public Fragment createFragment() {
        return new ThirdFragment();
    }
}
