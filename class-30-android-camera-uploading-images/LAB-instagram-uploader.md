# ![CF](http://i.imgur.com/7v5ASc8.png) Instagram Uploader


## Resources  
* [Spring Uploading Files](https://spring.io/guides/gs/uploading-files/)
* [Taking Photos Simply in Android](https://developer.android.com/training/camera/photobasics.html)

Build on the app to allow users to upload their own photos with a description.
Users should be able to pick a photo from their gallery, or take a new photo
on the spot with their camera.

When a user uploads a photo you should store the file, and associate the
file path in a database with the user's name, and their description, as well as
a timestamp to keep track of when the photo was uploaded.

Build two new routes off the server:
* One route returns the 10 most recently uploaded photos, with their timestamps,
  description and the username of their creator.
* One route that returns all the photos and their information for one specific
  user.
* One route returns the 10 most recently uploaded photos of other users that
  one user is following.
  
Basically, there should be a way to view one users pictures, and a friend feed,
and a global feed.

Design your app so it has several activities:
* A login activity where the app displays a logo, and users can enter their
  username and password.
* A Global Feed activity where users can view a list of the most recently uploaded
  pictures of all users.
* A Friend Feed activity where users can view pictures of only users they follow.
* The user search view where a user can search for other users.
* The user detail page where a user can view the bio and all the photos for just
  one user.

## Stretch Goals
* Add a heart button where users can "like" other users's pictures.
* Display how many times each picture has been liked.
* More Authorization:
  * Add a settings activity where users can toggle their account to be public
    or private
  * Reconfigure the database to store whether a user account is public or
    private.
  * Prevent users with privately-configured accounts from being displayed in the
    global feed, or from their photos being seen by users they are not following.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
