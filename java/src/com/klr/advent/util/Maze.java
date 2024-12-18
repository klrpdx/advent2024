package com.klr.advent.util;

import java.awt.Point;
import java.util.Hashtable;
import java.util.Map;

public class Maze {
    private final String asciiMap;
    private final Map<Point, MazeNode> nodeMap = new Hashtable<>();
    private MazeNode startNode;
    private MazeNode endNode;

    public Maze(String asciiMap) {
        this.asciiMap = asciiMap;
    }


    public char[][] makeArray() {
        String[] lines = asciiMap.split("\n");
        char[][] array = new char[asciiMap.length()][lines[0].length()];
        int count = 0;
        for (String line : lines) {
            array[count] =  line.toCharArray();
            count++;
        }
        return array;
    }

    private void makeNodes() {
        char[][] array = makeArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                MazeNode node = new MazeNode(array[i][j]);
                nodeMap.put(new Point(j, i), node);
                node.setLocation(new Point(j,i));
                if (node.isStart()) {
                    startNode = node;
                }
            }
        }
    }

    public MazeNode getAt(Point point) {
        if (nodeMap.isEmpty()) {
            makeNodes();
        }
        return nodeMap.get(point);
    }

    public MazeNode startNode() {
        if (nodeMap.isEmpty()) {
            makeNodes();
        }
        return startNode;
    }
}
