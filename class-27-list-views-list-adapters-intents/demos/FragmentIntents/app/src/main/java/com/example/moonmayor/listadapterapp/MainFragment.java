package com.example.moonmayor.listadapterapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainFragment extends Fragment {
    public static final int REQUEST_GET_ANIMAL = 1;

    private Button mButton;
    private Button mChooseAnimal;

    private TextView mFavoriteAnimal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mButton = view.findViewById(R.id.goToTwo);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });

        mFavoriteAnimal = view.findViewById(R.id.favoriteAnimal);
        mChooseAnimal = view.findViewById(R.id.chooseAnimal);
        mChooseAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChooseAnimalActivity.class);
                startActivityForResult(intent, REQUEST_GET_ANIMAL);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
