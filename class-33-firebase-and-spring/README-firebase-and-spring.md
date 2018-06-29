# ![CF](http://i.imgur.com/7v5ASc8.png) Firebase Integration on Spring


## Resources
* [Setup for Firebase REST API](https://firebase.google.com/docs/database/rest/start)
* [Java Firebase Wrapper (alpha!)](https://github.com/bane73/firebase4j)
* [Streaming from the REST API](https://firebase.google.com/docs/database/rest/retrieve-data#section-rest-streaming)

## Learning Objectives
* Students will be able to read, write and manipulate information in a Firebase
  Database from their Spring server.
* Students will be able to query Firebase for information and process it on
  their Spring server.
* Students will be able to make their Spring server act like a middle-man
  between Firebase and another client.
* Students will be able to make their Spring server manipulate data between
  Firebase and another client.

## Lecture Outline
* Firebase is fantastic, but it doesn't allow us to perform queries, or react to
  logic as much as we can with SQL.
* We can set up a Spring server to act as a middle man between Firebase and
  other clients. The Spring server can expose routes clients can query, and
  inside those routes the Spring server can query Firebase and pre-process
  the information before returning it to the client.
* Having a server preprocess information between Firebase and the client
  allows us to perform logic Firebase doesn't support, and possibly saves
  the client from performing expensive operations it doesn't need to do.
  * We generally assume phones have less computing power than our server.
    It's better for the server to crunch data than to offload that work to
    the client.
* Having a server act as a middleman also allows us to add additional logic
  before data is saved to the database, or when data is read.
  * For example, when you write data you can add logic that prevents anyone in a
    chat room from sending a message with the letter `e`
  * Also, when you write data you can detect if the message does something like
    mentioned `@someone` and generate a notification to that user.
  * When you're reading data to send back to the client you can manipulate it
    by doing things like sorting it in a certain order, or otherwise manipulating
    the data to make it easier for the client to read
## Demo
* Create a simple bare-bones chat room with Firebase
* Run chat commands through an endpoint on the server that rejects any message
  with an "e" in it.
  
### Streaming from the REST API
* Configure the Spring server to use the Firebase REST Streaming API
  to retrieve live data-change events in real time.
* Configure a website to communicate with the Spring server with WebSockets
  to preserve the back-and-forth communication Firebase normally provides.
* Configure the Spring server to send changes from the Streaming API to
  the socket it's got open with the web browser.
