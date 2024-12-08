package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.LabMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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



    @Override
    Integer solve() throws IOException {
        loadFile();
        LabMap labMap = new LabMap(this.asciiMap);
        return findGuardRoute(labMap);
    }



    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day6input.txt");
        DaySix solver = new DaySix(fileLoader);
        System.out.println("The solution part 1: " + solver.solve());
    }
}
