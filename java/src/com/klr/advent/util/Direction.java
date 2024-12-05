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

    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }
}
