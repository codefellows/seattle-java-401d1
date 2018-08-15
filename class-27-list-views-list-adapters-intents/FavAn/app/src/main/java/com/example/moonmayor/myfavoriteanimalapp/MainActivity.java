package com.example.moonmayor.myfavoriteanimalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CHOOSE_ANIMAL = 1;
    public static final String EXTRA_RANDOM_NUMBER = "random-number";

    private TextView favoriteAnimal;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favoriteAnimal = findViewById(R.id.favorite_animal);

        mButton = findViewById(R.id.goToTwo);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseAnimalActivity.class);
                intent.putExtra("random-number", Math.random());

                startActivityForResult(intent, REQUEST_CHOOSE_ANIMAL);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            reset();
            return;
        }

        if (requestCode == REQUEST_CHOOSE_ANIMAL) {
            if (data == null) {
                reset();
                return;
            }
            String favoriteAnimal = data.getStringExtra(ChooseAnimalActivity.FAVORITE_ANIMAL);
            String message = getString(R.string.animal_choice, favoriteAnimal);
            this.favoriteAnimal.setText(message);
        }
    }

    // reset the text to some default
    public void reset() {
        String message = getString(R.string.no_animal_chosen);
        this.favoriteAnimal.setText(message);
    }
}
