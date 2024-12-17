package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.Warehouse;

import java.io.IOException;

public class DayFifteen {

    FileLoader loader;

    public DayFifteen(FileLoader loader) {
        this.loader = loader;
    }




    public long solvePart1() throws IOException {
        StringBuilder builder = new StringBuilder();
        String line = null;
        while((line = loader.readLine()) != null) {
            builder.append(line).append("\n");
        }

        Warehouse warehouse = new Warehouse(builder.toString());
        warehouse.create();
        warehouse.startRobot();
        warehouse.print();
        return warehouse.getScore();
    }

    public long solvePart2() throws IOException {
        StringBuilder builder = new StringBuilder();
        String line;
        while((line = loader.readLine()) != null) {
            builder.append(line).append("\n");
        }

        Warehouse warehouse = new Warehouse(builder.toString());
        warehouse.createFat();
        warehouse.startRobotWide();
        warehouse.printWide();
        return warehouse.getScore();
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day15input.txt");
        DayFifteen df = new DayFifteen(fileLoader);
        System.out.println("Solution part 2: "+df.solvePart2());
    }

}
