package controller;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/products")
    @ResponseBody
    public List<Product> indexAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @RequestMapping("/products2")
    @ResponseBody
    public String two() {
        return "two";
    }
}
