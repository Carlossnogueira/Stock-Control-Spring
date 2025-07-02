package com.github.carlossnogueira.stock_control.controller;

import com.github.carlossnogueira.stock_control.dto.UserDTO;
import com.github.carlossnogueira.stock_control.exception.User.UserAlreadyExists;
import com.github.carlossnogueira.stock_control.model.User;
import com.github.carlossnogueira.stock_control.model.enums.UserRole;
import com.github.carlossnogueira.stock_control.repository.UserRepository;
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
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> createUser (@Valid @RequestBody UserDTO userRequest){
       this.userRepository.findByEmail(userRequest.getEmail())
               .ifPresent((user)->{
                    throw new UserAlreadyExists();
               });

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setUserRole(UserRole.EMPLOYEE);

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }
}
