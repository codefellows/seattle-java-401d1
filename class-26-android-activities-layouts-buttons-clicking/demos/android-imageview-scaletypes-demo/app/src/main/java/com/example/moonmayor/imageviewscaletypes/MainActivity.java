package com.example.moonmayor.imageviewscaletypes;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String EXTRA_CURRENT_INDEX = "CURRENT_INDEX";
    private int currentImageIndex = 0;
    private int[] images = {
            R.drawable.cube_icon, R.drawable.cube_photo,
            R.drawable.wide_icon, R.drawable.wide_photo,
            R.drawable.tall_icon, R.drawable.tall_photo,
    };

    Button cycleImageButton;
    ToggleButton toggleAdjustViewBounds;
    private List<ImageView> imageViews;
    private int[] imageViewIds = {
            R.id.center, R.id.centerCrop, R.id.centerInside,
            R.id.fitCenter, R.id.fitStart, R.id.fitEnd, R.id.fitXY,
            R.id.matrix
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = this.getIntent();
        if (intent != null && intent.getExtras() != null) {
            // set the current index if the app was reloaded after setting adjustViewBounds to false.
            Bundle extras = intent.getExtras();
            currentImageIndex = extras.getInt(EXTRA_CURRENT_INDEX, 0);
        }

        cycleImageButton = (Button) findViewById(R.id.cycleImageButton);
        toggleAdjustViewBounds = (ToggleButton) findViewById(R.id.toggleAdjustViewBounds);
        attachClickListeners();

        imageViews = new ArrayList<>();
        for (int id : imageViewIds) {
            ImageView imageView = (ImageView) findViewById(id);
            imageViews.add(imageView);
        }
        setImage();
    }

    private void attachClickListeners() {
        cycleImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cycleImage();
            }
        });

        toggleAdjustViewBounds.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    for (ImageView imageView : imageViews) {
                        imageView.setAdjustViewBounds(b);
                    }
                } else {
                    // setting adjustViewBounds back to false is ineffective.
                    // simple restart the activity.
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.putExtra(EXTRA_CURRENT_INDEX, currentImageIndex);
                    startActivity(intent);
                }
            }
        });
    }

    private void cycleImage() {
        currentImageIndex = ++currentImageIndex % images.length;
        setImage();
    }

    private void setImage() {
        String message = "Cycle Image (" + (currentImageIndex + 1) + "/" + images.length + ")";
        cycleImageButton.setText(message);
        for (ImageView view : imageViews) {
            Drawable drawable = getResources().getDrawable(images[currentImageIndex]);
            view.setImageDrawable(drawable);
        }
    }
}
