package com.github.carlossnogueira.stock_control.exception.User;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(){
        super("Username already exists");
    }
}
