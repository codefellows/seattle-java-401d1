# Classes
A collection of properties and methods.
A class actually has code inside of it's
methods
Classes can be extended so other classes
inherit their fully-built properties and methods

# Abstract Classes
A partial class where not all methods
are actually defined. Some methods
don't have code and rely on sub-classes
to define code to fill in these empty
spots.

# Interfaces
A collection of properties and methods
that another class **should** have.

An interface defines what something else
must have in order to be considered a
type of thing.

There's an interface called `Iterable`
that classes can `implement` to make
classes targets of forEach loops.

# Basic Traversals
min()
max()
contain(val)
size()

# Traversal w/
# extra logic
* numLeaves()
* longestBranch()

* in-order (do current in the middle)
  * recurse left
  * visit current
  * recurse right

* pre-order (do current first)
  * visit current
  * recurse left
  * recurse right

* post-order (do current last)
  * recurse left
  * recurse right
  * visit current

* visit ~== "print"
* visit can be anything, any function

# Basic Structure
```java
class TreeNode<E> {
  E data;
  TreeNode<E> left;
  TreeNode<E> right;
}

class BinaryTree<E> {
  private TreeNode<E> root;

  public boolean contains();
  public int size();
  public void add(E val);
  public int longestBranch();
}

int newValue = 11;
TreeNode node = this.root;
boolean isDone = false;
while (!isDone) {
  if (newValue < node.data) {
    node = node.left;
  } else {
    node = node.right;
  }
}
```
