package com.klr.advent.util;

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
        return getMachines(false);
    }

    public List<ClawMachine> getMachines(boolean longs) {
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
                long xA = Long.parseLong(matcherA.group(1));
                long yA = Long.parseLong(matcherA.group(2));
                long xB = Long.parseLong(matcherB.group(1));
                long yB = Long.parseLong(matcherB.group(2));
                long xP = 0;
                long yP = 0;
                if (longs) {
                    xP = Long.parseLong(matcherP.group(1)) + 10000000000000L;
                    yP = Long.parseLong(matcherP.group(2)) + 10000000000000L;
                }
                else {
                    xP = Long.parseLong(matcherP.group(1));
                    yP = Long.parseLong(matcherP.group(2));
                }
                machines.add(new ClawMachine(new Point(xA, yA), new Point(xB, yB), new Point(xP, yP)));
            }

            i += 3;

        }
        return machines;
    }



}
