package com.github.carlossnogueira.stock_control.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDTO {

    @NotBlank(message = "Name can't be blank.")
    @Length(min = 6, max = 60, message = "Use your full name.")
    private String name;

    @Length(min = 6, max = 12, message = "Password need to be more than 6 characters.")
    private String password;

    @Email(message = "Email is required.")
    private String email;
    
}
