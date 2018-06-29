package com.example.moonmayor.stopwatchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView mTime;

    private boolean isStarted = false;
    private boolean isPaused = false;

    private long startTime = 0;
    private long bankedMilliseconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTime = findViewById(R.id.timeDisplay);

        Button playPause = findViewById(R.id.playpause);
        Button reset = findViewById(R.id.reset);

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("STOPWATCH", "playpause");
                if (!isStarted) {
                    isStarted = true;
                    startTime = System.currentTimeMillis();
                    bankedMilliseconds = 0;
                } else {
                    isPaused = !isPaused;
                    if (isPaused) {
                        bankedMilliseconds = bankedMilliseconds + System.currentTimeMillis() - startTime;
                    } else {
                        startTime = System.currentTimeMillis();
                    }
                }
                startLoop();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("STOPWATCH", "reset");
                if (isStarted && isPaused) {
                    isStarted = false;
                    isPaused = false;
                    mTime.setText("0");
                }
            }
        });

        //startLoop();
    }

    public void startLoop() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int n = 0;
                    while (true) {
                        if (!isStarted || isPaused) {
                           return;
                        }

                        if (n % 100 == 0) {
                            Log.d("STOPWATCH", "" + n);
                        }
                        n++;

                        // calculate 60 frames per second.
                        Thread.sleep(1000 / 60);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateDisplay();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void updateDisplay() {
        long duration = 0;
        if (isPaused) {
            duration = bankedMilliseconds;
        } else {
            duration = bankedMilliseconds + System.currentTimeMillis() - startTime;
        }

        String format = "%01d:%02d:%02d.%03d";
        long milliseconds = duration % 1000;
        long seconds = duration / 1000 % 60;
        long minutes = duration / 1000 / 60 % 60;
        long hours = duration / 1000 / 60 / 60 % 10;

        String display = String.format(format, hours, minutes, seconds, milliseconds);
        mTime.setText(display);
    }
}
