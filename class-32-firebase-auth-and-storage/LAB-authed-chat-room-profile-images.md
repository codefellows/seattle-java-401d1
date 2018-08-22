# ![CF](http://i.imgur.com/7v5ASc8.png) Instagram-Like Image List

## Resources  
* [Ion Image Library](https://github.com/koush/ion)
* [Imgur Free Image Hosting](https://imgur.com/)

Continue practicing building lists with the `RecyclerView` and a custom
Adapter. Use the `Ion` image library to download images and display the images
inside `ImageView` views in the ViewHolder.

Build an app that displays a list of images, as if they were uploaded from
instagram.  Create a class with properties for the image url, and at least two
addtional properties (like a username, a timestamp, or a description of the
image).

Create a hard-coded list of the images and their additional information and
make it accessible to the adapter attached to the `RecyclerView`.

The images should be hosted externally somewhere online, and not dropped inside
your Drawables folder.

### Example Ion interaction
```java
Ion.with(imageView)
.placeholder(R.drawable.placeholder_image)
.error(R.drawable.error_image)
.load("http://example.com/image.png");
```

### Gradle Dependencies

```gradle
dependencies {
  implementation 'com.jakewharton:butterknife:8.8.1'
  annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'

  compile 'com.koushikdutta.ion:ion:2.+'
}
```
  
## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
