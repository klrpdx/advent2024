package com.klr.advent.util;

import net.bytebuddy.build.Plugin;

import java.awt.Point;
import java.util.*;

public class Maze {
    private final String asciiMap;
    private char[][] array;
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
            array[count] = line.toCharArray();
            count++;
        }
        this.array = array;
        return array;
    }




    private boolean inBounds(Point p) {
        return p.x >= 0 && p.x < array[0].length && p.y >= 0 && p.y < array.length;
    }

    private boolean isWall(Point p) {
        return array[p.y][p.x] == '#';
    }




    private void addNeighbors(MazeNode node) {
        Point nodeLocation = node.location();
        Point north = new Point(nodeLocation.x, nodeLocation.y - 1);
        Point south = new Point(nodeLocation.x, nodeLocation.y + 1);
        Point west = new Point(nodeLocation.x - 1, nodeLocation.y);
        Point east = new Point(nodeLocation.x + 1, nodeLocation.y);
        if (inBounds(north) && !isWall(north)) {
            node.addNeighbor(new MazeNode(array[north.y][north.x]));
        }

        if (inBounds(south) && !isWall(north)) {
            node.addNeighbor(new MazeNode(array[south.y][south.x]));
        }

        if (inBounds(east) && !isWall(north)) {
            node.addNeighbor(new MazeNode(array[east.y][east.x]));
        }

        if (inBounds(west) && !isWall(north)) {
            node.addNeighbor(new MazeNode(array[west.y][west.x]));
        }

    }

    private Integer getCost(MazeNode n, Compass travelDirection) {
        Point nodeLocation = n.location();

        return null;
    }

    public long findLeastCostToEnd() {
        makeArray();
        int height = array.length;
        MazeNode startNode = new MazeNode(array[1][height - 2]);
        addNeighbors(startNode);

        Map<MazeNode, Integer> costs = new HashMap<>();
        Map<MazeNode, MazeNode> parents = new HashMap<>();
        List<MazeNode> visited = new ArrayList<>();
        Compass travelDirection = Compass.EAST;


        for (MazeNode n : startNode.getNeighbors()) {
            costs.put(n, getCost(n, travelDirection));
        }

        return 0;
    }


    public long dijkstraScore() {
        long totalCost = 0;
        Map<MazeNode, Integer> costs = new HashMap<>();
        Map<MazeNode, MazeNode> parents = new HashMap<>();
        List<MazeNode> visited = new ArrayList<>();
        //MazeNode startNode = startNode();
        //costs.put(startNode.getNeighbor(Compass.EAST), 1);
        //costs.put(startNode.getNeighbor(Compass.NORTH), 1001);
        Compass travelDirection = Compass.EAST;

        MazeNode current = findLowestCostNode(costs, visited);
        while (current != null) {
            int cost = costs.get(current);
            //MazeNode cheapNeighbor = current.getNeighbor(travelDirection);
            //List<MazeNode> expensiveNeighbors = current.getOtherNeighbors(travelDirection);
            Map<MazeNode, Integer> myCosts = new HashMap<>();
            List<MazeNode> neighbors = new ArrayList<>(myCosts.keySet());
//            if (cheapNeighbor != null) {
//                myCosts.put(cheapNeighbor, 1);
//                neighbors.add(cheapNeighbor);
//            }
//            for (MazeNode neighbor : expensiveNeighbors) {
//                myCosts.put(neighbor, 1001);
//            }

            for (MazeNode neighbor : neighbors) {
                int newCost = cost + myCosts.get(neighbor);
                if (costs.get(neighbor) == null || costs.get(neighbor) > newCost) {
                    costs.put(neighbor, newCost);
                    parents.put(neighbor, current);
                }
            }
            visited.add(current);
            current = findLowestCostNode(costs, visited);
        }
        return totalCost;
    }

    private MazeNode findLowestCostNode(Map<MazeNode, Integer> costs, List<MazeNode> visited) {
        int lowestCost = Integer.MAX_VALUE;
        MazeNode lowestCostNode = null;
        for (MazeNode node : costs.keySet()) {
            int cost = costs.get(node);
            if (cost < lowestCost && !visited.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }



}
