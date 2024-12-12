package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.Path;

import java.util.*;

public class DayEleven {


    private boolean rule1(long stone) {
        return stone == 0;
    }

    private boolean rule2(long stone) {
        String digits = String.valueOf(stone);
        return digits.length() % 2 == 0;
    }

    public long applyRule1(long stone) {
        if (stone == 0) {
            return 1L;
        }
        return stone;
    }

    public long[] applyRule2(long stone) {
        if (rule2(stone)) {
            String digits = String.valueOf(stone);
            long half = Long.parseLong(digits.substring(0, digits.length() / 2));
            long otherHalf = Long.parseLong(digits.substring(digits.length() / 2));
            return new long[]{half, otherHalf};
        }
        return null;
    }

    public LinkedList<Long> blinky(LinkedList<Long> stones) {
        List<Long> splits = new ArrayList<>();
        int index = 0;
        for (Long stone : stones) {
            if (rule1(stone)) {
                stones.set(index, applyRule1(stone));
            } else if (rule2(stone)) {
                long[] split = applyRule2(stone);
                stones.set(index, split[0]);
                splits.add(split[1]);
            } else {
                stones.set(index, 2024L * stone);
            }
            index++;
        }
        stones.addAll(splits);
        return stones;
    }

    public long blinkyMap(List<Long> start, int blinks) {
        Map<Long, Long> stones = new HashMap<>();
        for (Long stone : start) {
            stones.put(stone, 1L);
        }

        for (int i = 0; i < blinks; i++) {
            Map<Long, Long> stonesNext = new HashMap<>();
            System.out.println("Blink " + i);
            Set<Long> keys = stones.keySet();
            for (Long key : keys) {
                long numberOfStones = stones.get(key);
                if (key == 0L) {
                    long prevAmount = stonesNext.get(1L) == null ? 0L : stonesNext.get(1L);
                    stonesNext.put(1L, prevAmount+numberOfStones);
                } else if (rule2(key)) {
                    long[] newStones = applyRule2(key);
                    long prevAmount1 = stonesNext.get(newStones[0]) == null ? 0L : stonesNext.get(newStones[0]);
                    stonesNext.put(newStones[0], prevAmount1+numberOfStones);
                    long prevAmount2 = stonesNext.get(newStones[1]) == null ? 0L : stonesNext.get(newStones[1]);
                    stonesNext.put(newStones[1], prevAmount2+numberOfStones);
                } else {
                    long mult = key*2024L;
                    long prevAmount = stonesNext.get(mult) == null ? 0L : stonesNext.get(mult);
                    stonesNext.put(mult, prevAmount+numberOfStones);
                }
            }
            stones.clear();
            stones.putAll(stonesNext);
        }

        long totalStones = 0L;
        for (Long stoneCount : stones.values()) {
            totalStones += stoneCount;
        }
        return totalStones;
    }


    public static void main(String[] args) throws Exception {
        DayEleven solution = new DayEleven();
        String input = "965842 9159 3372473 311 0 6 86213 48";
        String[] numbers = input.split(" ");
        List<Long> stones = new ArrayList<>();
        for (String number : numbers) {
            stones.add(Long.parseLong(number));
        }
        long stoneCount = solution.blinkyMap(stones, 75);
        System.out.println("Solution part 2: " + stoneCount);
    }


}
