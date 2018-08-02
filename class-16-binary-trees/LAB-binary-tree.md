# ![CF](http://i.imgur.com/7v5ASc8.png) Implement a Binary Tree

## Resources
* [Wikipedia: Binary Tree](https://en.wikipedia.org/wiki/Binary_tree)

## Feature Tasks
* Create a class called `TreeNode`
  * Add a public property of type `int` called `data`
  * Add a public property of type `TreeNode` called `left`
  * Add a public property of type `TreeNode` called `right`
* Create a class called `BinaryTree`
  * Add private a property of type `TreeNode` called `root`
  * Build three public traversal methods that traverse the tree and return the
    data in the tree as a list of type `List`:
    * `inOrder` traversal that visits left, current, right
    * `preOrder` traversal that visits current, left, right
    * `postOrder` traversal that visits left, right, current
  * Build a public method `toString()` that returns an in-order traversal of
    the tree as a String. (You may use `java.util.Arrays.toString`)
  * Build a public method called `size()` that returns the minimum value all
    throughout the tree.
  * Build a public method called `min()` that returns the minimum value all
    throughout the tree.
  * Build a public method called `contains(int val)` that returns `true` or
    `false` if the given value is anywhere in the tree.

Use overloaded public/private method pairs to make your class easier to use.
This allows programmers to interact with convenient methods. This means there's
one public method where programmers pass in data from outside the class, then
the public method combines internal class data to a method that adds additional
internal class data (like the root of the tree). This saves programmers using
objects outside the class from passing in frivilous data to class methods.

The type signatures of two contains methods should look like the following.

```java
public boolean contains(int value) {
  return contains(value, this.root);
}

private boolean contains(int value, TreeNode node) {

}
```

Manually wire together your own tree (because there's no add method).

```java
BinaryTree tree = new BinaryTree();
TreeNode n53 = new TreeNode(53);

TreeNode n18 = new TreeNode(18);
TreeNode n12 = new TreeNode(12);
TreeNode n24 = new TreeNode(24);

TreeNode n75 = new TreeNode(75);
TreeNode n66 = new TreeNode(66);
TreeNode n99 = new TreeNode(99);

// connect nodes
tree.root = n53;
n53.left = n18;
n18.left = n12;
n18.right = n24;

n53.right = n75;
n75.left = n66;
n75.right = n99;
```

```txt
      53
    /   \
   18    75 
  / \   /  \
12  24 66   99
```

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
