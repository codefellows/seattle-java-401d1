package com.example.moonmayor.androidlists;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public abstract class ThemedSingleFragmentActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_back_activity);

        View container = findViewById(R.id.container);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);
        if (fragment == null) {
            fm.beginTransaction()
                    .add(R.id.container, createFragment())
                    .commit();
        }

        ImageView header = findViewById(R.id.header);
        Drawable drawable = getResources().getDrawable(getHeaderDrawableId());
        header.setImageDrawable(drawable);

        Button goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public int getHeaderDrawableId() {
        return R.drawable.seattle;
    }

    public abstract Fragment createFragment();
}
