package server;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import server.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import server.repository.ProductRepository;

@SpringBootApplication
@EnableJpaAuditing
@Controller
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        System.out.println("http://localhost:8080");
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:/products";
    }

//    @Autowired
//    ProductRepository db;
//    @Bean
//    public void init() {
//        System.out.println("init");
//        Product toaster = new Product(1299, "Kenmore Toaster", "Toast your toast your toasty toast toaster.");
//        Product coffee = new Product(378, "Starbucks Frappe Cappuchino", "Wake up with this caffeinated treat.");
//
//        db.save(toaster);
//        db.save(coffee);
//    }
}
