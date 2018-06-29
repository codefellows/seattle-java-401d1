# ![CF](http://i.imgur.com/7v5ASc8.png) Arrays, Lists, Sets and Maps

## Resources
* [Java Tutorial: docs.oracle.com](https://docs.oracle.com/javase/tutorial/)
* [Effective Java: oracle.com](http://www.oracle.com/technetwork/java/effectivejava-136174.html)
* [Java tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html)

Now that the toolchain and development environment has been introduced, Java
language concepts can be covered.

## Learning Objectives  

* Understand JAVA Collection Types  

By the end of this class the students should understand that in Java, Object
Oriented Programming is a way to organize code. This concept is presented
around a simple single-function program which is then expanded into multiple
classes and packages.  All objects are presented with public accessors so the
student gets familiar with the fact that the organization of the code (class
structure), and visibility of the code (accessors) are two distinct concepts.
Accessors are foreshadowed and presented later. 

This is different than the traditional approach to teaching object oriented
programming in that the use of real world objects like vehicles are not used to
introduce the concepts. This saves time and gives the students a mental model
of object oriented programming that is more directly tied to how the virtual
machine actually runs code. 

Application performance and size can be greatly affected by the class hierarchy
of an application, and that is covered later.  

## Topics  

Introduction to Java and key concepts:

* language basics 
* primitives, numbers and strings 
* object oriented programming
* classes, objects
* interfaces and inheritance
* expressions, statements, blocks

Language Basics: cover syntax, function definitions, comments

Object Oriented Programming: difference between classes and objects. Classes are defined in code and files. Objects are instances of classes in memory. One class exists in a file, by many objects exist in memory.  Classes are loaded by the class loader, and objects are managed by the virtual machine. A single function is presented. Everything is described with public accessors. Code: `HelloWorldApplication`

Primitives, numbers and strings: all java code is written around the primitives. Code `HelloWorldMyApplication`.

Static variables. Code: `HelloWorldMyStaticApplication`


These topics may have to spill into class 3, depending on the pace of the class. Students who have not dedicated the amount of time assigned for the first class may not pick up on these topics easily.

Expressions, statements and blocks can be introduced in the general sense. So students can get a sense of where one statement ends and another begins. The concept of a block can also be introduced. Control statements can be introduced later.

### Foreshadowed

These items are foreshadowed and covered later:

* javadoc comments
* control structures such as loops, case, etc ...
* accessors/visibility
* the class loader and how it is used by the virtual machine.
* inner and anonymous classes.
* generics
* packages
* operators
* control flow statements
* performance

This lecture\'s code builds on the code from the previous lecture.

1. HelloWorldApplication: demonstrates classes, objects, and single function coding.
1. HelloWorldMyApplication: demonstrates primitives, inheritance and an application framework. Helps demystify the Android Application class.
1. HelloWorldMyStaticApplication: demonstrates static member variables 

Keywords presented: import, boolean, return, new, if, instanceof, throw, extends, byte, short, int, long, float, double, boolean, char

Literals presented: false, null

## Topics  
* Arrays  
* Collection Types  
* Lists  
* Set/SortedSet  
* Map  

## Lecture  

### Arrays  
Create a new file called `CollectionsDemo.java`.  

Add the following boilerplate code:  
```java
public class CollectionsDemo {
  
  public static void main(String[] args){
    
  }
}
```  

Pause to review from yesterday as needed.  

When ready, continue by writing the following method:  
```java
public static void arrayTest(){
  String[] family = {"Adam", "Amanda", "Mika"};
  
  for (String member: family) { //iterate over each role in roles array.
    System.out.println(member);
  }
  
  int familySize = family.length;
  
}
```  

Then call in the `main()` method.
```java
arrayTest();
```

### Collection Types  

### Lists  
Add the following method:  
```java
public static void listTest(){
  List<String> names = new ArrayList<String>();
  names.add("Adam");
  names.add("Amanda");
  
  String adam = names.get(0);
  System.out.println(adam);
  
  List<String> petNames = new LinkedList<String>();
  petNames.add("Mika");
  petNames.add("Bob");
  
  ArrayList<String> allNames = new ArrayList<String>(petNames);
  allNames.addAll(names);
  
  System.out.println(allNames);
  
  for (String name: allNames) {
    if (name == "Adam") {
      System.out.println("Hello " + name);
    }
  }
  
  if (petNames.contains("Mika")) {
    System.out.println("Mika is part of the family!");
  }
  
}
```  

Then call in the `main()` method:  

```java
listTest();
```  

### Set/SortedSet  

Implement the following `setTest()` method:  

```java
public static void setTest(){
  int[] data = {1, 100, 10, 50, 30, 1, 90, 1, 30};
  
  Set<Integer> uniqueValues = new TreeSet<Integer>();
  
  for(int i = 0; i < data.length; i++){
    uniqueValues.add(data[i]);
  }
  
  System.out.println(uniqueValues);

  String[] startingCategories = {"Metal","Classic Rock","Pop","Hip Hop"};
  Set<String> categories = new HashSet<String>();

  for(int i = 0; i < startingCategories.length; i++){
    categories.add(startingCategories[i]);
  }

  categories.add("Country");
  categories.add("Metal");
  categories.add("Electronica");
  
  System.out.println(categories);
}
```  

Then, in the `main()` method call:

```java
setTest();
```  

### Map  
Add the following `mapTest()` method:  
```java
public static void mapTest(){
  HashMap<String,String> playerEmails = new HashMap<String,String>();
  playerEmails.put("Adam", "adam@codefellows.com");
  playerEmails.put("Bob", "bob@bobross.com");
  playerEmails.put("Glenn", "glenn@glenpire.com");
  playerEmails.put("Brandy", "ionlydrinknice@brandy.com");
  
  String myEmail = playerEmails.get("Adam");
  
  System.out.println(playerEmails);
  System.out.println(myEmail);
  
  playerEmails.put("Adam", "adam.wallraff@gmail.com");
  
  myEmail = playerEmails.get("Adam");
  
  System.out.println(myEmail);
  
  if (!playerEmails.isEmpty()){
    for(Map.Entry<String, String> entry: playerEmails.entrySet()){
        System.out.println(entry.getKey() + " = " + entry.getValue());
    }
  }
  playerEmails.clear();
}
```  

Then, in the `main()` method, call:  

```java
mapTest();
```  
