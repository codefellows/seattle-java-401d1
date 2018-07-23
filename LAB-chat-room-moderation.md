# ![CF](http://i.imgur.com/7v5ASc8.png) Chat Room Moderation

## Resources
* [Popup Menus](https://developer.android.com/guide/topics/ui/menus.html)
* [Android Toasts](https://developer.android.com/guide/topics/ui/notifiers/toasts.html)

Add a new feature to the chat room that allows users to delete their own
messages.

Add user roles where some users can be moderators. Moderators are allowed to
delete anyone's messages, and they're allowed to kick users out of the chatroom
and ban user's permanently.

Configure your custom ListView to add these actions for rendered chat messages.
Users should be able to long-press on a chat message to bring up a menu with
options to delete / kick / ban (if they're a moderator).

Users should see a message appear in their app if they've been kicked out of the
chatroom or banned. Display a toast message.

Add logic that prevents users from joining the chatroom for five minutes if
they've been kicked, or prevent them from joining the chatroom forever if
they've been banned.

Most importantly: add a new `ModeratorActivity` accessible only by moderators.
This view should show a list of users that have been kicked or banned and allow
the moderator to reverse the restrictions so someone can join the chatroom
again.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
