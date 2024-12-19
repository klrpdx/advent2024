package com.klr.advent.util;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MazeNode {

    private final char symbol;
    private Point location;
    private final Map<Compass, MazeNode> neighbors = new HashMap<>();

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

    public void addNeighbor(Compass direction,  MazeNode mazeNode) {
        neighbors.put(direction, mazeNode);
    }

    public MazeNode getNeighbor(Compass direction) {
        return neighbors.get(direction);
    }

    public boolean contains(MazeNode node) {
        return neighbors.containsValue(node);
    }

    public boolean isEnd() {
        return symbol == 'E';
    }

    public List<MazeNode> getNeighbors() {
        return new ArrayList<>(neighbors.values());
    }
}
