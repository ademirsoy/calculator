package com.ademirsoy.calculator.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division implements Calculation {

    @Override
    public BigDecimal calculate(BigDecimal operand1, BigDecimal operand2) {
        return operand1.divide(operand2, 2, RoundingMode.HALF_EVEN);
    }
}
