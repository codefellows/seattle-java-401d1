package server.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
    // requires default constructor
    public Product() {}

    @Id
    @GeneratedValue(generator = "product_generator")
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence",
            initialValue = 1000
    )
    private Long id;

    @Min(0)
    public int price;

    @NotBlank
    @Size(min = 3, max = 100)
    public String name;

    @Column(name = "text")
    public String description;

    public Product(int price, String name, String desc) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = desc;
    }
}
