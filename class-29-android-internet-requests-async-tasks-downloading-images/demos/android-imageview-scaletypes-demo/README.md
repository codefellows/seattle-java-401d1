# ImageView scaleTypes Demo
This app shows off all the different possible values for the `scaleType`
attribute on an `ImageView`.

Notice that setting `adjustViewBounds` to `true` eliminates extra padding
that appears above or below images for certain scale types. (Note: the app
actually restarts when `adjustViewBounds` is toggled to `false` because it
must reset the `ImageView` to a clean slate.)

For a quick visual reference refer to this webpage which shows off the
scale types similarly: <https://robots.thoughtbot.com/android-imageview-scaletype-a-visual-guide>

And, here's a screenshot of that website:

![examples of scale types](screenshots/webpage_scale_types_demo.png)


Here's how the Android docs describe the scale types: <https://developer.android.com/reference/android/widget/ImageView.ScaleType.html>

<!-- Copied from Android docs -->
<table id="enumconstants" class="responsive constants">
  <tbody><tr><th colspan="2"><h3>Enum values</h3></th></tr>


  <tr class="api apilevel-1">
    <td><code><a href="https://developer.android.com/reference/android/widget/ImageView.ScaleType.html">ImageView.ScaleType</a></code>&nbsp;</td>
    <td width="100%">
      <code>CENTER</code>
      <p>Center the image in the view, but perform no scaling.&nbsp;


</p>
    </td>
  </tr>


  <tr class="api apilevel-1">
    <td><code><a href="https://developer.android.com/reference/android/widget/ImageView.ScaleType.html">ImageView.ScaleType</a></code>&nbsp;</td>
    <td width="100%">
      <code>CENTER_CROP</code>
      <p>Scale the image uniformly (maintain the image's aspect ratio) so
 that both dimensions (width and height) of the image will be equal
 to or larger than the corresponding dimension of the view
 (minus padding).&nbsp;


</p>
    </td>
  </tr>


  <tr class="api apilevel-1">
    <td><code><a href="https://developer.android.com/reference/android/widget/ImageView.ScaleType.html">ImageView.ScaleType</a></code>&nbsp;</td>
    <td width="100%">
      <code>CENTER_INSIDE</code>
      <p>Scale the image uniformly (maintain the image's aspect ratio) so
 that both dimensions (width and height) of the image will be equal
 to or less than the corresponding dimension of the view
 (minus padding).&nbsp;


</p>
    </td>
  </tr>


  <tr class="api apilevel-1">
    <td><code><a href="https://developer.android.com/reference/android/widget/ImageView.ScaleType.html">ImageView.ScaleType</a></code>&nbsp;</td>
    <td width="100%">
      <code>FIT_CENTER</code>
      <p>Scale the image using <code><a href="https://developer.android.com/reference/android/graphics/Matrix.ScaleToFit.html#CENTER">CENTER</a></code>.&nbsp;


</p>
    </td>
  </tr>


  <tr class="api apilevel-1">
    <td><code><a href="https://developer.android.com/reference/android/widget/ImageView.ScaleType.html">ImageView.ScaleType</a></code>&nbsp;</td>
    <td width="100%">
      <code>FIT_END</code>
      <p>Scale the image using <code><a href="https://developer.android.com/reference/android/graphics/Matrix.ScaleToFit.html#END">END</a></code>.&nbsp;


</p>
    </td>
  </tr>


  <tr class="api apilevel-1">
    <td><code><a href="https://developer.android.com/reference/android/widget/ImageView.ScaleType.html">ImageView.ScaleType</a></code>&nbsp;</td>
    <td width="100%">
      <code>FIT_START</code>
      <p>Scale the image using <code><a href="https://developer.android.com/reference/android/graphics/Matrix.ScaleToFit.html#START">START</a></code>.&nbsp;


</p>
    </td>
  </tr>


  <tr class="api apilevel-1">
    <td><code><a href="https://developer.android.com/reference/android/widget/ImageView.ScaleType.html">ImageView.ScaleType</a></code>&nbsp;</td>
    <td width="100%">
      <code>FIT_XY</code>
      <p>Scale the image using <code><a href="https://developer.android.com/reference/android/graphics/Matrix.ScaleToFit.html#FILL">FILL</a></code>.&nbsp;


</p>
    </td>
  </tr>


  <tr class="api apilevel-1">
    <td><code><a href="https://developer.android.com/reference/android/widget/ImageView.ScaleType.html">ImageView.ScaleType</a></code>&nbsp;</td>
    <td width="100%">
      <code>MATRIX</code>
      <p>Scale using the image matrix when drawing.&nbsp;


</p>
    </td>
  </tr>
<!-- ========== METHOD SUMMARY =========== -->
</tbody></table>

Here's what the app looks like

![square image in app](screenshots/demo_square_image.png)
![tall image in app](screenshots/demo_tall_image.png)
![wide image in app](screenshots/demo_wide_image.png)
