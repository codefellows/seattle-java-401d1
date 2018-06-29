package com.example.moonmayor.whatswhatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moonmayor.whatswhatsapp.adapters.ConversationListAdapter;
import com.example.moonmayor.whatswhatsapp.adapters.MessageListAdapter;
import com.example.moonmayor.whatswhatsapp.mockdata.MockConversations;
import com.example.moonmayor.whatswhatsapp.models.ChatConversation;
import com.example.moonmayor.whatswhatsapp.models.ChatMessage;

import java.util.Date;
import java.util.List;

/**
 * Created by moonmayor on 10/6/17.
 */

public class ConversationActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "TITLE";

    TextView mTextView;
    EditText mEditText;
    Button mSendButton;

    ListView mListView;
    MessageListAdapter mAdapter;

    ChatConversation mConversation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null || intent.getExtras().get(EXTRA_TITLE) == null) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        String title = intent.getExtras().getString(EXTRA_TITLE, "Untitled");
        mTextView = (TextView) findViewById(R.id.title);
        mTextView.setText(title);

        mEditText = (EditText) findViewById(R.id.newMessage);
        mSendButton = (Button) findViewById(R.id.send);
        configureSendMessage();

        mConversation = MockConversations.getConversationByTitle(title);
        mListView = (ListView) findViewById(R.id.messageList);
        mAdapter = new MessageListAdapter(this, R.layout.chat_message, mConversation.messages);
        mListView.setAdapter(mAdapter);
    }

    public void configureSendMessage() {
       mSendButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sendMessage();
           }
       });
    }

    public void sendMessage() {
        String message = mEditText.getText().toString();

        ChatMessage msg = new ChatMessage("username", message, (new Date()).getTime());
        mConversation.messages.add(msg);
        mAdapter.notifyDataSetChanged();
    }
}

