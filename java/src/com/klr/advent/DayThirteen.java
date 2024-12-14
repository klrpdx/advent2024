package com.klr.advent;

import com.klr.advent.util.ClawMachine;
import com.klr.advent.util.FileLoader;
import com.klr.advent.util.PrizeReader;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.sqrt;

public class DayThirteen {

    private final FileLoader fileLoader;


    public DayThirteen(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    private String loadFile() throws IOException {
        StringBuilder builder = new StringBuilder();
        String nextLine = null;
        while((nextLine = fileLoader.readLine()) != null) {
            builder.append(nextLine).append("\n");
        }
        return builder.toString();
    }


    public int[] buttonPushes(int prizeX, int prizeY, int buttonAx, int buttonAy, int buttonBx, int buttonBy) {
        int[] result = new int[2];
        result[0] = (prizeX*buttonBy - prizeY*buttonBx) / (buttonAx * buttonBy - buttonAy * buttonBx);
        result[1] = (buttonAx*prizeY - buttonAy*prizeX) / (buttonAx * buttonBy - buttonAy * buttonBx);
        return result;
    }

    public int price(ClawMachine machine) {
        int tokensA = 3;
        int tokensB = 1;
        int[] pushes = buttonPushes(machine.prize().x, machine.prize().y, machine.buttonA().x, machine.buttonA().y, machine.buttonB().x, machine.buttonB().y);
        int xMove = pushes[0]*machine.buttonA().x + pushes[1]*machine.buttonB().x;
        int yMove = pushes[0]*machine.buttonA().y + pushes[1]*machine.buttonB().y;
        Point point = new Point(xMove,yMove);
        if (!point.equals(machine.prize())) {
            return 0;
        }
        return (tokensA * pushes[0] + tokensB * pushes[1]);
    }


    public long solve() throws IOException {
        long total = 0;
        String input = loadFile();
        PrizeReader reader = new PrizeReader(input);
        List<ClawMachine> machines = reader.getMachines();
        for (ClawMachine machine : machines) {
            total += price(machine);
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day13input.txt");
        DayThirteen dt = new DayThirteen(fileLoader);
        System.out.println("The solution part 1:"+dt.solve());
    }

}
