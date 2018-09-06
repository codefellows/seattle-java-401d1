package com.example.moonmayor.multitouch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnLayoutChangeListener, View.OnTouchListener {
    Bitmap mBitmap;
    Canvas mCanvas;
    @BindView(R.id.image)
    ImageView mImageView;

    MultiTouchEngine engine;
    MultiTouchEngineDrawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mImageView.addOnLayoutChangeListener(this);
        mImageView.setOnTouchListener(this);
    }

    @Override
    public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
        initBitmap(view);
    }

    public void initBitmap(View view) {
        int width = view.getWidth();
        int height = view.getHeight();

        Log.d("LAYOUT", "w: " + width + " h: " + height);
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        engine = new MultiTouchEngine();
        drawer = new MultiTouchEngineDrawer(engine, mBitmap, mCanvas, mImageView);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        boolean isUsing = false;

        int pointers = event.getPointerCount();
        if (pointers > 1) {
            Log.d("IDS", event.getPointerId(0) + " " + event.getPointerId(1));
            Log.d("IDS", event.getPointerId(0) + " " + event.getPointerId(1));
        }

        Log.d("POINTERS", "" + pointers);
        for (int i = 0; i < pointers; i++) {
            int id = event.getPointerId(i);
            float xx = event.getX(i);
            float yy = event.getY(i);

            int action = event.getAction();
            int masked = event.getActionMasked();

            if (action == MotionEvent.ACTION_DOWN || masked == MotionEvent.ACTION_POINTER_DOWN) {
                engine.add(id, xx, yy);
                Log.d("ACTION", "down");
                isUsing = true;
            } else if (action == MotionEvent.ACTION_UP || masked == MotionEvent.ACTION_POINTER_UP) {
                engine.remove(id);
                Log.d("ACTION", "up");
                isUsing = true;
            } else if (action == MotionEvent.ACTION_MOVE) {
                engine.update(id, xx, yy);
                isUsing = true;
            }
        }

        if (isUsing) {
            drawer.clear();
            drawer.draw();
        }
        return isUsing;
    }
}
