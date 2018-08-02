# ![CF](http://i.imgur.com/7v5ASc8.png) Web Scraping

## Resources
* [JSoup Homepage](https://jsoup.org/)

The homepage includes this example code showing off how to download a webpage
and interact with elements on the page.

```java
Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
log(doc.title());
Elements newsHeadlines = doc.select("#mp-itn b a");
for (Element headline : newsHeadlines) {
  log("%s\n\t%s",
    headline.attr("title"), headline.absUrl("href"));
}
```
  
### Configuration
Add JSoup as a dependency in your `build.gradle` file.

```
dependencies {
  compile 'org.jsoup:jsoup:1.11.1'
}
```

## Feature Tasks  
#### Exercise
Use JSoup to navigate to the wikipedia page containing a list of states in
the United States. Find out which table contains links to individual pages
for each state. Download the wikipedia article for each state, scrape the
population data off that page and sum all the state populations to determine
the population of all the states.

Use this page to obtain the links for every other state:
[List of states and territories of the United States](https://en.wikipedia.org/wiki/List_of_states_and_territories_of_the_United_States)

Use your knowledge of HTML to find ways to extract the data. For instance, one
strategy to get the links to each state page is to find the table with all the
links, then grab links that appear in the first column on the table. You may
need to write some code to have your program ignore other links, like "postal
abbreviation" and "Capital" because these few links also happen to match the
pattern.

Access the population on a state's page by finding an element that has the
text "Population" and moving to it's sibling elements. JSoup's method
`element.nextElementSibling()` is useful for locating one element, then stepping
to the element next to it.

### Mungy Data
Data on webpages is inherently messy. Not all wikipedia pages follow one strict
format. They're very similar, but there's bound to be something different
between some pages.

One state (at the time of writing this) has it's population formatted slightly
different than the rest of the states. Find out which state(s) has a different
format and write special code to detect and deal with the different format.

## Testing  
Use JUnit to write tests to make sure your results are sensible.

* Write a test to verify the number of state links you get from the first
  page is exactly 50.
* Choose one state, manually look at it's population and write a test to make
  sure you're program scraping the population from the page correctly.
* Write one test that verifies the total counted population is over 300 million.

## Stretch Goals
* Crawl each state to find the Governor.
* Crawl the wikipedia page for all the Governors.
* Print out the state, name and birthday for each Governor.
* Print out the youngest and oldest governors.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
