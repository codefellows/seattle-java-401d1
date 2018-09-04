# ![CF](http://i.imgur.com/7v5ASc8.png) Conway's Game of Life

## Resources  
* [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
* [Glider](https://en.wikipedia.org/wiki/Glider_(Conway%27s_Life))
* [Gun](https://en.wikipedia.org/wiki/Gun_(cellular_automaton))

## Feature Tasks
Create an application that simulates Conway's Game of Life. Display the
simulation on a Canvas view and pick some practical assumptions for the size
of the cell (like 50 pixels, or something).

Add `step` and `clear` buttons to allow users to watch the simulation
step-by-step, and easily reset it. Do not configure the app to have the
animation "play." Users must press the `step` button to have the simulation
move forward tick by tick.

## Conway's Game of Life Rules
* Any live cell with fewer than two live neighbors dies, as if by under
  population.
* Any live cell with two or three live neighbors lives on to the next generation.
* Any live cell with more than three live neighbors dies, as if by
  overpopulation.
* Any dead cell with exactly three live neighbors becomes a live cell, as if by
  reproduction.

## Testing  
* Write JUnit tests for small boards that verify cells are born, live and die
  correctly.

## Documentation
Find a tool to make an animated GIF of your app in action and add it to your
`README.md`. You can screen yourself using the app in the emulator and then
convert short clips of that movie into a GIF, or try displaying the movie
itself on the GitHub README.

## Stretch Goals
* Add several tools that allow users to populate the board with different
  initial configurations like:
  * randomly populating the entire board with an adjustable `NN%` percent
    probability
  * Allowing users to tap, or press and drag around to draw live cells on to
    the board.
  * Allow users to play/pause the simulation and adjust it's playback speed
* Include notable initial setups for users to see like:
  * Stable set ups
  * Gliders
  * Guns

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
