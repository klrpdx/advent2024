package com.klr.advent.util;

import java.awt.Point;

public class MazeNode {

    private char symbol;
    private Point location;

    public MazeNode(char symbol) {
        this.symbol = symbol;
    }

    public void setLocation(Point point) {
        this.location = point;
    }

    public Point location() {
        return location;
    }

    public boolean isWall() {
        return symbol == '#';
    }

    public boolean isStart() {
        return symbol == 'S';
    }
}
