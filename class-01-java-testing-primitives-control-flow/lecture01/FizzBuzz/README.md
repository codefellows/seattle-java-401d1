# FizzBuzz
Let's convert a FizzBuzz implementation from JavaScript to Java.

* Create a file called **FizzBuzz.java**
* Surround everything in the file with `class FizzBuzz { }`
* Create a main method `public static void main(String[] args) { }`
* Copy the JavaScript Function to below the main method
* Replace `function` with `public static void`
* Replace `let` with Java's `int` datatype
* Replace `===` with `==`
* Replace `console.log` with `System.out.println`
* Replace single-quotes with double-qoutes
* Call `fizzBuzz()` from the main method
* Execute the program!
  * IntelliJ
    * Press Play
  * Command Line
    * `javac FizzBuzz.java`
    * `java FizzBuzz`

**fizz-buzz.js**
```js
function fizzBuzz() {
  for (let i = 1; i <= 100; i++) {
    if (i % 3 === 0 && i % 5 === 0) {
      console.log('fizz buzz');
    } else if (i % 5 === 0) {
      console.log('buzz');
    } else if (i % 3 === 0) {
      console.log('fizz');
    } else {
      console.log(i);
    }
  }
}

fizzBuzz();
```

**FizzBuzz.java**
```java
class FizzBuzz {
  public static void main(String[] args) {
    fizzBuzz();
  }

  public static void fizzBuzz() {
    for (int i = 1; i <= 100; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        System.out.println("fizz buzz");
      } else if (i % 5 == 0) {
        System.out.println("buzz");
      } else if (i % 3 == 0) {
        System.out.println("fizz");
      } else {
        System.out.println(i);
      }
    }
  }
}
```
