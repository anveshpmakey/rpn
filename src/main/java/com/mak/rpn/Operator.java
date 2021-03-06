package com.mak.rpn;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public enum Operator {

    ADDITION("+", "-", 2) {
        public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
            return secondOperand + firstOperand;
        }
    },

    SUBTRACTION("-", "+", 2) {
        public Double calculate(Double firstOperand, Double secondOperand) {
            return secondOperand - firstOperand;
        }
    },

    MULTIPLICATION("*", "/", 2) {
        public Double calculate(Double firstOperand, Double secondOperand) {
            return secondOperand * firstOperand;
        }
    },

    DIVISION("/", "*", 2) {
        public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
            if (firstOperand == 0)
                throw new RPNException("Cannot divide by 0.");
            return secondOperand / firstOperand;
        }
    },

    SQUAREROOT("sqrt", "pow", 1) {
        public Double calculate(Double firstOperand, Double secondOperand) {
            return sqrt(firstOperand);
        }
    },

    POWER("pow", "sqrt", 1) {
        public Double calculate(Double firstOperand, Double secondOperand) {
            return pow(firstOperand, 2.0);
        }
    },

    UNDO("undo", null, 0) {
        public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
            throw new RPNException("Invalid operation");
        }
    },

    CLEAR("clear", null, 0) {
        public Double calculate(Double firstOperand, Double secondOperand) throws RPNException {
            throw new RPNException("Invalid operation");
        }
    };
    // using map for a constant lookup cost
    private static final Map<String, Operator> lookup = new HashMap<String, Operator>();

    static {
        for (Operator o : values()) {
            lookup.put(o.getSymbol(), o);
        }
    }

    private String symbol;
    private String reverseOperation;
    private int numOfOperators;

    Operator(String symbol, String reverseOperator, int numOfOperators) {
        this.symbol = symbol;
        this.reverseOperation = reverseOperator;
        this.numOfOperators = numOfOperators;
    }

    public static Operator getEnum(String value) {
        return lookup.get(value);
    }

    public abstract Double calculate(Double firstOperand, Double secondOperand) throws RPNException;

    public String getSymbol() {
        return symbol;
    }

    public String getReverseOperation() {
        return reverseOperation;
    }

    public int getNumOfOperators() {
        return numOfOperators;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
