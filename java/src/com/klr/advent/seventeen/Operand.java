package com.klr.advent.seventeen;

public class Operand {

    private final Memory memory;
    private int currentValue;

    public Operand(Memory mem) {
        this.memory = mem;
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
            case 4 -> memory.getRegisterA();
            case 5 -> memory.getRegisterB();
            case 6 -> memory.getRegisterC();
            default -> 0;
        };
    }
}
