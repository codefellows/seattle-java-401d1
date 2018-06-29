# Bracket Matching
Write a method called `isNestedProperly` that accepts a String and returns true only
if each opening bracket is exactly nested with corresponding closing brackets.
Ignore any character that's not a bracket.

```
isNestedProperly("") // true
isNestedProperly("aaa[bbb[]]") // true
isNestedProperly("][") // false because closing bracket appears before opening
isNestedProperly("[[]") // false because there's a missing closing bracket
```
