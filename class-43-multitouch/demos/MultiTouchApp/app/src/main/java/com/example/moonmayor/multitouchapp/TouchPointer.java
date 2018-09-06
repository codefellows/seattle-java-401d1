package com.example.moonmayor.multitouchapp;

import android.graphics.Color;

class TouchPointer {
    int id;
    float xx;
    float yy;
    int color;
    boolean isDisabled;

    public TouchPointer(int id, float xx, float yy) {
        isDisabled = false;

        this.id = id;
        this.xx = xx;
        this.yy = yy;

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        this.color = Color.rgb(red, green, blue);
    }
}
