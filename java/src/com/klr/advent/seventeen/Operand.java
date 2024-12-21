package com.klr.advent.seventeen;

public class Operand {

    private final Register registerA;
    private final Register registerB;
    private final Register registerC;
    private int currentValue;

    public Operand(Register a, Register b, Register c) {
        registerA = a;
        registerB = b;
        registerC = c;
    }

    public void setValue(int value) {
        currentValue = value;
    }

    public int getValue() {
        return currentValue;
    }

    public int getComboValue() {
        return switch (currentValue) {
            case 0, 1, 2, 3 -> currentValue;
            case 4 -> registerA.getValue();
            case 5 -> registerB.getValue();
            case 6 -> registerC.getValue();
            default -> 0;
        };
    }
}
