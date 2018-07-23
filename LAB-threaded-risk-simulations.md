# ![CF](http://i.imgur.com/7v5ASc8.png) Simulating Risk Battles (the Board Game)

## Feature Tasks
* Write a method called `rollD6` that returns a number 1-6, like you're
  rolling a six sided die.
* Write a method called `battle` that takes two ints, `numAttackers` and
  `numDefenders`. The method should simulate rolling dice in a risk battle.
* Generate a 20x20 table that simulates battles and shows win/loss ratios
  when a number of attackers attacks a number of defenders in risk.
* The cells in the table should be computed by running `N` simulations
  for each set up.
* Start `N` at 10 simulations per cell.
* Turn `N` up to 100 simulations per cell.
* Turn `N` up to 10,000 simulations per cell.

Once you get the table running, now make it concurrent so each cell is
simulated on it's own Thread, all concurrently.

## Testing  
* Use JUnit to write a test for each of the Feature Tasks.
* Change your `battle` method to accept a `Random` object as a parameter instead
  of creating itself inside the method.
* Create a class `FakeRandom` that extends `Random`
* Override methods so your `FakeRandom` class returns numbers in a sequence that
  you'll know.
* Create tests passing your `FakeRandom` class to the `battle` method using dice
  sequences so you know how the battles will end up.

## Documentation
In your `README.md`

## Stretch Goals
* Measure how long your program takes to generate the 20x20 table
* Write a paragraph describing the speed gains you see for different values
  of `N`.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request

