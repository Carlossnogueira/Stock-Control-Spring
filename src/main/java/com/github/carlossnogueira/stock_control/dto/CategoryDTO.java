package com.github.carlossnogueira.stock_control.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {
    
    @NotBlank(message = "Category name can't be blank.")
    @Length(min = 1, max = 30, message = "Category can be between 1 and 30 characters.")
    public String name;
}
