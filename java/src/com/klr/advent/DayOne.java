package com.klr.advent;

import com.klr.advent.util.FileLoader;

import java.io.IOException;

public class DayOne {

    private final FileLoader fileLoader;
    private final LocationLists locationLists = new LocationLists();

    public DayOne(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }


    private LocationLists parseInput() throws IOException {
        String nextLine = null;

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
        locationLists.sort();
        return locationLists;
    }

    public int solve() {
        LocationLists lists = null;
        try {
            lists = parseInput();
        }
        catch (IOException e) {
            System.out.println("Failed to parse input file: "+e.getMessage());
            return -1;
        }

        int totalDiff = 0;
        Integer val1;
        Integer val2;
        while ((val1 = lists.getList1Smallest()) != null) {
            val2 = lists.getList2Smallest();
            totalDiff += Math.abs(val1 - val2);
        }

        return totalDiff;
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/Advent1input.csv");
        DayOne dayOne = new DayOne(fileLoader);
        System.out.println("The solution:");
        System.out.println(dayOne.solve());
    }

}
