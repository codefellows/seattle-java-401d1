# ![CF](http://i.imgur.com/7v5ASc8.png) Implement Array List

## Resources  
* [How to implement an ArrayList](http://www.vogella.com/tutorials/JavaDatastructureList/article.html)
* [Wikipedia: List ADT (Abstract Data Type)](https://en.wikipedia.org/wiki/List_(abstract_data_type))
* [Java Docs: List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
* [Java Docs: ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)

Your job is to build your own squishy-sized list-like class using a private
internal fixed-size array. Read the [How to implement an ArrayList](http://www.vogella.com/tutorials/JavaDatastructureList/article.html)
resource to see exactly how to build an ArrayList using a private internal
array.

![step by step explanation](./step-by-step-explanation.png)

<!---
| Operation | Size | Capacity | toString | Internal Array | Commentary | 
|-----------|------|----------|----------|----------------|------------|
| new MyArrayList() | 0 |  7 | `"[]"`                                   | `[ 0,  0,  0,  0,  0,  0,  0]`                      | The internal array has `7` spots, but toString shows everything as empty. |
| .add(12)          | 1 |  7 | `"[12]"`                                 | `[12,  0,  0,  0,  0,  0,  0]`                      | `12` is added at the first free spot |
| .add(82)          | 2 |  7 | `"[12, 82]"`                             | `[12, 82,  0,  0,  0,  0,  0]`                      | `82` is added at the next free spot |
| .add(47, 0)       | 3 |  7 | `"[47, 12, 82]"`                         | `[47, 12, 82,  0,  0,  0,  0]`                      | elements are shifted over to make room for `47` at index `0` |
| .add(51)          | 4 |  7 | `"[47, 12, 82, 51]"`                     | `[47, 12, 82, 51,  0,  0,  0]`                      | `51` is added at the next free spot |
| .add(52)          | 5 |  7 | `"[47, 12, 82, 51, 52]"`                 | `[47, 12, 82, 51, 52,  0,  0]`                      | `52` is added at the next free spot |
| .add(53)          | 6 |  7 | `"[47, 12, 82, 51, 52, 53]"`             | `[47, 12, 82, 51, 52, 53,  0]`                      | `53` is added at the next free spot |
| .removeValue(12)  | 5 |  7 | `"[47, 82, 51, 52, 53]"`                 | `[47, 82, 51, 52, 53,  0,  0]`                      | everything right of `12` is shifted left. The previous last index where `53` was is manually overwritten with `0` |
| .add(91)          | 6 |  7 | `"[47, 82, 51, 52, 53, 91]"`             | `[47, 82, 51, 52, 53, 91,  0]`                      | `91` is added at the next free spot |
| .add(92)          | 7 |  7 | `"[47, 82, 51, 52, 53, 91, 92]"`         | `[47, 82, 51, 52, 53, 91, 92]`                      | `92` is added at the next free spot |
| .add(93)          | 8 | 14 | `"[47, 82, 51, 52, 53, 91, 92, 93]"`     | `[47, 82, 51, 52, 53, 91, 92, 0, 0, 0, 0, 0, 0, 0]` | There is no free spot to add `93` so the class uses private method `.grow` to double the size of it's internal array and copy values over, then adds `93` at the next free spot. |
-->

## Feature Tasks
* Create a class called `MyArrayList`
* Our array list will be built specifically for integers. It won't store
  Strings or any other type of value.
* Your `MyArrayList` class should have the following methods:
  * A constructor that creates the internal array with a default size of `7`
  * A parameterized constructor that allows users to specify how large
    the initial array should be.
  * `add(int val)` - adds the value to the end of the list
  * `add(int val, int index)` - adds the value at the index, shifting all other
    elements to make room.
  * `.toString()` - a custom .toString implementation that returns a String
    like `"[]"`, `"[12]"` and  `"[12, 32, 11]"` to represent elements added
    to the array. The String should only print out the portions of the array
    that are actually storing values.
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
* Write `.toString` tests to make sure your class returns each of
  * `"[]"` for an empty list
  * `"[12]"` with no commas for a single-item list
  * `"[12, 32, 11]"` with commas between elements for a multi-item list
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
