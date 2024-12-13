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
                    siblings.add(vertex);
                    siblings.addAll(vertex.getSiblings());
                }
            }
        }
        return new ArrayList<>(siblings);
    }
}


