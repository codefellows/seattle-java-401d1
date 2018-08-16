package com.example.moonmayor.androidlists.starfleet;

import android.content.Intent;

public class StarfleetPersonnel {
    public String name;
    public String rank;
    public String bio;

    public StarfleetPersonnel(String name, String rank, String bio) {
        this.name = name;
        this.rank = rank;
        this.bio = bio;
    }

    public void fillIntent(Intent intent) {
        intent.putExtra("name", this.name);
        intent.putExtra("rank", this.rank);
        intent.putExtra("bio", this.bio);
    }

    public static StarfleetPersonnel fromIntent(Intent data) {
        return new StarfleetPersonnel(
                data.getStringExtra("name"),
                data.getStringExtra("rank"),
                data.getStringExtra("bio")
        );
    }
}
