# ![CF](http://i.imgur.com/7v5ASc8.png) Twitter Kit

## Resources
* [Twitter Kit](https://dev.twitter.com/twitterkit/android/overview)

### ListView  
> ListView is a view group that displays a list of scrollable items. The list items are automatically inserted to the list using an Adapter that pulls content from a source such as an array or database query and converts each item result into a view that's placed into the list.  

> ListView's are highly reliant on Adapters to get the data needed to present their views.  

```xml
android:divider	//Drawable or color to draw between list items.  
android:dividerHeight	//Height of the divider.  
```  

Remove the following code from `HomeTimelineActivity` `onCreate`:  
```java
ArrayList<Tweet> allTweets = JSON.getTweets(this, true);

for (int index = 0; index < allTweets.size(); index++){
    Log.d(TAG, "onCreate: TweetText - " + allTweets.get(index).text);
}
```  

Navigate to the `activity_home_timeline.xml` and delete the `Hello World` label.

Search for a `ListView`, then drag out and place on the `HomeTimelineActivity`.  

Near the bottom of the window, switch from `Design` to `Text` and make sure the `activity_home_timeline.xml` is as follows:  
```XML
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.adamwallraff.a501twitterclient.HomeTimelineActivity">

    <ListView
        android:id="@+id/tweet_list_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="8dp"
        tools:layout_editor_absoluteY="8dp"/>

</android.support.constraint.ConstraintLayout>
```  

Then, head back to `HomeTimelineActivity.java` and add the following method:  
```java
private void setupTweetListView(){
    tweetListView = (ListView) findViewById(R.id.tweet_list_view);

    ArrayList<Tweet> allTweets = JSON.getTweets(this, true);

    String[] listItems = new String[allTweets.size()];

    for (int index = 0; index < allTweets.size(); index++){
        listItems[index] = allTweets.get(index).text;
    }

    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);

    tweetListView.setAdapter(adapter);
}
```  

### Resources Directory  

> NOTE: Inform students, that we will be looking at the resource file, but this is very sensitive and should not be modified directly. This file is generated based on our XML files and Android Studio will generate our `R` class as necessary.  

Change to `Project` view and Navigate to:  
```
<App Name>/app/build/generated/source/r/debug/<ProjectName>/R
```  

In this file, `cmd+f` to search for:  
```
class id
```  

Explain.  

> NOTE: Also, mention the `android.R.layout.simple_list_item_1` is coming from the Android SDK. This provides default layouts for different Android Widgets and UI Elements. We will go into more detail on this in the next lecture.  

### Creating a new custom layout for list item  
In the `layout` module, right click and add navigate to `New > Layout Resource File`  

Make the root element a `Relative Layout` and name it `tweet_list_item`.  

Then, in design, drag out an `ImageView` and 2 `TextView`s.  

Switch to `xml` and ensure the layout looks as follows:  
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                android:layout_width="match_parent"
                android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_marginStart="20dp"
        android:layout_marginTop="20dp"
        app:srcCompat="@mipmap/ic_launcher"/>

    <TextView
        android:id="@+id/textView_first_name"
        android:textSize="20sp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@+id/imageView"
        android:layout_marginStart="10dp"
        android:layout_toRightOf="@+id/imageView"
        android:layout_alignParentRight="true"
        android:text="TextView"/>

    <TextView
        android:id="@+id/textView_last_name"
        android:textSize="15sp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        android:layout_below="@+id/textView_first_name"
        android:layout_alignStart="@+id/textView_first_name"
        android:layout_alignEnd="@+id/textView_first_name"
        android:layout_marginTop="10dp"/>
</RelativeLayout>
```  



### Adapters  
> Adapters manage the relationship between our tweet text and the ListView.  

Switch back to `Android` view and navigate back to `HomeTimelineActivity.java`.  

Call in the `onCreate()` method:  
```java
setupTweetListView();
```  

Build and run to show the text for each `Tweet` in the `ListView`.  


Then, show students how they can create their own custom UI and `Adapter`s for each item.  

In the `HomeTimelineActivity` add the following inner class:  
```java
class TweetListAdapter extends BaseAdapter {

    ArrayList<Tweet> tweets;

    public TweetListAdapter(ArrayList<Tweet> tweets){
        super();

        this.tweets = tweets;
    }

    @Override
    public int getCount() {
        return tweets.size();
    }

    @Override
    public Object getItem(int i) {
        return tweets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Tweet currentTweet = tweets.get(i);

        view = getLayoutInflater().inflate(R.layout.person_list_item, null);

        TextView firstNameView = (TextView) view.findViewById(R.id.textView_first_name);
        TextView lastNameView = (TextView) view.findViewById(R.id.textView_last_name);

        firstNameView.setText(tweets.get(i).firstName);
        lastNameView.setText(tweets.get(i).lastName);

        return view;
    }
}
```  


### Android Studio  
> Make sure students to show students how to turn on autocompleted Setters and getters in preferences:
PG: 35 - Android Programming

### Twitter Kit  
Head over to the Twitter Kit documentation: https://dev.twitter.com/twitterkit/android/installation  

Following the instructions, make sure to register your application with Twitter here:  
https://apps.twitter.com/  

Create a new application following the onscreen directions.  

Put the following in the callback URL field:  
```
https://<yourname>.com
```  

Then, go back to the https://dev.twitter.com/twitterkit/android/installation page and continue the process.  

Add the following to the gradle file and sync:  
```
compile 'com.twitter.sdk.android:twitter:3.1.1'
```  

Also, add the following resources to you `string.xml`:  
```XML
<string android:name="com.twitter.sdk.android.CONSUMER_KEY">XXXXXXXXXXX</string>
<string android:name="com.twitter.sdk.android.CONSUMER_SECRET">XXXXXXXXXXX</string>
```  

Make sure to insert your keys from registering your app on Twitter.  

### New Activities  
Navigate to `New > Activity > Empty Activity` and create a new Activity called `LoginActivity`.  

Then, in in `LoginActivity.java` change `onCreate()` to:  
```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Twitter.initialize(this);

    setContentView(R.layout.activity_login);
}
```  

Then, in the `activity_login.xml`:  
```XML
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    android:gravity="center"
    tools:layout_editor_absoluteY="8dp"
    tools:layout_editor_absoluteX="8dp">

    <com.twitter.sdk.android.core.identity.TwitterLoginButton
            android:id="@+id/login_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:layout_editor_absoluteX="0dp"
            tools:layout_editor_absoluteY="0dp"/>
</LinearLayout>
```  

Then, lastly, change the `AndroidManifest.xml` to:  
```XML
<activity android:name=".HomeTimelineActivity">
</activity>
<activity android:name=".LoginActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN"/>

        <category android:name="android.intent.category.LAUNCHER"/>
    </intent-filter>
</activity>
```  

This adds the new activity to our application's manifest but also makes it the entry point for our app.  

Run the app.  
> NOTE: clicking the login button will crash the application.  

Then, in the `LoginActivity.java` class, in `onCreate()`, underneath the `setContentView` add:  
```java
loginButton = (TwitterLoginButton) findViewById(R.id.login_button);

 loginButton.setCallback(new Callback<TwitterSession>() {
     @Override
     public void success(Result<TwitterSession> result) {
         Log.d(TAG, "success: " + result);
     }

     @Override
     public void failure(TwitterException exception) {
         Log.d(TAG, "failure: " + exception);
     }
 });
```  

Also, add the following `Override` method to the `LoginActivity` class:  
```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    Log.d(TAG, "onActivityResult: " + requestCode + " - " + resultCode + "-" + data);

    loginButton.onActivityResult(requestCode, resultCode, data);
}
```  

Build and run to show, when you click the button, it should present a webview allowing the user to login to their twitter account.  

Go through the login process, and it should dismiss the webview when done. Then look at the `LogCat` logs.  

### Presenting another Activity  

Navigate to the `AndroidManifest` and change the `HomeTimelineActivity` back to the application entry point:  
```XML
<activity android:name=".HomeTimelineActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN"/>

        <category android:name="android.intent.category.LAUNCHER"/>
    </intent-filter>
</activity>
<activity android:name=".LoginActivity">
</activity>
```  

Then, update the `onCreate()` method of `HomeTimelineActivity` to have:  
```java
Twitter.initialize(this);

TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();

if (session != null) {
    Log.d(TAG, "onCreate: Auth Token" + session.getAuthToken());
    setupTweetListView();
} else {
    Log.d(TAG, "onCreate: Twitter SESSION is NULL");
    startActivity(new Intent(this, LoginActivity.class));
}
```  

Also, override the following method for updating the `ListView` after a user logs in:  
```java
@Override
protected void onResume() {
    super.onResume();
    setupTweetListView();
}
```  

Then, navigate back to the `LoginActivity` and add the following in the `onCreate()` method, inside the `success` block:  
```java
finish();
```

> Build and run to show the login process, and walk through the Documentation on TwitterKit for login to show that it is managing the persistance of our accessToken.  

If you need to reset the  `SessionManager` to force getting a new token, use the following line of code in `onCreate()` of `HomeTimelineActivity`:  
```java
TwitterCore.getInstance().getSessionManager().clearActiveSession();
```  

### Make Request for actual Tweets  


#### Get Tweets from current user(If needed)  
In `HomeTimelineActivity` change the `setupTweetListView()` method to the following.  
```java
UserTimeline userTimeline = new UserTimeline.Builder().build();

Log.d(TAG, "getUsersTweets: " + userTimeline);

TweetTimelineListAdapter adapter = new TweetTimelineListAdapter(this, userTimeline);

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);

tweetListView.setAdapter(adapter);
```  

### Cover Lab Requirements  
