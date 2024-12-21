package com.klr.advent.seventeen;

public class BstInstruction {

    private final Register registerb;


    public BstInstruction(Register registerb) {
        this.registerb = registerb;
    }

    public Integer process(Operand operand) {
        registerb.setValue(operand.getComboValue() % 8);
        return registerb.getValue();
    }
}
