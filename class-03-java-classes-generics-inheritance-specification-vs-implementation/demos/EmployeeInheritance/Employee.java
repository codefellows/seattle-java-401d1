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