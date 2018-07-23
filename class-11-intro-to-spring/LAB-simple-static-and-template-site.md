# ![CF](http://i.imgur.com/7v5ASc8.png) Spring Boot Album Search

## Resources  
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)

## Feature Tasks
* Convert your discogs album art website to use Spring.
* Add CSS to the website to make it look like something more than standard
  bare-bones raw HTML.
* Deploy your site on heroku
* Your site should have one homepage that's totally static
* Your page should have one results page that renders the image result
* Choose a placeholder image for when there's no results and serve that from
  your static resource directory.

Use Spring's `@Controller("/path-to-my-route")` annotations to mark the methods
that control each route. Use Spring's `@RequestParam` annotation to annotate
the parameters for the controller method.

```java
public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {

}
```

## Documentation
Include a link to your live published/deployed site in the `README.md` file.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
