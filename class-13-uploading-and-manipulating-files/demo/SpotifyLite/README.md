[logo]:https://camo.githubusercontent.com/70edab54bba80edb7493cad3135e9606781cbb6b/687474703a2f2f692e696d6775722e636f6d2f377635415363382e706e67

![CF][logo] Spotify Lite

Make a webpage where users can log in, upload MP3 files and play them from
another device. Each user should only be able to play files they've uploaded.
Initially, have users manually enter the name of the artist, album and song
title.

Build a webpage with a simple interface to allow users to see what tracks
they've uploaded, search for a track, play, and pause a track.

## Feature Tasks
* Create a user table with id, username, password hash
* Create a song table with id, filepath, artist, album, song
* Create a table creating a 1-to-many relation between users and songs.
* Create a server that supports
  * user account creation
  * user login
  * user logout
  * file upload
  * simple song-playing web app

## Resources
* [MDN Docs: Audio tag](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/audio)
* [Spring Tutorial: Uploading Files](https://spring.io/guides/gs/uploading-files/)
* [ID3 metadata](https://en.wikipedia.org/wiki/ID3)

## Testing
* Create a unit test verifying you can encrypt a password and check
  plaintext attempts for matches and non-matches.
* Create a unit test verifying user accounts are properly created in the
  Database.
* Create a unit test verifying you can add song information to the database.
* Create a test verifying songs and users are properly related in the DB.
* Create a test verifying users can only access songs they've personally
  uploaded.

# Stretch Goals
* Configure the website to automatically play the next song when the current
  song ends.
* Allow users to create playlists.
* Save server space by detecting when any user uploads an identical file and
  set it up so they simply have access to play the one copy that the server
  keeps.
* Track how many times each song is played and display it on the homepage.
* Use a library to extract artist, album and song title information from the
  MP3 file.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
