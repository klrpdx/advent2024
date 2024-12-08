package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.LabMap;
import com.klr.advent.util.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DaySix extends Solver {

    private final List<String> asciiMap = new ArrayList<>();

    DaySix(FileLoader fileLoader) {
        super(fileLoader);
    }


    private void loadFile() throws IOException {
        String nextLine;
        while ((nextLine = fileLoader.readLine()) != null) {
            asciiMap.add(nextLine);
        }
    }


    private Integer findGuardRoute(LabMap labMap) {
        while (!labMap.guardHasLeftTheBuilding()) {
            boolean blocked = !labMap.move();
            if (blocked) {
                labMap.turnRight();
            }
        }
        return labMap.totalVisited();
    }


    private Integer findLoops(LabMap labMap) {
        findGuardRoute(labMap);
        List<Path> guardPaths = labMap.getPaths();
        return 0;
    }


    @Override
    Integer solve() throws IOException {
        loadFile();
        LabMap labMap = new LabMap(this.asciiMap);
        return findGuardRoute(labMap);
    }

    Integer solve2() {
        LabMap labMap = new LabMap(this.asciiMap);
        return findLoops(labMap);
    }


    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day6input.txt");
        DaySix solver = new DaySix(fileLoader);
        System.out.println("The solution part 1: " + solver.solve());
    }
}
