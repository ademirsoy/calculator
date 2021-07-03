package com.ademirsoy.calculator;

import com.ademirsoy.calculator.exception.InvalidExpressionException;
import com.ademirsoy.calculator.exception.InvalidOperatorException;
import com.ademirsoy.calculator.math.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionParserTest {

    private final ExpressionParser expressionParser = new ExpressionParser(new Calculator());

    @Test
    void calculateExpression_shouldReturnResult_when2operands() {
        //WHEN
        BigDecimal actual = expressionParser.calculateExpression("4 + 5");

        //THEN
        assertEquals(new BigDecimal("9"), actual);
    }

    @Test
    void calculateExpression_shouldReturnResult_when3operandsWithMultiplication() {
        //WHEN
        BigDecimal actual = expressionParser.calculateExpression("4 + 5 * 2");

        //THEN
        assertEquals(new BigDecimal("14"), actual);
    }

    @Test
    void calculateExpression_shouldReturnResult_when3operandsWithDivision() {
        //WHEN
        BigDecimal actual = expressionParser.calculateExpression("4 - 10 / 2");

        //THEN
        assertEquals(new BigDecimal("-1.00"), actual);
    }

    @Test
    void calculateExpression_shouldReturnResult_when4operandsWithDivisionAndMultiplication() {
        //WHEN
        BigDecimal actual = expressionParser.calculateExpression("25 - 10 / 2 * 5");

        //THEN
        assertEquals(new BigDecimal("0.00"), actual);
    }

    @Test
    void calculateExpression_shouldReturnResult_when4operandsWithMultiplicationAndDivision() {
        //WHEN
        BigDecimal actual = expressionParser.calculateExpression("10 - 2 * 10 / 5");

        //THEN
        assertEquals(new BigDecimal("6.00"), actual);
    }

    @Test
    void calculateExpression_shouldReturnResult_whenMoreThan4operands() {
        //WHEN
        BigDecimal actual = expressionParser.calculateExpression("10 - 2 + 3 * 10 / 5 + 2");

        //THEN
        assertEquals(new BigDecimal("16.00"), actual);
    }

    @Test
    void calculateExpression_shouldThrowException_when1operand() {
        Assertions.assertThrows(InvalidExpressionException.class, () -> {
            expressionParser.calculateExpression("10 +");
        });
    }

    @Test
    void calculateExpression_shouldThrowException_whenInvalidOperator() {
        Assertions.assertThrows(InvalidExpressionException.class, () -> {
            expressionParser.calculateExpression("10 + 5 % 5");
        });
    }

    @Test
    void calculateExpression_shouldThrowException_whenInvalidExpression() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            expressionParser.calculateExpression("10 + 5 a - 5");
        });
    }
}
