package com.example.moonmayor.canvasproject;

import android.graphics.Color;

public class Crapabacus extends CircleDrawingEngine {
    private final int BEAD_SIZE = 50;
    private final int ONES_Y = 100;
    private final int TENS_Y = 200;
    private final int HUNDREDS_Y = 300;

    private final int RED = Color.rgb(255, 0, 0);
    private final int GREEN = Color.rgb(0, 255, 0);
    private final int BLUE = Color.rgb(0, 0, 255);

    public Crapabacus() {
        super();

        // create one-beads
        for (int ones = 0; ones < 10; ones++ ) {
            float xx = BEAD_SIZE + BEAD_SIZE * ones;
            float yy = ONES_Y;
            Circle circle = new Circle(xx, yy, BEAD_SIZE, RED, 1);
            this.add(circle);
        }

        for (int ones = 0; ones < 10; ones++ ) {
            float xx = BEAD_SIZE + BEAD_SIZE * ones;
            float yy = TENS_Y;
            Circle circle = new Circle(xx, yy, BEAD_SIZE, GREEN, 10);
            this.add(circle);
        }

        for (int ones = 0; ones < 10; ones++ ) {
            float xx = BEAD_SIZE + BEAD_SIZE * ones;
            float yy = HUNDREDS_Y;
            Circle circle = new Circle(xx, yy, BEAD_SIZE, BLUE, 100);
            this.add(circle);
        }
    }
}
