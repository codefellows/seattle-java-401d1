# Implement a Queue with Two Stacks
Build a queue using only two stacks.

### Method
Keep 2 stacks, let's call them inbox and outbox.

### Enqueue
Push the new element onto inbox

### Dequeue:
If outbox is empty, refill it by popping each element from inbox and pushing it
onto outbox Pop and return the top element from outbox Using this method, each
element will be in each stack exactly once - meaning each element will be pushed
twice and popped twice, giving amortized constant time operations.

Credit: https://stackoverflow.com/a/69436
