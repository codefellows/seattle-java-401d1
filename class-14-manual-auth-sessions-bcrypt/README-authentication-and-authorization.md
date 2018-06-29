# ![CF](http://i.imgur.com/7v5ASc8.png) Authentication, Bcrypt and Sessions

## Resources
* [BCrypt Docs](https://docs.spring.io/autorepo/docs/spring-security/4.1.3.RELEASE/apidocs/org/springframework/security/crypto/bcrypt/BCrypt.html)
* [Session Docs](https://jsoup.org/)
* [The Java Tutorials: Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/)

## Learning Objectives
* Students will be able to create user accounts in a database that stores only
  hashed passwords
* Students will be able to use a cryptographically secure well-known password
  encryption library `BCrypt`
* Students will be able to match password entries to hashed password attempts
* Students will be able to store user password authentication in a server
  session state to authorize users to access material

## Lecture Outline
* Review RESTful routes for a `user` resource
* Build HTML templates for pages where users sign up for accounts and log in
* Create RESTful routes to create a user account
  * Distinguish between `user` creation routes and authorization routes, and the
    act of authorization
    * Users user an HTML page to create an account where they enter an email
      and a password
    * Users use a login page to login in to an account with a user and a password
    * There's a difference between a route that CREATES a user and a route that
      AUTHORIZES a user
      * `POST /users` - supplies information to create a user account
      * `POST /auth/login` - supplies a username and password to authenticate
        an account.
      * `/auth` is not part of the RESTful patten for creating, accessing,
        updating and deleting user accounts. User accounts are a resource
        that exists on their own. The `/auth` routes are routes that interact
        with existing user resources to make sure users are who they say they
        are.
* Create `/auth` routes to handle users logging in and logging out to authenticate
  and de-authenticate a user.
* Store authenticated user information using server sessions
* Add authorization checks in the server on protected routes to confirm that
  authenticated users have authorization to access the material there.
  
## Code Samples
```java
public class SessionServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                  throws ServletException, IOException {
          String attributeName = req.getParameter("attributeName");
          String attributeValue = req.getParameter("attributeValue");
          req.getSession().setAttribute(attributeName, attributeValue);
          resp.sendRedirect(req.getContextPath() + "/");
  }
}
```
```java
@Test
public void testCorectPass() {
    String password = "password";
    String wrongPassword = "nopenope";
    String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

    assertTrue(BCrypt.checkpw(password, hashed));
    assertFalse(BCrypt.checkpw(wrongPassword, hashed));
}
```
