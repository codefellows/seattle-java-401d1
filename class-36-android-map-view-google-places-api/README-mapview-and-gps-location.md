# ![CF](http://i.imgur.com/7v5ASc8.png) MapView, GPS Data, and Google Places API

## Resources
* [Location and Maps Guide](https://developer.android.com/guide/topics/location/index.html)
* [MapView Docs](https://developers.google.com/android/reference/com/google/android/gms/maps/MapView)

## Learning Objectives
* Students will be able to render an Android Google Maps MapView inside an
  application.
* Students will be able to configure their app to request permission to access
  GPS location data.
* Students will be able to display their current GPS location on the MapView
* Students will be able to query the Google Places API and display multiple
  location points of real-world places on the map.

## Lecture Outline
* Introduce Google Maps and GPS data as perhaps the best feature that exists
  on mobile phones.
* Explain that phones have the ability to read GPS data to determine a user's
  location, but the app must be explicitly configured to request permission
  to access the data.
* Discuss the security and privacy concerns about applications accessing user
  location data.
* Discuss power consumption concerns as GPS is a power-intensive resource.
* Create an application with a MapView
* Make the MapView cover the entire app.
* Use a FrameLayout so you can place a search box over the map.
* Access the GPS data
* Add a point on the map that displays the users location
* Configure your API_KEY credentials to be able to query the Google Places API
* Examine the API result data to determine useful information (like LAT/LONG)
* Display places from the query on the MapView
