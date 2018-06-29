package helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    System.out.println();
    System.out.println("Server running! Access it here:");

    // TODO: find out how to access port programatically
    // if you're trying to find it, it's defined in /src/main/resources/application.properties
    //String port = env.getProperty("server.port");
    String port = "8080";
    String format = "http://localhost:%s/greeting?name=Enoch Root";
    String message = String.format(format, port);
    System.out.println(message);
  }
}
