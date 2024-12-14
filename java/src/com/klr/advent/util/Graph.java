package com.klr.advent.util;


import java.awt.Point;
import java.util.*;

public class Graph {

    private final Map<Vertex, List<Vertex>> vertices = new HashMap<>();
    private final Map<Point, Vertex> locations = new HashMap<>();



    public void addVertex(Vertex vertex) {
        vertices.put(vertex, new ArrayList<>());
        locations.put(vertex.getLocation(), vertex);
    }

    public List<Vertex> getAllVertices() {
        return new ArrayList<>(vertices.keySet());
    }


    public Vertex getLocation(Point point) {
        return locations.get(point);
    }

}
