package com.example.moonmayor.multitouch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.widget.ImageView;

public class MultiTouchEngineDrawer {
    public static final int RADIUS = 100;

    protected MultiTouchEngine engine;
    protected Bitmap bitmap;
    protected Canvas canvas;
    protected ImageView imageView;

    public MultiTouchEngineDrawer(MultiTouchEngine engine, Bitmap bitmap, Canvas canvas, ImageView imageView) {
        this.engine = engine;
        this.bitmap = bitmap;
        this.canvas = canvas;
        this.imageView = imageView;
    }

    public void clear() {
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }

    public void draw() {
        Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
        for (TouchPointer pointer : engine.touches.values()) {
            brush.setColor(pointer.color);
            canvas.drawCircle(pointer.xx, pointer.yy, RADIUS, brush);
        }
        imageView.setImageBitmap(bitmap);
    }

}
