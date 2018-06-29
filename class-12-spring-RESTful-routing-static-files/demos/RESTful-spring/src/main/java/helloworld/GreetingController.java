package helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
  private final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    String message = String.format(template, name);
    long id = counter.incrementAndGet();
    Greeting greeting = new Greeting(id, message);

    return greeting;
  }
}
