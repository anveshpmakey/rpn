package com.mak.rpn;

public class RPNInstruction {

    Operator operator;
    Double value;

    public RPNInstruction(Operator operator, Double value) {
        this.operator = operator;
        this.value = value;
    }

    public String getReverseInstruction() throws RPNException {
        if (operator.getNumOfOperators() < 1)
            throw new RPNException(String.format("invalid operation for operator %s", operator.getSymbol()));

        return (operator.getNumOfOperators() < 2) ?
                String.format("%s", operator.getReverseOperation()) :
                String.format("%f %s %f", value, operator.getReverseOperation(), value);
    }
}
