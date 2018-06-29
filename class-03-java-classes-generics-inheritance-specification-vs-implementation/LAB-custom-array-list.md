# ![CF](http://i.imgur.com/7v5ASc8.png) Implement Array List

## Resources  
* [How to implement an ArrayList](http://www.vogella.com/tutorials/JavaDatastructureList/article.html)
* [Wikipedia: List ADT (Abstract Data Type)](https://en.wikipedia.org/wiki/List_(abstract_data_type))
* [Java Docs: List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
* [Java Docs: ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)

## Feature Tasks
* Create a class called `MyArrayList`
* Our array list will be built specifically for integers. It won't store
  Strings or any other type of value.
* Your `MyArrayList` class should have the following methods:
  * A constructor that creates an array with some default size.
  * A parameterized constructor that allows users to specify how large
    the initial array should be.
  * `add(int val)` - adds the value to the end of the list
  * `add(int val, int index)` - adds the value at the index, shifting all other
    elements to make room.
  * `removeValue(int val)` - searches for the first occurence of the value in
    the array, removes it, and shifts everything so there's no gaps left.
  * `removeAtIndex(int index)` - Removes the value at the index and shifts
    everything else to leave no gaps.
  * `size()` - returns the number of elements in the array.
  * `get(int index)` - returns the value of the element at the index in the array.

The array and the `size` variable (not the `size()` method!) should be private.
Users are only allowed to interact with the class via the public methods. This
guarantees that no one can break the list and get it into weird states.

## Testing  
### Reader Module Tests
* Use JUnit to write multiple tests for each method.
* Your tests should demonstrate a good understanding of edge cases, like
  how methods behave when the array is empty, when it's full, or when you try
  to access values at the front or end of the list, to make sure there's no
  `IndexOutOfBounds` exceptions.

## Documentation
Write comments for each method clearly explaining the parameters, functionality,
and return value.

## Stretch Goals
* Make a new class called `SortedArrayList` that uses your `MyArrayList` class
  to store a collection that's always sorted. It should have these methods:
  * `.add(int value)` adds the value automatically at the correct position to
    maintain sortedness in the list.
  * `.get(int index)` returns the value at the index
  * `.size()` returns an int, the number of elements in the list.
  * `.removeValue(int value)` searches for the first occurence of the value in the list
    and removes it.
  * `.removeIndex(int index)` removes the value located at the given index.
  * `.indexOf(int value)` returns an integer index of the location of the value
* Use a binary search algorithm to find the index of where new elements should
  be inserted in the list.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit your PR URL with a question and observation, how long you spent, and a link to
  your pull request
