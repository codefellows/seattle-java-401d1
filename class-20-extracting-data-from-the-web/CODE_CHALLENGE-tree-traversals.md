# In-Order Traversal
Write a method that accepts a Tree and prints out the values of each
node in an in-order traversal.

* [Tree Traversal Reference](http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/)

#### In-Order Traversal
An in-order traversal visits and prints nodes recursively in this order:

```
visit(this.left)
print(this.value)
visit(this.right)
```

#### Pre-Order Traversal
A pre-order traversal visits and prints nodes recursively in this order:

```
print(this.value)
visit(this.left)
visit(this.right)
```

#### Post-Order Traversal
A post-order traversal visits and prints nodes recursively in this order:

```
visit(this.left)
visit(this.right)
print(this.value)
```
