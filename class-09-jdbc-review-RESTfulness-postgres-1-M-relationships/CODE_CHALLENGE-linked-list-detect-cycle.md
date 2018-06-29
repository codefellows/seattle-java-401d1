# Detect a Cycle in a Linked List
Write a method called `isCyclic` that accepts a LinkedList and returns true or
false depending on if there is a cycle in the LinkedList.

A cycle is when one node points back to another node that's already in the
list. If you followed the `.next` references from one to the next and kept
going, a cycle would end up steering you in a circle and you'd never stop
traversing the list.

Imagine you have nodes `A`, `B`, `C` and `D`.

* A points to B
* B points to C
* C points to D
* D points to B

**Exercise:** Draw a picture of what this Linked List looks like.

**Stuck?:** It's hard. Read this: <https://blog.ostermiller.org/find-loop-singly-linked-list>
