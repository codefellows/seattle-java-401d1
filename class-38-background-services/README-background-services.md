# ![CF](http://i.imgur.com/7v5ASc8.png) Background Services


## Resources

## Learning Objectives
* Students will be able to build background services that run while the app
  doesn't have foreground focus.
* Students will be able to monitor user movement by accessing GPS location
  in the background.
* Students will be able to upload live location data to an online database
* Students will be able to create an app that shows users the live location
  of all other users using the app
* Students will be able to restrict their view of other users to only seeing
  users near them.
* Students will be able to configure the proximity that defines "nearby" users.
* Students will be able to toggle live-location sharing on and off.
* Students will be able to provide an indication to the user that their
  location is being shared.

## Lecture Outline
* Android allows applications to run background services that run when the app
  doesn't have foreground focus.
* Background services allow apps like Facebook Messenger to run while you're
  browsing the internet, or using another app, and receive notifications when
  someone messages you.
* Media apps like Spotify use background services to play music in the background
  while you use other apps.
* Today we'll configure a background service to monitor a users GPS location
  and broadcast it to a server so users can share their live location passively
  with other users.
  
