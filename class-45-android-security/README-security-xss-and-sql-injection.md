# ![CF](http://i.imgur.com/7v5ASc8.png) Security: XSS and SQL Injection

## Resources
* [Interactive SQL Injection Tutorial](https://www.codebashing.com/sql_demo)
* [OWASP SQL Injection](https://www.owasp.org/index.php/SQL_Injection)
* [Wikipedia: Samy (computer worm)](https://en.wikipedia.org/wiki/Samy_(computer_worm))
* [Self-XSS](https://en.wikipedia.org/wiki/Self-XSS)

### Long-reads
* [The MySpace Worm that Changed the Internet Forever](https://motherboard.vice.com/en_us/article/wnjwb4/the-myspace-worm-that-changed-the-internet-forever)
* [Dan Kaminsky (Seattleite) Discovers Fundamental Flaw in Internet](https://www.wired.com/2008/07/kaminsky-on-how/)

Never trust user input!

If your applications aren't properly secured it's possible for malicious users
to enter input in your application that could cause it to crash, or perform
unexpected, unwanted actions.

Two popular forms of attacks are SQL Injection, and Cross-Site Scripting (XSS).

* **SQL Injection** - someone enters text that changes the way a SQL query runs.
* **XSS** - someone submits input, like a comment on an HTML Facebook page, that
  ends up being executed as raw HTML, rendering and executing JavaScript on the
  page.
  
Let's observe examples of each.

### Evil User Input Example
Consider SQL designed to look up a specific order in a shopping system based
off someone's username and an order number. Somewhere in the application there
will be code that prepares an SQL statement and renders the user's name and the
order number they gave to complete the SQL.

#### SQL query template
```sql
SELECT * FROM orders
WHERE owner = '{{name}}'
AND ordernumber = '{{ordernumber}}';
```

#### User Input and Rendered SQL Query
```java
String name = "Jeff Bezos";
String orderNumber = "Z111PN4";
```

```sql
SELECT * FROM orders
WHERE owner = 'Jeff Bezos'
AND ordernumber = 'Z111PN4';
```

#### Same Rendered Template with EVIL User Input
```java
String name = "Jeff Bezos";
String orderNumber = "Z111PN4' OR 'a'='a";
```

```sql
SELECT * FROM orders
WHERE owner = 'Jeff Bezos'
AND ordernumber = 'Z111PN4' OR 'a'='a';
```

The clever evil user input an order number, then included a quote, and wrote
some additional SQL logic all AS IF it were their order number. The insecure
SQL template didn't know better and rendered the user input exactly as it
appeared.

The final result is that the `OR 'a'='a` input the user provided short-circuits
the SQL query and returns EVERY order, whether it belongs to the user, or not.
`OR 'a'='a` evaluates to `OR true`, so literally everything in the database is
returned. The SQL query becomes completely unrestricted.

### Sanitizing Input and XSS
In order to prevent users from entering evil input like this it's standard
practice to "sanitize" the user input. Sanitizing user input replaces any
special programming characters with escape sequences. Look at the difference
between raw HTML, and escaped HTML if someone were trying to write JavaScript
as a comment on someone's Facebook page.

HTML replaces the `<` and `>` characters with their escaped `&lt;` and `&gt;`.

```
<script>console.log("hacked");</script>
&lt;script&gt;console.log("sanitized");&lt;/script&gt;
```

If the user input wasn't sanitized and rendered on the page like a real
`<script>` then the user can execute any arbitrary JavaScript on a webpage,
without other users knowing.

There have been a few widespread XSS attacks on popular sites like MySpace and
Facebook.

Read the story of Samy, the computer worm, and how it spread on MySpace more
quickly than any other computer virus in history.

* [Wikipedia: Samy (computer worm)](https://en.wikipedia.org/wiki/Samy_(computer_worm))

### Self-XSS
* [Self-XSS](https://en.wikipedia.org/wiki/Self-XSS)

Some hackers try to take advantage of people by getting them to copy and paste
malicious JavaScript into the browser's console themselves. To this day if you
open the JavaScript console on <http://facebook.com> you'll see a large warning
message explaining to users to not copy and paste anything there anyone tells
them to.

### Best Practice
It's best practice to sanitize ALL user input that comes into an application.
Most modern frameworks have good security practices built-in and will escape
user input as it reaches critical points in a system (like executing a string as
an SQL query, or rendering content to a page). Still, as developers, it's our
job to be aware that these problems exist and we should be able to reason about
how they take advantage of our systems, and how we can defend against these
attacks.
