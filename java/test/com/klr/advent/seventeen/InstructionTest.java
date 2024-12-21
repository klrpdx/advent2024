package com.klr.advent.seventeen;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionTest {

    @Test
    void advInstruction() {
        Register registerA = new Register();
        registerA.setValue(1000);
        AdvInst adv = new AdvInst(registerA);
        Operand operand = new Operand(registerA, null, null);
        operand.setValue(3);
        Integer actual = adv.process(operand);
        assertEquals(125, actual);
    }

    @Test
    void advTruncation() {
        Register registerA = new Register();
        registerA.setValue(1000);
        Register registerC = new Register();
        registerC.setValue(2);
        AdvInst adv = new AdvInst(registerA);
        Operand operand = new Operand(registerA, null, registerC);
        operand.setValue(6);
        Integer actual = adv.process(operand);
        assertEquals(250, actual);
    }

    @Test
    void bxlInstruction() {
        Register registerb = new Register();
        registerb.setValue(236);
        BxlInstruction bxl = new BxlInstruction(registerb);

        Operand operand = new Operand(null, registerb, null);
        operand.setValue(4);
        bxl.process(operand);
        assertEquals(232, registerb.getValue());
    }

    @Test
    void bstInstruction() {
        Register registerb = new Register();
        registerb.setValue(236);
        Register registerC = new Register();
        registerC.setValue(2);

        BstInstruction bst = new BstInstruction(registerb);

        Operand operand = new Operand(null, registerb, registerC);
        operand.setValue(6);
        bst.process(operand);
        assertEquals(2, registerb.getValue());
    }


}
