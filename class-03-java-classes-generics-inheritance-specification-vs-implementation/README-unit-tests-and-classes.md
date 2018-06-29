# ![CF](http://i.imgur.com/7v5ASc8.png) Unit Testing

### How to Set Up Unit Tests
Let's create a new Java project in Intellij from scratch and set it up to run
unit tests with Junit.

This YouTube video is a great resource to follow: <https://www.youtube.com/watch?v=UqtorhWcjPM>

1. Open IntelliJ and choose File > New > Project...
1. Choose Java, click Next.
1. Leave "Create project from template" unchecked
1. Choose a project name, `MyMath`
1. Use the Project explorer to navigate to the `src` folder. Right click > New
   > Java Class and make a class called "MyMath"
1. Create a method `public static int add(int a, int b)` that looks like the
   method below.
1. Go to the project explorer, right click on the top folder of your project
   and choose New > Directory and name it `test`. You should see a `test`
   directory appear next to `src`, at the same level.
1. Right click on the test directory and choose "Mark Directory as" >
   "Test Sources Root"
1. Go back to the `MyMath` class file and open it.
1. Put your cursor on the `MyMath` where the class is declared.
1. Press `ALT + ENTER` and choose "Create Test". Do not navigate into the
   right-menu at those point where the "Edit intention settings" or
   "Disable Create Test" options live. Simply click "Create Test" directly,
   or press `ENTER` when it's highlighted.
1. Choose `JUnit4` for the testing library in the "Create Test" window.
1. Press the "Fix" button if you see "JUnit4 library not found in the module."
  * Choose "Use JUnit4 from IntelliJ IDEA distribution" and press OK.
1. Leave every option untouched, just use the default options.
1. Press OK for the "Create Test" window.
1. Make sure you're now in a new file called `MyMathTest` inside the `test`
   directory.
1. Create two new tests in the class, `passAdd` and `failAdd` as seen below.
1. Annotate the two methods with `@Test` as seen below.
1. Right click on the file `MyMathTest` in the project explorer.
1. Choose "Run 'MyMathTest'
1. Let the tests run, then look at the test results window that opens and
   verify that one test passes, and one test fails.

**src/MyMath**
```java
public class MyMath {
  public static int add(int a, int b) {
    return a + b;
  }
}
```

**test/MyMathTest**
```java
public class MyMathTest {
  @Test
  public void passAdd() {
    assertEquals(2, MyMath.add(1, 1));
  }

  @Test
  public void failAdd() {
    assertEquals(3, MyMath.add(1, 1));
  }
}
```

There may look like a lot of steps there, but IntelliJ really makes it easy and
fast to create tests for our programs.

Simply create files to test what you want to test, create individual tests
with methods and mark them with the `@Test` annotation. Use methods like
`assertEquals`, `assertTrue`, `assertNotEquals`, `assertNotNull` or any of
the other very many useful test methods JUnit provides.

Look at the [JUnit docs](http://junit.org/junit4/javadoc/4.8/org/junit/Assert.html)
to see what all is available!

### Why Pass and Fail?
When you first set up a test environment it's good to make sure that it will
tell you when tests pass, and when tests fail. If you set up a test environment
incorrectly tests might look like they're passing when they're really all failing
silently.

Writing two simple tests, where one passes, and one fails, gives us confidence
that our testing library isn't lying to us.

Happy testing!

# Java Classes
Having covered code organization, Java language features like loops and branch
control can be covered. By this point in the class students should be able to
easily identify class structure, package structure, and code blocks.

This class can focus on keywords, control structures and other aspects of Java
programming that increase in logical complexity.


## References
[Java Tutorial](https://docs.oracle.com/javase/tutorial/essential/index.html)

## Code Review  

## Learning Objectives  
* Understand Java Classes and the Object type  
* Understand Public and Private
* Understand Java Interfaces  

## Topics  
* Classes  
* Object  
* Public vs Private
* Interfaces  
* Collection/List Interface  

## Lecture  
Before you get started, create a new file called `ClassAndInterfaceDemo.java`:  

```java
public class ClassAndInterfaceDemo {
  public static void main(String[] args){

  }
}
```  

### Classes  
Create a new file called Person.java:  

```java
class Person {

  public String name;
  public int age;
  
  public Person(String name, int age){
    this.name = name;
    this.age = age;
  }
  
  public void sayHello(){
    System.out.println("Hello! My name is " + this.name + ".");
  }
}
```  

Create a new file called Employee.java:  

```java
class Employee extends Person {

  public int sickDays;
  public int id;
  
  public Employee(String name, int age, int sickDays, int id){
    super(name, age);
    this.id = id;
    this.sickDays = sickDays;
  }
}
```  

Back in ClassAndInterfaceDemo, inside the `main()` method, add the following:  

```java
public class ClassAndInterfaceDemo {
  public static void main(String[] args){
  
    Person michael = new Person("Michael", 17);
    Person amanda = new Person("Amanda", 30);
    Employee adam = new Employee("Adam", 31, 10, 1234);
    
    Person[] allPeople = {michael, amanda, adam};
    
    for (Person person: allPeople) {
      
      if (isLegallyAllowedToDrink(person)) {
        System.out.println(person.name + " is legally allowed to drink.");
      } else {
        System.out.println(person.name + " is NOT legally allowed to drink.");
      }
      
      if (person instanceof Employee) {
        takeSickDay((Employee) person);
      }
      
    }
  }
  
  public static boolean isLegallyAllowedToDrink(Person person) {
    return person.age >= 21;
  }
  
  public static int takeSickDay(Employee employee){
    if (employee.sickDays > 0) {
      employee.sickDays--;
      System.out.println(employee.name + " has " + employee.sickDays + " sick days left.");
    } else {
      System.out.println(employee.name + " has no more sick days left.");
    }
    
    return employee.sickDays;
  }
}
```  

* In the above code, make sure to explain how polymorphism allows Adam as an
  employee to be passed through the `isLegallyAllowedToDrink()` method.  

* Also, make sure to discuss the `instanceof` and Type Casting.  

Back to slides.  

### Interfaces  
Create a new file called `Boss.java`:  

```java
public interface Boss {
  public void fireEmployee(Employee employee);
  public Employee hireNewPerson(Person person);
}
```  

Then, change `Employee` to `implement Boss`:  
```java
class Employee extends Person implements Boss {

  public int sickDays;
  public int id;
  
  public Employee(String name, int age, int sickDays, int id){
    super(name, age);
    this.id = id;
    this.sickDays = sickDays;
  }
  
  public Employee hireNewPerson(Person person){
    return new Employee(person.name, person.age, 5, 12345);
  }
  
  public void fireEmployee(Employee employee){
    System.out.println(employee.name + ", You're Fired... Get outa here. Go.");
  }
}
```  

Finally, back in `ClassAndInterfaceDemo` at the bottom of the `main()` method:  
```java
Employee newEmployee = adam.hireNewPerson(amanda);
System.out.println(newEmployee.name + " Welcome to the company!");

adam.fireEmployee(newEmployee);
```  

Back to slides.  

### Collection/List Interface  

### Lecture Slides  
* [Class 3 Slides]()  
