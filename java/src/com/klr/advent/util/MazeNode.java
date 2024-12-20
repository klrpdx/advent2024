package com.klr.advent.util;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeNode {

    private Point location;
    private final Set<MazeNode> neighbors = new HashSet<>();
    private final Set<MazeNode> parents = new HashSet<>();
    private boolean LR = true;

    public MazeNode(int x, int y, boolean LR) {
        this.location = new Point(x, y);
        this.LR = LR;
    }

    public MazeNode(int x, int y) {
        this.location = new Point(x, y);
    }

    public boolean isLR() {
        return this.LR;
    }

    public Point location() {
        return new Point(location);
    }

    public void addNeighbor(MazeNode mazeNode) {
        neighbors.add(mazeNode);
    }

    public void addParent(MazeNode mazeNode) {
        parents.add(mazeNode);
    }

    public boolean isParent(MazeNode mazeNode) {
        return neighbors.contains(mazeNode);
    }

    public List<MazeNode> getNeighbors() {
        return new ArrayList<>(neighbors);
    }

}
