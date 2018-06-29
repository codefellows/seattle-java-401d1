# ![CF](http://i.imgur.com/7v5ASc8.png) Firebase Auth and Storage

## Resources
* [Firebase Auth](https://firebase.google.com/docs/auth/android/firebaseui)
* [Firebase Storage](https://firebase.google.com/docs/storage/android/start)
* [YouTube Getting Started with Firebase Auth on Android (4:53)](https://www.youtube.com/watch?v=SXlidHy-Tb8)
* [YouTube: Getting Started with Firebase Storage on Android (8:30)](https://www.youtube.com/watch?v=7puuTDSf3pk)

## Learning Objectives
* Students will be able to use Firebase Auth to create user accounts,
  authenticate users on login, and authorize users to interact with content.
* Students will be able to use intents to pick an image from the gallery.
* Students will be able to upload an image to Firebase storage.
* Students will be able to organize information across Firebase database,
  Firebase Auth, and Firebase storage to associate user profile images with
  user accounts.
* Students will be able to use Auth, and Database to create a live chat room.

## Lecture Outline
* Contextualize the lecture with the lab.
  * We're working toward building a chat room where users can sign in, add a
    profile image to their account, and chat with each other.
  * New technologies:
    * Firebase Auth - allows users to create accounts and sign in.
    * Firebase Storage - accepts image uploads
  * Old Technologies
    * Firebase Database
      * Holds chat messages
      * Associates user accounts with URLs to user profile images
* Introduce Firebase Auth
  * Use the official Firebase Auth demo app.
  * Build a simple app that logs in via social media, or GitHub.
* Introduce Firebase Storage
  * Use the official Firebase Storage demo app to upload a photo.
  * Observe where the photo is uploaded.
  * Copy the URL and open the image in your browser.
  * Attempt to query for "all images" in storage and show that this doesn't
    work. There's no way to query for all the images in Firebase storage.
    Images must be tracked manually.
* Saving Image URLs with Firebase Database
  * Configure the app so it has access to Firebase Database
  * Configure the image uploader to react to the URL it receives when it
    uploads an image, and save that URL into a list in the Firebase
    Database.
  * If you want to query for a list of images, you must use Firebase Database to
    retrieve the URLs, you don't query Storage.
  * In all: Storage is Storage. It doesn't perform queries. The Database is the
    Database. Query for information there.
* Tie together Auth, Storage and the Realtime Database with a demo app
  * Build something like a "click contest" app
  * Users log in and see a list of users with their profile images.
  * Users can click on other users as many times as they want.
  * The app should display how many clicks each user has performed,
    and display how many times each user has been clicked on.
  
## Code Samples
Uploading an image to Firebase Storage:

```java
private void upload() {
  Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
  StorageReference riversRef = mStorageRef.child("images/rivers.jpg");

  riversRef.putFile(file)
  .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
      @Override
      public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
          // Get a URL to the uploaded content
          Uri downloadUrl = taskSnapshot.getDownloadUrl();
      }
  })
  .addOnFailureListener(new OnFailureListener() {
      @Override
      public void onFailure(@NonNull Exception exception) {
          // Handle unsuccessful uploads
          // ...
      }
  });
}
```
