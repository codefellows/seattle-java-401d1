# ![CF](http://i.imgur.com/7v5ASc8.png) Chat Notifications and Image Uploads

## Resources
* [How to Configure Firebase Messaging](https://firebase.google.com/docs/cloud-messaging/android/client)
* [Ion: Asynchronous Image Loading](https://github.com/koush/ion)

## Feature Tasks
#### Add Notifications
Continue building the chat app. Add a new feature that will notify users
whenever they receive a chat notification if the app isn't in the foreground.

Clip the message so the user can read the beginning of the chat message when
they see it in the notification bar. Attach an intent to the message that will
take the user to the chatroom when they click on the notification.

#### Add In-chat Image Uploads
Add buttons near the "send" button to allow users to select an image, or take
a picture and upload it straight into the chat.

Configure the ListView that displays the chat messages to detect when a chat
message contains an image and renders the image in the chatroom. A good way to
identify chat messages that should be rendered with an image is to add a
`type` or `mediatype` property to all chat messages. Most messages will have a
type of `text` whereas messages with an images will display as `image` and
can be programmatically handled different.

Use the Ion library to load the images!

## Testing
* Add a unit test to make sure the text-clipping utility for displaying
  messages in a notification clips long strings properly.
* Add unit tests to make sure messages have the proper `type` or `mediatype`
  attribute attached to them so you can differentiate between regular messages
  and image messages.

## Documentation
* In your `README.md` include screenshots of your app.
* Include a sample of how information is structured and stored in your Firebase
  database.

## Stretch Goals
* Add buttons to send specific images like a "thumbs up"
* Add support for Slack-like `:emoji:` colon-surrounded text emojis. If a user
  types a supported emoji like `:happyface:` replace it with an image of your
  choosing.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
