# ![CF](http://i.imgur.com/7v5ASc8.png) Intro to Canvas


## Learning Objectives
* Students will be able to manipulate bitmaps and render them in ImageViews
* Students will be able to write programs that react to users interacting
  with the ImageView via touch events
* Students will be able to convert XY coordinates into entities represented
  within the bitmap in the ImageView
* Users will be able to programmatically track coordinates of touch
  start events, current XY positions, and final XY positions when touch
  events end

## Lecture Outline
* Create an application with an ImageView
* Use Butterknife to bind `@OnTouch` events to the ImageView
* Accept a `MotionEvent` as a parameter to the method handling the touch event
* Create a `Rect` class to represent rectangles at certain XY coordinates
  with a width and a height
* Create random rectangles and add them to a list
* Paint all the rectangles on the canvas
* Write a function to detect if XY coordinates exist within a rectangle
* Create a `draw()` function that draws all the rectangles to the screen
* Call the `draw()` function whenever a movement event happens
* Detect if the user's touch coordinates occur within the bounds of a rectangle
* Configure the Rectangles so they can draw themselves highlighted
* Draw a rectangle highlighted if a user is currently hovering their touch
  press over a rectangle
  
### Code Samples

#### Handling Touch Events
```java
@OnTouch({R.id.imageView})
boolean imageTouch(MotionEvent event) {
  int action = event.getAction();
  if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_MOVE || action == MotionEvent.ACTION_DOWN) {
    float x = event.getX();
    float y = event.getY();
  }
  return true;
}
```

#### Drawing on Bitmap Canvases
```java
Paint BLACK = new Paint(Paint.ANTI_ALIAS_FLAG);
BLACK.setColor(Color.BLACK);
BLACK.setStyle(Paint.Style.FILL);

ImageView imageView;
Bitmap bitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.RGB_565);
Canvas canvas = new Canvas(this.bitmap);
canvas.drawLine(x0, y0, x1, y1, BLACK);
canvas.drawCircle(xCenter, yCenter, radius, BLACK);

Rect rect = new Rect(x, y, x + squareSize, y + squareSize);
canvas.drawRect(rect, BLACK);

imageView.setImageDrawable(new BitmapDrawable(activity.getResources(), bitmap));
```
