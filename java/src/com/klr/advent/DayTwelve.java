package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.Garden;

import java.io.IOException;

public class DayTwelve {

    private final FileLoader fileLoader;
    private String asciiMap;

    public DayTwelve(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    private void loadAsciiMap() throws IOException {
        StringBuilder builder = new StringBuilder();
        String nextLine = null;
        while ((nextLine = fileLoader.readLine()) != null) {
            builder.append(nextLine).append("\n");
        }
        asciiMap = builder.toString();
    }

    public long solvePart1() throws IOException {
        loadAsciiMap();
        Garden garden = new Garden(asciiMap);
        return garden.getFencePrice();
    }

    public long solvePart2() throws IOException {
        loadAsciiMap();
        Garden garden = new Garden(asciiMap);
        return garden.getDiscountedFencePrice();
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day12input.txt");
        DayTwelve dayTwelve = new DayTwelve(fileLoader);
        System.out.println("Part II solution: "+dayTwelve.solvePart2());
    }




}
