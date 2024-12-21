package com.klr.advent.seventeen;

public class BstInstruction {

    private final Memory memory ;


    public BstInstruction(Memory mem) {
        this.memory = mem;
    }

    public Integer process(Operand operand) {
        memory.setRegisterB(operand.getComboValue() % 8);
        return memory.getRegisterB();
    }
}
