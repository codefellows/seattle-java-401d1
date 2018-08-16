package com.example.moonmayor.androidlists;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
    private int clicks = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        final TextView clickDisplay = view.findViewById(R.id.clickDisplay);

        Button button = view.findViewById(R.id.clicker);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                clickDisplay.setText("clicks: " + clicks);
            }
        });


        return view;
    }
}
