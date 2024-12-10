package com.klr.advent.util;

import java.awt.*;
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

    private boolean onMap(Point point) {
        return point.x >= 0 && point.x < rows.size() && point.y >= 0 && point.y < rows.size();
    }


    private Point[] findAntinodes(Point[] pair) {
        Point p1 = pair[0];
        Point p2 = pair[1];
        int x = p1.x - p2.x;
        int y = p1.y - p2.y;
        Point[] antinodes = new Point[2];
        antinodes[0] = new Point(p1.x+x, p1.y+y);
        antinodes[1] = new Point(p2.x-x, p2.y-y);
        return antinodes;
    }

    public List<Point> getAllAntinodes() {
        for (String freq : uniqueFrequencies) {
            List<Point[]> pairs = getPairs(freq);
            for (Point[] pair : pairs) {
                Point[] antinode = findAntinodes(pair);
                if (onMap(antinode[0])) {
                    antinodes.add(antinode[0]);
                }
                if (onMap(antinode[1])) {
                    antinodes.add(antinode[1]);
                }
            }
        }
        return new ArrayList<>(antinodes);
    }
}
