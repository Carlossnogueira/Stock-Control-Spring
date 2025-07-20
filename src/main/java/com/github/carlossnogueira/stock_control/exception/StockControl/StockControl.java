package com.github.carlossnogueira.stock_control.exception.StockControl;

public class StockControl extends RuntimeException {

    public final String fiel;

    public StockControl(String field, String message ){
        super(message);
        this.fiel = field;
    }

    public String getField() {
        return this.fiel;
    }
    

}
