package com.example.moonmayor.multitouchapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.widget.ImageView;

class MultiTouchEngineDrawer {
    public static final int SIZE = 100;

    MultiTouchEngine engine;
    Bitmap bitmap;
    Canvas canvas;
    ImageView imageView;

    public MultiTouchEngineDrawer(MultiTouchEngine engine,
            Bitmap bitmap, Canvas canvas, ImageView image
    ) {
        this.engine = engine;
        this.bitmap = bitmap;
        this.canvas = canvas;
        this.imageView = image;
    }

    public void clear() {
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        imageView.setImageBitmap(bitmap);
    }

    public void draw() {
        Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
        for (TouchPointer pointer : engine.pointers.values()) {
            if (pointer.isDisabled) {
                brush.setColor(Color.GRAY);
            } else {
                brush.setColor(pointer.color);
            }
            canvas.drawCircle(pointer.xx, pointer.yy, SIZE, brush);
        }
        imageView.setImageBitmap(bitmap);
    }
}
