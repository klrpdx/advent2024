package com.klr.advent.seventeen;

public class BxlInstruction {

    private final Memory memory ;

    public BxlInstruction(Memory mem) {
        this.memory = mem;
    }

    public Integer process(Operand operand) {
        int operandValue = operand.getValue();
        int bitwise = memory.getRegisterB() ^ operandValue;
        memory.setRegisterB(bitwise);
        return memory.getRegisterB();
    }
}
