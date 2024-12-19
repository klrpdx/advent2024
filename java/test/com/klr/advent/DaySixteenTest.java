package com.klr.advent;

import com.klr.advent.util.Maze;
import com.klr.advent.util.MazeNode;
import org.junit.jupiter.api.Disabled;
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
    void startNode() {

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
        Point point = new Point(1, 13);
        MazeNode startNode = maze.getStartNode();
        assertEquals(point, startNode.location());
        assertEquals(2, startNode.getNeighbors().size());
    }


    @Test
    public void bestPath() {
        String asciiMap =
                "###############\n" +
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
        assertEquals(7036, maze.findBestPathToEnd());
    }

    @Disabled
    @Test
    public void bestPathLarger() {
        String asciiMap =
                "#################\n" +
                        "#...#...#...#..E#\n" +
                        "#.#.#.#.#.#.#.#.#\n" +
                        "#.#.#.#...#...#.#\n" +
                        "#.#.#.#.###.#.#.#\n" +
                        "#...#.#.#.....#.#\n" +
                        "#.#.#.#.#.#####.#\n" +
                        "#.#...#.#.#.....#\n" +
                        "#.#.#####.#.###.#\n" +
                        "#.#.#.......#...#\n" +
                        "#.#.###.#####.###\n" +
                        "#.#.#...#.....#.#\n" +
                        "#.#.#.#####.###.#\n" +
                        "#.#.#.........#.#\n" +
                        "#.#.#.#########.#\n" +
                        "#S#.............#\n" +
                        "#################";

        Maze maze = new Maze(asciiMap);
        assertEquals(11048, maze.findBestPathToEnd());
    }

    @Disabled
    @Test
    public void bestPathLargerMod() {
        String asciiMap =
                "#################\n" +
                        "#...#...#...#..E#\n" +
                        "#.#.#.#.#.#.#.#.#\n" +
                        "#.#.#.#...#...#.#\n" +
                        "#####.#.###.#.#.#\n" +
                        "#...#.#.#.....#.#\n" +
                        "#.#.#.#.#.#####.#\n" +
                        "#.#.#.#.#.#...#.#\n" +
                        "#.#.#####.#.###.#\n" +
                        "#.#.#.......#...#\n" +
                        "#.#.###.#####.###\n" +
                        "#.#.#...###...#.#\n" +
                        "#.#.#######.###.#\n" +
                        "#.#.#.......###.#\n" +
                        "#.#.#.#########.#\n" +
                        "#S#...#.........#\n" +
                        "#################";

        Maze maze = new Maze(asciiMap);
        assertEquals(11048, maze.findBestPathToEnd());
    }

}