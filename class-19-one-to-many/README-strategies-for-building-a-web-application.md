# ![CF](http://i.imgur.com/7v5ASc8.png) Strategies for Building a Web Application

Web applications are complex. When you build one where should you begin? The
trick is to start with something tangible that you can observe and manipulate
and constantly improve in small steps from there. Do not become over-zealous
and try to build too many things at once. Like stacking rocks along a river you
should make sure a new rock balances on all others without your hands before
trying to stack the next rock.

When your building a web application start with your server. Configure your
server with a super basic route just to prove that you can communicate with it.
Create a root route that returns text "hello" or returns simple HTML with
a header. Start your server, access the page and verify that it is running.

Commit.

Now that the server is running see if you can receive data from the server.
Configure a route to return simple JSON. Return manually-constructued raw data.
That's to say, don't try to read data from a database. Literally construct
a new object inside the route and see if it gets sent over the wire correctly.

Commit.

Now see if you can send data to the server. Configure a route with URL
parameters. Write code that access the parameters and simply print their values
and look to make sure you can receive them. If you can receive URL parameters
now you have one way to send information to your server. Fantastic!

Commit.

Try rendering the information passed from the client via the URL parameters in
a page template. Render in manual data from a route in a view that requires
a for-each loop.

Commit.

At this point you have a powerful server. It's able to serve pages, render
templates and receive information via URL parameters.

At this point your server has examples for these common operations. You can use
the examples and copy them to build more routes, more templates, more
everything. If you have a problem building something new you can compare it
against old already-established to try to spot the difference to see what's
wrong.

Deploy the server and make sure there's nothing wrong in production.

Commit.

At this point the server isn't hooked up to a database. Before you connect the
server to a database you can create a class that mocks being a database. Decide
how you want to interact with your data and stub out functions modeling those
interactions.

Use a Java interface to capture the operations your database class should
suppose.

```java
public Interface StudentDB {
  public List<Student> getAllStudents();
  public Student getStudentById(long id);
  public void setStudentGrade(double grade);
}
```

Now that you have an interface you can build a class that imitates querying
being a database without actually being connected to one. This allows you to
write your application while someone else is working on setting up the
database. It introduces an excellent seperation of concerns. Your application
no longer depends on an actual database.

Furthermore, you can swap out different implementations of classes that fulfill
the StudentDB interface at will. You can have a mock database implementation,
a Postgres database implementation, a MongoDB database implementation or
anything else. The power of interfaces is in completely seperating what a class
is supposed to do from defining how it actually does that.

```java
public Interface MockStudentDB {
  // static because it exists only once.
  private static List<Student> students;

  // a static code block executes once and fills the list
  static {
    students.add(new Student("Lisa"));
    students.add(new Student("Bart"));
    students.add(new Student("Milhouse"));
  }


  public static List<Student> getAllStudents() {
    return students;
  }

  public static Student getStudentById(long id) {
    for (Student student : students) {
      if (student.id == id) {
        return student;
      }
    }
    return null;
  }

  public static void setStudentGrade(long id, double grade) {
    Student student = getStudentById(id);
    student.grade = grade;
  }
}
```

Commit.

After you've written the mock database now try wiring it up to your server.
Build your RESTful routes and make sure you can receive information from the
client correctly, correctly parse that information and use that information to
manipulate the mock database.

Commit.

At this point you should probably create the actual database. It's possible
that someone else on your team has done this simultaneously as team members
have worked on different parts of the project. It's also possible you started
your project by building the database first and nailing down all your SQL
queries. Whatever the case, make sure your server and database are conjoined
together now.

Commit.

You have a fully fledged server. Continue making constant small improvements.
Always make sure things work along the way! Strive to never let the complexity
of your application get away from you.

## Troubleshooting
When something goes wrong you need to "run the ropes" all follow the path of
execution right from where your problem starts through every place it passes
through your application.

How does someone create a new student?

* There's an HTML form
* Users enter data in inputs
* The form is configured with `method` and `action` to hit a route
* Verify the route is being hit
* Verify information is being passed correctly to the route.
* Does the route call other methods?
* Verify the information is passed exactly correctly everywhere in the code.
* Is it a database problem? How can you prove it is or isn't?
* Did it go through everywhere ok? Follow it back on the page as the response.

Use print statements and the debugger to follow information through your
application. Predict what your program will do before you watch it do it and
compare your prediction to the actual action.

## Farewell
Good luck making your app!

