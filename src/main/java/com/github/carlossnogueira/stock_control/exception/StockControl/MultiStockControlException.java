package com.github.carlossnogueira.stock_control.exception.StockControl;

import java.util.Map;

public class MultiStockControlException extends RuntimeException {
    private final Map<String, String> errors;

    public MultiStockControlException(Map<String, String> errors) {
        super("One or more erros finded.");
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
