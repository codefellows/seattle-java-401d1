public class HelloWorld {
  
  public static void main(String[] args){
    // System.out.println("Hello World");
    String firstName = "Adam";
    String lastName = "Wallraff";
    Integer age = 31;
    
    HelloWorld.helloWorld(); //call method with no arguments or return.
    
    HelloWorld.printFullName(firstName, lastName); //Show this
    
    HelloWorld myFancyHelloWorld = new HelloWorld();
    
    HelloWorld.helloWorld();
    
    myFancyHelloWorld.doStuff();
    
    printFullName(firstName, lastName); //Change to this to show omitting the class name when calling static methods inside other static methods of the same class.

    System.out.println(Math.abs(-100)); // 100
    System.out.println(Math.min(-100, 100)); // -100
    System.out.println(Math.max(-100, 100));// 100
    
  }
  
  public static void arrayTest(){
    String[] names = {"Adam","Amanda","Mika"};
  }

  public static String printFullName(String firstName, String lastName){
    String fullName = firstName + " " + lastName;
    System.out.println(fullName); //Output: "Adam Wallraff"
    return fullName;
  }

  public static void helloWorld(){
    System.out.println("HELLO WORLD!!");
  }
  
  public void doStuff(){
    System.out.println("sup instances");
  }
}







