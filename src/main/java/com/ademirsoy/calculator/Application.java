package com.ademirsoy.calculator;

import com.ademirsoy.calculator.math.Calculator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to the calculator. Please enter a valid expression");
        Calculator calculator = new Calculator();
        ExpressionParser expressionParser = new ExpressionParser(calculator);
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            try {
                String line = in.nextLine();
                String result = expressionParser.calculateExpression(line);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
