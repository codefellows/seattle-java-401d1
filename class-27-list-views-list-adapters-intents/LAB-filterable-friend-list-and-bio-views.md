# ![CF](http://i.imgur.com/7v5ASc8.png) Filterable Friend List and Bio Views


## Resources  
* [Android ListView](https://developer.android.com/guide/topics/ui/layout/listview.html)
* [Stack Overflow: How do I filter a ListView?](https://stackoverflow.com/a/14663821)
* [Putting Data in Intents](https://developer.android.com/guide/components/intents-filters.html)
  
Build an app that features a search bar where someone can look their friends up,
choose a friend and see details about their friend. This of this as similar to
the way Instagram allows you to search for friends accounts, it offers
suggestions and filters results in a list as you type, and you can click on
their name and navigate to their profile where you can read more about them,
and see their pictures. Our app will be simpler than full-fledged Instagram.

A friend's Bio page should simply show a paragraph of text about them.

Your app should have at least two activities:
1. An activity with a search bar that displays a list of friends and filters
   the list down to show only partial matches as you type.
2. An activity that shows the details (short biography) of a user. It should
   display their username prominently and include their descriptive paragraph.
   Include a back button so users can navigate back to the search list.
   
Use Intents and `putExtra()` to start the detail view activity from the search
activity. Put the username the user chose as data with the extra when the
second activity starts.

### Populating the Data
Either create your own mock data, or ask the instructors if they've made
available an interesting data set based of real life popular twitter accounts.
  
## Stretch Goals
Add profile images to each user. Customize the ListView to display a small icon
showing their profile image. Show a slightly larger version of their profile
image in their detail bio view.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
