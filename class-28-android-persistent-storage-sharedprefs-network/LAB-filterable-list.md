# ![CF](http://i.imgur.com/7v5ASc8.png) Filterable List

## Resources  
* [Android ListView](https://developer.android.com/guide/topics/ui/layout/listview.html)
* [Stack Overflow: How do I filter a ListView?](https://stackoverflow.com/a/14663821)
* [Putting Data in Intents](https://developer.android.com/guide/components/intents-filters.html)

## Reference Implementations
Building lists in Android can be tricky! You may these implementations as
a reference. You're not allowed to copy and paste code from them. Practice
generating a good git history and commiting small verifiable incremental
progress at a time. This helps prove that you didn't just type in code from
these examples all at once without thinking.

* [Number One](https://github.com/codefellows/seattle-java-401d1/tree/master/class-28-android-persistent-storage-sharedprefs-network/demos/AndroidLists)
* [Number Two](https://github.com/codefellows/seattle-java-401d1/tree/master/class-28-android-persistent-storage-sharedprefs-network/demos/TouchableList)
* [Number Three](https://github.com/codefellows/seattle-java-401d1/tree/master/class-28-android-persistent-storage-sharedprefs-network/demos/TouchableList)

Remember that you need at least these things:

* A `RecyclerView` - the view that shows the list
* A `LinearLayoutManager` - helps determine what items should be shown
* A custom `ListAdapter` - accepts a list position and builds views with model
  data attached to widgets in the view.
* A custom `ViewHolder` - a simple class that holds a reference to a view and
  all the widgets within. Contains an updateable reference to a model instance
  and implements click listener methods as well.

## Feature Tasks
Build an app that features a `RecyclerView` and a `EditText` search bar where
someone can look things up, choose a thing and see details about that thing.

The `Thing` should be modeled by a class. Have at least three properties where
two of the properties contain small amounts of information and the third
property contains a large amount of information. The first two properties
should appear in the list view whereas the third large property should appear
in the list item detail page.

Your app should have at least two activities:
1. An activity with a search bar that displays a list of things and filters
   the list down to show only partial matches as you type.
2. An activity that shows the details of a thing with all it's properties.
   
Use Intents and `putExtra()` to start the detail view activity from the search
activity. Write two methods on your `Thing` class to help with Intents. One
should accept an intent put each property as an Extra onto it. The second
should be static, accept an intent and return a new `Thing` from the intent.

### Populating the Data
Make a singleton class with a list of data. Attach a `get()` method that
returns the data. Attach a `search(String filter)` that filters the list to
only data that matches.
  
## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
