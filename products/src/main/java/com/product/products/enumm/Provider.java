package com.product.products.enumm;

public enum Provider {
    Арти_Партс("Арти Партс"),
    LadyLux("LadyLux"),
    OBi("OBi"),
    Батькин_Резерв("Батькин Резерв");

    private String displayValue;

    Provider(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}