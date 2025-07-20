package com.github.carlossnogueira.stock_control.model;

import com.github.carlossnogueira.stock_control.model.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name can't be blank.")
    @Length(min = 6, max = 60, message = "Use your full name.")
    private String name;

    @Email(message = "Email is required.")
    private String email;

    @Length(min = 6, max = 12, message = "Password need to be more than 6 characters.")
    private String password;

    private UserRole userRole;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
