package com.example.moonmayor.canvasproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle {
    private float xx;
    private float yy;
    private float radius;
    private int color;
    private int value;

    public Circle(float xx, float yy, float radius, int color, int value) {
        this.xx = xx;
        this.yy = yy;
        this.radius = radius;
        this.color = color;
        this.value = value;
    }

    public void setX(float xx) {
        this.xx = xx;
    }

    public void setY(float yy) {
        this.yy = yy;
    }

    public float getX() {
        return this.xx;
    }

    public int getValue() {
        return this.value;
    }

    public void draw(Canvas canvas) {
        Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
        brush.setColor(this.color);
        canvas.drawCircle(this.xx, this.yy, this.radius, brush);
    }

    public boolean contains(float xx, float yy) {
        float dx = this.xx - xx;
        float dy = this.yy - yy;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < this.radius;
    }
}
