# ![CF](http://i.imgur.com/7v5ASc8.png) Java Primitives and Control Flow

## Resources
* [Random Docs](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
* [LocalDateTime Docs](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html)

This lab is dedicated to practicing Java fundamentals. These problems will
challenge your understanding of Java's built-in primitive values (ints, floats,
doubles, Strings, booleans), for loops, while loops, if statements, functions,
parameters and return statements.

Create a file for each challenge. Each file should have a main method. Our
solution has these four files:

* Pluralize.java
* FlipNCoins.java
* CommandLineClock.java
* SpeedCheck.java

## Java Syntax Example
Here's an example Java program with examples of Java syntax.

```java
public class Main {
  public static void main(String[] args) {
    String greeting = "Welcome to my Java program.";
    System.out.println(greeting);
    
    int x = 7;
    float f = 42.3;
    double d = 42.3;
    
    // execute the function called "loopTo" and pass 10 as a parameter
    loopTo(10);
    
    int four = 4;
    int result = double(four);
    System.out.println(four + " doubled is " + result);
  }
  
  // Functions that return nothing have a return type of "void"
  public void loopTo(int max) {
    for (int i = 0; i < max; i++) {
      System.out.println("Loop #" + i);
    }
  }
  
  // This function has a return type of "int"
  public int double(int n) {
    return n * 2;
  }
}
```

## Feature Tasks
#### Pluralize
Write a function called `pluralize` that accepts a word and a number and returns
a string with the word pluralized with an "s" if the number is zero, or greater
than one.

```java
int dogCount = 1;
System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

int catCount = 2;
System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

int turtleCount = 0;
System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");
```

```
I own 1 dog.
I own 2 cats.
I own 0 turtles.
```

#### Flipping Coins
Write a function called `flipNHeads` that accepts an integer `n` and flips
coins until `n` heads are flipped in a row. Simulate coin flipping by choosing
a random number between `0` and `1`. Numbers below `.5` are considered tails.
Numbers equal and above `.5` are considered heads. Print out `heads` or `tails`
on one line for each flip. Print `It took FLIPS flips to flip N heads in a row.`
once `n` heads have been in a row.

```java
flipNHeads(1)
```

Example output:

```
tails
tails
tails
heads
It took 4 flips to flip 1 head in a row.
```

```
heads
It took 1 flip to flip 1 head in a row.
```

```
tails
heads
tails
tails
heads
heads
It took 6 flips to flip 2 heads in a row.
```

#### Command Line Clock
Write a program that uses Java's built-in `LocalDateTime` object to constantly
print out the current time to the console, second by second. The program should
run until someone manually kills it with `CTRL-C` or presses the "stop" button
in their IDE. Each time should only be printed once. Your program should detect
when the seconds increase and only print something out when the timestamp
changes.

Zero-pad single digit numbers as strings so `9` shows up as `09` so the
timestamp is always the same number of characters.

```
12:10:58
12:10:59
12:11:00
12:11:01
12:11:02
12:11:03
```

You can create a `LocalDateTime` object and get the hours, minutes and seconds
off it like this:

```
LocalDateTime now = new LocalDateTime.now();
int hour = now.getHour();
int minute = now.getMinute();
int second = now.getSecond();
```

## Documentation
Write comments

## Stretch Goals
Upgrade the command line clock to show how fast the program is processing
itself between time updates. Display the speed in hertz, kilohertz, megahertz,
or gigahertz (`Hz`, `kHz`, `MHz`, `GHz`). A hertz is defined as "one cycle per
second." A computer that executes one operation per second is a `1 Hz` computer.

* Hz - 1 cycle per second
* kHz - 1,000 cycles per second
* MHz - 1,000,000 cycles per second
* GHz - 1,000,000,000 cycles per second

**Note:** Java won't allow you to write commas in large numbers. Use underscores
instead.

```java
// commas won't compile
// int million = 1,000,000;
// underscores compile
int million = 1_000_000;
```

Count how many times the while loop executes between displaying each second and
show how many Hertz your program is operating at.

```
11:43:57 4.774371 MHz
11:43:58 4.747498 MHz
11:43:59 4.796893 MHz
11:44:00 3.900095 MHz
11:44:01 4.513468 MHz
11:44:02 4.462237 MHz
11:44:03 4.536814 MHz
11:44:04 4.791471 MHz
```

The speed you're seeing in the program shouldn't necessary be the speed you
see printed on your computer. The program isn't running raw on your CPU.
It also takes time to read the system time, peel off the second value, and
compare it to the previous value so there's really more than just "one"
operation happening here.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
