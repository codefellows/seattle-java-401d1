# ![CF](http://i.imgur.com/7v5ASc8.png) Bitmap Transformer

## Resources  
* [Bitmap Specification](https://en.wikipedia.org/wiki/BMP_file_format)
* [Buffer Docs](https://nodejs.org/api/buffer.html)

## Feature Tasks
For this assignment you will be building a bitmap (`.bmp`) transformer CLI. It
will read a bitmap in from disk, run one or more color or raster transforms and
then write it out to a new file. This project will require  manipulating binary
data. Your solution should be composed of small tested methods that solve
specific problems. Your methods should be thoughtfully named and well
documented. The entry point to your CLI should be an `Main.java` file. Your
bitmap transformer modules should not use any third party libraries.

#### Minimum Requirements
* The CLI should be architected using best modularization practices
* The CLI should require at least three arguments `input-file-path output-file-path transfrom-name`
* The CLI should support a minimum of four transforms
* The CLI should log useful Error messages if used incorrectly
* The CLI should log a success message on completion

## Testing
* Use JUnit to define descriptive tests
* Each `@Test` method should aim to test a small well defined feature of a function
* Write tests to ensure each function behaves correctly with valid and invalid inputs

### Tips
You will want to define a strategy for solving the problem before you begin to
code. Once you have a strategy defined, you can break it into steps that can be
split into helper methods. Each helper method should solve a small specific
problem. The main method should utilize the helper modules to execute your
original strategy.

###### Example Strategy
0. Gather user input (infile, outfile, and transform)
0. Read the input bitmap file using the fs module
0. Parse the bitmap's buffer into object representing a bitmap (using a constructor)
0. Using metadata from the parsed bitmap object run a transform on the buffer
   directly (mutate the color or raster data)
0. Write the mutated buffer to the output file path

###### Transform Ideas
* Color Pallet Transforms
  * Invert
  * Randomize
  * Black and White
  * Darken or Lighten
  * Add or Multiply a Hue
  * Add or Subtract Contrast
  
* Raster Data Transforms
  * Pixilate
  * Add a border
  * Add a watermark
  * Vertically or Horizontally Flip
  * Vertically or Horizontally Mirror
  * Vertically or Horizontally Stretch
  
## Documentation
Describe the transforms your program supports in `README.md`.

## Stretch Goals
* Implement more transforms!

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
