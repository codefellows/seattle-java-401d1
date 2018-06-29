# Uploading Files
Instructions derived from: <https://spring.io/guides/gs/uploading-files/>

The main Spring Boot instructions are missing explanations for several key
components. They define an interface for a StorageService but don't provide
an implementation. The full implementation exists in their own solution
repo.

https://geowarin.github.io/understanding-spring-boot.html

`@EnableConfigurationProperties` automatically maps a POJO to a set of properties
in the Spring Boot configuration file (by default `application.properties`)

# Build and Run

Build the application:

```
gradle
```

See everything you can run by listing tasks:

```
gradle tasks
```

Run the webserver with the `bootRun` tasks:

```
gradle bootRun
```

Access the server at:

* <http://localhost:8080/greeting>
* <http://localhost:8080/greeting?name=Enoch Root>
* <http://localhost:8080/greeting?name=Lidija>

If you try to access the server at the root route,
without `/greeting` it will crash because it's only
configured to response to the `/greeting` route.

This will error: <http://localhost:8080/>
