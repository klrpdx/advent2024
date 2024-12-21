package com.klr.advent.seventeen;

public class JnzInstruction {
    private final Memory memory;

    public JnzInstruction(Memory mem) {
        this.memory = mem;
    }

    public Integer process(Operand operand) {
        if (memory.getRegisterA() != 0) {
            memory.setInstructionPointer(operand.getValue());
        }
        return memory.getInstructionPointer();
    }
}
