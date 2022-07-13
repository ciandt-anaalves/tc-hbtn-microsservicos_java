package com.example.calculator.model;

import com.example.calculator.exception.CalculatorException;
import com.example.calculator.utils.Validation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {

    Validation validation = new Validation();

    public Double sum(Double number1, Double number2) {
        if (validation.doubleIsNull(number1) || validation.doubleIsNull(number2)) {
            throw new CalculatorException("Número 1 e número 2 são obrigatórios.");
        }

        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if (validation.doubleIsNull(number1) || validation.doubleIsNull(number2)) {
            throw new CalculatorException("Número 1 e número 2 são obrigatórios.");
        }

        System.out.println(number1 - number2);
        return number1 - number2;
    }

    public Double divide (Double number1, Double number2)  {
        if (validation.doubleIsNull(number1) || validation.doubleIsNull(number2)) {
            throw new CalculatorException("Número 1 e número 2 são obrigatórios.");
        }

        if (validation.isZero(number2)) {
            throw new CalculatorException("Divisão por zero não é permitido.");
        }

        return number1 / number2;
    }

    public Double multiply(Double number1, Double number2)  {
        if (validation.doubleIsNull(number1) || validation.doubleIsNull(number2)) {
            throw new CalculatorException("Número 1 e número 2 são obrigatórios.");
        }

        return number1 * number2;
    }

    public Integer factorial(Integer factorial) {
        if (validation.intIsNull(factorial)) {
            throw new CalculatorException("Número é obrigatório.");
        }

        if (validation.isNegative(factorial)) {
            throw new CalculatorException("Não existe fatorial para números negativos.");
        }

        int result = 1;

        for (int i = 1; i <= factorial; i++) {
                result *= i;
        }

        return result;
    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
        return Integer.parseInt(Integer.toBinaryString(integer));
    }

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 5 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer).toUpperCase();
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        return (int) ChronoUnit.DAYS.between(date1, date2);
    }

}