package com.example.adamwallraff.a501twitterclient;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import Model.JSON;
import Model.Tweet;

public class HomeTimelineActivity extends AppCompatActivity {

    private static final String TAG = "HomeTimelineActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_timeline);

        ArrayList<Tweet> allTweets = JSON.getTweets(this, true);

        for (Tweet tweet: allTweets) {
            Log.d(TAG, "onCreate: Username - " + tweet.user.name + ": " + tweet.text);
        }
    }

}
