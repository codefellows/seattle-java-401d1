* Views
  * XML files that define how one activity appears in the app
  * Layouts
    * Layouts define how nest views are rendered
    * LinearLayout, ConstraintLayout
  * Widgets
    * Something more "physical" in the view of your app
    * Like a Button, TextView, EditText, ImageView
    * Not exactly HTML, but similar
* Activity
  * one view of your application.
  * your application can have many different views
  * MainActivity - the activity that runs when your app starts
* Fragments
  * mini-Activities where multiple Fragments can be inserted into one Activity
  * Fragments are reusable so you can have multiple of the same fragment in
    one Activity, or reuse a Fragment in other places of your app
* ClickListener
  * a block of code we can attach to a button that executes
    when a button is pressed
* Intent
  * We use intents to move from one place to another
  * One intent object is used to transfer from one activity to another
  * That one intent object can have multiple "extras" attached
  * An activity that starts a second activity can start the activity and expect
    a result using `startActivityForResult` and implementing `onActivityResult`
  * It's possible to send information from one activity to another
    and get information back when a started activity ends
* Extra
  * One piece of information attached to an Intent to carry information
    from the first Activity to the second Activity
  * Multiple Extras can be attached to one intent by calling
    `putExtra` method several times
  * Every extra is key/value pair
  * You can access each extra by asking for `getTYPEExtra`
    * `getStringExtra("foo")`
    * `getIntegerExtra("bar")`
    * `getDoubleExtra("baz")`
* String Resources
  * Android has a file called `strings.xml` where it strives to store every raw
    string that would appear in our application
  * This makes localization and internationalization (l10n and i18n) easier
  * Improves consistency, and makes use less prone to make typos by retyping
    strings all the time


