# ![CF](http://i.imgur.com/7v5ASc8.png) Advanced Canvas


## Learning Objectives
* Students will be able to create their own interactive UIs manipulating
  bitmaps and responding to touch events
* Students will be able to deal with UIs that depend on radial coordinates
  converting XY coordinates into (distance from center, angle) coordinates

## Lecture Outline
* Review sin, cos, tan
* Draw a unit circle on the whiteboard with several example points at the
  center, and at various points in each quadrant
* Demonstrate how XY coordinates can be converted into radial coordinates
  by determining the angle of the XY point from the X axis, and the distance
  to the point from the origin
* Work through the math to convert XY coordinates to their (distance, angle)
  equivalents
* Draw a simple compass on a Bitmap drawn to an ImageView
* Use Butterknife to respond to touch events on the ImageView
* Draw a line from the origin to where the user is pressing to verify the
  program is accurately interpreting where the user is touching
* Use the angle to determine what North, East, South, West direction the user
  is touching with respect to the origin and display what direction their
  touching on the screen.
  
