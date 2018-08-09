# ![CF](http://i.imgur.com/7v5ASc8.png) Android Activities, Layouts and Click Handlers

## Reading
* Read Big Nerd Ranch
* **Android Debugger: Issues with the R class** (page 87)
* **SDK Versions: A Sane Minimum** (page 114)
* **App Basics** (page 2)
* **Wiring Up Widgets** (pages 21-23)
* **Android and Model-View-Controller** (pages 33-46)
* Read about problems (and solutions!) you might encounter with the `R` class and
  the Android Studio IDE.
* What's a sane minimum choice for the Android SDK?
* Gain an understanding of Android `activities` and `layouts`.
* Learn how to get a reference to widgets and attach click listeners
* Review the `GeoQuiz` app in the Model-View-Controller chapter to gain an
  understanding of how user actions in the app travel from the layout to the activity
  to modify internal state of the application and modify the layout to make the app
  interactive.

## Resources
* [Download Android Studio](https://developer.android.com/studio/)
* [Android SDK Releases (API levels 1-28)](https://source.android.com/setup/start/build-numbers)

### Creating a new project  
* Open Android Studio
* Choose "Start a new Android Studio project"
* Choose an Application name
* Leave the company domain as default
* Choose a Project Location (make sure you create a folder to contain everything)
* Leave everything else default
* Press Next
* Select the checkbox for "Phone and Tablet, " then choose API level 23
* Press Next
* Choose empty-actvity
* Press Next
* Leave the Activity Name and Layout Name as defaults
* Press Finish

Observe Android Studio and Gradle generating an Android project for you.
Notice that it built a directory structure like
`app > java > com.example.username.application > MainActivity`.
MainActivity defines the first thing that will run when someone starts your
app, like a `Main` method in a traditional Java program.

Look at the directory structure outside of `app > java` and observe what's
put under `app > res > layout`. This is where the templates for Android
applications exist. Notice the file `activity_main.xml` defines what's
shown on the screen when your app is run.

## Android Studio Layout
You should be familiar with the Android Studio layout as it is very similar
to IntelliJ IDEA.

Now we will go over a quick breakdown of each `Tool Window`  
* Lefthand side - Project Tool Window  
* Main View - Editor  

### Gradle  
Go over `build.gradle`  

Navigate to https://dev.twitter.com/twitterkit/android/installation.  

Demonstrate adding TwitterKit to our `gradle` file.  

Navigate to the `HomeActivity` and in the `onCreate()` method:  
```java
Twitter.initialize(this);
```  

Explain that we will continue deeper into the Twitter SDK in future classes.  

Back to slides.  

### XML Layouts  

Navigate to `app/res/layout/activity_home.xml` and double-click to view.  

Explain to students that this is where we can design our layouts for Each Activity. We will discuss activities later.  

Click on the text tab at the bottom of the screen to show the underlying XML.  

While looking at the XML explain to students that we are looking at 2 default `Widgets`. The `RelativeLayout` and `TextView` which we will discuss later in the course.  

Then, go into the `values` directory and inspect the following 2 xml files, and explain these are the primary files we will be working with besides layouts:  
* `strings.xml` - Should contain all the user-facing Strings of your app.  
* `colors.xml` - Should contain all the colors for your UI  

### Android Emulators  

Begin the process of running the application.  

Walkthrough the process of creating a new emulator and choosing the corresponding api version.  

### Activity Lifecycle  
Create a new Activity subclass called `LifeCycleActivity` and implement the following code:  
```java
private static final String TAG = "LifecycleActivity";

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Log.d(TAG, "onCreate Called");
}

@Override
protected void onStart() {
    super.onStart();

    Log.d(TAG, "onStart Called");
}

@Override
protected void onResume() {
    super.onResume();

    Log.d(TAG, "onResume Called");
}

@Override
protected void onPause() {
    super.onPause();

    Log.d(TAG, "onPause Called");
}

@Override
protected void onStop() {
    super.onStop();

    Log.d(TAG, "onStop called");
}

@Override
protected void onRestart() {
    super.onRestart();

    Log.d(TAG, "onRestart: called");
}

@Override
protected void onDestroy() {
    super.onDestroy();

    Log.d(TAG, "onDestroy: called");
}
```  

Then, navigate to the `HomeActivity` and change it to `extend LifeCycleActivity`.  

Run the application to and show accessing `LogCat` and the lifecycle methods being called.  


### Android Studio  
* Get students familiar with the Android Studio Ecosystem.  
  * Installing Toolchains  
  * Compiling your first program  
  * Familiar with Dev environment  
  
