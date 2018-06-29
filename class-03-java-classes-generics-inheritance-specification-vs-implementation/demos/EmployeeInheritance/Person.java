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