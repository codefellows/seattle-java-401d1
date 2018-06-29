package com.example.moonmayor.whatswhatsapp.storage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.moonmayor.whatswhatsapp.LoginActivity;
import com.example.moonmayor.whatswhatsapp.MainActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by moonmayor on 10/10/17.
 */

public class MySharedPreferences {
    private static final String PREFERENCES_FILENAME = "userinfo";
    private static final String PREF_USERNAME = "username";


    public static void storeUsername(Context context, String username) {
        // check to see if the user is already logged in
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCES_FILENAME, MODE_PRIVATE).edit();
        editor.putString(PREF_USERNAME, username);
        editor.commit();
    }

    public static String getUsername(Context context) {
        // check to see if the user is already logged in
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCES_FILENAME, MODE_PRIVATE);
        String username = prefs.getString(PREF_USERNAME, null);
        return username;
    }
}
