package com.example.moonmayor.whatswhatsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moonmayor.whatswhatsapp.storage.MySharedPreferences;

/**
 * Created by moonmayor on 10/4/17.
 */

public class LoginActivity extends AppCompatActivity {
    EditText mUsernameInput;
    Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // check to see if the user is already logged in
        String username = MySharedPreferences.getUsername(this);
        if (username != null) {
            launchMainActivity();
        }

        mUsernameInput = (EditText) findViewById(R.id.usernameInput);
        mLoginButton = (Button) findViewById(R.id.loginButton);
        attachClickHandlers();
    }

    private void attachClickHandlers() {
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUsername();
            }
        });

        mUsernameInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // detect if the user presses [enter]
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    saveUsername();
                    return true;
                }
                return false;
            }
        });
    }

    private void saveUsername() {
        String username = mUsernameInput.getText().toString();
        MySharedPreferences.storeUsername(this, username);

        launchMainActivity();
    }

    private void launchMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

