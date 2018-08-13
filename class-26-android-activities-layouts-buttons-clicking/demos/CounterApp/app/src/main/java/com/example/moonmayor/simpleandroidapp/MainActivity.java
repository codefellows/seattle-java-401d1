package com.example.moonmayor.simpleandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int totalClicks;
    private int aClicks;
    private int bClicks;
    private int cClicks;

    private EditText mEditText;
    private Button mManualUpdate;

    private Button mClickMe;
    private Button mAButton;
    private Button mBButton;
    private Button mCButton;

    private TextView mClicks;
    private TextView mATextView;
    private TextView mBTextView;
    private TextView mCTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.manualEntry);
        mManualUpdate = findViewById(R.id.manualUpdate);

        mClickMe = findViewById(R.id.clickMe);
        mAButton = findViewById(R.id.aButton);
        mBButton = findViewById(R.id.bButton);
        mCButton = findViewById(R.id.cButton);

        mClicks = findViewById(R.id.clicks);
        mATextView = findViewById(R.id.aText);
        mBTextView = findViewById(R.id.bText);
        mCTextView = findViewById(R.id.cText);

        mManualUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String text1 = mEditText.toString();
                    String text2 = mEditText.getText().toString();

                    totalClicks = Integer.parseInt(text2);
                    mClicks.setText("Clicks: " + totalClicks);
                } catch (NumberFormatException e) {
                    
                }
            }
        });

        mClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               totalClicks++;
               mClicks.setText("Clicks: " + totalClicks);
            }
        });

        mAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aClicks++;
                mATextView.setText("A clicks: " + aClicks);
            }
        });

        mBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bClicks++;
                mBTextView.setText("B clicks: " + bClicks);
            }
        });

        mCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cClicks++;
                mCTextView.setText("C clicks: " + cClicks);
            }
        });
    }
}
