# ![CF](http://i.imgur.com/7v5ASc8.png) Authed Chat Room and Profile Images

## Resources  
* [Firebase Auth](https://firebase.google.com/docs/auth/android/firebaseui)
* [Firebase Storage](https://firebase.google.com/docs/storage/android/start)
* [YouTube Getting Started with Firebase Auth on Android (4:53)](https://www.youtube.com/watch?v=SXlidHy-Tb8)
* [YouTube: Getting Started with Firebase Storage on Android (8:30)](https://www.youtube.com/watch?v=7puuTDSf3pk)

Create an app that allows users to create an account with a profile image,
log in, and join one chat room where they can talk to other users.

This lab combines Firebase Auth, Storage and the Realtime Database. Use Firebase
Auth to create accounts and log users in. Store their profile images in Firebase
Storage. Keep track of user account and profile picture associations with the
Firebase Database. Store chat messages in the Firebase Database.

Retrieve and display the chat history when a user joins a chatroom. Keep them
subscribed to the realtime changes in the database and show new messages as
they come in.

Ensure that the chat messages are in reverse chronological order so the newest
messages are always display at the bottom of the chat room view.

Display the chat's username, the user's profile image, and a small timestamp
with each chat message.

## Stretch Goals
Once your made one default global chat room try to make a new activity that
represents a lobby where users can see several different chat rooms to join.
Modify the structure of your Firebase Database to store chats across different
rooms.

Allow users to click a button to create a new room and give the new room a name.
  
## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
