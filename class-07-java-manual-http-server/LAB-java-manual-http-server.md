# ![cf](https://i.imgur.com/7v5ASc8.png) Vanilla HTTP Server

## Resources
* [Java Server Socket Tutorial](https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html)
* [Java Networking Tutorial](https://www.tutorialspoint.com/java/java_networking.htm)

## Feature Tasks  
For this assignment you will be building a HTTP server.

#### Server.java
The server class is responsible for implementing an http server.

###### GET /
When a client makes a GET request to the root route `/` the server should send
back HTML with a project description and an anchor to `/cowsay`.

``` html
<!DOCTYPE html>
<html>
  <head>
    <title> cowsay </title>  
  </head>
  <body>
   <header>
     <nav>
       <ul>
         <li><a href="/cowsay">cowsay</a></li>
       </ul>
     </nav>
   <header>
   <main>
     <!-- project description -->
   </main>
  </body>
</html>
```

###### GET /cowsay?text={message}
When a client makes a GET request to `/cowsay?text={message}` the server should
parse the querystring for a text key. It should then send a rendered HTML page
with a cowsay cow speaking the value of the text query. If their is no text
query the cow message should say `'I need something good to say!'`.

``` html
<!DOCTYPE html>
<html>
  <head>
    <title> cowsay </title>  
  </head>
  <body>
    <h1> cowsay </h1>
    <pre>
      <!-- cowsay.say({text: req.query.text}) -->
    </pre>
  </body>
</html>
```

###### GET /api/cowsay?text={message}
When a client makes a POST request to /api/cowsay it should send JSON that
includes `{"text": "<message>"}`. The server should respond with a JSON body
`{"content": "<cowsay cow text>"}`.  

A response for a valid Requests should have a status code of 200 and the JSON body   
``` json
{
  "content": "<cowsay cow text>"
}
```

A response for invalid Requests should have a status code of 400 and the JSON body...
```
{
  "error": "invalid request: text query required"
}
```

###### POST /api/cowsay
When a client makes a POST request to `/api/cowsay` it should send JSON that
includes `{"text": "<message>"}`. The server should respond with a JSON body
`{"content": "<cowsay cow>"}`.

| Request                            | Response Status Code | Response Type | Response Body |
| -- | -- | -- | -- |
| With out a body                    | 400 | JSON | `{"error": "invalid request: body required"}` |
| With out text property on the body | 400 | JSON | `{"error": "invalid request: text query required"}` |
| With text query                    | 200 | JSON | `{"content": "<cowsay cow text>"}` |

## Stretch Goals
* Add the ability to change the cowfile on
  * GET /cowsay
  * GET /api/cowsay
  * POST /api/cowsay
* For example, make it say dragon, sheep or something else.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to your pull request
