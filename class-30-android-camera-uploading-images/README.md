# ![CF](http://i.imgur.com/7v5ASc8.png) Accessing Camera and Uploading Images

## Resources
* [Android Training: Taking Photos Simply](https://developer.android.com/training/camera/photobasics.html)

## Code Review  

## Topics  
* Basic `ImageView` review
  * possible values for the `scaleType` attribute values
* Introduce Intents
  * Used to launch applications (open address in Maps)
  * Used to retrieve information from apps (reading QR Codes)
  * Intents may contain "Extra" information (edit a photo at this file location)
* Using the camera
  * Configure app manifest to allow Camera use
  * Use an intent to launch the Camera
* Accessing Intent results
  * `onActivityResult` method
  * Retrieve image data from Camera result
  * Save the camera image to the local gallery
  * Access the full-resolution photo via a file
    * Configure a FileProvider in the app manifest
    * Add an XML file defining the location of app files
* Choosing a photo
  * Select and display a picture from the gallery * Make a button to take a picture with the camera * Make a button to choose a picture from the gallery * Create a popup Dialog to choose between using the camera or the gallery ### ImageView Review Review the `scaleType` property for `ImageView`. Choosing the proper scaleType is important when you're working with an application that displays a wide
variety of images. Consider how an image's size and its aspect ratio could
affect how it's displayed in an app.

If an image is small it might show up super tiny. If an image is huge it might
explode and fill up the entire view of an app. It's good to scale an image to
try to fit it so it fills exactly the space you want.

It's not enough to say "small images should get bigger, and big images should
get smaller." There are a variety of ways to define exactly how an image should
be scaled.

Along with the size of the an image (let's say it's width) we must also consider
the aspect ratio of an image (the ratio of its width compared to its height).
Let's categorize image aspect ratios into three general types:

* **Square:** an image where its image is practically equal to its height.
* **Tall:** an image whose height is significantly greater than it's width.
* **Wide:** an image whose width is significantly greater than it's height.

Here's an easy way to keep these aspect ratios in mind. Remember these three
objects:

* Cube
* Space Needle
* Hollywood Sign

Whenever you're making an app consider how pictures of these objects (these
aspect ratios) should be displayed in your app.

Android defines eight different values for the `scaleType` attribute. Let's see
what they each do.

Here's a repo bundling together lots of resources for you to understand
scale types. The repo has an app with one `ImageView` for each different scale
type. There's a button in the app that cycles through different images (small,
large, square, tall and wide) so you can see how different types of images are
displayed in an app for each `scaleType`.

https://github.com/codefellows/android-imageview-scaletypes-demo

Also, refer to this website or the Android docs for quick access to this info:

* https://robots.thoughtbot.com/android-imageview-scaletype-a-visual-guide
* https://developer.android.com/reference/android/widget/ImageView.ScaleType.html

Checkout the app, review it's code, run it and cycle through the images to
observe together how the images different images behave with different
scaleTypes.

### Configure the ImageView Properly
Review the basic structure of an `<ImageView>` while looking through the app.
Describe the rationale for the `layout_width` and `layout_height` values.

In this Instagram-like app we want images to stretch to fill the entire width of
the screen. I've personally found `centerCrop` to be the best option.

Notice that the images scaled with `centerInside`, `fitCenter`, `fitEnd` and
`fitStart` have lots of extra padding above or below the images. There's another
property `adjustViewBounds` you can add to remove this extraneous padding.

Add the `adjustViewBounds` and `scaleType` attributes to the `<ImageView>`
element to configure it to display correctly.

```xml
<ImageView
  android:id="@+id/imageResult"
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:adjustViewBounds="true"
  android:scaleType="centerCrop"/>
```

### Intro to Intents
Dev Guide: <https://developer.android.com/guide/components/intents-filters.html>

The Android operating system uses "Intents" to send messages between
applications. This is a very Android concept. Apple's iPhones and their iOS
don't have a real real equivalent to Android's Intents.

[source](https://stackoverflow.com/questions/5630874/is-there-android-intent-concept-in-iphone-sdk)

Intents are what Android calls the messaging system under the hood. Android
users don't need to know that Intents exist. Here's what Intents looks like
from a user perspective:

I can open Facebook, go to an event page and see an Address. If I click on the
address Android allows me to interact with it in a few different ways:

- Open it in Google Maps
- See it in Facebook's map viewer
- Search for it in the browser via Google

One of the coolest things about Android is how it allows users to customize
pretty much everything.

If you have multiple browsers installed on your phone and click on a link like
`http://www.yahoo.com` Android will prompt you and ask which browser you'd like
to open the link with.

iOS does not have Intents. It's frustrating. When people click on an address
in a Facebook app on iOS iOS pretty much forces users to open the address with
the Apple Maps app. It's possible to install Google Maps on iOS, but it's not
possible (correct me if I'm wrong, I checked) to make Google Maps or any other
map app the system's default map app.

To be fair, the Apple Maps app does include "Share" functionality that allows
users to open another Map app. Still, you must invoke this manually and iOS
won't route things to different apps automatically.

In summary, Android has something under the hood called "Intents." Intents are
part of Android's inter-app messaging system. Intents allow users to take a
piece of information (like an address, or a URL) and choose an application they
want to interact with that data.

Intents allow your phone to do several awesome things:

* Launch an app from inside another app (open address in Google Maps)
* Use an app to gather or process information from inside another app (launch
  QR code reader)
* Choose applications to replace default apps like the browser, the text message
  app, the phone app, the maps app, or really anything else.
* Allow apps to configure themselves to open for specific URLs, like opening a
  native app when you visit Yelp, or reddit.
* Allow apps to configure themselves to react to a general class of actions,
  like taking pictures, or saving contact information.
  
### Intent Specifics
Here's what an Intent looks like inside a program. We create a `new Intent()`
object and use the built-in `MediaStore.ACTION_IMAGE_CAPTURE` to tell it we're
sending off an Intent to capture an image. This Intent will launch the camera
so we can take a picture.

The if statement is there to see if there's any activity that will acknowledge
it knows how to handle this type of Intent. If there's no application that can
handle that type of intent then our application won't even bother sending it
off.

```java
// This int is defined by our own app. It's like a cattle brand. We use it to
// identify different types of Intents when they finish and come back to our app.
int REQUEST_IMAGE_CAPTURE = 1;

Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
}
```
  
Let's write an application that generates this intent and see if we can get it
to launch the camera and take a picture.
  
### Using the Camera
In order for our app to use the camera we'll need to modify the application
manifest to add a special permission specifically stating it will use the
camera.

```xml
<manifest ... >
    <uses-feature android:name="android.hardware.camera"
                  android:required="true" />
    ...
</manifest>
```

Add the Intent code from above and let's see what happens.

The application should launch, and immediately launch the camera to take a
picture. And then that's it. We need to add an ImageView to actually see it.

### Add an ImageView
The application needs somewhere to display the image. Use the `<ImageView>` view.
We're trying to configure the `<ImageView>` here to fill the whole width of the
screen so it stretches across our entire app nicely.

We'll also need code to populate the `<ImageView>` with image data once we receive
it from the camera.

```xml
<ImageView
  android:id="@+id/imageResult"
  android:layout_width="match_parent"
  android:layout_height="wrap_content" />
```

Add a private field at the top of our application to save a reference to the new
`<ImageView>`.

```java
private ImageView mImageResult;
```

The image data is sent to our application via an `Intent` through the apps
`onActivityResult` method. We need to override this method, receive the
`Intent`, extract the bitmap data from the intent and insert that image
data into the `<ImageView>`.

Notice that we check the `requestCode` against the int value we made up to
identify what the original intent was, `REQUEST_IMAGE_CAPTURE`. We do this
because this one method deals with all intent results that come back to our
application. When we send out more than one type of Intent we need some way
to disambiguate them when they come back.

```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        mImageResult.setImageBitmap(imageBitmap);
    }
}
```

Run the app, take a picture, and see what happens!

**Spoiler alert:** the image shows up very short. It doesn't stretch to fill
the entire screen. What's going on?!

### Common Intents
Cool. We can take pictures and display them in our app. What else can we do?
Review this Dev Guide showing common Intents in Android.

Some Intent labels are stored in different namespaces, like `MediaStore.`,
`AlarmClock.`, or simply `Intent.`. Actions under `Intent` disambiguate
themselves by using different URI patterns. URIs look a lot like URLs. If you're
really interested in the technical differences of them, then here you go:

Here's a page describing URIs vs URLs: <https://danielmiessler.com/study/url-uri/>

Here's a wikipedia quote:

```
One can classify URIs as locators (URLs), or as names (URNs), or as both. A
Uniform Resource Name (URN) functions like a person’s name, while a Uniform
Resource Locator (URL) resembles that person’s street address. In other words:
the URN defines an item’s identity, while the URL provides a method for finding
it.
```

* **URI** - Uniform Resource Identifier
  * a square is a rectangle
  * a URL is a URI
* **URL** - Uniform Resource Locator
  * a rectangle is not always a square
  * a URI is not always a URL

Here's some different common Intents. Notice that Maps and the Browser both
use the same `Intent.ACTION_VIEW` to start themselves off. These Intents are
disambiguated based on the string passed to `Uri.parse("foo")`.
  
* AlarmClock.ACTION_SET_ALARM
* Camera
  * MediaStore.ACTION_IMAGE_CAPTURE
  * MediaStore.ACTION_VIDEO_CAPTURE
* Text messages
  * Intent.ACTION_SENDTO
  * Intent.ACTION_SEND
  * Intent.ACTION_SEND_MULTIPLE
* Maps
  * Intent.ACTION_VIEW
    * new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=my+street+address"));
* Web Browser
  * Intent.ACTION_VIEW
    * new Intent(Intent.ACTION_VIEW, Uri.parse("http://yahoo.com"));
    
The Maps and Browser Intents gather their information from data inside the URI
string. The Alarm Clock, message and text messages intents get their data by
having the Intent filled with Extra information.
    
Alarm Clock:

```
Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
  .putExtra(AlarmClock.EXTRA_MESSAGE, message)
  .putExtra(AlarmClock.EXTRA_HOUR, hour)
  .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
```
    
#### General messaging apps:

```
Intent intent = new Intent(Intent.ACTION_SENDTO);
intent.setType(HTTP.PLAIN_TEXT_TYPE);
intent.putExtra("sms_body", message);
intent.putExtra(Intent.EXTRA_STREAM, attachment);
```
    
#### Text messages only:
    
```
Intent intent = new Intent(Intent.ACTION_SEND);
intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
intent.putExtra("sms_body", message);
```
  

Dev Guide: <https://developer.android.com/guide/components/intents-common.html>

### Trouble Points
* Telling the Intent to write the photo result to a file wont also
  return a thumbnail. `takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);`
  * Refer to the docs here:
    * https://developer.android.com/reference/android/provider/MediaStore.html#ACTION_IMAGE_CAPTURE
    * If the EXTRA_OUTPUT is not present, then a small sized image is returned as a Bitmap object in the extra field.

* Be sure to change the package name whenever your configuring a FileProvider.
* Change `com.example.android.fileprovider` to `com.yourdomain.yourapp`

```
Uri photoURI = FileProvider.getUriForFile(this,
  "com.example.android.fileprovider",
  photoFile);
```

* `getExternalFilesDir()` - seems to work fine.
* `getExternalStoragePublicDirectory()` - I'm having trouble with file permissions
  * works on a real phone, but does not work on an emulated phone.
