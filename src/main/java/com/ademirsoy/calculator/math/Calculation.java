package com.ademirsoy.calculator.math;

import java.math.BigDecimal;

@FunctionalInterface
public interface Calculation {

    BigDecimal calculate(BigDecimal operand1, BigDecimal operand2);
}
