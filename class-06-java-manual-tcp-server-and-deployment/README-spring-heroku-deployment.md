# ![CF](http://i.imgur.com/7v5ASc8.png) Spring MVC Heroku Deployment

These notes are based off Heroku's own "Deploying Spring Boot Applications"
docs. Their docs run through the steps of initializing a repo, using the
Heroku command line tools to create a new Heroku app, upload the app and
run the app. It automatically detects how to start and run it.

These docs make the assumption users configure their app with Maven, but
the same process applies for us while we're using Gradle. The command line
tool instructions are identical. Heroku does a great job detecting how the app
should run automatically.

[Deploying Spring Boot Applications to Heroku](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku)

Create a Spring MVC app, initialize it as a git repo and make at least one
commit.  Now, deploying and running the app on Heroku is as easy as using the
Heroku command line tools!

```
heroku login
heroku create
git push heroku master
heroku open
```

* `heroku login` authenticates your terminal with your Heroku account.
* `heroku create` creates a new Heroku app for your project and configures
  your repo to be able to push branches up to Heroku.
* `git push heroku master` uses the newly configured branch to upload changes
  to Heroku.
* `heroku open` launches your browser to the website where the just-deployed app
  lives.
