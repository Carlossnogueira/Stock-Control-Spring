package com.github.carlossnogueira.stock_control.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Map;

import com.github.carlossnogueira.stock_control.exception.StockControl.MultiStockControlException;

@ControllerAdvice
public class HandleMultiStockControlException {

    @ExceptionHandler(MultiStockControlException.class)
    public ResponseEntity<Map<String, String>> handleMultiBusinessException(MultiStockControlException ex) {
        return new ResponseEntity<>(ex.getErrors(), HttpStatus.BAD_REQUEST);
    }

}
