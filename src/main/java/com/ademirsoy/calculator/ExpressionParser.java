package com.ademirsoy.calculator;

import com.ademirsoy.calculator.exception.InvalidExpressionException;
import com.ademirsoy.calculator.math.Calculator;
import com.ademirsoy.calculator.math.Operator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpressionParser {

    private final Calculator calculator;

    public ExpressionParser(Calculator calculator) {
        this.calculator = calculator;
    }

    public BigDecimal calculateExpression(String expression) {
        expression = expression.replaceAll(" ", "");
        Pattern operatorPattern = Pattern.compile("[+, \\-, \\/, *]");
        String[] operands = operatorPattern.split(expression);
        if (operands.length < 2) {
            throw new InvalidExpressionException("Invalid expression! There should be at least 2 operands and one of these operators: [+ - * /]");
        }
        List<BigDecimal> operandList;
        try {
            operandList = Arrays.stream(operands).map(BigDecimal::new).collect(Collectors.toCollection(LinkedList::new));
        } catch (NumberFormatException e) {
            throw new InvalidExpressionException("Invalid expression! Only numbers and these expressions are supported: [+ - * /]");
        }

        Pattern operandPattern = Pattern.compile("[0-9]*\\.?[0-9]+");
        String[] operators = operandPattern.split(expression);
        List<String> operatorList = Arrays
                .stream(operators)
                .filter(o -> o != null && !"".equals(o))
                .collect(Collectors.toList());

        return calculate(operandList, operatorList);
    }

    private BigDecimal calculate(List<BigDecimal> operandList, List<String> operatorList) {

        int i = 0;
        while (operandList.size() > 1) {
            if (i >= operatorList.size()) {
                break;
            }
            if (shouldPerformOperation(operatorList, i)) {
                String operator = operatorList.get(i);
                BigDecimal operand1 = operandList.get(i);
                BigDecimal operand2 = operandList.get(i + 1);
                BigDecimal value = this.calculator.calculate(operator, operand1, operand2);
                operandList.remove(i);
                operatorList.remove(i);
                operandList.set(i, value);
            } else {
                i++;
            }
        }
        if (operandList.size() > 1) {
            return calculate(operandList, operatorList);
        } else {
            return operandList.get(0);
        }
    }

    private boolean shouldPerformOperation(List<String> operatorList, int index) {
        if (index == operatorList.size() - 1) {
            return true;
        }
        String operator = operatorList.get(index);
        String nextOperator = operatorList.get(index + 1);
        return Operator.getPrecedence(operator) <= Operator.getPrecedence(nextOperator);
    }
}
