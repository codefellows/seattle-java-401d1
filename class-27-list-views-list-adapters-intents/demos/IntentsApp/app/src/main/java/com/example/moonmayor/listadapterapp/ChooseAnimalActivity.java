package com.example.moonmayor.listadapterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;


public class ChooseAnimalActivity extends AppCompatActivity {
    public static final String FAVORITE_ANIMAL = "favorite-animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_animal);

        List<View> buttons = ((LinearLayout) findViewById(R.id.choices)).getTouchables();
        for (View button : buttons) {
            button.setOnClickListener(new ChooseAnimalListener());
        }
    }

    public class ChooseAnimalListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            String favoriteAnimal = button.getText().toString();

            Intent data = new Intent();
            data.putExtra(FAVORITE_ANIMAL, favoriteAnimal);
            setResult(RESULT_OK, data);

            ChooseAnimalActivity.this.finish();
        }
    }
}
