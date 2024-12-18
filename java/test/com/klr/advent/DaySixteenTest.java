package com.klr.advent;

import com.klr.advent.util.Maze;
import com.klr.advent.util.MazeNode;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DaySixteenTest {


    @Test
    public void buildArray() {
        String asciiMap = "###############\n" +
                "#.......#....E#\n" +
                "#.#.###.#.###.#\n" +
                "#.....#.#...#.#\n" +
                "#.###.#####.#.#\n" +
                "#.#.#.......#.#\n" +
                "#.#.#####.###.#\n" +
                "#...........#.#\n" +
                "###.#.#####.#.#\n" +
                "#...#.....#.#.#\n" +
                "#.#.#.###.#.#.#\n" +
                "#.....#...#.#.#\n" +
                "#.###.#.#.#.#.#\n" +
                "#S..#.....#...#\n" +
                "###############";

        Maze maze = new Maze(asciiMap);
        char[][] mazeArray = maze.makeArray();

        assertEquals('S', mazeArray[13][1]);
        assertEquals('E', mazeArray[1][13]);
    }

    @Test
    public void buildNodes() {
        String asciiMap = "###############\n" +
                "#.......#....E#\n" +
                "#.#.###.#.###.#\n" +
                "#.....#.#...#.#\n" +
                "#.###.#####.#.#\n" +
                "#.#.#.......#.#\n" +
                "#.#.#####.###.#\n" +
                "#...........#.#\n" +
                "###.#.#####.#.#\n" +
                "#...#.....#.#.#\n" +
                "#.#.#.###.#.#.#\n" +
                "#.....#...#.#.#\n" +
                "#.###.#.#.#.#.#\n" +
                "#S..#.....#...#\n" +
                "###############";

        Maze maze = new Maze(asciiMap);
        MazeNode node = maze.getAt(new Point(8, 1));
        assertTrue(node.isWall());
    }


    @Test
    public void startNode() {
        String asciiMap = "###############\n" +
                "#.......#....E#\n" +
                "#.#.###.#.###.#\n" +
                "#.....#.#...#.#\n" +
                "#.###.#####.#.#\n" +
                "#.#.#.......#.#\n" +
                "#.#.#####.###.#\n" +
                "#...........#.#\n" +
                "###.#.#####.#.#\n" +
                "#...#.....#.#.#\n" +
                "#.#.#.###.#.#.#\n" +
                "#.....#...#.#.#\n" +
                "#.###.#.#.#.#.#\n" +
                "#S..#.....#...#\n" +
                "###############";

        Maze maze = new Maze(asciiMap);
        MazeNode node = maze.startNode();
        assertEquals(new Point(1, 13), node.location());
    }
}