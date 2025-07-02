package com.github.carlossnogueira.stock_control.controller;

import com.github.carlossnogueira.stock_control.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/register")
    public void createUser (@Valid @RequestBody UserDTO userRequest){
        System.out.println("Creating user: " + userRequest);
    }
}
