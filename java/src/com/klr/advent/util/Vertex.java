package com.klr.advent.util;

import java.awt.Point;
import java.util.*;

public class Vertex {

    private final String label;
    private final Point location;
    private final List<Vertex> neighbours = new ArrayList<>();
    private Set<Vertex> siblings;

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
        return isUpDown(vertex) || isLeftRight(vertex);
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

    private boolean isLeftRight(Vertex vertex) {
        Point p = vertex.getLocation();
        return (p.x == location.x+1 || p.x == location.x-1)  && p.y == location.y;
    }

    private boolean isUpDown(Vertex vertex) {
        Point p = vertex.getLocation();
        return (p.y == location.y+1 || p.y == location.y-1)  && p.x == location.x;
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

}


