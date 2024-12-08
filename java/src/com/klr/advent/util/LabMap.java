package com.klr.advent.util;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LabMap {
    private final List<boolean[]> rows = new ArrayList<>();
    private final Point guardLocation = new Point();
    private int xDirection = 0;
    private int yDirection = 0;
    private final Set<Point> visited = new HashSet<>();
    private int moves;

    public LabMap(List<String> rows) {
        scanLines(rows);
    }

    private void scanLines(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int index = 0;
            boolean[] row = new boolean[lines.getFirst().length()];
            for (char c : line.toCharArray()) {
                if (c == '^' || c == 'v' || c == '<' || c == '>') {
                    guardLocation.setLocation(index, i);
                    visited.add(guardLocation);
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
        return guardLocation;
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
            visited.add(guardLocation);
            moves++;
        }
        return true;
    }

    private boolean boundsCheck(int x, int y) {
        boolean inBound = x >= 0 && x < rows.getFirst().length && y >= 0 && y < rows.size();
        if (!inBound) {
            System.out.printf("Out of bounds at (%d,%d) after %d moves\n",x,y,moves);
        }
        return inBound;
    }

    public boolean guardHasLeftTheBuilding() {
        return !boundsCheck(guardLocation.x, guardLocation.y);
    }

    public void turnRight() {
        if (xDirection == 0) {
            xDirection = -yDirection;
            yDirection = 0;
        } else {
            yDirection = xDirection;
            xDirection = 0;
        }
    }
}
