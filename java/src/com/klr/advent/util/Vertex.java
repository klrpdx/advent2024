package com.klr.advent.util;

import java.awt.Point;
import java.util.*;

public class Vertex {

    private final String label;
    private final Point location;
    private final List<Vertex> neighbours = new ArrayList<>();
    private Set<Vertex> siblings;
    private boolean sibUp;
    private boolean sibDown;
    private boolean sibLeft;
    private boolean sibRight;
    private boolean cousUpright;
    private boolean cousUpleft;
    private boolean cousdownleft;
    private boolean cousdownright;

    public Vertex(Point location, String label) {
        this.location = location;
        this.label = label;
    }

    public void addEdge(Vertex vertex) {
        neighbours.add(vertex);
    }

    public Point getLocation() {
        return location;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex vertex)) return false;
        return Objects.equals(label, vertex.label) && Objects.equals(location, vertex.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, location);
    }

    public List<Vertex> getConnections() {
        return new ArrayList<>(neighbours);
    }

    public List<Vertex> getSiblings() {
        if (siblings == null) {
            siblings = new HashSet<>();
            for (Vertex vertex : neighbours) {
                if (vertex.label.equals(label)) {
                    if (isSibling(vertex)) {
                        siblings.add(vertex);
                        siblings.addAll(vertex.getSiblings());
                    }
                }
            }
            if (siblings.isEmpty()) {
                siblings.add(this);
            }
        }
        return new ArrayList<>(siblings);
    }

    private boolean isSibling(Vertex vertex) {
        return isUp(vertex) || isDown(vertex) || isLeft(vertex) || isRight(vertex);
    }

    private boolean isCousin(Vertex vertex) {
        Point p = vertex.getLocation();
        return (p.x == location.x+1 && p.y == location.y-1)
            || (p.x == location.x+1 && p.y == location.y+1)
            || (p.x == location.x-1 && p.y == location.y-1)
            || (p.x == location.x-1 && p.y == location.y+1);

    }

    public List<Vertex> getCousins() {
        List<Vertex> cousins = new ArrayList<>();
        for (Vertex v : neighbours) {
            if (v.label.equals(label) && isCousin(v)) {
                cousins.add(v);
            }
        }
        return cousins;
    }

    private boolean isLeft(Vertex vertex) {
        Point p = vertex.getLocation();
        return p.x == location.x-1 && p.y == location.y;
    }

    private boolean isRight(Vertex vertex) {
        Point p = vertex.getLocation();
        return p.x == location.x+1 && p.y == location.y;
    }

    private boolean isUp(Vertex vertex) {
        Point p = vertex.getLocation();
        return p.y == location.y-1 && p.x == location.x;
    }

    private boolean isDown(Vertex vertex) {
        Point p = vertex.getLocation();
        return p.y == location.y+1 && p.x == location.x;
    }

    private boolean isUpRight(Vertex vertex) {
        Point p = vertex.getLocation();
        return p.y == location.y-1 && p.x == location.x+1;
    }

    private boolean isUpLeft(Vertex vertex) {
        Point p = vertex.getLocation();
        return p.y == location.y-1 && p.x == location.x-1;
    }

    private boolean isDownRight(Vertex vertex) {
        Point p = vertex.getLocation();
        return p.y == location.y+1 && p.x == location.x+1;
    }

    private boolean isDownLeft(Vertex vertex) {
        Point p = vertex.getLocation();
        return p.y == location.y+1 && p.x == location.x-1;
    }

    public int getNumOfSiblingNeighbors() {
        int count = 0;
        for (Vertex vertex : neighbours) {
            if (vertex.label.equals(label) && isSibling(vertex)) {
                count++;
            }
        }
        return count;
    }

    private void setNeighborFlags() {
        for (Vertex vertex : neighbours) {
            if (vertex.label.equals(label)) {
                sibUp = sibUp || isUp(vertex);
                sibDown = sibDown || isDown(vertex);
                sibLeft = sibLeft || isLeft(vertex);
                sibRight = sibRight || isRight(vertex);
                cousUpright = cousUpright || isUpRight(vertex);
                cousUpleft = cousUpleft || isUpLeft(vertex);
                cousdownleft = cousdownleft || isDownLeft(vertex);
                cousdownright = cousdownright || isDownRight(vertex);
            }
        }
    }

    public int numCorners() {
        int corners = 0;
        setNeighborFlags();

        //upper left
        if (!sibUp && !sibLeft || !cousUpleft && sibUp && sibLeft) {
            corners++;
        }
        //upper right
        if (!sibUp && !sibRight || !cousUpright && sibUp && sibRight) {
            corners++;
        }
        //Lower left
        if (!sibDown && !sibLeft || !cousdownleft && sibDown && sibLeft) {
            corners++;
        }
        //Lower right
        if (!sibDown && !sibRight || !cousdownright && sibDown && sibRight) {
            corners++;
        }
        return corners;
    }
}


