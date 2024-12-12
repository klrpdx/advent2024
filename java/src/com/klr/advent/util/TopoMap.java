package com.klr.advent.util;

import java.awt.Point;
import java.util.*;

public class TopoMap {

    private final String asciMap;
    private int[][] topoArray;
    private Set<TrailVertex> trailheads = new HashSet<>();
    private Map<Point, TrailVertex> points = new HashMap<>();

    public TopoMap(String asciFile) {
        asciMap = asciFile;
    }

    public int[][] createArray() {
        String[] rows = asciMap.split("\n");
        int height = rows.length;
        int width = rows[0].length();
        topoArray = new int[height][width];

        int row = 0;
        for (String line : rows) {
            line = line.trim();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int level = Character.getNumericValue(chars[i]);
                topoArray[row][i] = level;
            }
            row++;
        }

        return topoArray;
    }


    public TrailGraph createGraph() {
        if (topoArray == null) {
            createArray();
        }

        TrailGraph graph = new TrailGraph();
        int id = 0;

        for (int y = 0; y < topoArray.length; y++) {
            for (int x = 0; x < topoArray[y].length; x++) {
                int level = topoArray[y][x];
                TrailVertex v = new TrailVertex(id, level, new Point(x, y));
                graph.addVertex(v);
                if (level == 0) {
                    trailheads.add(v);
                }
                points.put(v.getLocation(), v);
                id++;
            }
        }

        for (TrailVertex v : graph.getAllVertices()) {
            Point myPoint = v.getLocation();
            for (int y = myPoint.y - 1; y <= myPoint.y + 1; y++) {
                if (y >= 0 && y < topoArray.length) {
                    Point neighbor = new Point(myPoint.x, y);
                    TrailVertex vNeighbor = points.get(neighbor);
                    if (vNeighbor.getLevel() == (v.getLevel()+1)) {
                        graph.addEdge(v, vNeighbor);
                    }
                }
            }
            for (int x = myPoint.x - 1; x <= myPoint.x + 1; x++) {
                if (x >= 0 && x < topoArray[0].length) {
                    Point neighbor = new Point(x, myPoint.y);
                    TrailVertex vNeighbor = points.get(neighbor);
                    if (vNeighbor.getLevel() == (v.getLevel()+1)) {
                        graph.addEdge(v, vNeighbor);
                    }
                }
            }
        }

        return graph;
    }

    public Set<TrailVertex> getTrailheads() {
        return trailheads;
    }

}
