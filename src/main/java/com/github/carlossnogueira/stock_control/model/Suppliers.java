package com.github.carlossnogueira.stock_control.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity(name = "suppliers")
@Data
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name can't be blank.")
    @Length(min = 6, max = 60, message = "Use full company name.")
    private String name;

    private String cpf;

    private String cnpj;

    @Email
    private String email;

    @NotBlank
    private String phone;
}
