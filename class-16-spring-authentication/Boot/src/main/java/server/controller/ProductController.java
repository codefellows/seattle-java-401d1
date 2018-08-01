package server.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.web.bind.annotation.RequestParam;
import server.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import server.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/products")
    @ResponseBody
    @JsonSerialize
    public List<Product> indexAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @RequestMapping("/products/new")
    @ResponseBody
    public Product newProduct(
            @RequestParam int price,
            @RequestParam String name,
            @RequestParam String description
    ) {
        Product product = new Product(price, name, description);
        productRepository.save(product);
        return product;
    }

    @RequestMapping("/products2")
    @ResponseBody
    public String two() {
        return "two";
    }
}
