package com.klr.advent.util;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Plot {

    private final Vertex aVertex;

    public Plot(Vertex aVertex) {
        this.aVertex = aVertex;
    }

    public List<Vertex> getVertices() {
        return aVertex.getSiblings();
    }

    public boolean contains(Vertex v) {
        return aVertex.getSiblings().contains(v);
    }

}
