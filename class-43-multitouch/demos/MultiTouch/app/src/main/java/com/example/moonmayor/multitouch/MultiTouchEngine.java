package com.example.moonmayor.multitouch;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MultiTouchEngine {
    protected Map<Integer, TouchPointer> touches;

    public MultiTouchEngine() {
        touches = new HashMap<>();
    }

    public void add(int id, float xx, float yy) {
        TouchPointer pointer = new TouchPointer(id, xx, yy);
        touches.put(id, pointer);
    }

    public void update(int id, float xx, float yy) {
        TouchPointer pointer = touches.get(id);
        if (pointer != null) {
            pointer.xx = xx;
            pointer.yy = yy;
        }
        Log.d("UPDATE", touches.toString());
    }

    public void remove(int id) {
        touches.remove(id);
    }
}
