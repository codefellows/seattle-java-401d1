# Recursive isPalindrome
Write a Recursive method that accepts a String and returns true or false
depending on if the String is an exact palindrome.

A palindrome is any word that's spelled the same backward and forwad.

isPalindrome("racecar") // returns true
isPalindrome("Racecar") // returns false because of capitalization
isPalindrome("elephant") // returns false because it's not spelled the same in reverse

## Stretch Goals
* Modify the isPalindrome function so it ignores:
  * Whitespace
  * Capitalization
  * Punctuation
* It should only care about the letters A-Z and digits 0-9

With this modification your program should recognize these lines as a palindromes:

```
UFO tofu?
A man, a plan, a canal, Panama!
Was it a car or a cat I saw?
No 'x' in Nixon
Are we not pure? “No, sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man—a prisoner up to new era.
```

And this rather long one:

```
Dennis, Nell, Edna, Leon, Nedra, Anita, Rolf, Nora, Alice, Carol, Leo, Jane, Reed, Dena, Dale, Basil, Rae, Penny, Lana, Dave, Denny, Lena, Ida, Bernadette, Ben, Ray, Lila, Nina, Jo, Ira, Mara, Sara, Mario, Jan, Ina, Lily, Arne, Bette, Dan, Reba, Diane, Lynn, Ed, Eva, Dana, Lynne, Pearl, Isabel, Ada, Ned, Dee, Rena, Joel, Lora, Cecil, Aaron, Flora, Tina, Arden, Noel, and Ellen sinned.
```
