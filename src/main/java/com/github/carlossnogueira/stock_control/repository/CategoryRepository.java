package com.github.carlossnogueira.stock_control.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.carlossnogueira.stock_control.model.ProductCategory;


public interface CategoryRepository extends JpaRepository<ProductCategory, Integer> {
    Optional<ProductCategory> findByName(String name);
    
}
