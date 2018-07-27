# ![CF](http://i.imgur.com/7v5ASc8.png) Spotify Lite

## Resources
* [Spotify](http://spotify.com)
* [MDN: The Embed Audio Element](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/audio)
* [Free Music Public Domain](http://www.freemusicpublicdomain.com/)

**You MUST deploy** this lab to Heroku! (but note: Heroku has an "ephemeral"
filesystem so any files you upload will eventually disappear. They may stay
there for a moment, but when Heroku shuts down your instances and cycles
servers every 24 hours your files will definitely be deleted.)

Create a web interface like Spotify allowing users to access MP3 files they've
uploaded. Protect other users from accessing MP3 files with user authentication
and authorization.

Configure your server to upload MP3s to the public directory in
`src/main/java/resources/public/uploads`.

Build a database that stores the following properties for an MP3:
* The userid of whoever uploaded the song.
* The name of the song
* The artist
* The uploaded location of the MP3

Build a webpage that allows users to enter information about an MP3 and upload
an MP3 file. The same page should have a list of all MP3s the user uploaded.

Access the filepath and strip off the `static` prefix to get a URL for the file
location.

```
String filepath = storageService.store(file);
filepath = filepath.split("static")[1];
System.out.println(filepath);
```

Display each MP3 in an audio tag so it can be played:

```
List<Song> songs = getSongsFromDatabaseByUser(userId);
model.setAttribute("songs", songs);

<div th:each="song : ${songs}">
    <span th:text="${song.title}"></span>
    <span th:text="${song.artist}"></span>
    <audio controls="controls">
        <source th:src="${song.path}"></source>
    </audio>
</div>
```

# Stretch Goals
* Add a new table to the database to track how many times a user listens to
  each of their songs.
* Add a new table to keep track of when artists and songs were uploaded and
  keep track of dates for each time they've been played. Display this
  information to the user on a webpage where they can see their "most-listened-to"
  stats.
* Leverage your web-scraping, album-art-fetching API to display album art
  for artists and songs as they play.
* Modify the site to allow users to upload videos! Create a new table in the
  database to store movies associated with a user. Create a new HTML template
  to allow users to interact with their videos. Refer to MDN docs about the
  HTML5 `<video>` tag to figure out how to display videos on a page.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
