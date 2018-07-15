package com.mak.rpn;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.Stack;

public class Calculator {

    static String command;
    static boolean newCommand = false;

    public static void main(String[] args) {

        Console console = System.console();
        if (console == null) {
            System.err.println("Console not available.");
            System.exit(1);
        }

        RPNCalculator rpnCalculator = new RPNCalculator();

        System.out.println("Enter expression, or 'exit' to quit");

        boolean keepRunning = true;
        while (keepRunning) {
            String inputString = console.readLine(": ");
            if ("exit".equals(inputString)) {
                keepRunning = false;
            } else {
                try {
                    rpnCalculator.eval(inputString);
                } catch (RPNException e) {
                    System.out.println(e.getMessage());
                }

                DecimalFormat fmt = new DecimalFormat("0.##########");
                Stack<Double> stack = rpnCalculator.getValuesStack();
                System.out.print("Stack: ");
                for (Double value : stack) {
                    System.out.print(fmt.format(value));
                    System.out.print(" ");
                }
                System.out.printf("%n");
            }
        }
    }
}
