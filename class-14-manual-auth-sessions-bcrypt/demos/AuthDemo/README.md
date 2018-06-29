# Manual Authentication

Tutorial with WebConfig, Bcrypt and things.

## References
* [jBCrypt repo](https://github.com/jeremyh/jBCrypt)
* [Postgres Datatypes](https://www.techonthenet.com/postgresql/datatypes.php)
* [HTML Postgres Cheat Sheet](http://www.postgresonline.com/special_feature.php?sf_name=postgresql83_cheatsheet&outputformat=html)
* [Postgres CLI repo](https://github.com/dbcli/pgcli)
* [Spring Docs on Web Security](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-web-security)
* [Bcrypt Tutorial](http://www.baeldung.com/spring-security-registration-password-encoding-bcrypt)
* [Tutorials Point: Bean Definition](https://www.tutorialspoint.com/spring/spring_bean_definition.htm)

What does `@Autowired` do? Bring in a Bean, I assume.

## Configuring Sequelize
The sequelize cli doesn't work well for Java server projects. Although it
provides a nice command line interface for creating databases and quickly
defining models it is too focused on interacting with Node.js servers.

We'll configure out database manually, and create custom scripts to automate
the tedious process in case we want to nuke the databases and start from
scratch in the future (very likely).

Download pgcli for a better Postgres CLI.

```
brew install pgcli
```

## Dealing with Sessions

```java
@PostMapping("/login")
@ResponseBody
public User login(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
    User user = UserDB.getUserByName(username);
    if (user != null && user.checkPassword(password)) {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        return user;
    }

    // incorrect password;
    return null;
}

@GetMapping("/sessiondata")
@ResponseBody
public String getSessionData(HttpServletRequest request) {
    return (String) request.getSession().getAttribute("username");
}

@PostMapping("/logout")
@ResponseBody
public boolean logout(HttpServletRequest request) {
    request.getSession().invalidate();

    // disable and session stuff.
    return true;
}
```
