package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.TrailGraph;
import com.klr.advent.util.TopoMap;
import com.klr.advent.util.TrailVertex;

import java.io.IOException;
import java.util.Set;

public class DayTen {

    private final FileLoader fileLoader;

    public DayTen(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }


    public TopoMap parseFile() throws IOException {
        StringBuilder asciiMap = new StringBuilder();
        String nextLine = null;
        while ((nextLine = fileLoader.readLine()) != null) {
            asciiMap.append(nextLine).append("\n");
        }
        TopoMap map = new TopoMap(asciiMap.toString());
        return map;
    }

    public long solve() throws IOException {
        TopoMap map = parseFile();
        TrailGraph graph = map.createGraph();
        Set<TrailVertex> trailheads = map.getTrailheads();
        int score = 0;
        for (TrailVertex trailhead : trailheads) {
            score += graph.findUniquePathTo(trailhead,9).size();
        }
        return score;
    }

    public long solve2() throws IOException {
        TopoMap map = parseFile();
        TrailGraph graph = map.createGraph();
        Set<TrailVertex> trailheads = map.getTrailheads();
        int score = 0;
        for (TrailVertex trailhead : trailheads) {
            score += graph.findAllPathsTo(trailhead,9).size();
        }
        return score;
    }


    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day10input.txt");
        DayTen solver = new DayTen(fileLoader);
        System.out.println("The solution part 2: " + solver.solve2());
    }

}
