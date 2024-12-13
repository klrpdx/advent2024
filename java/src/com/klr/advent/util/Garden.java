package com.klr.advent.util;

import java.awt.Point;
import java.util.*;

public class Garden {

    private final String asciiMap;
    private String[][] plotArray;
    private Graph graph;
    private Set<Plot> plots = new HashSet<>();
    private final Map<Vertex, Plot> plotMap = new HashMap<>();

    public Garden(String ascii) {
        asciiMap = ascii;
    }

    private Graph makeGraph() {
        Graph graph = new Graph();

        String[] rows = asciiMap.split("\n");
        int height = rows.length;
        int width = rows[0].length();
        plotArray = new String[height][width];

        int row = 0;
        for (String line : rows) {
            line = line.trim();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                String label = String.valueOf(chars[i]);
                plotArray[row][i] = label;
            }
            row++;
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                String label = plotArray[y][x];
                Vertex vertex = new Vertex(new Point(x, y), label);
                graph.addVertex(vertex);
            }
        }

        List<Vertex> vertices = graph.getAllVertices();
        for (Vertex vertex : vertices) {
            Point location = vertex.getLocation();
            for (int x = location.x-1; x<=location.x+1; x++) {
                if (x>=0 && x<width && x != location.x) {
                    vertex.addEdge(graph.getLocation(new Point(x, location.y)));
                }
            }
            for (int y = location.y-1; y<=location.y+1; y++) {
                if (y>=0 && y<height && y != location.y) {
                    vertex.addEdge(graph.getLocation(new Point(location.x, y)));
                }
            }
        }

        return graph;
    }

    public Graph getGardenGraph() {
        if (graph == null) {
            graph = makeGraph();
        }
        return graph;
    }

    public List<Plot> getPlots() {
        List<Vertex> vertices = graph.getAllVertices();
        for (Vertex vertex : vertices) {
            if (plotMap.get(vertex) == null) {
                Plot plot = new Plot(vertex);
                plots.add(plot);
                for (Vertex sibs : vertex.getSiblings()) {
                    plotMap.put(sibs, plot);
                }
            }
        }
        return new ArrayList<>(plots);
    }

    public long getFencePrice() {
        getGardenGraph();
        List<Plot> plots = getPlots();
        long price = 0;
        for (Plot plot : plots) {
            price += plot.getArea() * plot.getPerimeter();
        }
        return price;
    }
}
