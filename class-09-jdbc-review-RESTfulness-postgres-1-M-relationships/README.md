# ![CF](http://i.imgur.com/7v5ASc8.png) Java Database Connectivity

## Configuration

Add the Postgres driver to **build.gradle**.

```
dependencies {
    compile group: 'postgresql', name: 'postgresql', version: '9.0-801.jdbc4'
}
```

Create a new class with a `main` method. Add this import statement to the top
to have IntelliJ detect that you want to include the postgres driver. Hover over
the import statement and use the tooltip to have IntelliJ add the driver to
the classpath.

```java
import org.postgresql.Driver;
```

Add some code that looks up the class for the postgres driver to make sure it's
properly configured.

```java
// Investigate whether the postgres driver is properly accessible.
try {
  Class.forName("org.postgresql.Driver");
} catch (ClassNotFoundException e) {
  e.printStackTrace();
  System.out.println("Postgres driver not configured correctly.");
}
```

Add some code to construct a URL to connect to the database through
JDBC. This code snippet assumes there's a database called `music`
and executes a query grabbing all the artist names.

```java
String url = "jdbc:postgresql://localhost:5432/music";
  Properties props = new Properties();
  // use these properties if you need to provide a username or password.
  //props.setProperty("user","fred");
  //props.setProperty("password","secret");
  //props.setProperty("ssl","true");

  try {
    Connection conn = DriverManager.getConnection(url, props);
    ResultSet results = conn.createStatement().executeQuery("SELECT * FROM artists");
    while (results.next()) {
      int id = results.getInt("id");
      String name = results.getString("name");
      Date createdAt = results.getDate("createdAt");
      Date updatedAt = results.getDate("updatedAt");

      System.out.println("id: " + id + " artist: " + name);
    }
  } catch (SQLException e) {
    e.printStackTrace();
    System.out.println("DB error.");
  }
}
```

## Resources
* [JDBC Introduction](https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html)
* [JDBC Basics](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)

The JDBC API is a Java API that can access any kind of tabular data, especially data stored in a Relational Database.

JDBC helps you to write Java applications that manage these three programming activities:

Connect to a data source, like a database
Send queries and update statements to the database
Retrieve and process the results received from the database in answer to your query
The following simple code fragment gives a simple example of these three steps:

```java
public void connectToAndQueryDatabase(String username, String password) {
    Connection con = DriverManager.getConnection(
                         "jdbc:myDriver:myDatabase",
                         username,
                         password);

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");

    while (rs.next()) {
        int x = rs.getInt("a");
        String s = rs.getString("b");
        float f = rs.getFloat("c");
    }
}
```
