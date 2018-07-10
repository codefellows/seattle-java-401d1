// name of the file matters
// main method
// function with a return type
// variables have types
class FizzBuzz {
  public static void main(String[] args) {
    System.out.println("Hello world!!");
    fizzBuzz();
  }

  // print out the numbers from 1 to 100
// anything divisible by 3 should say "fizz"
// anything divisible by 5 should say "buzz"
// anything divisible by 3 and 5 should say "fizz buzz"
// words go in place of the number
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