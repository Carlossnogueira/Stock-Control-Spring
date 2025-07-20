package com.github.carlossnogueira.stock_control.useCase.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.carlossnogueira.stock_control.dto.CategoryDTO;
import com.github.carlossnogueira.stock_control.exception.StockControl.StockControl;
import com.github.carlossnogueira.stock_control.model.ProductCategory;
import com.github.carlossnogueira.stock_control.repository.CategoryRepository;

@Service
public class RegisterCategoryUseCase {

    @Autowired
    public CategoryRepository categoryRepository;

    public void execute(CategoryDTO category) {
        this.categoryRepository.findByName(category.getName()).ifPresent((user) ->{
            throw new StockControl("Name", "Category already exists.");
        });

        var Category = new ProductCategory();
        Category.setName(category.getName());

        this.categoryRepository.save(Category);
    }

}
