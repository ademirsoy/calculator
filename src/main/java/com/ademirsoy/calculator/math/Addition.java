package com.ademirsoy.calculator.math;

import java.math.BigDecimal;

public class Addition implements Calculation {

    @Override
    public BigDecimal calculate(BigDecimal... operands) {
        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal operand : operands) {
            total = total.add(operand);
        }
        return total;
    }
}
