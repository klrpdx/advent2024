package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.TopoMap;

import java.io.IOException;

public class DayTen {

    private final FileLoader fileLoader;

    public DayTen(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }


    public int[][] parseFile() throws IOException {
        StringBuilder asciiMap = new StringBuilder();
        String nextLine = null;
        while ((nextLine = fileLoader.readLine()) != null) {
            asciiMap.append(nextLine).append("\n");
        }
        TopoMap map = new TopoMap(asciiMap.toString());
        return map.createArray();
    }

    public long solve() {

        return 0;
    }



}
