# ![CF](http://i.imgur.com/7v5ASc8.png) Uploading Files

## Resources  
* [Spring Guide: Uploading Files](https://spring.io/guides/gs/uploading-files/)
* [Baeldung: File Upload with Spring](http://www.baeldung.com/spring-file-upload)
  
## Learning Objectives
* Students will be able to built HTML pages allowing users to choose a file
  (or files) to upload
* Students will be able to configure their server to accept file uploads
* Students will be able to upload files and store them on the server
* Students will be able to find files uploaded to their server
* Students will be able to make uploaded files available for download
  
## Lecture Outline
* Uploading files is an important web experience.
* People upload files for all sorts of things:
  * Uploading profile images
  * Uploading images to share with friends
  * Uploading video to share on YouTube
  * Uploading files to share via Google Drive or Dropbox
  * Uploading zip files to turn in homework for a class
  * Uploading files to import data or configurations for a web service
* Let's configure our Spring server so people can upload files and make it so
  we can interact with those files, manipulate them, and allow users to
  download some result
  * Remember the bitmap manipulation lab?
    * We could create a website where users upload images, we run our bit
      manipulation on the file and the user can download the modified file!
    * Or, we could leave the file on the server and use the manipulated
      version to display on different parts of our website
  * Remember the JavaScript semicolon linting program?
    * We could create a website where users upload JavaScript files, we run
      the linter, and then display the lint errors in their code!

### Spring File Upload Configuration
* Spring has mechanisms in place to help us deal with receiving and storing
  uploaded files.
* Like many things in Java, it can require a lot of configuration!
* Check out the Spring demo file upload repo and run a server to show that
  it's possible to upload files in Spring
* Create a new Spring server from scratch, follow configuration instructions
  to prove we can build our own server that accepts file uploads and
  customize it how we like.
  
