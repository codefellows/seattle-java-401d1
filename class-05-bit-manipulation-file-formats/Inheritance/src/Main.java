import employees.CEO;
import employees.Employee;
import employees.Programmer;
import employees.Receptionist;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> workers = new ArrayList<>();
        workers.add(new Receptionist());
        workers.add(new CEO());
        workers.add(new Programmer());
        workers.add(new Programmer());
        workers.add(new Programmer());
        workers.add(new Programmer());

        for (Employee employee : workers) {
            System.out.println(employee);
            if (employee instanceof Programmer) {
               doProgrammingWork((Programmer) employee);
            }
        }
    }

    public static void doProgrammingWork(Programmer person) {
        person.program();
    }
}
