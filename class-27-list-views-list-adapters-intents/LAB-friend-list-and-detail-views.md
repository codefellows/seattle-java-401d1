# ![CF](http://i.imgur.com/7v5ASc8.png) Friend List and Detail Views

## Resources  
* [Putting Data in Intents](https://developer.android.com/guide/components/intents-filters.html)

This lab focuses on creating apps with multiple activites, and passing info
from one activity to another via Intents. This lab does not involve passing
data backwards as a result from a started activity back to the first activity.

Build an app with the following:

* A class `Friend` with at least the following properties:
  * A public String `name` property for their name
  * A public String `bio` property for a short description of them
* `MainActivity`
  * A `TextView` with a short intro explaining what your app is about, like
    "use this app to find out a little more about my friends."
  * A `Button` that says "See My Friends"
* `FriendsActivity`
  * Includes a hard-coded array with five of your friends.
  * Only show the friends name.
  * Do not show the friends bio.
  * A `Button` for each friend that says "More" and launches the
    `FriendDetailActivity`
  * Use an `Intent` to launch the second activity
  * Put an `extra` on the intent with the friend's name.
  * Put an `extra` on the intent with the friend's short bio.
  * Do not try to pass the entire `Friend` object through as an extra on an
    intent. Intents are good at passing primitive values. It requires more work
    to pass our own custom classes.
* `FriendDetailActivity`
  * Use a `ConstraintView` as the main outer layout
  * Have a large bold `TextView` showing your friend's name.
  * Have a smaller paragraph under the name showing your friend's short bio
  * Have a `Button` constrained to the bottom of the page that says "Back"
  * Have the "Back" button `finish()` the activity without setting a result
    to pass information back to the activity.
  
## Stretch Goals
Include a picture for each of your friends. Add a `int` id so your hard-coded
array can reference a Drawable. Show the each friend's picture when you view
their detail page.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request

