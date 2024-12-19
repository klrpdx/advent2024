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

    public MazeNode(int x, int y) {
        this.location = new Point(x, y);
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
        return parents.contains(mazeNode);
    }

    public boolean contains(MazeNode node) {
        return neighbors.contains(node);
    }

    public List<MazeNode> getNeighbors() {
        return new ArrayList<>(neighbors);
    }
}
