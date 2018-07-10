// print out the numbers from 1 to 100
// anything divisible by 3 should say "fizz"
// anything divisible by 5 should say "buzz"
// anything divisible by 3 and 5 should say "fizz buzz"
// words go in place of the number
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