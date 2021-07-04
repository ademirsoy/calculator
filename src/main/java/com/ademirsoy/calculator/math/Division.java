package com.ademirsoy.calculator.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division implements Calculation {

    @Override
    public BigDecimal calculate(BigDecimal... operands) {
        return operands[0].divide(operands[1], 2, RoundingMode.HALF_EVEN);
    }
}
