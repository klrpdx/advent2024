package com.klr.advent.util;

import java.awt.*;
import java.util.Objects;

public class Vertex {

    private final String label;
    private final Point location;

    public Vertex(Point location, String label) {
        this.location = location;
        this.label = label;
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
}


