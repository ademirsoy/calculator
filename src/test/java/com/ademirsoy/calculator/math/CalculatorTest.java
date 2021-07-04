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
        BigDecimal result = calculator.calculate(sign, operand1, operand2);

        //THEN
        assertEquals(new BigDecimal("31.0"), result);
    }

    @Test
    void calculate_shouldAddNumbers_whenMultipleAdditionOperation() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("10.5");
        BigDecimal operand2 = new BigDecimal("20.5");
        BigDecimal operand3 = new BigDecimal("5");
        String sign = Operator.ADDITION.getSign();

        //WHEN
        BigDecimal result = calculator.calculate(sign, operand1, operand2, operand3);

        //THEN
        assertEquals(new BigDecimal("36.0"), result);
    }

    @Test
    void calculate_shouldSubtractNumbers_whenSubtractionOperation() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("10.5");
        BigDecimal operand2 = new BigDecimal("20.5");
        String sign = Operator.SUBTRACTION.getSign();

        //WHEN
        BigDecimal result = calculator.calculate(sign, operand1, operand2);

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
        BigDecimal result = calculator.calculate(sign, operand1, operand2);

        //THEN
        assertEquals(new BigDecimal("15"), result);
    }

    @Test
    void calculate_shouldMultiplyNumbers_whenMultipleMultiplicationOperation() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("5");
        BigDecimal operand2 = new BigDecimal("3");
        BigDecimal operand3 = new BigDecimal("10");
        String sign = Operator.MULTIPLICATION.getSign();

        //WHEN
        BigDecimal result = calculator.calculate(sign, operand1, operand2, operand3);

        //THEN
        assertEquals(new BigDecimal("150"), result);
    }

    @Test
    void calculate_shouldDivideNumbers_whenDivisionOperation() {
        //GIVEN
        BigDecimal operand1 = new BigDecimal("10");
        BigDecimal operand2 = new BigDecimal("2");
        String sign = Operator.DIVISION.getSign();

        //WHEN
        BigDecimal result = calculator.calculate(sign, operand1, operand2);

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
        BigDecimal result = calculator.calculate(sign, operand1, operand2);

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
            calculator.calculate(unsupportedSign, operand1, operand2);
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
            calculator.calculate(sign, operand1, operand2);
        });
    }

    @Test
    void calculate_shouldThrowException_whenNoOperandGiven() {
        //GIVEN
        String sign = Operator.DIVISION.getSign();

        //WHEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(sign);
        });
    }
}
