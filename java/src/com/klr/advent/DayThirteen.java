package com.klr.advent;

import com.klr.advent.util.ClawMachine;
import com.klr.advent.util.FileLoader;
import com.klr.advent.util.Point;
import com.klr.advent.util.PrizeReader;

import java.io.IOException;
import java.util.List;

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


    public long[] buttonPushes(long prizeX, long prizeY, long buttonAx, long buttonAy, long buttonBx, long buttonBy) {
        long[] result = new long[2];
        result[0] = (prizeX*buttonBy - prizeY*buttonBx) / (buttonAx * buttonBy - buttonAy * buttonBx);
        result[1] = (buttonAx*prizeY - buttonAy*prizeX) / (buttonAx * buttonBy - buttonAy * buttonBx);
        return result;
    }

    public long price(ClawMachine machine) {
        long tokensA = 3L;
        long tokensB = 1L;
        long[] pushes = buttonPushes(machine.prize().x(), machine.prize().y(), machine.buttonA().x(), machine.buttonA().y(), machine.buttonB().x(), machine.buttonB().y());
        long xMove = pushes[0]*machine.buttonA().x() + pushes[1]*machine.buttonB().x();
        long yMove = pushes[0]*machine.buttonA().y() + pushes[1]*machine.buttonB().y();
        Point point = new Point(xMove,yMove);
        if (!point.equals(machine.prize())) {
            return 0L;
        }
        return (tokensA * pushes[0] + tokensB * pushes[1]);
    }


    public long solve() throws IOException {
        long total = 0;
        String input = loadFile();
        PrizeReader reader = new PrizeReader(input);
        List<ClawMachine> machines = reader.getMachines(true);
        for (ClawMachine machine : machines) {
            total += price(machine);
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader("/Users/klr/Projects/advent2024/resources/day13input.txt");
        DayThirteen dt = new DayThirteen(fileLoader);
        System.out.println("The solution part 2: "+dt.solve());
    }

}
