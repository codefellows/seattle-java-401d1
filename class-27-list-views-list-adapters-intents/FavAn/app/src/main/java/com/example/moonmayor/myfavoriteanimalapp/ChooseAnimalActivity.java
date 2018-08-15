package com.example.moonmayor.myfavoriteanimalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChooseAnimalActivity extends AppCompatActivity {
    public static final String FAVORITE_ANIMAL = "favorite-animal";

    Button mCow;
    Button mChicken;
    Button mDog;

    Button mCancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_animal);

        Intent intent = getIntent();
        double random = intent.getDoubleExtra(MainActivity.EXTRA_RANDOM_NUMBER, 0);

        mCow = findViewById(R.id.cow);
        mChicken = findViewById(R.id.chicken);
        mDog = findViewById(R.id.dog);

        mCancel = findViewById(R.id.cancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        attachClickListener(mCow, "cow");
        attachClickListener(mChicken, "chicken");
        attachClickListener(mDog, "dog");
    }

    public void attachClickListener(Button button, final String animal) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(FAVORITE_ANIMAL, animal);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
