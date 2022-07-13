package com.example.calculator.model;

import com.example.calculator.exception.CalculatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        assertEquals(2, calculator.sum(1D, 1D), 0);
        assertEquals(1.42, calculator.sum(3.14, -1.72), 0.001);
        assertEquals(2.0/3, calculator.sum(1.0/3, 1.0/3), 0.001);
    }

    @Test
    public void numbersNullSumTest() {
        CalculatorException exception1 = assertThrows(CalculatorException.class, () -> {
            calculator.sum(null, 1D);
        }, "Era esperado um CalculatorException");

        CalculatorException exception2 = assertThrows(CalculatorException.class, () -> {
            calculator.sum(1D, null);
        }, "Era esperado um CalculatorException");

        CalculatorException exception3 = assertThrows(CalculatorException.class, () -> {
            calculator.sum(null, null);
        }, "Era esperado um CalculatorException");

        assertEquals("Número 1 e número 2 são obrigatórios.", exception1.getMessage());
        assertEquals("Número 1 e número 2 são obrigatórios.", exception2.getMessage());
        assertEquals("Número 1 e número 2 são obrigatórios.", exception3.getMessage());
    }

    @Test
    void subTest() {
        assertEquals(0, calculator.sub(1D, 1D), 0);
        assertEquals(4.86, calculator.sub(3.14, -1.72), 0.001);
        assertEquals(2.0/3, calculator.sub(1.0/3, -1.0/3), 0.001);
    }

    @Test
    public void numbersNullSubTest() {
        CalculatorException exception1 = assertThrows(CalculatorException.class, () -> {
            calculator.sub(null, 1D);
        }, "Era esperado um CalculatorException");

        CalculatorException exception2 = assertThrows(CalculatorException.class, () -> {
            calculator.sub(1D, null);
        }, "Era esperado um CalculatorException");

        CalculatorException exception3 = assertThrows(CalculatorException.class, () -> {
            calculator.sub(null, null);
        }, "Era esperado um CalculatorException");

        assertEquals("Número 1 e número 2 são obrigatórios.", exception1.getMessage());
        assertEquals("Número 1 e número 2 são obrigatórios.", exception2.getMessage());
        assertEquals("Número 1 e número 2 são obrigatórios.", exception3.getMessage());
    }

    @Test
    void divideTest() {
        assertEquals(2, calculator.divide(4D, 2D), 0);
        assertEquals(-1.826, calculator.divide(3.14, -1.72), 0.001);
        assertEquals(1, calculator.divide(1.0/3, 1.0/3), 0);
    }

    @Test
    public void numbersNullDivideTest() {
        CalculatorException exception1 = assertThrows(CalculatorException.class, () -> {
            calculator.divide(null, 1D);
        }, "Era esperado um CalculatorException");

        CalculatorException exception2 = assertThrows(CalculatorException.class, () -> {
            calculator.divide(1D, null);
        }, "Era esperado um CalculatorException");

        CalculatorException exception3 = assertThrows(CalculatorException.class, () -> {
            calculator.divide(null, null);
        }, "Era esperado um CalculatorException");

        assertEquals("Número 1 e número 2 são obrigatórios.", exception1.getMessage());
        assertEquals("Número 1 e número 2 são obrigatórios.", exception2.getMessage());
        assertEquals("Número 1 e número 2 são obrigatórios.", exception3.getMessage());
    }

    @Test
    public void divisionByZeroTest() {
        CalculatorException exception = assertThrows(CalculatorException.class, () -> {
            calculator.divide(2D, 0D);
        }, "Era esperado um CalculatorException");

        assertEquals("Divisão por zero não é permitido.", exception.getMessage());
    }

    @Test
    void multiplyTest() {
        assertEquals(2, calculator.multiply(1D, 2D), 0);
        assertEquals(-5.4008, calculator.multiply(3.14, -1.72), 0.001);
        assertEquals(0.111, calculator.multiply(1.0/3, 1.0/3), 0.001);
    }

    @Test
    public void numbersNullMultiplyTest() {
        CalculatorException exception1 = assertThrows(CalculatorException.class, () -> {
            calculator.multiply(null, 1D);
        }, "Era esperado um CalculatorException");

        CalculatorException exception2 = assertThrows(CalculatorException.class, () -> {
            calculator.multiply(1D, null);
        }, "Era esperado um CalculatorException");

        CalculatorException exception3 = assertThrows(CalculatorException.class, () -> {
            calculator.multiply(null, null);
        }, "Era esperado um CalculatorException");

        assertEquals("Número 1 e número 2 são obrigatórios.", exception1.getMessage());
        assertEquals("Número 1 e número 2 são obrigatórios.", exception2.getMessage());
        assertEquals("Número 1 e número 2 são obrigatórios.", exception3.getMessage());
    }

    @Test
    void factorialTest() {
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(720, calculator.factorial(6));
    }

    @Test
    void numberNullFactorialTest() {
        CalculatorException exception = assertThrows(CalculatorException.class, () -> {
            calculator.factorial(null);
        }, "Era esperado um CalculatorException");

        assertEquals("Número é obrigatório.", exception.getMessage());
    }

    @Test
    void numberNegativeFactorialTest() {
        CalculatorException exception = assertThrows(CalculatorException.class, () -> {
            calculator.factorial(-1);
        }, "Era esperado um CalculatorException");

        assertEquals("Não existe fatorial para números negativos.", exception.getMessage());
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(1, calculator.integerToBinary(1));
        assertEquals(101, calculator.integerToBinary(5));
        assertEquals(10100, calculator.integerToBinary(20));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("1", calculator.integerToHexadecimal(1));
        assertEquals("1E", calculator.integerToHexadecimal(30));
        assertEquals("AA", calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);

        assertEquals(14, calculator.calculeDayBetweenDate(date1, date2));
    }

}
