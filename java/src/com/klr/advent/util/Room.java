package com.klr.advent.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Point;

public class Room {

    private final int width;
    private final int height;
    private final int maxX;
    private final int maxY;
    private final String robotMap;
    private final Pattern pattern = Pattern.compile("p=(\\d+),(\\d+) v=(-?\\d+),(-?\\d+)");
    private final List<Robot> robots = new ArrayList<Robot>();

    public Room(int width, int height, String robotMap) {
        this.width = width;
        this.height = height;
        this.maxX = width -1;
        this.maxY = height -1;
        this.robotMap = robotMap;
    }

    public void populateRoom() {
        String[] robotDetails = this.robotMap.split("\n");
        for (int i = 0; i < robotDetails.length; i++) {
            Matcher matcher = pattern.matcher(robotDetails[i]);
            if (matcher.find()) {
                 int x = Integer.parseInt(matcher.group(1));
                 int y = Integer.parseInt(matcher.group(2));
                 int vX = Integer.parseInt(matcher.group(3));
                 int vY = Integer.parseInt(matcher.group(4));
                 robots.add(new Robot(x, y, vX, vY, width, height, i));
            }
        }
    }

    public int getNumberOfRobotsAt(int x, int y) {
        int count = 0;
        Point p = new Point(x, y);
        for (Robot robot : this.robots) {
            count += robot.atPosition(p) ? 1 : 0;
        }
        return count;
    }

    public void click() {
        for (Robot robot : this.robots) {
            robot.click();
        }
    }
}
