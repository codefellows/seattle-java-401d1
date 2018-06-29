# ![CF](http://i.imgur.com/7v5ASc8.png) Arrays

## Resources  
* [Java Arrays Tutorial](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)
  
## Feature Tasks
This lab is dedicated to creating, interacting with and manipulating arrays
in Java. Arrays in Java have a fixed size. Arrays are created with a certain
size and they never shrink or grow. Java arrays are typed. You can have an
array of integers, or an array of strings, but not an array mixed with
integers and strings.

Here's an example of how to create and interact with an array in Java.

```java
// a new array of integers starts with a value of zero for every index.
int[] temperatures = new int[7];
for (int i = 0; i < temperatures.length; i++) {
  System.out.println(temperatures[i]);
}

// a new array of strings starts with a value of null for every index.
String[] dayNames = new String[7];
for (int i = 0; i < dayNames.length; i++) {
  System.out.println(dayNames[i]);
}

// an array can be hard-coded with values initially using curly braces.
int[] daysInMonth = {31, 28, 31, 30, 31, 30,
                     31, 31, 30, 31, 30, 31};
String[] months = {"January", "February", "March", "April", "May", "June",
                   "July", "August", "September", "October", "November", "December"};

for (int i = 0; i < months.length; i++) {
  String message = "There are " + daysInMonth[i] + " days in " + months[i];
  System.out.println(message);
}
```


## Feature Tasks
#### Rolling Dice
Write a function called `roll` that accepts an integer `n` and rolls a six-sided
dice `n` times. The function should return an array containing the values of the
rolls.

```java
roll(4)
```

Should return something like:

```java
[3, 2, 1, 5]
```

#### Contains Duplicates
Write a function called `containsDuplicates` that returns `true` or `false`
depending on whether the array contains duplicate values.

#### Calculating Averages
Write a function that accepts an array of integers and calculates and returns
the average of all the values in the array.

#### Arrays of Arrays
Given an array of arrays calculate the average value for each array and return
the array with the lowest average.

```java
// Daily average temperatures for Seattle, October 1-28 2017
int[][] weeklyMonthTemperatures = {
  {66, 64, 58, 65, 71, 57, 60}
  {57, 65, 65, 70, 72, 65, 51}
  {55, 54, 60, 53, 59, 57, 61}
  {65, 56, 55, 52, 55, 62, 57}
};
```
#### Analyzing Weather Data
Use the October Seattle weather data from the previous problem. Iterate through
all of the data to find the min and max values. Use a `HashSet` of type
`Integer` to keep track of all the unique temperatures seen. Finally, iterate from
the min temp to the max temp and print out any temperature not seen during the
month.

Expected output:

```java
High: 72
 Low: 51
Never saw temperature: 63
Never saw temperature: 67
Never saw temperature: 68
Never saw temperature: 69
```

#### Tallying Election
Write a function called `tally` that accepts a List of Strings representing
votes and returns one string to show what got the most votes.

```java
List<String> votes = new ArrayList<>();
votes.add("Bush");
votes.add("Bush");
votes.add("Bush");
votes.add("Shrub");
votes.add("Hedge");
votes.add("Shrub");
votes.add("Bush");
votes.add("Hedge");
votes.add("Bush");

String winner = tally(votes);
System.out.println(winner + " received the most votes!");
```

## Testing  
* Use JUnit to write a test for each of the Feature Tasks.

## Stretch Goals
#### Toy CPU
Write a programing that accepts an array of Strings and executes a program.
Each string contains a short programming instruction.

* `MOV XY val` - moves a value into either X or Y
* `ADD XY val` - adds a value to either X or Y
* `JUMP val`   - jump directly to the instructions on line `val`
* `JEQ XY XY val` - jump to the instruction on line `val` if X and Y are equal.
* `JLT X Y val` - jump to the instruction on line `val` if X < Y are equal.

Here's an example program that counts to 10.

```
String[] program = {
  "MOV X 0",  // set X to zero
  "JUMP 3",   // jump straight to the instructions at index 3
  "MOV Y 20", // this line should be avoided by the jump.
  "MOV Y 10", // set Y to ten
  "ADD X 1",  // add one to X
  "JLT X Y 10 1", // JLT (Jump if Less Than) go to index 2 if X is less than Y
};
```

Your program should have a variable `i` that keeps track of what line you're
reading and executing. Use two local method variables `x` and `y` to keep track
of the values of x and y.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
