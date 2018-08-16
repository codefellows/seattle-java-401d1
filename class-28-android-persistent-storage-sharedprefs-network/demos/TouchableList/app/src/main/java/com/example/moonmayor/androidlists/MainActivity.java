package com.example.moonmayor.androidlists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonGoToTwo;
    Button buttonGoToThree;
    Button goToStarfleetRoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGoToTwo = findViewById(R.id.goToTwo);
        buttonGoToThree = findViewById(R.id.goToThree);
        goToStarfleetRoster = findViewById(R.id.goToStarfleetRoster);

        attachClickListener(buttonGoToTwo, SecondActivity.class);
        attachClickListener(buttonGoToThree, ThirdActivity.class);
        attachClickListener(goToStarfleetRoster, StarfleetRosterActivity.class);
    }

    public void attachClickListener(Button button, final Class class_) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, class_);
                startActivity(intent);
            }
        });

    }
}
