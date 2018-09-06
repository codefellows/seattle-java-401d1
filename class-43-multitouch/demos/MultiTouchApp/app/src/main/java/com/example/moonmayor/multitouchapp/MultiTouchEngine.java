package com.example.moonmayor.multitouchapp;

import java.util.HashMap;
import java.util.Map;

class MultiTouchEngine {
    protected Map<Integer, TouchPointer> pointers;

    public MultiTouchEngine() {
        pointers = new HashMap<>();
    }

    public void add(int id, float xx, float yy) {
        TouchPointer pointer = new TouchPointer(id, xx, yy);
        pointers.put(id, pointer);
    }

    public void update(int id, float xx, float yy) {
        TouchPointer pointer = pointers.get(id);
        if (pointer != null) {
            pointer.xx = xx;
            pointer.yy = yy;
        }
    }

    public void remove(int id) {
        pointers.remove(id);
    }

    public void pickOneWinner() {
        // .876543 * 10 => 8.76543 => 8

        int size = pointers.values().size();
        int choice = (int) Math.floor(Math.random() * size);

        int n = 0;
        for (TouchPointer pointer : pointers.values()) {
            if (n != choice) {
                pointer.isDisabled = true;
            } else {
                pointer.isDisabled = false;
            }
            n++;
        }
    }
}
