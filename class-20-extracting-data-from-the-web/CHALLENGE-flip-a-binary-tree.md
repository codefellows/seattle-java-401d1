# Code Challenge

Flip a Binary Tree so all it's left and right nodes are swapped.

## Specifications
- Read all of the following instructions carefully. Name things exactly as described, or you will get a ZERO without comment
- Do all your work in a public repository called `data-structures-and-algorithms`, with a well-formated, detailed top level README.md matching the example provided by your instructor
- Create a branch in your repository called `flip-binary-tree`
- On your branch, create...
    - _Java_: Create a method named `flip` attached to your `BinaryTree`
      class.
    - _C#_: Create a method named `flip()` outside of `Main()` in your `Program.cs` file. Call Your newly created method in `Main()` once complete. 
    - _JavaScript_: a file called `flip-binary-tree.js`
    - _Python_: a file called `flip_binary_tree.py`
- Include any language-specific configuration files required for this challenge to become an individual component, module, library, etc.
    - _NOTE: You can find an example of this configuration for your course in your class lecture repository._

## Feature Tasks
Traverse through a binary tree and swap each right and left value.

Hint: consider this incomplete pseudocode:

```
recurse(node):
  newLeft = recurse(node.right)
  node.right = recurse(node.left)
  node.left = newLeft
  return node
```

## Structure and Testing
Utilize the Single-responsibility principle: any methods you write should be clean, reusable, abstract component parts to the whole challenge. You will be given feedback and marked down if you attempt to define a large, complex algorithm in one function definition.

Write at least three test assertions for each method that you define.

Ensure your tests are passing before you submit your solution.

## Example

### Input
```
    8
   / \
  2   6
     /
    7
     \
      1
```

### Output
```
    8
   / \
  6   2
   \  
    7
   /
  1
```

## Documentation: Your README.md

```markdown
# Determine if two Binary Trees are identical
<!-- Short summary or background information -->

## Challenge
<!-- Description of the challenge -->

## Solution
<!-- Embedded whiteboard image -->

```

## Submission Instructions
1. Take a photo of your completed whiteboard, matching the [example whiteboard layout](../Whiteboard_Workflow.md){:target="_blank"}
     1. Copy your photo into an `/assets` directory in your repo
     1. Give the image file the same name as the branch you are working on
     1. Embed the image in your README.md documentation
1. Create a pull request from your branch to your `master` branch
1. In your open pull request, leave as a comment [a checklist](https://github.com/blog/1825-task-lists-in-all-markdown-documents){:target="_blank"} of the specifications and tasks above, with the actual steps that you completed checked off
1. Submitting your completed work to Canvas:
    1. Copy the link to your open pull request and paste it into the corresponding Canvas assignment
    1. Leave a description of how long this assignment took you in the comments box
    1. Add any additional comments you like about your process or any difficulties you may have had with the assignment
1. Merge your branch into `master`, and delete your branch (don't worry, the PR link will still work)
