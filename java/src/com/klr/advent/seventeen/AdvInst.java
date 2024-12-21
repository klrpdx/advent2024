package com.klr.advent.seventeen;

public class AdvInst {

    private final Register registerA;

    public AdvInst(Register registerA) {
        this.registerA = registerA;
    }


    public Integer process(Operand operand) {
        return (int) (registerA.getValue() / Math.pow(2, operand.getComboValue()));
    }
}
