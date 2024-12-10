package com.klr.advent;

import com.klr.advent.util.AntennaMap;
import com.klr.advent.util.FileLoader;

import java.io.IOException;

public class DayEight {

    private final FileLoader fileLoader;

    DayEight(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }



    public int solve() throws IOException {
        AntennaMap map = new AntennaMap();
        String newline = null;
        while((newline = fileLoader.readLine()) != null) {
            map.scanLine(newline);
        }

        return map.getAllAntinodes().size();
    }


    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day8input.txt");
        DayEight solver = new DayEight(fileLoader);
        System.out.println("The solution part 1: " + solver.solve());
    }

}

