package Model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by adamwallraff on 8/30/17.
 */

public class Tweet {

    private static String TAG = "Tweet";

    public String text;
    public String id;
    public User user;

    public Tweet(JSONObject tweetJSON){

        try {
            this.text = tweetJSON.getString("text");
            this.id = tweetJSON.getString("id");
            this.user = new User(tweetJSON.getJSONObject("user"));
        }catch (Exception exception){
            Log.d(TAG, "Tweet Creation Exception: " + exception);
        }

    }
}
