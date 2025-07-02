package com.github.carlossnogueira.stock_control.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "Product name can't be blank.")
    private String name;

    @Column(nullable = true)
    private String sku;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Min(value = 1, message = "Min one of this product.")
    private int quantity;

    @Min(value = 1, message = "Min quantity need to be more than one.")
    @Column(name = "min_quantity")
    private int minQuantity;

    @Column(name = "max_quantity")
    private int maxQuantity;

    private double priceCost;
    private double priceSale;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
