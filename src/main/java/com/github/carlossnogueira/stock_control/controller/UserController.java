package com.github.carlossnogueira.stock_control.controller;

import com.github.carlossnogueira.stock_control.dto.UserDTO;
import com.github.carlossnogueira.stock_control.useCase.User.RegisterUserUserCase;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RegisterUserUserCase registerUserUserCase;

    @PostMapping("/register")
    public ResponseEntity<String> createUser (@Valid @RequestBody UserDTO userRequest){
       
        this.registerUserUserCase.execute(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }
}
