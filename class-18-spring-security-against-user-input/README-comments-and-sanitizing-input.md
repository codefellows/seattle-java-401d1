# ![CF](http://i.imgur.com/7v5ASc8.png) Leaving Comments and Sanitizing User Input

## Learning Objectives
* Students will be able to create social apps where users can comment on
  other users's activity.
* Students will be able to identify security concerns dealing with unsanitized
  user input
* Students will be able to protect their application against malicious user
  input by sanitizing all user input, and escaping user input displayed in
  the app.

## Postgres on Heroku
* [Heroku Postgres Docs](https://devcenter.heroku.com/articles/heroku-postgresql)

Create a heroku app and push your code up there:

```
heroku create
git push heroku master
```

You must create an environment variable called `DATABASE_URL` in bash. Set it
equal to the URL for your local database. Use the `heroku pg:push` command to
upload your database.

```
DATABASE_URL=postgresql://localhost:5432/jpa_products
heroku pg:push jpa_products DATABASE_URL
```

Download the remote database and bring it back to your machine with the
`hg:pull` command. Use the same `DATABASE_URL` variable from before, but you
must provide the name of a new table that doens't exist to prevent overwriting
data.`

```
heroku pg:pull DATABASE_URL jpa_products_prod
```
