package com.klr.advent;

import com.klr.advent.util.FileLoader;

import java.io.IOException;
import java.util.List;

public class DayOne {

    private final FileLoader fileLoader;
    private LocationLists locationLists;

    public DayOne(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }


    private void parseInput() throws IOException {
        String nextLine = null;
        locationLists = new LocationLists();
        while ((nextLine = fileLoader.readLine()) != null) {
            String[] vals = nextLine.split(",");
            if (vals.length != 2) {
                throw new IOException(String.format("Invalid input: %s", nextLine));
            }
            locationLists.addList1Val(Integer.parseInt(vals[0].trim()));
            locationLists.addList2Val(Integer.parseInt(vals[1].trim()));
        }
        if (!locationLists.valid()) {
            throw new IOException("Invalid input: Lists are of different length");
        }
        locationLists.sortAndHash();
    }

    public int solve() {

        try {
            parseInput();
        }
        catch (IOException e) {
            System.out.println("Failed to parse input file: "+e.getMessage());
            return -1;
        }

        int totalDiff = 0;
        Integer val1;
        Integer val2;
        while ((val1 = locationLists.getList1Smallest()) != null) {
            val2 = locationLists.getList2Smallest();
            totalDiff += Math.abs(val1 - val2);
        }

        return totalDiff;
    }

    private int solvePart2() {

        List<Integer> keys = locationLists.getKeys();
        int sum = 0;
        for (Integer key : keys) {
            int list1Occur = locationLists.getOccurances1(key);
            int list2Occur = locationLists.getOccurances2(key);
            sum += (key * list2Occur) * list1Occur;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/Advent1input.csv");
        DayOne dayOne = new DayOne(fileLoader);
        System.out.println("The solution part 1:");
        System.out.println(dayOne.solve());
        System.out.println("\n");
        System.out.println("The solution part 2:");
        System.out.println(dayOne.solvePart2());
    }

}
