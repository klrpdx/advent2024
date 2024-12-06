package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.RuleMaker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DayFive extends Solver {

    private final RuleMaker ruleMaker = new RuleMaker();

    DayFive(FileLoader fileLoader) {
        super(fileLoader);
    }


    private void createRules() throws IOException {
        String nextLine;
        while((nextLine = fileLoader.readLine()) != null && !nextLine.trim().isEmpty()) {
            ruleMaker.addRule(nextLine);
        }
    }

    private int correctOrder() {
        return 0;
    }

    private int[] checkPages() throws IOException {
        int middleSum = 0;
        int middleSumFixed = 0;
        String nextLine;
        while((nextLine = fileLoader.readLine()) != null) {
            String[] parts = nextLine.split(",");
            List<Integer> pages = Arrays.stream(parts).map(Integer::valueOf).toList();
            List<Integer> cameBefore = new ArrayList<>();
            boolean valid = true;
            for (int page : pages) {
                List<Integer> mustNotComeBefore = ruleMaker.getRule(page);
                if (mustNotComeBefore != null &&  !Collections.disjoint(cameBefore, mustNotComeBefore)) {
                    valid = false;
                    List<Integer> ordered = ruleMaker.fixList(pages);
                    middleSumFixed += ordered.get(ordered.size()/2);
                    break;
                }
                cameBefore.add(page);
            }
            middleSum = middleSum +  (valid ? pages.get(pages.size()/2) : 0);
        }
        return new int[]{middleSum,middleSumFixed};
    }

    @Override
    int[] solve() throws IOException {
        createRules();
        return checkPages();
    }


    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day5input.txt");
        DayFive solver = new DayFive(fileLoader);
        int[] result = solver.solve();
        System.out.printf("The solution part 1: %d\n",result[0]);
        System.out.printf("The solution part 2: %d\n",result[1]);
    }
}
