package com.github.carlossnogueira.stock_control.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.carlossnogueira.stock_control.exception.StockControl.StockControl;

@ControllerAdvice
public class HandleStockControlException {
    @ExceptionHandler(StockControl.class)
    public ResponseEntity<Map<String, String>> handleBusinessException(StockControl ex) {
        Map<String, String> error = new HashMap<>();
        error.put(ex.getField(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
