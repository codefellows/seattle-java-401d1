# ![CF](http://i.imgur.com/7v5ASc8.png) Firebase Realtime Chatroom Status

## Resources  
* [Firebase Structured Data](https://firebase.google.com/docs/database/android/structure-data)
* [Read and Write Data](https://firebase.google.com/docs/database/android/read-and-write)
* [Working with Lists of Data](https://firebase.google.com/docs/database/android/lists-of-data)

"Status" is something chatrooms use to allow users to quickly report on what
they're doing. Status in this app is a combination of a type of status (online,
away, or offline) and a line of text describing what the user is doing.

* Someone can be online and "working on TPS reports"
* Someone can be online and "listening to the new U2 album"
* Someone can be away and "grabbing a sandwich"
* Someone can be offline and "done for the night. back at 9AM"
* Any combination of online/away/offline and any small piece of text.

Create an Android app that allows users to set their status and status text.
Use Firebase to store the user's chosen username, their status, and a message
they want to convey to other users.

## Application Architecture
Make two Activities:
* A `LoginActivity` that accepts someone's username (no auth or password)
  and has a button to go to the activiry with a list of other users.
* A `UserList` activity that shows a list of users, their statuses and
  their status text.

Use Android `SharedPreferences` to store the user's username between the
`LoginActivity` and the `UserList` activity.

The `UserList` activity should show a list of all users, their status and their
status text. Include a way for users to set their own status and enter status
text.

## Modeling Statuses
Create a Java class that models a user and their status:

```java
class ChatroomStatus {
  String username;
  String status;     // "online", "away", "offline"
  String statusText;
}
```

## Displaying Statuses
Find icons to display each possible variation of the User's status. Consider
using things like the following:

* Green circle for online
* Yellow circle for away
* Red circle for offline

## Configuration
* Open Android Studio and start a new project.
* Choose `Tools > Firebase` from the main drop-down menu
* Expand `Realtime Database`
* Click `Save and retrieve data`.
* Click `Connect to Firebase`
* Choose `Create a new Firebase project` and click `Connect to Firebase` in the
  pop-up menu.
* Go back to the Firebase Tools menu and choose `Add the Realtime Database to you app`
* Click `Accept Changes`
* Follow the code samples in the Firebase Tools window
* Load the Firebase console in your browser
* Make some simple read/write changes to the database and make sure you see
  them appear in the web console.

## Database
Manually add several users to the Firebase Database so the list always has
users with statuses to show. Include a variety of users with different
statuses, some with and without status text set.

Your application should allow you to sign in as any of those usernames (without
auth or passwords) and update their status and status text. If you have a phone
and the android emulator you should see changes update nearly instantly between 
the multiple devices.

Even if you don't have multiple Android devices you should be able to navigate
to the Firebase Database console, manually change data in the webpage and see
your emulator or phone react to changes and display the new information.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request

