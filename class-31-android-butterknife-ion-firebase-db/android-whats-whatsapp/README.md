# Whats Whatsapp
A simple implementation of a chat application using Firebase's realtime
database.

## Steps to Create
1. Create two activities, `MainActivity` and `LoginActivity`
  * `LoginActivity` should have an `<EditText>` to gather a username
     and a login button to send the username to the `LoginActivity`
     using intents and extras. No username/password authentication happens yet.
  * `MainActivity` checks to see if it was launched with an Intent, with
    an extra containing the username. If the Activity was launched without
    being supplied with a username then it creates an Intent to send the
    user to the `LoginActivity`.
  * If the `MainActivity` is launched properly with an Intent supplying a
    username, then display the username.
2. Create a new activity to show a list of all conversations.
   * Use a `ListAdapter` and a `ListView` to display the conversations.
   * Create one custom view to define how conversations are display.
   * Use the custom view with a custom `ListAdapter` to display mock
     conversations in the app.
   * Create a file containing mock conversation data
     * Have mock data for when there's zero conversations.
     * Have mock data for when there's one conversation.
     * Have mock data for when there's a few conversations.
     * Have mock data for when there's many conversations.
     * It's ok to duplicate the data.
   * Conversations have the following properties:
     * **title** - the name of the conversation
     * **lastMessage** - a snippet of the last message sent to the thread
     * **lastTimestamp** - the timestamp of the last message sent to the thread.
     * **unreadCount** - the number of currently unread messages.
3. Create a new Activity to show a single conversation
  * Users should be able to click on one conversation in the conversation
    list and be taken to the activity that shows one conversation.
  * Include a back button so uses can navigate back to the list of all
    conversations.
  * Create mock data for a single chat message in a conversation.
  * One chat message has the following properties:
    * Name of the sender
    * Text of what they sent
    * Timestamp of when they sent it
4. Become familiar with Firebase and manually create data modelling chat
   messages and conversations.
   * Install the Firebase tools in Android Studio.
   * Use the Firebase tools to configure your app to use the Firebase 
     Realtime Database.
   * Create a new app that has manual code that creates new data in the
     Realtime Database.
     * Do not hook up the code to anything in the Android view.
     * Simply practice writing code that modifies the database.
     * Attaching the Firebase code to buttons and text inputs will
       happen in a later step.
5. Modify the conversation list activity to build inputs so users can create
   new conversations.
  * Do not attach these inputs to database code yet.
  * Simply create the inputs so they exist.
  * At the most, you should be able to log the value of the inputs to verify
    that you have access to the values programatically.
  * Allow users to name the conversation.
  * Allow users to choose who the conversation is sent to.
  * Allow users to cancel creating a new conversation.
6. Modify the single conversation activity to so users can input text to
   send in messages.
  * Do not attach these inputs to database code yet.
  * Simply create the inputs so they exist.
  * At the most, you should be able to log the value of the inputs to verify
    that you have access to the values programatically.
7. Combine your work from the last three steps so user input actually
   modifies the database.
8. Ship it.
