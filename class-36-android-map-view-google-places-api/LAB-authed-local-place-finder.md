# ![CF](http://i.imgur.com/7v5ASc8.png) Authed Local Search App

## Resources
* [Getting Started with Google Maps](https://developers.google.com/maps/documentation/android-api/start)
* [MapView Docs](https://developers.google.com/android/reference/com/google/android/gms/maps/MapView)
* [Google Places Android API](https://developers.google.com/places/android-api/)
* [Accessing Android Location Data](https://developers.google.com/maps/documentation/android-api/location)

## Feature Tasks
Create an Android app that uses the `MapView`, determines your current GPS
location, and uses the Google Places API to allow users to search for places
near them.

Clear the map whenever someone performs a search so the map doesn't become
polluted with tons of pointer pins.

Choose an appropriate layout that allows you to display a fullscreen map across
the entire screen (besides the top menu bar) and allows you to place a search
box for users to type in, and buttons.

Use Firebase Auth to authorize users to use the app. We'll use more with auth
and maps later.

## Testing  
* Write JUnit tests to make sure you can interact with the Google Places API
  appropriately.

## Documentation
In your `README.md` include screenshots of your app.

## Stretch Goals
* Allow users to click on a result and open the place in the native Google Maps
  app so they can get directions from there.
* Replace the default map icons with custom icons of your choice.
* Include some buttons in your app to show users your own pre-curated set of
  some of your favorite locations.
  * Ideas might include:
    * Your list of best places to get sandwiches in an area
    * Local spots tourists should see
    * Favorite music venues
    * Favorite bars

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
