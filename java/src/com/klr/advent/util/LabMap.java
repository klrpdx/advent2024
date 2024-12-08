package com.klr.advent.util;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.awt.Point;
import java.util.*;

public class LabMap {
    private final List<boolean[]> rows = new ArrayList<>();
    private final Point guardLocation = new Point();
    private int xDirection = 0;
    private int yDirection = 0;
    private Set<Point> visited = new HashSet<>();
    private int moves;

    public LabMap(List<String> rows) {
        scanLines(rows);
    }

    private void scanLines(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int index = 0;
            boolean[] row = new boolean[line.length()];
            for (char c : line.toCharArray()) {
                if (c == '^' || c == 'v' || c == '<' || c == '>') {
                    guardLocation.setLocation(index, i);
                    System.out.printf("Starting Guard Location: (%d,%d)\n",index,i);
                    visited.add(new Point(guardLocation));
                    switch (c) {
                        case '^':
                            yDirection = -1;
                            break;
                        case 'v':
                            yDirection = 1;
                            break;
                        case '<':
                            xDirection = -1;
                            break;
                        case '>':
                            xDirection = 1;
                    }
                }
                row[index++] = (c == '#');
            }
            rows.add(row);
        }
        System.out.println("Dimensions: "+rows.size()+","+rows.getFirst().length);
    }

    public boolean getLocation(int row, int col) {
        return rows.get(row)[col];
    }

    public Point guardLocation() {
        return guardLocation.getLocation();
    }

    public int totalVisited() {
        return visited.size();
    }

    public boolean move() {
        guardLocation.translate(xDirection, yDirection);
        if (!guardHasLeftTheBuilding() && rows.get(guardLocation.y)[guardLocation.x]) {
            guardLocation.translate(-xDirection, -yDirection);
            return false;
        }
        if (!guardHasLeftTheBuilding()) {
            Point newLocation = new Point(guardLocation);
            visited.add(newLocation);
            moves++;
        }
        return true;
    }

    private boolean boundsCheck(int x, int y) {
        return x >= 0 && x < rows.getFirst().length && y >= 0 && y < rows.size();
    }

    public boolean guardHasLeftTheBuilding() {
        return !boundsCheck(guardLocation.x, guardLocation.y);
    }

    public void turnRight() {
        if (xDirection == 0) {
            xDirection = -yDirection;
            yDirection = 0;
        } else if (yDirection == 0) {
            yDirection = xDirection;
            xDirection = 0;
        }
    }
}
