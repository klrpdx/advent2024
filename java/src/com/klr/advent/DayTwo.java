package com.klr.advent;

import com.klr.advent.util.FileLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwo {


    private final FileLoader fileLoader;
    private int totalLines = 0;

    public DayTwo(FileLoader loader) {
        this.fileLoader = loader;
    }

    private List<Integer> makeArray(String nextLine) {
        String[] vals = nextLine.split(" ");
        List<Integer> arr = new ArrayList<>(vals.length);
        for (int i = 0; i < vals.length; i++) {
            arr.add(Integer.parseInt(vals[i].trim()));
        }
        return arr;
    }


    private int levelCheck(List<Integer> vals) {
        boolean incrementing = vals.getFirst() < vals.getLast();
        for (int i = 0; i <= vals.size()-2; i++) {
            if (!isSafe(incrementing, vals.get(i), vals.get(i+1))) {
                return i;
            }
        }
        return -1;
    }


    private boolean fullCheck(List<Integer> vals) {
        int badLevel1 = levelCheck(vals);
        int badLevel2 = badLevel1 + 1;
        if (badLevel1 != -1) {
            List<Integer> newVals = new ArrayList<>(vals);
            newVals.remove(badLevel1);
            badLevel1 = levelCheck(newVals);
            if (badLevel1 != -1 && badLevel1 < newVals.size()) {
                newVals = new ArrayList<>(vals);
                newVals.remove(badLevel2);
                badLevel1 = levelCheck(newVals);
            }
        }

        return badLevel1  < 0;
    }

    private boolean isSafe(boolean incrementing, int val1, int val2) {
       boolean safe = (incrementing && val1 < val2) || (!incrementing && val1 > val2);
       int diff = Math.abs(val1 - val2);
       safe = safe && (diff >= 1 && diff <= 3);
       return safe;
    }

    public int solve() throws IOException {
        int safeTotal = 0;
        String nextLine = null;
        while ((nextLine = fileLoader.readLine()) != null) {
            totalLines++;
            List<Integer> vals = makeArray(nextLine);
            safeTotal += fullCheck(vals) ? 1 : 0;
        }
        return safeTotal;
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day2input.txt");
        DayTwo solver = new DayTwo(fileLoader);
        System.out.println("The solution part 1: "+solver.solve());
        System.out.println("\t"+"Total lines: "+solver.totalLines);
    }

}
