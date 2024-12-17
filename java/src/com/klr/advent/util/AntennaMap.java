package com.klr.advent.util;

import java.awt.Point;
import java.util.List;
import java.util.*;

public class AntennaMap {

    private final List<char[]> rows = new ArrayList<>();
    private final Set<String> uniqueFrequencies = new HashSet<>();
    private final Set<Point> antinodes = new HashSet<>();
    private final Map<String, List<Point>> antennaLocations = new HashMap<>();


    public void scanLine(String line) {

        char[] row = line.toCharArray();
        for (int i = 0; i < row.length; i++) {
            char aChar = row[i];
            if (Character.isLetter(aChar) || Character.isDigit(aChar)) {
                String key = Character.toString(aChar);
                uniqueFrequencies.add(key);
                Point newPoint = new Point(i, rows.size());
                List<Point> locs = antennaLocations.get(key);
                if (locs == null) {
                    locs = new ArrayList<>();
                }
                locs.add(newPoint);
                antennaLocations.put(key, locs);
            }
        }
        rows.add(row);

    }

    public List<String> getFrequencies() {
        return new ArrayList<>(uniqueFrequencies);
    }

    public List<Point[]> getPairs(String freq) {
        List<Point[]> pairs = new ArrayList<>();
        List<Point> locations = antennaLocations.get(freq);
        for (int i = 0; i < locations.size(); i++) {
            Point point = locations.get(i);
            for (int j = i + 1; j < locations.size(); j++) {
                Point point2 = locations.get(j);
                pairs.add(new Point[]{point, point2});
            }
        }
        return pairs;
    }

    private boolean onMap(int x, int y) {
        return x >= 0 && x < rows.size() && y >= 0 && y < rows.size();
    }


    private Set<Point> findAntinodes(Point[] pair) {
        Point p1 = pair[0];
        Point p2 = pair[1];
        int xChange = p1.x - p2.x;
        int yChange = p1.y - p2.y;
        Set<Point> antinodes = new HashSet<>();
        antinodes.add(p1);
        antinodes.add(p2);
        int newX = p1.x + xChange;
        int newY = p1.y + yChange;
        while (onMap(newX, newY)) {
            antinodes.add(new Point(newX, newY));
            newX += xChange;
            newY += yChange;
        }
        newX = p1.x - xChange;
        newY = p1.y - yChange;
        while (onMap(newX, newY)) {
            antinodes.add(new Point(newX, newY));
            newX -= xChange;
            newY -= yChange;
        }
        return antinodes;
    }

    public List<Point> getAllAntinodes() {
        Set<Point> antinodes = new HashSet<>();
        for (String freq : uniqueFrequencies) {
            List<Point[]> pairs = getPairs(freq);
            for (Point[] pair : pairs) {
                antinodes.addAll(findAntinodes(pair));
            }
        }
        return new ArrayList<>(antinodes);
    }
}
