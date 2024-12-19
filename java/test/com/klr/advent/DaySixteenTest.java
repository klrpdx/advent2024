package com.klr.advent;

import com.klr.advent.util.Maze;
import com.klr.advent.util.MazeNode;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.Collections;
import java.util.List;

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
        long score = maze.dijkstraScore();
        assertEquals(7036, score);
    }

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
        //List<Long> score = maze.pathsToEnd();
//        Collections.sort(score);
//        System.out.println(score);
//        System.out.println(asciiMap);
//        assertEquals(11048, score.getFirst());
    }

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

//        Maze maze = new Maze(asciiMap);
//        List<Long> score = maze.pathsToEnd();
//        Collections.sort(score);
//        System.out.println(score);
//        System.out.println(asciiMap);
//        assertEquals(11048, score.getFirst());
    }

}