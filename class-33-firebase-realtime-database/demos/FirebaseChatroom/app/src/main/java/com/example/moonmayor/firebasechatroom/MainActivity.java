package com.example.moonmayor.firebasechatroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "CHATAPP";

    @BindView(R.id.text) TextView mText;
    @BindView(R.id.recycler) RecyclerView recycler;

    List<ChatroomStatus> statuses;

    private LinearLayoutManager linearLayoutManager;
    private ChatroomStatusAdapter chatroomStatusAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        statuses = new ArrayList<>();

        linearLayoutManager = new LinearLayoutManager(this);
        chatroomStatusAdapter = new ChatroomStatusAdapter(statuses);

        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(chatroomStatusAdapter);

        attachDBListener();
        attachUsersListener();
    }

    public void attachUsersListener() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");

        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<ChatroomStatus> statuses = new ArrayList<>();
                for (DataSnapshot user :dataSnapshot.getChildren()) {
                    String username = user.getKey();

                    String status = user.child("status").getValue(String.class);

                    String statusText = "";
                    if (user.hasChild("statusText")) {
                        statusText = user.child("statusText").getValue(String.class);
                    }

                    ChatroomStatus chatStatus = new ChatroomStatus(username, status, statusText);
                    statuses.add(chatStatus);

                    Log.d(TAG, chatStatus.toString());
                }

                chatroomStatusAdapter.setStatuses(statuses);
                chatroomStatusAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.write)
    public void write() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World! " + Math.random());
    }

    public void attachDBListener() {
        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);

                mText.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
