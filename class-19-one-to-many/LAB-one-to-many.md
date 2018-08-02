# ![CF](http://i.imgur.com/7v5ASc8.png) One-to-many Relationships 

## Resources
* [iRESTful Spring Repositories](https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/)

You're provided with a server that models movie theater companies and theater
locations. There is a one-to-many relationship between a movie theater company
and the locations they operate. The `Regal` and `AMC` companies have locations
in many different cities (even multiple locations in the same city).

The server has the `MovieCompany` and `TheaterLocation` classes modeled and
annotated to integrate with the Java Persistence API (JPA). Your job is to
write code inside a `POST` route controller that creates a new
`TheaterLocation` and associates it with an existing `MovieCompany` using
a one-to-many relationship.

## Feature Tasks
* Set up a project with the provided starter code.
* Use Postico, another Postgres admin tool, or craft manual SQL to set up
  a database with the required properties.
* Verify that you can use the provided `Create Movie Company` HTML form,
  server, and route to create new `MovieCompany` instances in your database.
* Verify that you can use the provided `Add Theater Location` to hit the
  controller route configured to receive information for a new theater
  location.
* Vertify that you can send and access all the relevant information you'll need
  to use in this route (`company_id`, `theater name`, `theater address`).
* Use the `MovieCompany` and `TheaterLocation` repository interfaces to create
  new `TheaterLocations`, associate them with the proper `MovieCompany` and
  save them.
* Use Heroku command line tools to create a heroku app, deploy your solution
  and push up a database with pre-existing data in it. (remember that you have
  to go to heroku's website and specifically add the `Heroku Postgres` add-on).
  
```
 heroku create restful-theaters-<your_unique_name>
 git push heroku master

 DATABASE_URL=postgresql://localhost:5432
 heroku pg:push CRUDTrek DATABASE_URL
 heroku pg:pull DATABASE_URL CRUDTrek
```

## Tests
No tests.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
