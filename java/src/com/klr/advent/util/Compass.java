package com.klr.advent.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.awt.Point;

public enum Compass {
    NORTH(0,-1),
    EAST(1,0),
    SOUTH(0,1),
    WEST(-1,0);

    private final int xDir;
    private final int yDir;

    Compass(int xDir, int yDir) {
        this.xDir = xDir;
        this.yDir = yDir;
    }

    public boolean inLine(Point origin, Point target) {
        int xDiff = target.x - origin.x;
        int yDiff = target.y - origin.y;
        return xDiff == xDir && yDiff == yDir;
    }

}

