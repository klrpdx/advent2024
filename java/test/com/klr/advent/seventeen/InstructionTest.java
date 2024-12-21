package com.klr.advent.seventeen;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionTest {

    @Test
    void advInstruction() {
        RegisterA registerA = new RegisterA();
        registerA.setValue(1000);
        AdvInst adv = new AdvInst(registerA);
        Integer actual = adv.process(3);
        assertEquals(333, actual);
    }

    @Test
    void advTruncation() {
        RegisterA registerA = new RegisterA();
        registerA.setValue(1000);
        AdvInst adv = new AdvInst(registerA);
        Integer actual = adv.process(7);
        assertEquals(142, actual);
    }

    @Test
    void advRegAIsReference() {
        RegisterA regA = new RegisterA();
        regA.setValue(1000);
        AdvInst adv = new AdvInst(regA);
        Integer actual = adv.process(7);
        assertEquals(142, actual);

        regA.setValue(777);
        actual = adv.process(7);
        assertEquals(111, actual);
    }




    //2. Combo object needed and is passed in instead of int



}
