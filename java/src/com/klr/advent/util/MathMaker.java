package com.klr.advent.util;

import java.util.Arrays;
import java.util.List;

public class MathMaker {

    private final long result;
    private final List<Long> operands;

    public MathMaker(String numbersString) {
        result = Long.parseLong(numbersString.split(":")[0]);
        String operandString = numbersString.split(":")[1];
        String[] stringOperands = operandString.trim().split(" ");
        operands =  Arrays.stream(stringOperands).map(Long::parseLong).toList();
    }

    public long getTargetResult() {
        return result;
    }

    public List<Long> getOperands() {
        return operands;
    }

    private boolean solve(long result, List<Long> operands) {
        if (operands.size() == 2) {
            return operands.get(0) + operands.get(1) == result
                    || operands.get(0) * operands.get(1) == result;
        }

        long num = operands.getLast();
        long newResultAdd = result - num;
        long newResultMult = result % num == 0 ? result / num : 0;
        return solve(newResultAdd, operands.subList(0, operands.size()-1)) || solve(newResultMult, operands.subList(0, operands.size()-1));
    }


    public boolean isSolvable() {
        return solve(result, operands);
    }
}
