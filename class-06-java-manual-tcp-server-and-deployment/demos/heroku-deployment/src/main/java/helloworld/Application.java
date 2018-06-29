package helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    System.out.println();
    System.out.println("Server running! Access it here:");
    System.out.println("http://localhost:8080/greeting?name=Enoch Root");
  }
}
