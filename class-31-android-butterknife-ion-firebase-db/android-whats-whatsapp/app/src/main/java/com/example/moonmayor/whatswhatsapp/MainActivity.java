package com.example.moonmayor.whatswhatsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moonmayor.whatswhatsapp.adapters.ConversationListAdapter;
import com.example.moonmayor.whatswhatsapp.mockdata.MockConversations;
import com.example.moonmayor.whatswhatsapp.models.ChatConversation;
import com.example.moonmayor.whatswhatsapp.storage.MySharedPreferences;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView usernameTextView;

    private ListView mConversationsListView;
    private ArrayAdapter<ChatConversation> mConversationsAdapter;

    private String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check to see if the user is already logged in
        mUsername = MySharedPreferences.getUsername(this);
        if (mUsername == null) {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            return;
        }

        usernameTextView = (TextView) findViewById(R.id.usernameDisplay);
        usernameTextView.setText(mUsername);

        attachConversations();
    }

    private void attachConversations() {
        List<ChatConversation> conversations = MockConversations.allConversations;
        mConversationsAdapter = new ConversationListAdapter(this, R.layout.chat_conversation, conversations);
        mConversationsListView = (ListView) findViewById(R.id.conversations);
        mConversationsListView.setAdapter(mConversationsAdapter);
    }
}
