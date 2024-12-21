package com.klr.advent.seventeen;

public class Memory {

    private Integer registerA = 0;
    private Integer registerB = 0;
    private Integer registerC = 0;
    private Integer instructionPointer = 0;

    public Memory() {

    }

    public Integer getRegisterA() {
        return registerA;
    }

    public void setRegisterA(int value) {
        this.registerA = value;
    }
    public Integer getRegisterB() {
        return registerB;
    }
    public void setRegisterB(int value) {
        this.registerB = value;
    }

    public Integer getRegisterC() {
        return registerC;
    }

    public void setRegisterC(int value) {
        this.registerC = value;
    }

    public Integer getInstructionPointer() {
        return instructionPointer;
    }

    public void setInstructionPointer(int value) {
        this.instructionPointer = value;
    }
}
