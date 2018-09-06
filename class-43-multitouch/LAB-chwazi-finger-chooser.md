# ![CF](http://i.imgur.com/7v5ASc8.png) Multi-Touch

## Resources  
* [Handling Multi-Touch Gestures](https://developer.android.com/training/gestures/multi)
* [Chwazi Finger Chooser](https://play.google.com/store/apps/details?id=com.tendadigital.chwaziApp&hl=en)
  
Create a multi-touch application that tracks multiple touch points and draws
circles to indicate where they are when they're pressed, moved around and
lifted off the screen.

Use the Canvas to draw different colored circles around each finger as it presses
and moves around the screen. 

Create three classes to help model, track and draw touches on the screen:
* `TouchPointer`
  * Tracks one touch with `id`, `xx`, `yy`, `color` properties
* `MultiTouchEngine`
  * `add(int id, float xx, float yy)`
  * `update(int id, float xx, float yy)`
  * `remove(int id)`
* `MultiTouchEngineDrawer`
  * The constructor accepts `MultiTouchEngine`, `Bitmap`, `Canvas` and `ImageView`
  * `clear()`
  * `draw()`

Remember that `event.getAction()` won't react to the general
`ACTION_POINTER_DOWN` action event. You must use masked actions in order to
detect it for multiple touches.

## Stretch Goals
Allows a group of users to each place a finger on the phone, waits for some
number of fingers to be held down consistently for some period of time, then
randomly choose one finger and highlights where it's touching on the screen.

Download and play with the Chwazi Finger Choose app to see how it behaves.

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
