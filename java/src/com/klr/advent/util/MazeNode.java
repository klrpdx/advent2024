package com.klr.advent.util;

public class MazeNode {

    private char symbol;

    public MazeNode(char symbol) {
        this.symbol = symbol;
    }

    public boolean isWall() {
        return symbol == '#';
    }

}
