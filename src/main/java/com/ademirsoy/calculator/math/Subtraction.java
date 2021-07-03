package com.ademirsoy.calculator.math;

import java.math.BigDecimal;

public class Subtraction implements Calculation {

    @Override
    public BigDecimal calculate(BigDecimal operand1, BigDecimal operand2) {
        return operand1.subtract(operand2);
    }
}
