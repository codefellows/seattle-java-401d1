# ![CF](http://i.imgur.com/7v5ASc8.png) Implement a Binary Tree

## Resources
* [Wikipedia: Binary Tree](https://en.wikipedia.org/wiki/Binary_tree)

## Feature Tasks
* Create a class called `TreeNode`
  * Configure the class to use Java generics `E` so you can parameterize the type
    of data the `TreeNode` holds when it's declared.
  * Add a public generic property of type `E` called `data`
  * Add a public property of type `TreeNode<E>` called `left`
  * Add a public property of type `TreeNode<E>` called `right`
* Create a class called `BinaryTree`
  * Configure the class to use Java generics `E` so you can parameterize the type
    of data the `BinaryTree` holds when it's declared.
  * Add private a property of type `TreeNode<E>` called `root`
  * Build three public traversal methods that traverse the tree and return the
    data in the tree as a list of type `List<E>`:
    * `inOrder` traversal that visits left, current, right
    * `preOrder` traversal that visits current, left, right
    * `postOrder` traversal that visits left, right, current
  * Build a public method `toString()` that returns an in-order traversal of
    the tree as a String. (You may use `java.util.Arrays.toString`)
  * Build a public method called `size()` that returns the minimum value all
    throughout the tree.
  * Build a public method called `min()` that returns the minimum value all
    throughout the tree.
  * Build a public method called `contains(E val)` that returns `true` or
    `false` if the given value is anywhere in the tree.

Use overloaded public/private method pairs to make your class easier to use.
This allows programmers to interact with convenient methods. This means there's
one public method where programmers pass in data from outside the class, then
the public method combines internal class data to a method that adds additional
internal class data (like the root of the tree). This saves programmers using
objects outside the class from passing in frivilous data to class methods.

The type signatures of two contains methods should look like the following.

```java
public boolean contains(E value) {
  return contains(value, this.root);
}

private boolean contains(E value, TreeNode<E> node) {

}
```

```java
BinaryTree<Integer> tree = new BinaryTree<>();
```

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
