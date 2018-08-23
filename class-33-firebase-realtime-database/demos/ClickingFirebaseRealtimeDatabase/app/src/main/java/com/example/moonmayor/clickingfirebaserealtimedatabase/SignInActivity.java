package com.example.moonmayor.clickingfirebaserealtimedatabase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {
    @BindView(R.id.usernameInput) EditText mUsernameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.signin)
    public void signin() {
        String username = mUsernameInput.getText().toString();

        Intent intent = new Intent(this, StatusActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}
