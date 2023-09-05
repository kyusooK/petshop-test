package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.ProductApplication;
import petshop.domain.ProductCreated;
import petshop.domain.ProductDeleted;

@Entity
@Table(name = "Product_table")
@Data
//<<< DDD / Aggregate Root
public class Product {

    @Id
    private String name;

    @Embedded
    private Money price;

    private String description;

    @ElementCollection
    private List<Ingredient> ingredients;

    @PostPersist
    public void onPostPersist() {
        ProductCreated productCreated = new ProductCreated(this);
        productCreated.publishAfterCommit();

        ProductDeleted productDeleted = new ProductDeleted(this);
        productDeleted.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ProductRepository repository() {
        ProductRepository productRepository = ProductApplication.applicationContext.getBean(
            ProductRepository.class
        );
        return productRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateProduct(UpdateProductCommand updateProductCommand) {
        //implement business logic here:

        ProductUpdated productUpdated = new ProductUpdated(this);
        productUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
