# ![CF](http://i.imgur.com/7v5ASc8.png) Web Scraping, Threads and Concurrency

## Resources
* [JSoup Homepage](https://jsoup.org/)
* [The Java Tutorials: Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/)

## Learning Objectives
* Students will be able to inspect a webpage to choose CSS selectors as
  targets to extract information from a webpage.
* Students will be able to create threads that execute in parallel.
* Students will be able to write programs that wait for all threads to finish
  their execution and combine all their results into one summary result.
* Students will be able to create:
  * Worst case scenario programs emphasizing potential problems with concurrency.
  * Best practices (localized variables, using atomic actions) to mitigate
    problems caused by race-conditions with concurrency.

## Lecture Outline
* Introduce JSoup web scraper
  * Configure `build.gradle` to have JSoup as a dependency
  * Use JSoup to download a webpage and print HTML
  * Use Chrome to right click and `Inspect` and element with target data.
  * Reason about the structure of the HTML and CSS we can use to identify the
    target element, and elements like it
    * Navigate to <https://www.codefellows.org/courses/code-400/>
    * Right click on "Code 401: Advanced Software Development in Full-Stack JavaScript"
    * Choose `Inspect`
    * Notice it is wrapped in an `<h3>` tag
    * Use jQuery or `document.querySelectorAll` to see what other `<h3>`
      elements exist on the page.
    * Notice all other `<h3>` elements happen to also be course titles.
    * Notice *most* of them have a convenient `.class-title` CSS rule
    * Mention it would be nice if all of the course titles had the CSS class
    * Point out data is messy. We must use what we've got.
    * Conclude targeting `<h3>` elements will be sufficient
  * Use JSoup to select the `<h3>` elements
  * Iterate through the elements and print out the text inside the elements to
    print all the course titles.
* Use JSoup to scrape information off multiple web pages
  * Get the data from one page
    * Navigate to [US 1824 election](https://en.wikipedia.org/wiki/United_States_presidential_election,_1824)
    * Look in the info box in the top right for Popular vote totals
    * Right click and `Inspect` to find if there's an easy HTML/CSS selector to
      obtain the element containing these totals.
    * Notice there's no easy selector.
    * Show students how to target elements at higher scope, then drill down.
    * Target the entire `table.infobox` table itself.
    * Select **ALL** `<tr>` elements inside the `table.infobox`
    * Iterate through the rows and read their text content looking for one with
      `"Popular vote"`
    * Target `<td>` elements inside the one matching `<tr>`
    * Access the text content with `.text()`
    * Sum the two numbers to get the total number of votes cast.
    * Print the total.
  * Get the data from multiple pages
    * Write a for loop that iterates through elections from 1824 to present.
    * Print out the total votes cast in each election.
    * Write `try/catch` statements to deal with any page that might not
      be formatted exactly as the first one.
    * Time the program to see how long it takes to run.
* Introduce Threads and Concurrency
  * Posit the program spends lots of time waiting for the page to download.
  * Posit JSoup is fast at parsing the page and actually extracting the
    information.
  * What if we could fetch multiple pages at once so we wait for multiple
    pages at once?
  * Create a class that can be run by a `Thread` that will download the page
    asynchronously, all in parallel, concurrently.
  * Show that the results come back non-ordered.
  * Use a Thread Pool to wait until all the threads are complete before
    printing any results.
* Talk about problems with concurrency.
  * Build a "slow bank" simulation
  * Withdraw money asynchronously twice before the bank properly updates the
    reduced value of the account.
  
### Code Samples

```
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
