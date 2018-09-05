package com.example.moonmayor.canvasproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements ViewTreeObserver.OnGlobalLayoutListener,
        View.OnTouchListener {
    @BindView(R.id.canvasView) public ImageView imageView;
    @BindView(R.id.value) public TextView valueDisplay;

    private Bitmap mBitmap;
    private Canvas mCanvas;

    private CircleDrawingEngine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        engine = new Crapabacus();

        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    @Override
    public void onGlobalLayout() {
        initBitmap();
        engine.drawAll(mCanvas);
    }

    public void initBitmap() {
        imageView.setOnTouchListener(this);

        int width = imageView.getWidth();
        int height = imageView.getHeight();

        Log.d("DIMENSIONS", "" + width + "x" + height + "y");

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    @OnClick(R.id.reset)
    public void reset() {
        engine.reset();
        clear();
    }

    public void clear() {
        if (mCanvas != null) {
            Log.d("CANVAS", "clear");
            mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        }
    }

    public Circle randomCircle(float xx, float yy) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        int red = Color.rgb(255, 0, 0);
        int green = Color.rgb(0, 255, 0);
        int blue = Color.rgb(0, 0, 255);

        int color = 0;
        int value = 0;
        double choice = Math.random();
        if (choice < .33) {
            color = red;
            value = 1;
        } else if (choice < .66) {
            color = green;
            value = 10;
        } else {
            color = blue;
            value = 100;
        }

        Circle circle = new Circle(xx, yy, 50, color, value);
        return circle;
    }

    public void drawAll() {
        engine.drawAll(mCanvas);
        imageView.setImageBitmap(mBitmap);
    }

    private float xDown;
    private float yDown;

    private float xUp;
    private float yUp;

    private float xMove;
    private float yMove;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float xx = motionEvent.getX();
        float yy = motionEvent.getY();

        if (action == MotionEvent.ACTION_DOWN) {
            Log.d("ACTION", "down");
            xDown = xx;
            yDown = yy;

            engine.grab(xDown, yDown);
            return true;
        } else if (action == MotionEvent.ACTION_UP) {
            Log.d("ACTION", "up");
            xUp = xx;
            yUp = yy;

            clear();

            if (!engine.isGrabbing()) {
                Circle circle = randomCircle(xUp, yUp);
                engine.add(circle);
            } else {
                engine.release();
            }

            drawAll();

            return true;
        } else if (action == MotionEvent.ACTION_MOVE) {
            Log.d("ACTION", "move");
            xMove = xx;
            yMove = yy;

            clear();

            if (!engine.isGrabbing()) {
                Log.d("GRABBING", "random circle");
                Circle circle = randomCircle(xMove, yMove);
                circle.draw(mCanvas);
                imageView.setImageBitmap(mBitmap);
            } else {
                Log.d("GRABBING", "grabbing circle");
                engine.update(xMove, yMove);
            }

            drawAll();

            int value = engine.value(imageView.getWidth() / 2);
            valueDisplay.setText("" + value);

            return true;
        }
        return false;
    }
}
