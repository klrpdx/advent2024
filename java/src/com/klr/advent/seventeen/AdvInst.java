package com.klr.advent.seventeen;

public class AdvInst {

    private final Memory memory;

    public AdvInst(Memory memory) {
        this.memory = memory;
    }


    public Integer process(Operand operand) {
        return (int) (memory.getRegisterA() / Math.pow(2, operand.getComboValue()));
    }
}
