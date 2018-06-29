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
