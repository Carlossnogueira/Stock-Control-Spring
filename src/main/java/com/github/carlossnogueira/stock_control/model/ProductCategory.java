package com.github.carlossnogueira.stock_control.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Entity(name = "categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Category name can't be empty.")
    @Length(min = 6, max = 12, message = "Password need to be more than 6 characters.")
    @Pattern(regexp = "\\S+", message = "Don't use spaces in category name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
