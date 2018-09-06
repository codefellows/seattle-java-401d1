package com.example.moonmayor.multitouchapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements View.OnLayoutChangeListener, View.OnTouchListener{
    public static final int DELAY = 3000;

    @BindView(R.id.image) ImageView image;
    @BindView(R.id.timeLeft) TextView timeLeft;

    protected Bitmap bitmap;
    protected Canvas canvas;
    protected MultiTouchEngine engine;
    protected MultiTouchEngineDrawer drawer;

    WaitToChooseFingerTask mTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        image.addOnLayoutChangeListener(this);
        image.setOnTouchListener(this);
    }

    @Override
    public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
        initBitmap(view);
    }

    public void initBitmap(View view) {
        int width = view.getWidth();
        int height = view.getHeight();

        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);

        engine = new MultiTouchEngine();
        drawer = new MultiTouchEngineDrawer(engine, bitmap, canvas, image);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean isInteracting = false;
        int pointers = motionEvent.getPointerCount();

        for (int i = 0; i < pointers; i++) {
            float xx = motionEvent.getX(i);
            float yy = motionEvent.getY(i);

            int id = motionEvent.getPointerId(i);
            int action = motionEvent.getAction();
            int masked = motionEvent.getActionMasked();

            if (action == MotionEvent.ACTION_DOWN || masked == MotionEvent.ACTION_POINTER_DOWN) {
                Log.d("ACTION", "down");
                engine.add(id, xx, yy);
                isInteracting = true;

                if (mTask == null || mTask.isFinished) {
                    mTask = new WaitToChooseFingerTask(engine, DELAY, timeLeft);
                    mTask.execute();
                }
                mTask.update();
            } else if (action == MotionEvent.ACTION_UP || masked == MotionEvent.ACTION_POINTER_UP) {
                Log.d("ACTION", "up " +  pointers);
                engine.remove(id);

                if (pointers == 1) {
                    mTask.cancel(true);
                } else {
                    mTask.update();
                }

                isInteracting = true;
            } else if (action == MotionEvent.ACTION_MOVE) {
                Log.d("ACTION", "move");
                engine.update(id, xx, yy);
                isInteracting = true;
            }
        }

        if (isInteracting) {
            drawer.clear();
            drawer.draw();
        }

        return isInteracting;
    }
}
