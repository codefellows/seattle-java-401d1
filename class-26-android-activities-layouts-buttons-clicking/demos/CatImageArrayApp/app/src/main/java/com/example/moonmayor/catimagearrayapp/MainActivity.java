package com.example.moonmayor.catimagearrayapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moonmayor.catimagearrayapp.models.CatAdoptions;

public class MainActivity extends AppCompatActivity {
    private int currentIndex;

    CatAdoptions[] cats = {
            new CatAdoptions("Sapporo", R.drawable.sapporo,
                    "Come down to PAWS and meet Zen master Sapporo! This handsome fellow is here to brighten your day! He is an expert in relaxing and is now taking students! Sapporo would prefer a quiet home, with adults and teenagers who can respect his space and allow him some much needed decompression time!" +
                    "Cheerio is a shyer boy who can take a moment to warm up to new friends but once comfortable he enjoys affection. He may take some time to settle in, but once you pick him up and give him pets, he's a purr machine! This sweet multi-toed boy is ready to start a new life with you! Come meet him at PAWS today!"),
            new CatAdoptions("Cheerio", R.drawable.cheerio,
                    "Cheerio is a shyer boy who can take a moment to warm up to new friends but once comfortable he enjoys affection. He may take some time to settle in, but once you pick him up and give him pets, he's a purr machine! This sweet multi-toed boy is ready to start a new life with you! Come meet him at PAWS today!"),
            new CatAdoptions("Eileen", R.drawable.eileen,
                    "Come on Eileen....at this moment you mean everything....check out roly poly Eileen...this little butterball is a friendly lady who enjoys affection and treats! Ready to meet your new couch buddy??"),
            new CatAdoptions("TomTom", R.drawable.tomtom,
                    "CAP1:- Hi there! My name is TomTom and boy will I be glad to come home with you! I am searching for an adult only home where my new family can help me settle in with a nice slow introduction! I really want to bond with my human friends, it just takes me a little time to scope you out! Once we are friends I can be sure to be found on your lap, looking out of windows or having a good old nap! Come down to PAWS and meet me today!"),
    };

    private ImageView picture;
    private TextView name;
    private TextView desc;

    private Button prev;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentIndex = 0;

        picture = findViewById(R.id.picture);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.description);

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        showCat();

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });
    }

    public void increment() {
        currentIndex++;
        showCat();
    }

    public void decrement() {
        currentIndex--;
        showCat();
    }

    public void showCat() {
        cycleBounds();

        CatAdoptions cat = cats[currentIndex];
        name.setText(cat.name);
        desc.setText(cat.description);

        Drawable pic = getResources().getDrawable(cat.drawableId);
        picture.setImageDrawable(pic);
    }

    public void cycleBounds() {
        // assume the best
        next.setEnabled(true);
        prev.setEnabled(true);

        if (currentIndex < 0) {
            currentIndex = cats.length - 1;
        } else {
            currentIndex = currentIndex % cats.length;
        }
    }

    public void preventBounds() {
        // assume the best
        next.setEnabled(true);
        prev.setEnabled(true);

        // guarantee the current index is between zero and the length of the array
        currentIndex = Math.max(currentIndex, 0);
        currentIndex = Math.min(currentIndex, cats.length - 1);

        // deal with the worst
        if (currentIndex == cats.length - 1) {
            next.setEnabled(false);
        }

        if (currentIndex == 0) {
            prev.setEnabled(false);
        }

    }
}
