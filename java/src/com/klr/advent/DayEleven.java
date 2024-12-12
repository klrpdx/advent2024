package com.klr.advent;

import com.klr.advent.util.FileLoader;

import java.util.ArrayList;
import java.util.List;

public class DayEleven {

    private final FileLoader fileLoader;

    public DayEleven(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }



    public long solve() throws Exception {
        return 0;
    }

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
        else {
            newStones.add(stone);
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
        else {
            newStones.add(stone);
        }

        return newStones;
    }

    public List<Long> applyRule3(long stone) {
        List<Long> newStones = new ArrayList<>();
        if (!rule1(stone) && !rule2(stone)) {
            newStones.add(stone*2024L);
        }
        else {
            newStones.add(stone);
        }

        return newStones;
    }
}
