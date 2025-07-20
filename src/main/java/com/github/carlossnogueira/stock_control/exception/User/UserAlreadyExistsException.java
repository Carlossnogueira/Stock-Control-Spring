package com.github.carlossnogueira.stock_control.exception.User;

import com.github.carlossnogueira.stock_control.exception.StockControl.StockControl;

public class UserAlreadyExistsException extends StockControl{

    public UserAlreadyExistsException() {
        super("Email $ Password", "User Already Exists.");
    }
}