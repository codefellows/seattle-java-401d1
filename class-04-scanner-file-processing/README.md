# ![CF](http://i.imgur.com/7v5ASc8.png) Scanner! User Input and File Processing

Java uses an object called a `Scanner` to process program input. Program input
can be things users type or data read in from a file. `Scanner` objects start
at the beginning of input and move forward, reading input line by line, or word
by word. Scanners don't move backward.

Consider this file:

```
token token token token
this is a new line with words
not everything in the file is a word
sometimes you can have as many as 99 numbers
or even more, like 400!

but when do you really know when a file is done?
```

Scanners process files as "tokenized" input. The Scanner reads the file a
small amount at a time. It doesn't just read the entire file all at once.
This is good! Files might be incredibly large. It can be more efficient to
read it a small amount at a time.

Scanners read file input line by line, and word by word. Words are almost
synonymous with "tokens." A token is any group of characters all seperated by
whitespace. In the file example above the first line has four words, or four
tokens.

Scanner uses the terminology "token" to disambiguate between a group of
characters that's en English word, or something else like numbers or other
information. A **token** is any group of characters seperated by whitespace.

#### Check for understanding:
* How many tokens are on the first line?
* How many tokens are on the last line?
* How many tokens are on line 4?
* Give an example of a token that's not an English word.

# Scanner Methods
The scanner has methods that return input to our program in a variety of ways.

* `scanner.nextLine()` - returns the entire next line of input
* `scanner.next()` - returns one word as a String
* `scanner.nextInt()` - returns one word as an integer
* `scanner.nextDouble()` - returns one word as an integer
* `scanner.nextFloat()` - returns one word as an integer
* `scanner.nextBoolean()` - returns one word as an integer

The Scanner also has "peek ahead" methods that give us information about what's
coming next in the input.

* `scanner.hasNextLine()` - returns one word as a String
* `scanner.hasNext()` - returns one word as a String
* `scanner.hasNextInt()` - returns one word as an integer
* `scanner.hasnextDouble()` - returns one word as an integer
* `scanner.hasnextFloat()` - returns one word as an integer
* `scanner.hasnextBoolean()` - returns one word as an integer

Here's how to create a Scanner that reads input from a file.

```java
try {
  String filename = "file.txt";
  File file = new File(filename);
  Scanner scanner = new Scanner(file);
} catch (IOException e) {
  e.printStackTrace();
  System.out.println("Problem opening file.");
}
```



# Reading Tokens like Pac Man
The Scanner reads a file like Pac Man only moving forward. It eats tokens
in the file token by token, or line by line. Our program controls the Scanner
and tells it when to take it's next bite.

Let's use the `.next()` method on the Scanner to process the file. We can
put it inside a for loop so the Scanner eats through the whole file token by
token.

```java
while (true) {
  String token = scanner.next();
  System.out.println(token);
}
```

This program will crash with a `NoSuchElementException`. The Scanner crashes
when we call `.next()` and it has nothing left in the file to read.

Use the `.hasNext()` method to look one step ahead before telling the Scanner
to try to consume the next token.

```java
while (scanner.hasNext()) {
  String token = scanner.next();
  System.out.println(token);
}
```

`.hasNext()` will return true if that's anything left in the file. Using it
as the condition for the while loop prevents the Scanner from running off the
end of the file and stops the program from crashing.

# Detecting Integers

Use the `.hasNextInt()` method to detect if the next token the Scanner will
consume can be interpreted as an integer. If it can then you can call the
`.nextInt()` method and have the Scanner interpret the token as an int and
save it as a int variable in your program.

Similar methods exist for other primitive data types (`.hasNextBoolean()`,
`.hasNextFloat()`, `.hasNextDouble`).

Here's a simple program that iterates through a scanner, only looks for ints,
and adds them all together.

```
int total = 0;
while (scanner.hasNext()) {
  if (scanner.hasNextInt()) {
    int n = scanner.nextInt();
    total += n;
  } else {
    // move the scanner forward past anything that's not an integer.
    // don't bother saving any of these tokens to a variable because
    // they're not being used.
    scanner.next();
  }
}
```
