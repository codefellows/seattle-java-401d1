# ![CF](http://i.imgur.com/7v5ASc8.png) Scrape Site for Album Covers

## Resources
* [jsoup Java HTML Parser](https://jsoup.org/)
* [Deploying Java on Heroku](https://devcenter.heroku.com/articles/deploying-java)

Today we're going to write web scrapers to obtain album art for music. Use the
website discogs.com to search for an artist, album or song. Scrape information
off the page to find an image and display it.

Observe these URLs and the HTML content on the page they return to plan how you
will design a scraper to obtain the album art.

* <https://www.discogs.com/search/?q=thrice+vheissu&type=all>
* <https://www.discogs.com/Sufjan-Stevens-All-Delighted-People-EP/master/291315>

## Feature Tasks
* Build a web page where you can enter an artist, album, or song to search for.
* Create an API endpoint that accepts the search information the user inputs.
* Build a web scraper that returns album art from discogs.com.
* Hook your website up to your API and scraper so searching for music returns
  and displays album art.
  * Configure your API to return a default placeholder album art for whenever
    album art isn't found.
* Deploy your entire site to Heroku.

## Testing
* Write a unit test for your scraper to make sure it returns an image for
  music you know.
* Write a unit test for your scraper to make sure it returns the default
  album art placeholder for music discogs.com can't find.

## Documentation
Use `README.md` to provide a brief description of what your application does
and explain how it behaves when it can't find album art.

## Stretch Goals
* Cache search results in a database so you don't need to fetch and scrape
  the discogs.com website every time someone searches.
* Download the images from discogs.com and save them to your own server so
  you're not hot-linking images.
* Allow users to upload their own album art.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
