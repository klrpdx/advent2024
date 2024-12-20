package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.Maze;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaySixteen {

    private final FileLoader fileLoader;

    public DaySixteen(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    private String getAsciiMap() throws IOException {
        StringBuilder builder = new StringBuilder();
        String line ;
        while((line = fileLoader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        return builder.toString();
    }


    public long solvePart1() throws IOException {
        Maze maze = new Maze(getAsciiMap());
        return maze.findBestPathToEnd();
    }


    public long solvePart2() throws IOException {
        Maze maze = new Maze(getAsciiMap());
        return maze.getBestPathLength();
    }

    public static void main(String[] args)  throws IOException {
        FileLoader loader = new FileLoader("/Users/klr/Projects/advent2024/resources/day16input.txt");
        DaySixteen ds = new DaySixteen(loader);
        System.out.println("Solution, Part 2: "+ds.solvePart2());
    }

}
