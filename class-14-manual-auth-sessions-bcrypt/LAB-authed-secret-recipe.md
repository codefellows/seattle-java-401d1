# ![CF](http://i.imgur.com/7v5ASc8.png) Auth for Secret Recipe

## Resources
* [jBCrypt](https://www.mindrot.org/projects/jBCrypt/)

Build a website that protects a secret recipe by requiring users to sign up
for an account and log in. Users should only be able to see the recipe after
they've logged in and established an authenticated session.

Create this authentication system on your own. Do not use Spring's own built-in
auth system.

Display a user's username in a header nav bar to indicate to a user that they're
logged in.

Use Bcrypt to hash and check user passwords. Make sure not to return user's
passwords, or their hashes if you return User information over any request.

## Feature Tasks
* Create a database
* Create a table that models users with a username, id, and hashed password.
* Authenticate the site so only logged-in users can see the secret recipe.
* Use Bcrypt to hash all passwords stored on the site.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
