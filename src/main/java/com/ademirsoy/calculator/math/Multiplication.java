package com.ademirsoy.calculator.math;

import java.math.BigDecimal;

public class Multiplication implements Calculation {

    @Override
    public BigDecimal calculate(BigDecimal... operands) {
        BigDecimal total = BigDecimal.ONE;
        for (BigDecimal operand : operands) {
            total = total.multiply(operand);
        }
        return total;
    }
}
