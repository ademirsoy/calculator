package com.ademirsoy.calculator.math;

import com.ademirsoy.calculator.exception.InvalidOperatorException;

public enum Operator {
    //NOTE: BODMAS rule for precedence
    DIVISION("/", 1),
    MULTIPLICATION("*", 1),
    ADDITION("+", 2),
    SUBTRACTION("-", 2);

    private final int precedence;
    private final String sign;

    Operator(String sign, int precedence) {
        this.sign = sign;
        this.precedence = precedence;
    }

    public static int getPrecedence(String sign) {
        switch (sign) {
            case "/":
                return DIVISION.precedence;
            case "*":
                return MULTIPLICATION.precedence;
            case "+":
                return ADDITION.precedence;
            case "-":
                return SUBTRACTION.precedence;
            default:
                throw new InvalidOperatorException("Unexpected operator: " + sign);
        }
    }

    public int getPrecedence() {
        return precedence;
    }

    public String getSign() {
        return sign;
    }
}
