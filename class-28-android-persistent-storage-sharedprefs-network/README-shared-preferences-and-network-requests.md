# ![CF](http://i.imgur.com/7v5ASc8.png) Persistent Storage with Shared Preferences, and Simple Network Requests

## Resources
* [Shared Preferences Guide](https://developer.android.com/guide/topics/data/data-storage.html#pref)
* [Using Shared Preferences](https://developer.android.com/training/data-storage/shared-preferences.html)
* [Sending a Simple Request](https://developer.android.com/training/volley/simple.html)

### Persistent Storage
It can be hard to persist information while users switch from activity to
activity. Although it's possible to tie activities together passing and
receiving data through Intents this can turn out be be quite cumbersome.

Android's built-in `SharedPreferences` storage mechanism allows us to store
information that persists throughout the entire app. `SharedPreferences`
allows you to create a file that stores primitive values as key-value pairs.
It's especially great for storing information like someone's username or an auth
token -- things you'll need to access all throughout the app.

This custom class, `MySharedPreferences` wraps around the standard
`SharedPreferences` to create even more easy functionality. This is something we
create manually and is not part of Android itself. It creates two methods,
`storeUsername` and `getUsername` to standardize the way applications interact
with the `SharedPreferences`. Notice that the filename and the `PREF_USERNAME`
values are standardized at the top of the file. Standardizing key names like
this prevents typo errors.

Use this class as a pattern to build your own class that adds more `get` and
`set` methods to store all sorts of primitive data to share between all the
Activities in your app.

**LoginActivity.java**
```java
protected void onCreate(Bundle savedInstanceState) {
  // store the username
  MySharedPreferences.storeUsername(this, "moon");

  // retrieve the username
  String username = MySharedPreferences.getUsername(this);
}
```

**MySharedPreferences.java**
```java
public class MySharedPreferences {
    private static final String PREFERENCES_FILENAME = "userinfo";
    private static final String PREF_USERNAME = "username";

    public static void storeUsername(Context context, String username) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCES_FILENAME, MODE_PRIVATE).edit();
        editor.putString(PREF_USERNAME, username);
        editor.commit();
    }

    public static String getUsername(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCES_FILENAME, MODE_PRIVATE);
        String username = prefs.getString(PREF_USERNAME, null);
        return username;
    }
}
```

Here's a way to hook up an `EditText` to respond to the enter key.

```java
EditText mUsernameInput = (EditText) findViewById(R.id.usernameInput);
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
```

### Network Requests
In order for your app to interact with the internet you need to add the
`android.permission.INTERNET` permission to your app's manifest. This presents
an explicit dialog to the user to make them aware that the app they are using
may read their data and transmit information to the internet. Explicitly
asking for internet permission from the user is a security and privacy concern.
If you download a simple calculator app and it asks for internet permission that
may be a clue the app is doing something nefarious on your phone.

Android has a library called `Volley` that helps manage network requests.
Volley builds an object called a `RequestQueue` to manage multiple network
requests. It's possible to create a request, define how the request should
execute on success or on an error, and add the request to the RequestQueue.
The `StringRequest` `Response.Listener` acts very much like a JavaScript
promise. The listener response and error methods will execute when the
network request completes.

```java
final TextView mTextView = (TextView) findViewById(R.id.text);

// Instantiate the RequestQueue.
RequestQueue queue = Volley.newRequestQueue(this);
String url ="http://www.google.com";

// Request a string response from the provided URL.
StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        // Display the first 500 characters of the response string.
        mTextView.setText("Response is: "+ response.substring(0,500));
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        mTextView.setText("That didn't work!");
    }
});
// Add the request to the RequestQueue.
queue.add(stringRequest);
```
