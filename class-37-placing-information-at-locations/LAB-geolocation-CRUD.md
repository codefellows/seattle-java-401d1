# ![CF](http://i.imgur.com/7v5ASc8.png) Tasks At Locations

## Resources
* [Google Places API](https://developers.google.com/places/android-api/)
* [Android Location Services](https://developer.android.com/training/location/index.html)

## Feature Tasks
Create an Android app that allows users to place points on a map and save them
to a database. Include Google Places so users can easily search for places they
know.

Configure the app so users can long-press on a point on the map and create a pin
with information describing the place. Prompt the user with a text input so they
can describe what to do at the location.

Allow users to see all tasks that all users have placed at locations. Only allow
users to edit tasks they have created.

Use Firebase to store places users create. Users should be able to log out of
the application, uninstall the app, reinstall the app and still have access to
the places they've saved.

**Remember:** DO NOT store your Google Maps API key in your repo!

## Testing  
* Write JUnit tests to document how you save and read annotated geographic data
  to the Firebase Database.

## Documentation
* In your `README.md` include screenshots of your app.
* Include a sample of how information is structured and stored in your Firebase
  database.

## Stretch Goals
Create an Activity with a ListView that allows users to see a list of all other
users and allows them to click on another user and see the places they've saved
in the map. Users should only be able to edit their own tasks.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
