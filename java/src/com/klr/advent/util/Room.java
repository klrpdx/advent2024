package com.klr.advent.util;

import java.awt.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Room {

    private final int width;
    private final int height;
    private final String robotMap;
    private final Pattern pattern = Pattern.compile("p=(\\d+),(\\d+) v=(-?\\d+),(-?\\d+)");
    private final List<Robot> robots = new ArrayList<Robot>();
    private final Map<Integer, Robot> robotHash = new HashMap<Integer, Robot>();

    public Room(int width, int height, String robotMap) {
        this.width = width;
        this.height = height;
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
                Robot robot = new Robot(x, y, vX, vY, width, height, i);
                robots.add(robot);
                robotHash.put(i, robot);
            }
        }

        print();
    }

    public void print(int time, float distance) {
        System.out.printf("Elapsed time: %d. Distance: %f\n", time, distance);
        print();
    }
    public void print() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int count = getNumberOfRobotsAt(x, y);
                String square = count == 0 ? "." : Integer.toString(count);
                builder.append(square);
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    public int getNumberOfRobotsAt(int x, int y) {
        int count = 0;
        Point p = new Point(x, y);
        for (Robot robot : this.robots) {
            count += robot.atPosition(p) ? 1 : 0;
        }
        return count;
    }

    public void click(int num) {
        for (int i = 0; i < num; i++) {
            click();
            System.out.printf("Elapsed time: %d secs\n",i);
            print();
        }
    }

    public void click() {
        for (Robot robot : this.robots) {
            robot.click();
        }
    }


    public int quadrantCount(int quadrant) {
        Map<Point, Integer> locationsMap = new HashMap<Point, Integer>();
        for (Robot robot : this.robots) {
            locationsMap.compute(robot.getPosition(), (k, count) -> count == null ? 1 : count + 1);
        }
        int[] quadCount = new int[4];
        int midx = width / 2;
        int midy = height / 2;

        for (Point location : locationsMap.keySet()) {
            if (location.x < midx && location.y < midy) {
                quadCount[0] += locationsMap.get(location);
            }
            if (location.x > midx && location.y < midy) {
                quadCount[1] += locationsMap.get(location);
            }
            if (location.x < midx && location.y > midy) {
                quadCount[2] += locationsMap.get(location);
            }
            if (location.x > midx && location.y > midy) {
                quadCount[3] += locationsMap.get(location);
            }
        }
        return quadCount[quadrant - 1];
    }

    public int getSafetyScore() {
        return quadrantCount(1) * quadrantCount(2) * quadrantCount(3) * quadrantCount(4);
    }

    public Point getLocationForRobot(int i) {
        return robotHash.get(i).getPosition();
    }

    public int minEntropy() {
        int maxTime = 10000;
        float meanDistance = getMeanDistance();
        int minTime = 0;
        int clickCount = 0;
        while (clickCount < maxTime) {
            clickCount++;
            click();
            float newMean = getMeanDistance();
            if (newMean < meanDistance) {
                meanDistance = newMean;
                print(clickCount,meanDistance);
                minTime = clickCount;
            }
        }
        return clickCount;
    }

    private float getMeanDistance() {
        float distanceTotal = 0f;
        float count = 0f;
        for (Robot robot : this.robots) {
            for (Robot otherRobot : this.robots) {
                if (!otherRobot.equals(robot)) {
                    int xDelta = robot.getPosition().x - otherRobot.getPosition().x;
                    int yDelta = robot.getPosition().y - otherRobot.getPosition().y;
                    distanceTotal += (float) Math.sqrt((xDelta*xDelta) + (yDelta*yDelta));
                    count++;
                }
            }
        }
        return distanceTotal / count;
    }
}
