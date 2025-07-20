package com.github.carlossnogueira.stock_control.controller;

import org.springframework.web.bind.annotation.RestController;

import com.github.carlossnogueira.stock_control.dto.CategoryDTO;
import com.github.carlossnogueira.stock_control.useCase.Category.RegisterCategoryUseCase;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private RegisterCategoryUseCase registerCategoryUseCase;

    @PostMapping()
    public ResponseEntity<String> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        registerCategoryUseCase.execute(categoryDTO);
        

        return ResponseEntity.status(HttpStatus.CREATED).body("Category created!");
    }
    
}
