# ![CF](http://i.imgur.com/7v5ASc8.png) List Views

# Turning Tweet JSON Into List Views

## Topics  
* Access a JSON file as a resource and extract data.
* Build classes modeling data.
* Populate JSON data into a custom List View

###  Starting Twitter  
Create a new project in Android Studio called `TwitterClient`.  

Open the `HomeTimelineActivity.java`, and override `Activity` methods to show the `Activity Lifecycle`.  

Back to Slides.  

### JSON  

In Android Studio, right-click on `app` and navigate to:  
```
New > Folder > Asset Folder
```  

Then, right-click on the `assets` folder and navigate to:  
```
New > File
```  

Enter `Tweet.json` as the file name and paste the contents of another `Tweet.json` into the file and save. Notice that the file recognizes that it is a JSON file.  

> If your first time teaching, Tweet.json is located in the resources directory above.  

Once you have properly added the `Tweet.json` file we need to create a new group for our model objects.  

To do this, right-click on `app` in the navigation window and select:  
```
New > Package...
```  

Add the package to the `...app/src/main/java` directory, and name the package Model.  

> You should see the directory appear in your project.  

Select the `Model` package and navigate to:  
```
File > New > Java Class
```  

Do this to create the following model objects:  
* `JSON`  

Explain to students that we will start by parsing the `Tweet.json` file we added earlier in the `JSON` class.  

In `JSON.java` add the following method:  
```java
public static String getSampleJSONAsString(Context context){
    StringBuilder stringBuilder = new StringBuilder();
    InputStream stream = context.getAssets().open("Tweet.json");
}
```  

Pause here and explain the red underlined line.  

> This is due to the fact that `open()` can throw, and so we need to wrap in a try/catch.  

#### StringBuilder  

> This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.  

#### InputStream  

> An InputStream is a reference to source of data (be it a file, network connection etc), that we want to process as follows: we generally want to read the data as "raw bytes" and then write our own code to do something interesting with the bytes.  

Then, complete the method:  
```java
public static String getSampleJSONAsString(Context context){
    StringBuilder stringBuilder = new StringBuilder();
    String jsonString = null;

    try {
        InputStream stream = context.getAssets().open("Tweet.json");
        Integer jsonDataLength = stream.available();

        byte[] buffer = new byte[jsonDataLength];
        stream.read(buffer);
        stream.close();

        jsonString = new String(buffer, "UTF-8");
    } catch (Exception exception){
        Log.d(TAG, "getSampleJSON: ERROR - " + exception);
    }

    return jsonString;
}
```  

Go to the `HomeTimelineActivity.java` and add the following to the `onCreate()` method:  
```java
Log.d(TAG, "onCreate: " + JSON.getSampleJSONAsString(this));
```  

Run to show the JSON printing to the console.  

Next, lets go back and make the `getSampleJSONAsString()` method `private`.  

Then explain to students that we need to start working on our other Model objects to get things going.  

Back to Slides.  

### MVC  
Select the `Model` package and navigate to:  
```
File > New > Java Class
```  

Do this to create the following model objects:  
* `Tweet`  
* `User`  

First we will build out the `User.java`:  
```java
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
```  

Walk through the above code with students, then we need to implement `Tweet.java`:  
```java
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
```  

Now we will head back to `JSON.java` and add the public method `getTweets()`:  
```java
public static ArrayList<Tweet> getTweets(Context context, Boolean usingSampleJSON) {
    ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    try {
        JSONArray tweetsJSON = new JSONArray(getSampleJSONAsString(context));
        for (Integer i = 0; i < tweetsJSON.length(); i++){
            JSONObject tweetJSON = tweetsJSON.getJSONObject(i);
            Log.d(TAG, "getTweets: TweetText - " + tweetJSON.get("text"));
            tweets.add(new Tweet(tweetJSON));
        }

    }catch (Exception exception){
        Log.d(TAG, "getTweets: ERROR - " + exception);
    }

    return tweets;
}
```  

Now, we need to demonstrate using the method to show students we are generating actual instances of `Tweet`.  

In `HomeTimelineActivity.java` add the following to `onCreate()`:  
```java
ArrayList<Tweet> allTweets = JSON.getTweets(this, true);
for (int index = 0; index < allTweets.size(); index++){
    Log.d(TAG, "onCreate: TweetText - " + allTweets.get(index).text);
}
```  

Run and show the Tweet text in logcat.  

Back to Slides.  

### ListView  
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
        android:layout_width="368dp"
        android:layout_height="495dp"
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

### Adapters  
> Adapters manage the relationship between our tweet text and the ListView.  

Switch back to `Android` view and navigate back to `HomeTimelineActivity.java`.  

Call in the `onCreate()` method:  
```java
setupTweetListView();
```  

Build and run to show the text for each `Tweet` in the `ListView`.  

### Android Studio  
> Make sure students to show students how to turn on autocompleted Setters and getters in preferences:
PG: 35 - Android Programming
