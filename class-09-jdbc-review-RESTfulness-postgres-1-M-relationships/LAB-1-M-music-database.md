# ![CF](http://i.imgur.com/7v5ASc8.png) 1:M Music Database

## Resources  
* [Postgres Datatypes](https://www.techonthenet.com/postgresql/datatypes.php)
* [HTML Postgres Cheat Sheet](http://www.postgresonline.com/special_feature.php?sf_name=postgresql83_cheatsheet&outputformat=html)
* [Postgres CLI (Command Line Interface)](https://www.pgcli.com/)
* [Postico](https://eggerapps.at/postico/)
* [RESTed HTTP OSX Tool](https://itunes.apple.com/us/app/rested-simple-http-requests/id421879749?mt=12)

## Feature Tasks
Create a database that models the relationship between artists and songs.
Your database should allow people to write queries to look up an artist by name,
look up songs by name, query songs by artist and query an artist by a song.

Create two tables: one for artists, one for songs. Create a 1:M relationship
where one artist can have an association to many songs.

The tables should look like the following. In addition, you'll need to add a
column yourself to model the 1:M relationship between an artist and their
songs.

* Artist:
  * artistId
  * name
* Song:
  * songId
  * title

Write SQL to populate the database with a few of your own known artists and
songs.

Write SQL queries for CRUD operations on both artists and songs:
* Create a new artist/songs
* Retrieve an artist/song by id or name
* Update the name/title of an artist/song
* Update artist a song is related to.
* Delete an artist/song

Create files to store these raw SQL queries. Use the PostgresCLI or Postico
to manually execute the queries and make sure they return sensible results.

Create a Java class called `ArtistDB` and `SongDB` that has CRUD methods to
interact with the database. Use the standard Java Database Connection (JDBC)
package to interact with the database.

Create Java unit tests to make sure the methods for both the DB classes work
as expected.

Create RESTful routes in your Spring app to gather input from users passed
from a webpage. Run the server and use a tool like Postman or Rested to check
the routes.

## Testing
Create unit tests to make sure you can create Artists, Songs and associate
them together properly.

## Docomentation
Use a tool to generate an ERD (Entity Relationship Diagram) for your
database.
  
## Stretch Goals
* Create a seed script that creates database tables and populates them with
  standard data. Seed scripts are a great way to develop and test your data.
  Seed scripts allow you to populate a database with known data so you can
  interact with it, and make sure it behaves as expected. Seed scripts allow
  you to rapidly create, obliterate, and create databases again so you can
  test to make sure they work correctly in a default state.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
