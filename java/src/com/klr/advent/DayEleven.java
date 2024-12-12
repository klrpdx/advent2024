package com.klr.advent;

import com.klr.advent.util.FileLoader;

import java.util.ArrayList;
import java.util.List;

public class DayEleven {



    private boolean rule1(long stone) {
        return stone == 0;
    }

    private boolean rule2(long stone) {
        String digits = String.valueOf(stone);
        return digits.length() % 2 == 0;
    }

    public List<Long> applyRule1(long stone) {
        List<Long> newStones = new ArrayList<>();
        if (stone == 0) {
            newStones.add(1L);
        }
        return newStones;
    }

    public List<Long> applyRule2(long stone) {
        List<Long> newStones = new ArrayList<>();
        if (rule2(stone)) {
            String digits = String.valueOf(stone);
            Long half = Long.valueOf(digits.substring(0, digits.length() / 2));
            Long otherHalf = Long.valueOf(digits.substring(digits.length() / 2));
            newStones.add(half);
            newStones.add(otherHalf);
        }
        return newStones;
    }

    public List<Long> applyRule3(long stone) {
        List<Long> newStones = new ArrayList<>();
        if (!rule1(stone) && !rule2(stone)) {
            newStones.add(stone * 2024L);
        }
        return newStones;
    }

    public long solve() throws Exception {
        return 0;
    }

    public List<Long> blink(List<Long> stones) {
        List<Long> newStones = new ArrayList<>();
        for (Long stone : stones) {
            newStones.addAll(applyRule1(stone));
            newStones.addAll(applyRule2(stone));
            newStones.addAll(applyRule3(stone));
        }
        return newStones;
    }

    public static void main(String[] args) throws Exception {
        DayEleven solution = new DayEleven();
        String input = "965842 9159 3372473 311 0 6 86213 48";
        String[] numbers = input.split(" ");
        long count = 0L;
        for (String number : numbers) {
            List<Long> stones = new ArrayList<>();
            stones.add(Long.parseLong(number));
            for (int blink=0;blink<75;blink++) {
                stones = solution.blink(stones);
            }
            count += stones.size();
        }

        System.out.println("Solution part 2: " + count);
    }


}
