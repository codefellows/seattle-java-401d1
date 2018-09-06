package com.example.moonmayor.multitouch;

import android.graphics.Color;

public class TouchPointer {
    public int id;
    public float xx;
    public float yy;
    public int color;

    public TouchPointer(int id, float xx, float yy) {
        this.id = id;
        this.xx = xx;
        this.yy = yy;

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        this.color = Color.rgb(red, green, blue);
    }

    public String toString() {
        return this.id + ":(" + this.xx + "," + this.yy + ")";
    }
}
