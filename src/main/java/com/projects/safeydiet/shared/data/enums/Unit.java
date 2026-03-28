package com.projects.safeydiet.shared.data.enums;

public enum Unit {
    GRAM("g"),
    KILOGRAM("kg"),
    MILLILITER("mL"),
    LITER("L");

    private final String symbol;

    Unit(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }
}
