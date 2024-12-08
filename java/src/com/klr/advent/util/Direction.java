package com.klr.advent.util;

public enum Direction {

    UP(0,-1),
    DOWN(0,1),
    LEFT(-1,0),
    RIGHT(1,0),
    UPLEFT( -1, -1),
    UPRIGHT( 1, -1),
    DOWNLEFT( -1, 1),
    DOWNRIGHT( 1, 1);


    private final int xDir;
    private final int yDir;

    Direction(int xDir, int yDIr) {
        this.xDir = xDir;
        this.yDir = yDIr;
    }

    public static Direction getDirection(int xDir, int yDir) {
        if (xDir == 0 && yDir == 1) {
            return DOWN;
        }
        if (xDir == 0 && yDir == -1) {
            return UP;
        }
        if (xDir == 1 && yDir == 0) {
            return RIGHT;
        }
        return LEFT;
    }

    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }
}
