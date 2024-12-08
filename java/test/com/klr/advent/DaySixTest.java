package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.LabMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DaySixTest {


    @Mock
    private FileLoader loader;

    @Test
    void createMap() {
        List<String> rows = new ArrayList<>();
        rows.add("....#.....");
        LabMap map = new LabMap(rows);
        assertTrue(map.getLocation(0, 4));
        assertFalse(map.getLocation(0, 5));
    }

    @Test
    void findGuard() {
        List<String> rows = new ArrayList<>();
        rows.add("....#.....");
        rows.add(".#..#..^..");
        LabMap map = new LabMap(rows);
        Point point = new Point(7, 1);
        assertEquals(point, map.guardLocation());
    }

    @Test
    void move() {
        List<String> rows = new ArrayList<>();
        rows.add("....#.....");
        rows.add(".#..#..^..");
        LabMap map = new LabMap(rows);

        Point point = new Point(7, 0);
        map.move();
        assertEquals(point, map.guardLocation());
    }

    @Test
    void moveRight() {
        List<String> rows = new ArrayList<>();
        rows.add("....#.....");
        rows.add(".#..#..>..");
        LabMap map = new LabMap(rows);

        Point point = new Point(8, 1);
        map.move();
        assertEquals(point, map.guardLocation());
    }

    @Test
    void moveLeft() {
        List<String> rows = new ArrayList<>();
        rows.add("....#.....");
        rows.add(".#..#..<..");
        LabMap map = new LabMap(rows);

        Point point = new Point(6, 1);
        map.move();
        assertEquals(point, map.guardLocation());
    }

    @Test
    void moveOffSide() {
        List<String> rows = new ArrayList<>();
        rows.add("....#.....");
        rows.add(".#..#..>..");
        LabMap map = new LabMap(rows);

        map.move();
        map.move();
        map.move();
        assertTrue(map.guardHasLeftTheBuilding());
    }

    @Test
    void hitObstacle() {
        List<String> rows = new ArrayList<>();
        rows.add("....#.....");
        rows.add(".#..#..<..");
        LabMap map = new LabMap(rows);

        map.move();
        map.move();
        assertFalse(map.move());
    }

    @Test
    void countMoves() {
        List<String> rows = new ArrayList<>();
        rows.add("....#.....");
        rows.add(".#..#..<..");
        LabMap map = new LabMap(rows);

        map.move();
        map.move();
        assertEquals(3, map.totalVisited());
    }

    @Test
    void changeDirection() {
        List<String> rows = new ArrayList<>();
        rows.add("....#.....");
        rows.add(".#..#..<..");
        LabMap map = new LabMap(rows);

        map.move();
        map.move();
        map.turnRight();
        map.move();
        Point point = new Point(5, 0);
        assertEquals(4, map.totalVisited());
        assertEquals(point, map.guardLocation());
    }


    @Test
    void solver() throws IOException {
        DaySix daySix = new DaySix(loader);
        when(loader.readLine())
                .thenReturn("....#.....")
                .thenReturn(".........#")
                .thenReturn("..........")
                .thenReturn("..#.......")
                .thenReturn(".......#..")
                .thenReturn("..........")
                .thenReturn(".#..^.....")
                .thenReturn("........#.")
                .thenReturn("#.........")
                .thenReturn("......#...")
                .thenReturn(null);

        int moves = daySix.solve();
        assertEquals(41, moves);
    }

    @Test
    void loopSolver() throws IOException {
        DaySix daySix = new DaySix(loader);
        when(loader.readLine())
                .thenReturn("....#.....")
                .thenReturn(".........#")
                .thenReturn("..........")
                .thenReturn("..#.......")
                .thenReturn(".......#..")
                .thenReturn("..........")
                .thenReturn(".#..^.....")
                .thenReturn("........#.")
                .thenReturn("#.........")
                .thenReturn("......#...")
                .thenReturn(null);

        daySix.solve();
        int loops = daySix.solve2();
        assertEquals(6, loops);
    }

}