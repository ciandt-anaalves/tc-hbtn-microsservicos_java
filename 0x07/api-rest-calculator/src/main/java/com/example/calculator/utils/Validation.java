package com.example.calculator.utils;

public class Validation {

    public boolean doubleIsNull(Double number) {
        return number == null;
    }

    public boolean intIsNull(Integer number) {
        return number == null;
    }

    public boolean isZero(Double number) {
        return number == 0.0;
    }

    public boolean isNegative(Integer number) {
        return number < 0;
    }

}
