package com.klr.advent.seventeen;

public class AdvInst {

    private final RegisterA registerA;

    public AdvInst(RegisterA registerA) {
        this.registerA = registerA;
    }


    public Integer process(int comboOp) {
        return registerA.getValue()/comboOp;
    }
}
