package com.ademirsoy.calculator.math;

import com.ademirsoy.calculator.exception.InvalidOperatorException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Calculation> supportedOperations;

    public Calculator() {
        this.supportedOperations = new HashMap<>();
        this.supportedOperations.put(Operator.ADDITION.getSign(), new Addition());
        this.supportedOperations.put(Operator.SUBTRACTION.getSign(), new Subtraction());
        this.supportedOperations.put(Operator.DIVISION.getSign(), new Division());
        this.supportedOperations.put(Operator.MULTIPLICATION.getSign(), new Multiplication());
    }

    public BigDecimal calculate(BigDecimal operand1, BigDecimal operand2, String operator) {
        Calculation calculation = this.supportedOperations.get(operator);
        if (calculation == null) {
            throw new InvalidOperatorException("Unsupported operator: " + operator + ". Supported operators are: " +
                    this.supportedOperations.keySet().toString());
        }
        return calculation.calculate(operand1, operand2);
    }
}
