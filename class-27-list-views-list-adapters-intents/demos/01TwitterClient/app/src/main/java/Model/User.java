package Model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by adamwallraff on 8/30/17.
 */

public class User {

    private static String TAG = "User";

    public String name;
    public String profileImageURL;
    public String location;

    public User(JSONObject userObject){
        try {
            this.name = userObject.getString("name");
            this.profileImageURL = userObject.getString("profile_image_url");
            this.location = userObject.getString("location");
        }catch (Exception exception){
            Log.d(TAG, "User Creation Exception: " + exception);
        }
    }
}
