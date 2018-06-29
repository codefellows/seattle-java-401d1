# ![CF](http://i.imgur.com/7v5ASc8.png) Firebase Messaging and Storage

## Resources
* [How to Configure Firebase Messaging](https://firebase.google.com/docs/cloud-messaging/android/client)
* [Ion: Asynchronous Image Loading](https://github.com/koush/ion)

## Learning Objectives
* Students will be able to upload an image to Firebase
* Students will be able to store the URL locations of images uploaded to Storage
  in the Firebase Database
* Students will be able to retrieve and display a list view of images uploaded
  to Storage
* Students will be able to trigger notifications on devices when the app is
  in the background

## Lecture Outline

#### Messaging
* Users like to receive notifications about important events
* We'll use Firebase messaging to notify users they receive new chats.
* Download the Firebase demo repo and run the Messaging demo app.
* Build a project from scratch and configure it to use Firebase Messaging.
* Use the Firebase console to send notifications to the app.

#### Heterogeneous ListViews
Slack allows users to chat, and to upload images. When a user uploads an image
it shows up right in the chat room. Users don't post a link and other users
click the link view the image. Slack actually renders the image right there
visible to everyone in the chat room.

Let's discuss how to upgrade out ListView so it can render diverse content.
Let's make our chat messages more "widgety."

* Build small views customized for different types of messages. Make sure they
  each work so you can see an image, or play audio:
  * Text Message
  * Image Message
  * Audio Message
  * Interactive Vote Message (very fancy)
* All of these messages will extend from one class `Message` so we can keep
  them all in one list.
* Model Java classes that will capture the data in each different type of message
* Choose messages, and media to include in an example conversation that we'll
  use
  * Someone says hello
  * Someone responds
  * Someone posts an image (it's rendered so other users see it)
  * Someone replies "lol"
  * Someone posts a song  (other users can click "play" to hear it)
* Build logic in the list adapter that detects what type of message is sent
  in each message.
  * text, text, image, text, audio
* Write a `getView()` message that returns a specific customized layout for the
  type of message
* Render the list and see the customized listviews come in.
