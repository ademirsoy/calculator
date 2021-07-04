package com.ademirsoy.calculator.math;

import java.math.BigDecimal;

public class Subtraction implements Calculation {

    @Override
    public BigDecimal calculate(BigDecimal... operands) {
        return operands[0].subtract(operands[1]);
    }
}
