# ![CF](http://i.imgur.com/7v5ASc8.png) Username Input, Server-Stored Friend Relationships

## Resources
* [Using Shared Preferences](https://developer.android.com/guide/topics/data/data-storage.html#pref)

Configure a database to store user information. Create a table to model M:M
friendships between users.

Design the database to have asymmetrical friend relationships. Make it possible
for one user to follow another user without that user following them back.

Configure the database so it can store user bio information. Add a text field
where users can store up to 300 characters.

Build routes on the server to:
* Retrieve a list of one user's friends
* Retrieve a list of all users
* Retrieve a list of users that partially match some username search query

## Testing
* Write Unit tests for:
  * Creating a new user
  * Editing the bio of a new user
  * Following a user
  * Unfollowing a user

### Populating the Data
Either create your own mock data, or ask the instructors if they've made
available an interesting data set for this lab. Try searching through
<http://kaggle.com> to see if there's something you could adapt for this app.
  
## Stretch Goals
Add stats to the user bio pages where users can see how many users each user
follows, and how many followers each user has.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
