package com.example.moonmayor.listadapterapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_GET_ANIMAL = 1;

    private Button mButton;
    private Button mChooseAnimal;

    private TextView mFavoriteAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.goToTwo);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        mFavoriteAnimal = findViewById(R.id.favoriteAnimal);
        mChooseAnimal = findViewById(R.id.chooseAnimal);
        mChooseAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseAnimalActivity.class);
                startActivityForResult(intent, REQUEST_GET_ANIMAL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_GET_ANIMAL) {
            if (data == null) {
                return;
            }

            String favorite = data.getStringExtra(ChooseAnimalActivity.FAVORITE_ANIMAL);
            String message = "You're favorite animal is a: " + favorite;

            mFavoriteAnimal.setText(message);
        }
    }
}
