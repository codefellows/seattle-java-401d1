# Is Linked List Sorted?
Write a function `isSorted` that accepts a LinkedList of integers and returns
true or false if it's sorted.

A Linked List with these values should return:

```
isSorted(1, 2, 3) // true
isSorted(1, 3, 2) // false because it's not sorted in either order
isSorted(3, 2, 1) // false because it's not in ascending order
```

## Stretch Goal
Modify the function so it returns true if the list is sorted, no matter if it's
in ascending order or descending order.

After making the changes both these lists should return true because they're
sorted, just in ascending vs descending order:

```
isSorted(1, 2, 3) // true
isSorted(3, 2, 1) // true
```
