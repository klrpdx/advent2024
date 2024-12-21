package com.klr.advent.seventeen;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionTest {

    @Test
    void advInstruction() {
        Memory mem = new Memory();
        mem.setRegisterA(1000);
        AdvInst adv = new AdvInst(mem);
        Operand operand = new Operand(mem);
        operand.setValue(3);
        Integer actual = adv.process(operand);
        assertEquals(125, actual);
    }

    @Test
    void advTruncation() {
        Memory mem = new Memory();
        mem.setRegisterA(1000);
        mem.setRegisterC(2);
        AdvInst adv = new AdvInst(mem);
        Operand operand = new Operand(mem);
        operand.setValue(6);
        Integer actual = adv.process(operand);
        assertEquals(250, actual);
    }

    @Test
    void bxlInstruction() {
        Memory mem = new Memory();
        mem.setRegisterB(236);
        BxlInstruction bxl = new BxlInstruction(mem);

        Operand operand = new Operand(mem);
        operand.setValue(4);
        bxl.process(operand);
        assertEquals(232, mem.getRegisterB());
    }

    @Test
    void bstInstruction() {
        Memory mem = new Memory();
        mem.setRegisterB(236);
        mem.setRegisterC(2);

        BstInstruction bst = new BstInstruction(mem);

        Operand operand = new Operand(mem);
        operand.setValue(6);
        bst.process(operand);
        assertEquals(2, mem.getRegisterB());
    }

    @Test
    void jnzInstruction() {
        Memory mem = new Memory();
        mem.setRegisterA(2);
        mem.setInstructionPointer(7);
        JnzInstruction jnz = new JnzInstruction(mem);
        Operand operand = new Operand(mem);
        operand.setValue(3);
        jnz.process(operand);
        assertEquals(3, mem.getInstructionPointer());
    }

    @Test
    void jnzInstructionA0() {
        Memory mem = new Memory();
        mem.setRegisterA(0);
        JnzInstruction jnz = new JnzInstruction(mem);
        Operand operand = new Operand(mem);
        operand.setValue(3);
        jnz.process(operand);
        assertEquals(0, mem.getInstructionPointer());
    }


}
