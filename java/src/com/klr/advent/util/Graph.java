package com.klr.advent.util;

import java.util.*;

public class Graph {

    private final Map<Vertex,List<Vertex>> vertices = new HashMap<>();



    public List<Vertex> getVertex(int i) {
        return vertices.get(i);
    }

    public void addVertex(Vertex vertex) {
        vertices.put(vertex, new ArrayList<>());
    }

    public List<Vertex> getAllVertices() {
        return new ArrayList<>(vertices.keySet());
    }

    public void addEdge(Vertex vFrom, Vertex vTo) {
        vertices.get(vFrom).add(vTo);
    }

    public List<Vertex> getEdges(Vertex v) {
        return vertices.get(v);
    }

    public Set<Vertex> findPathTo(Vertex from, int level) {
        Set<Vertex> ends = new HashSet<>();
        List<Vertex> vertices = getEdges(from);
        for (Vertex v : vertices) {
            if (v.getLevel() == level) {
                ends.add(v);
            }
            else {
                ends = findPathTo(v, level);
            }
        }
        return ends;
    }

}
