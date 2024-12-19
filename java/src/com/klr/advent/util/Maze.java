package com.klr.advent.util;

import net.bytebuddy.build.Plugin;

import java.awt.Point;
import java.util.*;

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
            array[count] = line.toCharArray();
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
                node.setLocation(new Point(j, i));
                if (node.isStart()) {
                    startNode = node;
                }
                if (node.isEnd()) {
                    endNode = node;
                }
            }
        }
        Set<MazeNode> visitedNodes = new HashSet<>();
        getNeighbors(startNode, visitedNodes);
    }


    public void getNeighbors(MazeNode node, Set<MazeNode> visitedNodes) {

        if (visitedNodes.contains(node)) {
            return;
        }

        visitedNodes.add(node);

        Point nodeLocation = node.location();
        Point north = new Point(nodeLocation.x, nodeLocation.y - 1);
        Point south = new Point(nodeLocation.x, nodeLocation.y + 1);
        Point west = new Point(nodeLocation.x - 1, nodeLocation.y);
        Point east = new Point(nodeLocation.x + 1, nodeLocation.y);

        if (inBounds(north)) {
            MazeNode neighborNode = nodeMap.get(north);
            if (!node.contains(neighborNode) && !neighborNode.isWall()) {
                node.addNeighbor(Compass.NORTH, neighborNode);
                getNeighbors(neighborNode, visitedNodes);
            }
        }
        if (inBounds(south)) {
            MazeNode neighborNode = nodeMap.get(south);
            if (!node.contains(neighborNode) && !neighborNode.isWall()) {
                node.addNeighbor(Compass.SOUTH, neighborNode);
                getNeighbors(neighborNode, visitedNodes);
            }
        }
        if (inBounds(east)) {
            MazeNode neighborNode = nodeMap.get(east);
            if (!node.contains(neighborNode) && !neighborNode.isWall()) {
                node.addNeighbor(Compass.EAST, neighborNode);
                getNeighbors(neighborNode, visitedNodes);
            }
        }
        if (inBounds(west)) {
            MazeNode neighborNode = nodeMap.get(west);
            if (!node.contains(neighborNode) && !neighborNode.isWall()) {
                node.addNeighbor(Compass.WEST, neighborNode);
                getNeighbors(neighborNode, visitedNodes);
            }
        }
    }

    private boolean inBounds(Point p) {
        return p.x >= 0 && p.x < asciiMap.length() && p.y >= 0 && p.y < asciiMap.length();
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


    public List<Long> pathsToEnd(MazeNode node, Compass direction,  List<MazeNode> visited, long entryCost, List<Long> pathCosts) {

        if (node.equals(endNode)) {
            pathCosts.add(entryCost);
            return pathCosts;
        }

        visited.add(node);
        entryCost++;
        MazeNode neighbor = node.getNeighbor(direction);
        if (neighbor != null &&  !visited.contains(neighbor)) {
            pathCosts = pathsToEnd(neighbor, direction, visited, entryCost, pathCosts);
        }

        long cost = 0;
        if (direction != Compass.NORTH) {
            neighbor = node.getNeighbor(Compass.NORTH);
            if (neighbor != null && !visited.contains(neighbor)) {
                cost = entryCost + 1000L * Compass.diff(direction, Compass.NORTH);
                pathCosts = pathsToEnd(neighbor, Compass.NORTH, visited, cost, pathCosts);
            }
        }

        if (direction != Compass.EAST) {
            neighbor = node.getNeighbor(Compass.EAST);
            if (neighbor != null && !visited.contains(neighbor)) {
                cost = entryCost + 1000L * Compass.diff(direction, Compass.EAST);
                pathCosts = pathsToEnd(neighbor, Compass.EAST, visited, cost, pathCosts);
            }
        }

        if (direction != Compass.SOUTH) {
            neighbor = node.getNeighbor(Compass.SOUTH);
            if (neighbor != null && !visited.contains(neighbor)) {
                cost = entryCost + 1000L * Compass.diff(direction, Compass.SOUTH);
                pathCosts = pathsToEnd(neighbor, Compass.SOUTH, visited, cost, pathCosts);
            }
        }

        if (direction != Compass.WEST) {
            neighbor = node.getNeighbor(Compass.WEST);
            if (neighbor != null && !visited.contains(neighbor)) {
                cost = entryCost +  1000L * Compass.diff(direction, Compass.WEST);
                pathCosts = pathsToEnd(neighbor, Compass.WEST, visited, cost, pathCosts);
            }
        }


        visited.remove(node);
        return pathCosts;
    }

    public long dijkstraScore() {
        long totalCost = 0;
        Map<MazeNode, Integer> costs = new HashMap<>();
        Map<MazeNode, MazeNode> parents = new HashMap<>();
        List<MazeNode> visited = new ArrayList<>();
        MazeNode startNode = startNode();
        costs.put(startNode.getNeighbor(Compass.EAST), 1);
        costs.put(startNode.getNeighbor(Compass.NORTH), 1001);
        Compass travelDirection = Compass.EAST;

        MazeNode current = findLowestCostNode(costs, visited);
        while (current != null) {
            int cost = costs.get(current);
            MazeNode cheapNeighbor = current.getNeighbor(travelDirection);
            List<MazeNode> expensiveNeighbors = current.getOtherNeighbors(travelDirection);
            Map<MazeNode, Integer> myCosts = new HashMap<>();
            List<MazeNode> neighbors = new ArrayList<>(myCosts.keySet());
            if (cheapNeighbor != null) {
                myCosts.put(cheapNeighbor, 1);
                neighbors.add(cheapNeighbor);
            }
            for (MazeNode neighbor : expensiveNeighbors) {
                myCosts.put(neighbor, 1001);
            }

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


    public List<Long> pathsToEnd() {
        List<MazeNode> visited = new ArrayList<>();
        List<Long> pathCosts = new ArrayList<>();
        visited.add(startNode());
        return pathsToEnd(startNode, Compass.EAST, visited, 0, pathCosts);
    }

}
