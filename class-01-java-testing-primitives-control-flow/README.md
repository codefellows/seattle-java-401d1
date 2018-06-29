# ![CF](http://i.imgur.com/7v5ASc8.png) Class Kickoff and Intro to Java 

## Resources
* [Java Language Features Supported in Android](https://developer.android.com/guide/platform/j8-jack.html)
* [Java SDK Downloads and Release Notes](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Common Problems and Their Solutions](https://docs.oracle.com/javase/tutorial/getStarted/problems/index.html)
* [Java Tutorial Hello World](https://docs.oracle.com/javase/tutorial/getStarted/index.html)

Introduction to the Java toolchain and compilation of the first program, Hello World.

## Learning Objectives  
* Get students acclimated to the Code Fellows space and have a good understanding of the format class will take each day.  

* Students should have a fundamental understanding of the basics of JAVA including:  
  * Variables & Constants  
  * Numeric Types & Operations  
  * Strings  
  * Decisions  
  * Repeating Steps  
  * Methods  

* Installing toolchains
* Compiling your first program
* Get familiar with the development environment: toolchains, editors, etc ...

### Kick Off Notes:  

### Address the following during your class specific kick off.

Introduce yourself, TA's and other instructional staff  
Inform students that the TA's will be helping with grading and uploading lecture videos each day.  

TA's are also the second line of defense when coming across bugs or other issues.  

The first source of help:  
**Each Other**  

#### Instructor and TA availability  
Let students know that you always try to be available, but to please be understanding of time off.  
Everyone needs breaks, even instructors. :-)  

We try and respond as quickly as possible, but there may be times where those questions and concerns will have to wait for class/lab.  

### Student and staff introductions  

If you haven't already, give a quick intro on your background.  

Go around and do quick student intros:  
* Name  
* Geeky fact about yourself  
* Why Android?  

Let students know that today will be a long day considering we have a lot to cover on top of the Kick-Off we just completed.  

Remind students that by this point they should have ALL completed the pre-work assignments.  

### Reminder of bathroom codes and CF access.  
* Men's: 5218*  
* Women's: 5208*  

### Verify Student Toolbelts  

* Make sure students have all installed the following:

  * `git` on the CommandLine: [GIT Tools Website](https://git-scm.com)
  * Java SDK 1.7: [JAVA SDK Download](http://www.oracle.com/technetwork/java/archive-139210.html) 
  * The student's favorite text editor.

*Related information*

* Make sure students have all installed `git` on the CommandLine.  
* Show students your command prompt and let them know about `EZPrompt`.  
* Also, at this level, if they would like to, tell them they can look into using `zsh` and `oh-my-zsh`, but will need to do their own research.  
* If they would like more help setting this up, we can address during lab individually.  

#### Android Specific System Verification:  
* Students have all downloaded and setup Android Studio  

> Explain that we will go into heavy detail on the GUI of Android Studio, but first we need to get a fundamental understanding of JAVA.  

### Installing Java Locally  
> Students should have already set this up based on the prework, but slack out the following link to download the JDK:  http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html  

* The next thing we need to do is get Atom configured to help us with writing our Java code.  

* have Students install the following 2 packages:  
```
autocomplete-java
linter-javac
```  

### Topics  

* Introduction to the Java toolchain: compiler, javadoc, command line switches
* Difference between Java variations (J2SDK, J2ME, J2EE, Embedded Java).  
* Embedded development: java development on a very small device.

### Foreshadowed

These items are foreshadowed and convered later:
* Android as a variant of Java - similar to J2ME.

### Lecture Code  
* Once all the above have been confirmed, we are going to write our first program to test the JDK on the command-line.  

* Open the terminal, and change directory to `~/codefellows/501/android/` and run the following commands:  

```bash
mkdir hello-world
cd hello-world
atom HelloWorld.java
```  

Then, in Atom, write the following `HelloWorld` code:  

```Java
public class HelloWorld {
  public static void main(String[] args){
    System.out.println("Hello World");
  }
}
```  

Notes on the code above:  
> 1. Talk about the fact that **EVERYTHING** in Java must be inside of a class.  
> 2. Mention that while we are focusing on Java, we will need to implement this reserved `main()` function, but it will be abstracted away from us in Android Studio.  
> 3. Also, mention that in Android Studio, we will have a different method of printing to the console using `log`.  
> 4. Explain that we will discuss access control in the future.  

* Save the file and go back to the command-line and enter the following commands:  
```
javac HelloWorld.java
java HelloWorld
```  

> You should see `Hello World` print out to the command-line.  

* Explain the `javac` is the `Java compiler`  
* Inform students that they will only need to compile their code 1 time. After that, any changes made to the program and saved will be reflected on the command-line.  

1. HelloWorld

Keywords presented: package, public, class, static, void


### Variables and Constants  
* In `HelloWorld.java` change the above code to the following:  
```Java  
public class HelloWorld {
  public static void main(String[] args){
    // System.out.println("Hello World");
    
    String firstName = "Adam";
    String lastName = "Wallraff";
    Integer age = 31;
    
    System.out.println("Name: " + firstName + " " + lastName + " - Age: " + age);
    
  }
}
```  

* Explain that all the variables are mutable by default. After the `age` declaration, add the following:  
```Java
firstName = "Something Else";
```  

* Run the program to show that the value changed.  

* Now, change `firstName` to the following:  
```Java
final String firstName = "Adam";
```  

* Save, and explain the error that we are seeing is because we have changed this variable to a constant.  

### Characters and Strings  

### Making Decisions  
Below the above code, write and explain the following:  
```java
if (name.contains("Adam")) {
  System.out.println("Your name is Adam!");
} else if (name == "Bob") {
  System.out.println("Your name is Bob!");
} else {
  System.out.println("I dont know your name...");
}

switch (name) {
  case "Adam":
  case "Adam Wallraff":
  System.out.println("Your name is Adam Wallraff!");
  break;
  case "Bob":
  System.out.println("Your name is Bob!");
  break;
  default:
  System.out.println("I don't know you...");
}

String favoriteLanguage = firstName == "Adam" ? "Swift" : "Not Sure";

System.out.println(favoriteLanguage);
```  

### Loops  
Below the above code, add:  
```java
int numberOfStudents = 5; //Enter Class size here.

for (int i = 1; i <= numberOfStudents; i++) {
  System.out.println("Student: " + i);
}

//Then show implementing a "Enhanced For Loop":

String[] teachers = {"Adam", "Brian", "Duncan"};

for (String teacher : teachers) {
  System.out.println(teacher);
}

int number = 0;
while(number < 100) {
  System.out.println(number);
  number++;
}

do {
  System.out.println("number: " + number);
  number += 50;
} while (number <= 200);

}
```  

### Methods  
Implement the following functions in the HelloWorld class:  
```java
public static String printFullName(String firstName, String lastName){
  String fullName = firstName + " " + lastName;
  System.out.println(fullName); //Output: "Adam Wallraff"
  return fullName;
}

public static void helloWorld(){
  System.out.println("HELLO WORLD!!");
}
```  

Then, call in the `main()` function:  
```java
public static void main(String[] args){
  // System.out.println("Hello World");
  String firstName = "Adam";
  String lastName = "Wallraff";
  Integer age = 31;
  
  HelloWorld.helloWorld(); //call method with no arguments or return.
  
  HelloWorld.printFullName(firstName, lastName); //Show this
  printFullName(firstName, lastName); //Change to this to show omitting the class name when calling static methods inside other static methods of the same class.

  System.out.println(Math.abs(-100)); // 100
  System.out.println(Math.min(-100, 100)); // -100
  System.out.println(Math.max(-100, 100));// 100
  
}
```  

### Lab Submissions  
Go over how to properly submit lab assignments via gist for today.  
