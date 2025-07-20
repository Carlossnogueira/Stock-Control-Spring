package com.github.carlossnogueira.stock_control.useCase.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.carlossnogueira.stock_control.dto.UserDTO;
import com.github.carlossnogueira.stock_control.exception.User.UserAlreadyExistsException;
import com.github.carlossnogueira.stock_control.model.User;
import com.github.carlossnogueira.stock_control.model.enums.UserRole;
import com.github.carlossnogueira.stock_control.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class RegisterUserUserCase {
    
   @Autowired
    private UserRepository userRepository;

    public void execute(@Valid UserDTO userRequest){
       
        this.userRepository.findByEmail(userRequest.getEmail())
               .ifPresent((user)->{
                    throw new UserAlreadyExistsException();
               });


        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setUserRole(UserRole.EMPLOYEE);

        this.userRepository.save(user);
    }

}
