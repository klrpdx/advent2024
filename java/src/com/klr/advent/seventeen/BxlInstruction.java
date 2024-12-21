package com.klr.advent.seventeen;

public class BxlInstruction {

    private final Register registerb;

    public BxlInstruction(Register registerb) {
        this.registerb = registerb;
    }

    public Integer process(Operand operand) {
        int operandValue = operand.getValue();
        int bitwise = registerb.getValue() ^ operandValue;
        registerb.setValue(bitwise);
        return registerb.getValue();
    }
}
