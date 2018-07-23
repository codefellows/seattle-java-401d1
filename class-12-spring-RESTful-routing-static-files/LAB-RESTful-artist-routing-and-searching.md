# ![CF](http://i.imgur.com/7v5ASc8.png) Spring RESTful Routing

## Resources
* [Baeldung: Spring Request Mapping](http://www.baeldung.com/spring-requestmapping)

Configure a Spring server to have RESTful routing to map HTTP requests to
classes that interact with and manipulate a Postgres database. Create page
templates that allow users to view Artist and Song information, and include
forms and AJAX-intercepted buttons the create, read, update and delete row
in the database.

Make sure your requests accurately obtain user input via URL parameters, or
by accessing the body of POST requests.

Make sure your server fails gracefully. The server shouldn't crash and the
database shouldn't be corrupted in any way if a user attempts to read or
manipulate information that doesn't exist.

# Stretch Goals
* If your database has lots and lots of entries for artists or songs (even over
  50) build a pagination system so users can view some number (50) of artists
  or songs at a time, and press `< prev` or `next >` buttons to view more
  results.

## Code Samples
#### Annotate a Class with RequestMappings as a Controller
```java
@Controller
public class MyController {
  @RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
  @ResponseBody
  public String getFoosBySimplePath() {
      return "Get some Foos";
  }
}
```

#### Get Information via URL Parameters
```java
@RequestMapping(value = "/params")
@ResponseBody
public String getUrlParams(@RequestParam("id") String name) {
    return "Hello " + name + "!";
}
```

#### Differentiate Requests by HTTP Methods
```java
@RequestMapping(value = "/example", method = RequestMethod.GET)
@ResponseBody
public String getExample() {
    return "GET some foo";
}

@RequestMapping(value = "/example", method = RequestMethod.POST)
@ResponseBody
public String postExample() {
    return "POST some foo";
}
```

#### Access POST Body
```java
@RequestMapping(value = "/postbody", method = RequestMethod.POST)
@ResponseBody
public String saveData(HttpServletRequest request){
   String name = request.getParameter("name");
   return "Hello POST body name: " + name;
}
```

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
