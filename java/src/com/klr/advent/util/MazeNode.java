package com.klr.advent.util;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MazeNode {

    private final char symbol;
    private Point location;
    private final List<MazeNode> neighbors = new ArrayList<>();

    public MazeNode(char symbol) {
        this.symbol = symbol;
    }


    public Point location() {
        return new Point(location);
    }

    public boolean isStart() {
        return symbol == 'S';
    }

    public boolean isEnd() {
        return symbol == 'E';
    }

    public void addNeighbor(MazeNode mazeNode) {
        neighbors.add(mazeNode);
    }

    public boolean contains(MazeNode node) {
        return neighbors.contains(node);
    }

    public List<MazeNode> getNeighbors() {
        return new ArrayList<>(neighbors);
    }
}
