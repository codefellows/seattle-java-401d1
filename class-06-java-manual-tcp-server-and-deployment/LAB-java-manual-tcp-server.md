# ![cf](https://i.imgur.com/7v5ASc8.png) TCP Chat Server

## Resources
* [Example Java TCP Server & Client](https://systembash.com/a-simple-java-tcp-server-and-tcp-client/)

## Feature Tasks  
For this assignment you will be building a TCP chatroom. Clients should be able
to connect using a telnet client nickname them selfs and talk to each other.
Clients should also be able to run special commands to quit, list users, reset
their nickname, and send direct messages. You may add as many features to the
chat as you would like. Do not use any third party libraries in your chatroom
modules.

#### Minimum Requirements
* Create a TCP Server importing the same classes as the example in Resources
* Create a Client constructor that models an individual connection.
  * Each client instance should contain at least an `id`, `nickname`, and `socket`.
* Clients should be able to send messages to all other clients by sending it to the server
* Clients should be able to run special commands by sending messages that start with a command name
  * The client should send `@quit` to disconnect
  * The client should send `@list` to list all connected users
  * The client should send `@nickname <new-name>` to change their nickname
  * The client should send `@dm <to-username> <message>` to  send a message directly to another user by nickname
* Connected clients should be maintained in an in memory collection called the `clientPool`
  * When a socket emits the `close` event, the socket should be removed from the client pool
  * When a socket emits the `error` event, the error should be logged on the server
  * When a socket emits the `data` event, the data should be logged on the server and the commands below should be implemented

## Testing  
No testing required for this lab. Yay!

## Documentation  
* Write documentation for starting your server and connection using telnet.
* Write documentation for the chat room usage.

## Stretch Goals
Use net.Socket to test your server. Your tests should include the ability to
connect, send and receive messages, and run special commands.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to your pull request
