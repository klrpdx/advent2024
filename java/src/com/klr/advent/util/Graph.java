package com.klr.advent.util;

import java.util.*;

public class Graph {

    private final Map<Vertex, List<Vertex>> vertices = new HashMap<>();


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

    public Set<Vertex> findUniquePathTo(Vertex from, int level) {
        return new HashSet<>(findAllPathsTo(from, level));
    }

    public List<Vertex> findAllPathsTo(Vertex from, int level) {
        List<Vertex> ends = new ArrayList<>();
        List<Vertex> vertices = getEdges(from);
        for (Vertex v : vertices) {
            if (v.getLevel() == level) {
                ends.add(v);
            } else {
                ends.addAll(findAllPathsTo(v, level));
            }
        }
        return ends;
    }

}
