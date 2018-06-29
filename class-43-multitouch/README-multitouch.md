# ![CF](http://i.imgur.com/7v5ASc8.png) Multitouch


## Learning Objectives
* Students will be able to respond to multiple simultaneous touch events
* Students will be able to visualize multiple simultaneous touch events on
  the screen

## Lecture Outline
* Create an ImageView with a bitmap that draws a dot on the screen and
  tracks where a user is touching as they press and drag a finger around
* Demonstrate that the program doesn't track more that one touch point at once
* Respond to touch events tracking more than one user touch event at once
* Display how many touch events are currently interacting with the screen
  at once
* Draw text or other distinguishing visual features to distinguish between
  the first, second, third and so on touch entities to touch the screen at once
* Try to make the application max out how many touch events it can respond to
  simultaneously
* Constantly track how many touch events are occurring at once and determine
  how the same number of touch events have remained on the screen
* Add debouncing so the visual number of touch events occurring at once only
  changes after the number of touch events has stabilized past a certain timed
  threshold
  * If someone touches, show one person is touching instantly
  * Don't show that two people are touching until two people have been touching
    for more than one second
    * Prevent the app from saying two people are touching it until they've both
      held their fingers there for more than one second
