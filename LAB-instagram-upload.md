# ![CF](http://i.imgur.com/7v5ASc8.png) Instagram Uploader

In this lab you'll create a small Instagram app that takes pictures, uploads
them to a server and displays everyone's photos in one feed.

## Resources  
* [Spring Uploading Files](https://spring.io/guides/gs/uploading-files/)
* [Taking Photos Simply in Android](https://developer.android.com/training/camera/photobasics.html)
  
## Configuration
Follow the guide in "Spring Uploading Files" to create a simple server that
accepts file uploads and provides a route that returns a list of every photo
on the server.

Follow the guide in "Taking Photos Simply" to create a basic app that takes
photos and obtains access to the photo data via a file on the phone.

## Feature Tasks  
#### Exercise
* Create a main activity where users can view the main feed seeing all the
  pictures.
* Add a button "Take Picture" that creates an intent to send users to the camera.
* Upload the picture to the server.
* Return the user back to the main feed with their own picture at the top of
  the feed.

## Testing  
* Write JUnit tests to make sure the server returns a list of photo URLs.

## Documentation
* Provide documentation about the upload and photo URL list API points.
* Take screenshots of the app and include it in your `README.md`.

## Stretch Goals
Allow users to choose and persist a username for themselves when they log in to
the app. Pass that username along while uploading photos. Display usernames next
to pictures in the main feed. Add more routes so the server can return photos
just for that user. Configure the app to display only one user's photos when
clicking on their username.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
