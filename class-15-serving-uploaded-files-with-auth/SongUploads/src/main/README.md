# ![CF](http://i.imgur.com/7v5ASc8.png) Uploading Text to Calculate Readability Score

## Resources  
* [Flesch-Kincaid Readability Tests](https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests)
* [Download public domain texts from Project Gutenberg](https://www.gutenberg.org/)
  
## Feature Tasks  
#### Exercise
Create a web server where users can upload `.txt` files. Process the texts
and show the user the text's readability score. Use the Flesch-Kincaid metric
to calculate the score.

You may assume the end of sentence is denoted by any token whose last character
is not a letter.

Approximate syllable counting by following the following rules:
* any word five characters or less counts as one syllable
* all other words divide their length by 2 and round down.

![Flesch-Kincaid formula](./grade-level.svg)

## Testing  
* Write small unit tests against known scored small lengths of text.
* Write unit tests that make sure your program parses sentences in text
  correctly when there are exclamation marks and question marks present.
* Download large texts from Project Gutenberg and write a test that
  processes a large text.
* Choose several texts and write tests to prove your program can score
  texts with low readability, average readability and high scores.

## Documentation
Use `README.md` to provide a brief description of the app. Give sample
texts that have low-scoring and high-scoring readability scores.

## Stretch Goals
Rewrite your program to calculate how many syllables each word has.

Use a popular Java NLP (Natural Langauge Processing) library to help you
determine the number of syllables.

Try these:

* https://nlp.stanford.edu/
* http://opennlp.apache.org/

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
