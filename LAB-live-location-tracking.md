# ![CF](http://i.imgur.com/7v5ASc8.png) Live Location Tracking

## Resources
* [Adding Maps](https://developer.android.com/training/maps/index.html)
* [Android Location Services](https://developer.android.com/training/location/index.html)
* [Running in a Background Service](https://developer.android.com/training/run-background-service/index.html)

## Feature Tasks
Use an Android background service to monitor someone's live location. Configure
the app manifest to request explicit user permission to access their location
data. Periodically upload the location data to a Firebase database.

Display a message in the notification tray to indicate to the user that their
location is being accessed and uploaded (Android requires applications to display
an indicator like this in order to remain as a constantly running background
service.)

Use a `MapView` to show the user's location on the map. Update their displayed
location as they move around.

Show users tasks that are near them. Allow them to adjust a maximum distance so
they can view only tasks that are within some range. Add an endpoint to a Spring
server that retrieves Tasks from firebase and whittles them down based on the
users current location and their maximum distance preference.

Create a notification if a user doesn't have the app open and they move near a
task.

**Opportunity for Fun:** Take your phones out into the real world and watch your
location update as you move around. Notice how your location moves. Consider
how much you need to move before your location registers as a change by GPS.
Alternate between moving slowly and quickly (walking slow, walking quick,
jogging, running, biking, driving) and see how GPS responds to the different
speeds.


## Testing  
* Write a test to make sure you can access the phone's location data.
* Write tests to determine the distance between two locations, near and far.

## Documentation
* In your `README.md` include screenshots of your app.
* Include a sample of how information is structured and stored in your Firebase
  database.

## Stretch Goals
* Allow someone else to monitor the users location by opening the app and
  disabling live updates of their location. One user should be able to run the
  app on an emulator without broadcasting information while another person runs
  the app on their phone and walks around outside.
* Build a simple website using JavaScript Google Maps that retrieves information
  from Firebase and displays the users location on a webpage.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
