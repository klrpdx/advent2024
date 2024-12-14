package com.klr.advent.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrizeReader {

    private final String prizeList;
    private final Pattern patternA = Pattern.compile("Button A: X\\+(\\d+), Y\\+(\\d+)");
    private final Pattern patternB = Pattern.compile("Button B: X\\+(\\d+), Y\\+(\\d+)");
    private final Pattern patternP = Pattern.compile("Prize: X=(\\d+), Y=(\\d+)");

    public PrizeReader(String prizeList) {
        this.prizeList = prizeList;
    }


    public List<ClawMachine> getMachines() {
        List<ClawMachine> machines = new ArrayList<>();
        String[] lines = prizeList.split("\n");
        for (int i=0; i<lines.length; i++) {
            String aLine = lines[i];
            String bLine = lines[i+1];
            String prizeLine = lines[i+2];

            Matcher matcherA = patternA.matcher(aLine);
            Matcher matcherB = patternB.matcher(bLine);
            Matcher matcherP = patternP.matcher(prizeLine);

            if (matcherA.find() && matcherB.find() && matcherP.find()) {
                int xA = Integer.parseInt(matcherA.group(1));
                int yA = Integer.parseInt(matcherA.group(2));
                int xB = Integer.parseInt(matcherB.group(1));
                int yB = Integer.parseInt(matcherB.group(2));
                int xP = Integer.parseInt(matcherP.group(1));
                int yP = Integer.parseInt(matcherP.group(2));
                machines.add(new ClawMachine(new Point(xA, yA), new Point(xB, yB), new Point(xP, yP)));
            }

            i += 3;

        }
        return machines;
    }



}
