# Breadth-First Traversal
Write a method that accepts a Tree and prints out the values of each
node in a breadth-first traversal.

The nodes should be printed out level-by-level, from left to right.
Use a queue as an auxiliary data structure to achieve this effect.

A breadth-first traversal visits nodes in this order:

1. Put the root node in a queue
2. Dequeue one node and visit/print it
3. Enqueue the current nodes left child
4. Enqueue the current nodes right child
5. Repeat steps 2-5 until the queue is empty.

```
    10
   /  \
  4   37
 / \
1   5
```

This tree should display as `10 4 37 1 5`.
