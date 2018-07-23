# ![CF](http://i.imgur.com/7v5ASc8.png) File Processing

## Resources  
* [Scanner Docs](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)
  
## Feature Tasks  
#### JavaScript Linter
Let's write a program that reads a JavaScript file and prints an error whenever
it finds a line that doesn't end in a semi-colon.

Use a Scanner to read through the file line by line. Print an error message
`"Line 3: Missing semicolon."` if a line is missing a semicolon.

* Don't show an error if the line is empty.
* Don't show an error if the line ends with an opening curly brace `{`
* Don't show an error if the line ends with an closing curly brace `}`
* Don't show an error if the line contains `if` or `else`

Use the file `gates.js`.

## Testing  
* Use JUnit to write a test for each of the Feature Tasks.
* Test the linter on a file that contains no errors.
* Test the linter on a file that contains one error.
* Test the linter on a file that contains few errors.
* Test the linter on a file that contains many errors.
* Test the linter on an empty file.

## Documentation
In your `README.md` describe the behavior of the linter and explain what
users should expect to see when it runs.

## Stretch Goals
* Implement another simple lint rule to the linter.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
