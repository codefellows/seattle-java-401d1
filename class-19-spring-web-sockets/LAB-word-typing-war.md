# ![CF](http://i.imgur.com/7v5ASc8.png) Word Typing War

## Resources  
* [Spring WebSockets](https://spring.io/guides/gs/messaging-stomp-websocket/)
  
Create a game where users compete against each other type unique words.
If a user types a unique word it appears on the users screen stacked up
like blocks. Each user has to type the words in their block to erase the word.
One user wins when they've sent over enough unique words to send their opponent's
word stack "breaking through" the top of their screen.

Create a webpage where each user sees a split-screen of their stack of blocks
and their opponents stack of blocks.

The whole thing looks something like this:

```
                         |                       
  zoo                    |                       
  elephant               |       laptop          
  rope                   |       sled            
==============================================
Input: [firewood    ]    |     Input: [log      ]
```

If the user starts typing letters that start a word on their block then
highlight that block and highlight the letters as they type. Erase the
block from their stack once they complete the word, or backspace back to
type their own word or the start of another word.

Include a simple dictionary that checks words users type so they can only
press enter and sent a word once a word is legitimate.

## Configuration
config

## Feature Tasks  
#### Exercise
Exercise description

* Requirement / clarification N

## Testing  
* Use JUnit to write a test for each of the Feature Tasks.

## Documentation
In your `README.md`

## Stretch Goals
Bonus bonus bonus

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
