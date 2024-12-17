package com.klr.advent.util;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private final String asciiMap;
    private char[] movementMap;
    private int moveNumber = 0;
    private WarehouseRobot robot;
    private final Map<WarehouseObject, Point> reverseLocationMap = new HashMap<>();
    private final Map<Point, WarehouseObject> locationMap = new HashMap<>();
    private int width;
    private int height;

    public Warehouse(String asciiMap) {
        this.asciiMap = asciiMap;
    }

    public boolean moveRobotOneStep() {
        boolean moved = robot.move(movementMap[moveNumber++]);
        return moved;
    }


    public void startRobot() {
        while (moveNumber < movementMap.length) {
            moveRobotOneStep();
        }
        System.out.println("Total moves: "+moveNumber);
    }

    public void create() {
        String[] lines = asciiMap.split("\n");

        int row = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                break;
            }
            char[] chars = line.toCharArray();
            width = chars.length;
            for (int i = 0; i < chars.length; i++) {
                WarehouseObject object = null;
                Point p = new Point(i,row);
                object = switch (chars[i]) {
                    case '#' -> new WarehouseWall(p, locationMap);
                    case 'O' -> new WarehouseBox(p, locationMap);
                    case '@' -> new WarehouseRobot(p,locationMap);
                    default -> null;
                };
                if (object != null) {
                    reverseLocationMap.put(object, object.getLocation());
                    if (object instanceof WarehouseRobot) {
                        robot = (WarehouseRobot) object;
                    }
                }
            }
            row++;
        }
        height = row;

        StringBuilder builder = new StringBuilder();
        for (int i = row+1; i < lines.length; i++) {
            builder.append(lines[i]);
        }
        String instructions = builder.toString();
        instructions = instructions.replaceAll("/n","");
        createMovementMap(instructions);

    }

    private void createMovementMap(String ascii) {
        movementMap = ascii.toCharArray();
    }

    public Point findRobot() {
        return robot.getLocation();
    }

    public WarehouseObject getAt(Point point) {
        return locationMap.get(point);
    }


    public void print() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                WarehouseObject object = locationMap.get(new Point(x, y));
                String square = object == null ? "." : object.toString();
                builder.append(square);
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    public long getScore() {
        long score = 0;
        for (WarehouseObject object : locationMap.values()) {
            if (object instanceof WarehouseBox) {
                WarehouseBox box = (WarehouseBox) object;
                score += (long) (box.getLocation().getY() * 100 + box.getLocation().getX());
            }
        }
        return score;
    }
}
