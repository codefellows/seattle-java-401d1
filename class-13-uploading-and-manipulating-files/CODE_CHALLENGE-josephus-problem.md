# Josephus Problem
People are standing in a circle waiting to be executed. Counting begins at a
specified point in the circle and proceeds around the circle in a specified
direction. After a specified number of people are skipped, the next person is
executed. The procedure is repeated with the remaining people, starting with the
next person, going in the same direction and skipping the same number of people,
until only one person remains, and is freed.

https://en.wikipedia.org/wiki/Josephus_problem

Write a function called `josephus()` that accepts a list of Strings and an int
`n`. Start at the beginning of the list and count up to `n` and remove the person
at the current index from the list. Keep counting from that index and count
up to `n` over and over until only one person is left in the list. Return a
String with the name of the last person left in the list.

```
n=3
[A, B, C, D, E]    // 1A, 2B, 3C
[A, B, _, D, E]    // C was removed
[_, B, _, D, E]    // A was removed
[_, B, _, D, _]    // E was removed
[_, _, _, D, _]    // B was removed
                   // only D is left
```
