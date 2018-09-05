package com.example.moonmayor.alarmclock;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements ViewTreeObserver.OnGlobalLayoutListener, View.OnTouchListener {
    @BindView(R.id.layout) ConstraintLayout layout;

    @BindView(R.id.clock) ImageView clock;
    @BindView(R.id.canvas) ImageView canvasView;

    @BindView(R.id.hour) TextView mHourText;
    @BindView(R.id.minute) TextView mMinuteText;
    @BindView(R.id.amPm) TextView mAmPm;

    private int mHour;
    private int mMinute;

    private float mHourAngle;
    private float mMinuteAngle;

    private boolean isAm;

    private Canvas mCanvas;
    private Bitmap mBitmap;

    private int mWidth;
    private int mHeight;

    private boolean isLaidOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        isLaidOut = false;

        mHour = 0;
        mMinute = 0;
        displayAmPm();

        ViewTreeObserver viewTreeObserver = layout.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    // set up the canvas for drawing
    public void onGlobalLayout() {
        if (isLaidOut) {
            return;
        }

        isLaidOut = true;

        setHourMinute(0, 0);

        initBitMap();
        drawHourMinuteHands();

        canvasView.setOnTouchListener(this);
    }

    @OnClick(R.id.amPm)
    public void toggleAmPm() {
        isAm = !isAm;
        displayAmPm();
    }

    public void displayAmPm() {
        if (isAm) {
            mAmPm.setText(getString(R.string.am));
        } else {
            mAmPm.setText(getString(R.string.pm));
        }
    }

    public void setHourMinute(int hours, int minutes) {
        setHour(hours);
        setMinute(hours);
    }

    public void setHour(int hours) {
        mHour = hours % 12 + 1;
        if (mHour == 12) {
            mHourAngle = 0;
        } else {
            mHourAngle = mHour / 12f;
        }

        zeroPadTextView(mHourText, mHour);
    }

    public void setMinute(int minutes) {
        mMinute = minutes % 60;
        mMinuteAngle = mHour / 60f;
        zeroPadTextView(mMinuteText, mMinute);
    }

    public void zeroPadTextView(TextView view, int time) {
        String value = "";
        if (time < 10) {
            value += 0;
        }
        value += time;
        view.setText(value);
    }

    public void initBitMap() {
        mWidth = canvasView.getWidth();
        mHeight = canvasView.getHeight();

        mBitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_4444);
        mCanvas = new Canvas(mBitmap);
    }

    public void clear() {
        mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }

    public void drawHourMinuteHands() {
        Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
        int black = Color.rgb(0, 0, 0);
        int red = Color.rgb(255, 0, 0);

        brush.setColor(black);
        brush.setStyle(Paint.Style.FILL);

        float xCenter = mWidth / 2;
        float yCenter = mWidth / 2;

        // hour hand
        brush.setStrokeWidth(12f);
        mCanvas.drawLine(xCenter, yCenter, mWidth / 2, (1f - .9f) * mHeight, brush);

        // minute hand
        brush.setStrokeWidth(20f);
        mCanvas.drawLine(xCenter, yCenter, mWidth / 2, (1f - .8f) * mHeight, brush);

        Log.d("LAYOUT", "minutehour");
        canvasView.setImageDrawable(new BitmapDrawable(this.getResources(), mBitmap));
    }

    public void drawCircle() {
        Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);

        int green = Color.rgb(0, 255, 0);
        brush.setColor(green);
        brush.setStyle(Paint.Style.FILL);
        mCanvas.drawCircle(xmove, ymove, 30f, brush);

        Log.d("DREW", "circle");
        canvasView.setImageDrawable(new BitmapDrawable(this.getResources(), mBitmap));
    }

    private float xdown;
    private float ydown;

    private float xmove;
    private float ymove;

    private float xup;
    private float yup;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("ACTION", "" + motionEvent.getAction());
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            xdown = motionEvent.getX();
            ydown = motionEvent.getY();
            return true;
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            xup = motionEvent.getX();
            yup = motionEvent.getY();

            clear();
            drawHourMinuteHands();

            return true;
        } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            xmove = motionEvent.getX();
            ymove = motionEvent.getY();

            clear();
            drawHourMinuteHands();
            drawCircle();

            determineAngle();

            return true;
        }
        return false;
    }

    public void determineAngle() {
        boolean xPos = xmove > mWidth / 2;
        boolean yPos = ymove > mWidth / 2;

        float absX = Math.abs(mWidth / 2 - xmove);
        float absY = Math.abs(mHeight / 2 - ymove);

        double radians = Math.atan2(absY, absX);
        double degrees = radians / Math.PI * 180;
        Log.d("ANGLE", "" + degrees);
    }
}
