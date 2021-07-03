package com.ademirsoy.calculator.math;


import com.ademirsoy.calculator.exception.InvalidOperatorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void calculate_shouldAddNumbers_whenAdditionOperation() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("10.5");
        BigDecimal operand2 = new BigDecimal("20.5");
        String sign = Operator.ADDITION.getSign();

        //WHEN
        BigDecimal result = calculator.calculate(operand1, operand2, sign);

        //THEN
        assertEquals(new BigDecimal("31.0"), result);
    }

    @Test
    void calculate_shouldSubtractNumbers_whenSubtractionOperation() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("10.5");
        BigDecimal operand2 = new BigDecimal("20.5");
        String sign = Operator.SUBTRACTION.getSign();

        //WHEN
        BigDecimal result = calculator.calculate(operand1, operand2, sign);

        //THEN
        assertEquals(new BigDecimal("-10.0"), result);
    }

    @Test
    void calculate_shouldMultiplyNumbers_whenMultiplicationOperation() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("5");
        BigDecimal operand2 = new BigDecimal("3");
        String sign = Operator.MULTIPLICATION.getSign();

        //WHEN
        BigDecimal result = calculator.calculate(operand1, operand2, sign);

        //THEN
        assertEquals(new BigDecimal("15"), result);
    }

    @Test
    void calculate_shouldDivideNumbers_whenDivisionOperation() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("2");
        String sign = Operator.DIVISION.getSign();

        //WHEN
        BigDecimal result = calculator.calculate(operand1, operand2, sign);

        //THEN
        assertEquals(new BigDecimal("5.00"), result);
    }

    @Test
    void calculate_shouldDivideNumbersAndRound_whenDivisionOperation() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("3");
        String sign = Operator.DIVISION.getSign();

        //WHEN
        BigDecimal result = calculator.calculate(operand1, operand2, sign);

        //THEN
        assertEquals(new BigDecimal("3.33"), result);
    }

    @Test
    void calculate_shouldThrowException_whenOperatorNotSupported() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("3");
        String unsupportedSign = "%";

        //WHEN
        Assertions.assertThrows(InvalidOperatorException.class, () -> {
            calculator.calculate(operand1, operand2, unsupportedSign);
        });
    }

    @Test
    void calculate_shouldThrowException_whenDivisionByZero() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("0");
        String sign = Operator.DIVISION.getSign();

        //WHEN
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(operand1, operand2, sign);
        });
    }
}
