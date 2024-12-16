package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.Room;

import java.io.IOException;

public class DayFourteen {


    private FileLoader loader;

    public DayFourteen(FileLoader loader) {
        this.loader = loader;
    }

    private Room loadInput() throws IOException {
        StringBuilder builder = new StringBuilder();
        String nextLine = null;
        while((nextLine = loader.readLine()) != null) {
            builder.append(nextLine);
            builder.append("\n");
        }
        return new Room(101, 103, builder.toString());
    }

    public int solvePart1() throws IOException {
        Room room = loadInput();
        room.populateRoom();
        room.click(100);
        return room.getSafetyScore();
    }

    public int solvePart2() throws IOException {
        Room room = loadInput();
        room.populateRoom();
        return room.minEntropy();
    }


    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day14input.txt");
        DayFourteen df = new DayFourteen(fileLoader);
        System.out.println("Solution Part 2: "+df.solvePart2());
    }
}
