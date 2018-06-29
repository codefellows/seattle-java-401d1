
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
    
    Employee newEmployee = adam.hireNewPerson(amanda);
    System.out.println(newEmployee.name + " Welcome to the company!");
    
    adam.fireEmployee(newEmployee);
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



