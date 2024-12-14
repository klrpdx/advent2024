package com.klr.advent.util;


import java.util.List;

public class Plot {

    private final Vertex aVertex;

    public Plot(Vertex aVertex) {
        this.aVertex = aVertex;
    }

    public Vertex getVertex() {
        return aVertex;
    }
    public List<Vertex> getVertices() {
        return aVertex.getSiblings();
    }

    public boolean contains(Vertex v) {
        return aVertex.getSiblings().contains(v);
    }

    public long getArea() {
        return aVertex.getSiblings().size();
    }

    public long getPerimeter() {
        long perimeter = 0;

        for (Vertex v : getVertices()) {
            perimeter += 4L - v.getNumOfSiblingNeighbors();
        }
        return perimeter;
    }
}
