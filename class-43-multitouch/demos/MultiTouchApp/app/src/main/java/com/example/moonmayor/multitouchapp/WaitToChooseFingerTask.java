package com.example.moonmayor.multitouchapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class WaitToChooseFingerTask extends AsyncTask<Void, Void, Void> {
    MultiTouchEngine engine;
    int minWait;
    TextView timeLeft;

    long lastTouch;
    protected boolean isFinished;

    public WaitToChooseFingerTask(MultiTouchEngine engine, int minWait, TextView timeLeft) {
        this.engine = engine;
        this.minWait = minWait;
        this.timeLeft = timeLeft;

        isFinished = false;
        update();
    }

    public void update() {
       lastTouch = System.currentTimeMillis();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        boolean hasWaitedLongEnough = false;
        boolean isCancelled = false;

        while (!hasWaitedLongEnough && !isCancelled) {
            long now = System.currentTimeMillis();
            long delta = now - lastTouch;
            if (delta > this.minWait) {
                hasWaitedLongEnough = true;
            }

            long left = minWait - delta;
            left = Math.max(left, 0);
            timeLeft.setText("" + left);

            try {
                // run at 60 frames per second
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                isCancelled = true;
            }
        }

        if (isCancelled) {
            isFinished = true;
            timeLeft.setText("cancelled");
            return null;
        }

        engine.pickOneWinner();

        isFinished = true;
        return null;
    }
}
