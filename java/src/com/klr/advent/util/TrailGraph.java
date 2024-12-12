package com.klr.advent.util;


import java.util.*;
import java.util.List;

public class TrailGraph {

    private final Map<TrailVertex, List<TrailVertex>> vertices = new HashMap<>();
   

    public void addVertex(TrailVertex vertex) {
        vertices.put(vertex, new ArrayList<>());
    }

    public List<TrailVertex> getAllVertices() {
        return new ArrayList<>(vertices.keySet());
    }

    public void addEdge(TrailVertex vFrom, TrailVertex vTo) {
        vertices.get(vFrom).add(vTo);
    }

    public List<TrailVertex> getEdges(TrailVertex v) {
        return vertices.get(v);
    }

    public Set<TrailVertex> findUniquePathTo(TrailVertex from, int level) {
        return new HashSet<>(findAllPathsTo(from, level));
    }

    public List<TrailVertex> findAllPathsTo(TrailVertex from, int level) {
        List<TrailVertex> ends = new ArrayList<>();
        List<TrailVertex> vertices = getEdges(from);
        for (TrailVertex v : vertices) {
            if (v.getLevel() == level) {
                ends.add(v);
            } else {
                ends.addAll(findAllPathsTo(v, level));
            }
        }
        return ends;
    }

}
