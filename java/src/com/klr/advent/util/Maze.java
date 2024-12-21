package com.klr.advent.util;

import java.awt.Point;
import java.util.*;

public class Maze {
    private final String asciiMap;
    private char[][] array;
    private final Map<Point, MazeNode> nodeMap = new Hashtable<>();
    private final Map<MazeNode, MazeNode> parents = new HashMap<>();
    private MazeNode endNode;

    public Maze(String asciiMap) {
        this.asciiMap = asciiMap;
    }
    public char[][] makeArray() {
        String[] lines = asciiMap.split("\n");
        char[][] array = new char[lines.length][lines[0].length()];
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

    private boolean isOpen(Point p) {
        return array[p.y][p.x] != '#';
    }

    public MazeNode getStartAndEndNodes() {
        makeArray();
        int height = array.length;
        int width = array[0].length;
        MazeNode startNode = new MazeNode(1,height-2, true);
        MazeNode endNode = new MazeNode(width-2,1);
        addNeighbors(startNode);
        nodeMap.put(startNode.location(), startNode);
        nodeMap.put(endNode.location(), endNode);
        this.endNode = endNode;
        return startNode;
    }



    private void addNeighbors(MazeNode node) {
        Point nodeLocation = node.location();
        boolean parentIsLR = node.isLR();
        Point north = new Point(nodeLocation.x, nodeLocation.y - 1);
        Point south = new Point(nodeLocation.x, nodeLocation.y + 1);
        Point west = new Point(nodeLocation.x - 1, nodeLocation.y);
        Point east = new Point(nodeLocation.x + 1, nodeLocation.y);

        if (inBounds(north) && isOpen(north)) {
            addNeighbor(north, node, false);
        }
        if (inBounds(south) && isOpen(south)) {
            addNeighbor(south, node, false);
        }

        if (inBounds(east) && isOpen(east)) {
            addNeighbor(east, node, true);
        }

        if (inBounds(west) && isOpen(west)) {
            addNeighbor(west, node, true);
        }
    }

    private void addNeighbor(Point p, MazeNode parent, boolean isLR) {
        MazeNode node = nodeMap.get(p);

        if (node == null) {
            node = new MazeNode(p.x, p.y, isLR);
            nodeMap.put(p, node);
            parent.addNeighbor(node);
            node.addParent(parent);
        }
        else {
            if (!node.isParent(parent)) {
                parent.addNeighbor(node);
                node.addParent(parent);
            }
        }
    }


    private Integer getCost(MazeNode origin,  MazeNode target) {
        boolean inLine = origin.isLR() && target.isLR() || !origin.isLR() && !target.isLR() || target.equals(endNode);
        return inLine ? 1 : 1001;
    }

    public long findBestPathToEnd() {
        MazeNode startNode = getStartAndEndNodes();

        Map<MazeNode, Integer> costs = new HashMap<>();
        parents.clear();
        List<MazeNode> visited = new ArrayList<>();


        for (MazeNode n : startNode.getNeighbors()) {
            costs.put(n, getCost(startNode,  n));
        }

        return dijkstraScore(costs, visited);
    }

    public int getBestPathLength() {
        findBestPathToEnd();
        int count = 0;
        MazeNode parent = parents.get(endNode);
        while (parent != null) {
            count++;
            parent = parents.get(parent);
        }
        List<MazeNode> allParents = new ArrayList<>(parents.keySet());
        Set<MazeNode> allValues = new HashSet<>(parents.values());
        System.out.println(allParents.size() + " " + allValues.size());


        return count;
    }



    public long dijkstraScore(Map<MazeNode, Integer> costs, List<MazeNode> visited) {
        MazeNode current = findLowestCostNode(costs, visited);
        while (current != null) {
            int cost = costs.get(current);
            for (MazeNode neighbor : current.getNeighbors()) {
                int newCost = cost + getCost(current, neighbor);
                Integer neighborCost = costs.get(neighbor);
                if (neighborCost == null ||  neighborCost > newCost) {
                    costs.put(neighbor, newCost);
                    parents.put(neighbor, current);
                }
            }
            visited.add(current);
            current = findLowestCostNode(costs, visited);
        }
        return costs.get(endNode);
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
        if (lowestCostNode != null) {
            addNeighbors(lowestCostNode);
        }
        return lowestCostNode;
    }



}
