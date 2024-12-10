package com.klr.advent;

import com.klr.advent.util.AntennaMap;
import com.klr.advent.util.FileLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DayEightTest {


    @Mock
    private FileLoader loader;

    @Test
    void findFreq() {
        String asciiMap =
                "..........\n" +
                        "...#......\n" +
                        "..........\n" +
                        "....a.....\n" +
                        "..........\n" +
                        ".....a....\n" +
                        "..........\n" +
                        "......#...\n" +
                        "..........\n" +
                        "..........";

        String[] lines = asciiMap.split("\n");
        AntennaMap map = new AntennaMap();
        for (String line : lines) {
            map.scanLine(line);
        }

        List<String> freqs = map.getFrequencies();
        assertAll("Map scanned correctly",
                () -> assertEquals(1, freqs.size()),
                () -> assertTrue(freqs.contains("a"))
        );
    }

    @Test
    void findMoreFreq() {
        String asciiMap =
                "............\n" +
                        "........0...\n" +
                        ".....0......\n" +
                        ".......0....\n" +
                        "....0.......\n" +
                        "......A.....\n" +
                        "............\n" +
                        "............\n" +
                        "........A...\n" +
                        ".........A..\n" +
                        "............\n" +
                        "............";

        String[] lines = asciiMap.split("\n");
        AntennaMap map = new AntennaMap();
        for (String line : lines) {
            map.scanLine(line);
        }

        List<String> freqs = map.getFrequencies();
        assertAll("Map scanned correctly",
                () -> assertEquals(2, freqs.size()),
                () -> assertTrue(freqs.contains("A")),
                () -> assertTrue(freqs.contains("0"))
        );
    }

    @Test
    void getPairs() {
        String asciiMap =
                "............\n" +
                        "........0...\n" +
                        ".....0......\n" +
                        ".......0....\n" +
                        "....0.......\n" +
                        "......A.....\n" +
                        "............\n" +
                        "............\n" +
                        "........A...\n" +
                        ".........A..\n" +
                        "............\n" +
                        "............";

        final Point a1 = new Point(6, 5);
        final Point a2 = new Point(8, 8);
        final Point a3 = new Point(9, 9);

        final Point[] expected1 = {a1, a2};
        final Point[] expected2 = {a1, a3};
        final Point[] expected3 = {a2, a3};


        String[] lines = asciiMap.split("\n");
        AntennaMap map = new AntennaMap();
        for (String line : lines) {
            map.scanLine(line);
        }

        List<Point[]> pairs = map.getPairs("A");
        boolean containsPair1 = false;
        boolean containsPair2 = false;
        boolean containsPair3 = false;
        for (Point[] pair : pairs) {
            List points = List.of(pair);
            containsPair1 = containsPair1 || points.contains(a1) && points.contains(a2);
            containsPair2 = containsPair2 || points.contains(a1) && points.contains(a3);
            containsPair3 = containsPair3 || points.contains(a2) && points.contains(a3);
        }

        assertEquals(3, pairs.size());
        assertTrue(containsPair1, "Pair 1");
        assertTrue(containsPair2, "Pair 2");
        assertTrue(containsPair3, "Pair 3");
    }

    @Test
    void getAntinodesForOnePair() {
        String asciiMap =
                        "............\n" +
                        "............\n" +
                        "..........#.\n" +
                        ".......0....\n" +
                        "....0.......\n" +
                        ".#..........\n" +
                        "............\n" +
                        "............\n" +
                        "............\n" +
                        "............\n" +
                        "............\n" +
                        "............";

        final Point antinode1 = new Point(10, 2);
        final Point antinode2 = new Point(1, 5);

        String[] lines = asciiMap.split("\n");
        AntennaMap map = new AntennaMap();
        for (String line : lines) {
            map.scanLine(line);
        }
        List<Point> antinodes = map.getAllAntinodes();
        assertEquals(2, antinodes.size());
        assertTrue(antinodes.contains(antinode1));
        assertTrue(antinodes.contains(antinode2));
    }

    @Test
    void getAntinodesForTwoPairs() {
        String asciiMap =
                "............\n" +
                        "............\n" +
                        "..........#.\n" +
                        ".......0....\n" +
                        "....0.......\n" +
                        ".#..........\n" +
                        "..a.........\n" +
                        "...a........\n" +
                        "....#.......\n" +
                        "............\n" +
                        "............\n" +
                        "............";

        final Point antinode1 = new Point(10, 2);
        final Point antinode2 = new Point(1, 5);
        final Point antinode3 = new Point(4, 8);

        String[] lines = asciiMap.split("\n");
        AntennaMap map = new AntennaMap();
        for (String line : lines) {
            map.scanLine(line);
        }
        List<Point> antinodes = map.getAllAntinodes();
        assertEquals(3, antinodes.size());
        assertTrue(antinodes.contains(antinode1));
        assertTrue(antinodes.contains(antinode2));
        assertTrue(antinodes.contains(antinode3));
    }

    @Test
    void ignoreAntinodesOffMap() {
        String asciiMap =
                "............\n" +
                        "............\n" +
                        "........0...\n" +
                        "............\n" +
                        "....0.......\n" +
                        ".#..........\n" +
                        "#.a.........\n" +
                        "...a........\n" +
                        "....#.......\n" +
                        "............\n" +
                        "............\n" +
                        "............";

        final Point antinode1 = new Point(1, 5);
        final Point antinode2 = new Point(4, 8);
        final Point antinode3 = new Point(0, 6);

        String[] lines = asciiMap.split("\n");
        AntennaMap map = new AntennaMap();
        for (String line : lines) {
            map.scanLine(line);
        }
        List<Point> antinodes = map.getAllAntinodes();
        assertEquals(3, antinodes.size());
        assertTrue(antinodes.contains(antinode1));
        assertTrue(antinodes.contains(antinode2));
        assertTrue(antinodes.contains(antinode3));
    }

    @Test
    void getAntinodesBigMap() {
        String asciiMap =
                "......#....#\n" +
                        "...#....0...\n" +
                        "....#0....#.\n" +
                        "..#....0....\n" +
                        "....0....#..\n" +
                        ".#....A.....\n" +
                        "...#........\n" +
                        "#......#....\n" +
                        "........A...\n" +
                        ".........A..\n" +
                        "..........#.\n" +
                        "..........#.";

        String[] lines = asciiMap.split("\n");
        AntennaMap map = new AntennaMap();
        for (String line : lines) {
            map.scanLine(line);
        }
        List<Point> antinodes = map.getAllAntinodes();
        assertEquals(14, antinodes.size());
    }


}