package com.example.moonmayor.catimagearrayapp.models;

import android.graphics.drawable.Drawable;

public class CatAdoptions {
    public String name;
    public int drawableId;
    public String description;

    public CatAdoptions(String name, int drawableId, String description) {
        this.name = name;
        this.drawableId = drawableId;
        this.description = description;
    }
}

