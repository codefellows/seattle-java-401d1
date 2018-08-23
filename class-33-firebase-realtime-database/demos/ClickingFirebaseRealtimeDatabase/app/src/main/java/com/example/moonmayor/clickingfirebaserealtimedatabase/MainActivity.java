package com.example.moonmayor.clickingfirebaserealtimedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "FIREBASE_CLICKER";

    @BindView(R.id.leftClickTotal) public TextView leftClickTotal;
    @BindView(R.id.rightClickTotal) public TextView rightClickTotal;

    private int mLeftClicks = 0;
    private int mRightClicks = 0;

    FirebaseDatabase mDatabase;
    DatabaseReference mLeftRef;
    DatabaseReference mRightRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mDatabase = FirebaseDatabase.getInstance();
        mLeftRef = mDatabase.getReference("left");
        mRightRef = mDatabase.getReference("right");

        mLeftRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Integer.class);
                Log.d(TAG, "Left value is: " + value);
                mLeftClicks = value;
                leftClickTotal.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        mRightRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Integer.class);
                Log.d(TAG, "Right value is: " + value);
                mRightClicks = value;
                rightClickTotal.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    @OnClick(R.id.leftClick)
    public void leftIncrement() {
       increment("left");
    }

    @OnClick(R.id.rightClick)
    public void rightIncrement() {
        increment("right");
    }

    public void increment(String side) {
        if (side.equals("left")) {
            mLeftClicks++;
            mLeftRef.setValue(mLeftClicks);
        } else if (side.equals("right")) {
            mRightClicks++;
            mRightRef.setValue(mRightClicks);
        }
        leftClickTotal.setText("" + mLeftClicks);
        rightClickTotal.setText("" + mRightClicks);
    }
}
