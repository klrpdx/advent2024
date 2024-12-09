package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.MathMaker;

import java.io.IOException;

public class DaySeven extends Solver {
    DaySeven(FileLoader fileLoader) {
        super(fileLoader);
    }



    @Override
    Object solve() throws IOException {
        String nextLine;
        long result = 0;
        while ((nextLine = fileLoader.readLine()) != null) {
            MathMaker mm = new MathMaker(nextLine);
            if (mm.isSolvable()) {
                result += mm.getTargetResult();
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day7input.txt");
        DaySeven solver = new DaySeven(fileLoader);
        System.out.println("The solution part 1: " + (long)solver.solve());
    }
}
