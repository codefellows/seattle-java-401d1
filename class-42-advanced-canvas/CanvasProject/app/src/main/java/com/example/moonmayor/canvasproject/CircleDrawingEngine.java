package com.example.moonmayor.canvasproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.ImageView;

import java.util.HashSet;
import java.util.Set;

public class CircleDrawingEngine {
    private Set<Circle> circles;

    private boolean isGrabbing;
    private Circle currentCircle;

    public CircleDrawingEngine() {
        circles = new HashSet<>();
        this.reset();
    }

    public void reset() {
        circles.clear();
        isGrabbing = false;
        currentCircle = null;
    }

    public boolean isGrabbing() {
        return this.isGrabbing;
    }

    public void drawAll(Canvas canvas) {
        for (Circle circle : circles) {
            circle.draw(canvas);
        }
    }

    public void add(Circle circle) {
        circles.add(circle);
    }

    public boolean grab(float xx, float yy) {
        for (Circle circle : this.circles) {
            if (circle.contains(xx, yy)) {
                isGrabbing = true;
                currentCircle = circle;
                return true;
            }
        }
        return false;
    }

    public void update(float xx, float yy) {
        if (isGrabbing && currentCircle != null) {
            currentCircle.setX(xx);
            //currentCircle.setY(yy);
        }
    }

    public void release() {
        isGrabbing = false;
        currentCircle = null;
    }

    public int value(int crossoverX) {
        int result = 0;

        for (Circle circle : circles) {
            if (circle.getX() > crossoverX) {
                result += circle.getValue();
            }
        }

        return result;
    }
}
