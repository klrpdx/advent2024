package com.klr.advent.util;

import java.util.Arrays;
import java.util.List;

public class MathMaker {

    private final int result;
    private final List<Integer> operands;

    public MathMaker(String numbersString) {
        result = Integer.parseInt(numbersString.split(":")[0]);
        String operandString = numbersString.split(":")[1];
        String[] stringOperands = operandString.trim().split(" ");
        operands =  Arrays.stream(stringOperands).map(Integer::parseInt).toList();
    }

    public int getTargetResult() {
        return result;
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public boolean isSolvable() {
        return true;
    }
}
