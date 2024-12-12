package com.klr.advent.util;

import java.awt.*;
import java.util.Objects;

public class Vertex {

    private final int level;
    private final int id;
    private Point location;

    public Vertex(int id, int level) {
        this.id = id;
        this.level = level;
    }

    public Vertex(int id, int level, Point location) {
        this.id = id;
        this.level = level;
        this.location = location;
    }

    public Point getLocation()  {
        return location;
    }

    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
