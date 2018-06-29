# ![CF](http://i.imgur.com/7v5ASc8.png) Android Activities, Layouts and Click Handlers

## Resources
* [Download Android Studio]()

### Creating a new project  
First, when creating a new project, assign your company domain to be:  
```
android.<yourname>.com
```  

Notice the package name update, using reverse DNS  

Continue.  

Select the following Minimum SDK:  
```
<Insert here>
```  

Select Phone and Tablet.  

Continue forward.  

Explain to students that we will start with an Empty Activity at the start of each project to teach the necessary concepts and avoid introducing unnecessary code.  

When prompted, name the Activity `HomeActivity`.  

Continue with finishing creating the new project.  

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
  
