package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.Graph;
import com.klr.advent.util.TopoMap;
import com.klr.advent.util.Vertex;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DayTenTest {

    @Mock
    private FileLoader fileLoader;


    @Test
    void createMap() {
        String ascii =
                "0123\n" +
                        "1234\n" +
                        "8765\n" +
                        "9876";

        final int[][] expected = {{0, 1, 2, 3}, {1, 2, 3, 4}, {8, 7, 6, 5}, {9, 8, 7, 6}};

        TopoMap map = new TopoMap(ascii);
        int[][] mapArray = map.createArray();
        assertArrayEquals(expected, mapArray);
    }


    @Test
    void readFile() throws IOException {
        DayTen dayTen = new DayTen(fileLoader);
        when(fileLoader.readLine())
                .thenReturn("0123")
                .thenReturn("1234")
                .thenReturn("8765")
                .thenReturn("9876")
                .thenReturn(null);

        final int[][] expected = {{0, 1, 2, 3}, {1, 2, 3, 4}, {8, 7, 6, 5}, {9, 8, 7, 6}};
        assertArrayEquals(expected, dayTen.parseFile());
    }

    @Test
    void getConnected() {
        String ascii =
                "0123\n" +
                "1234\n" +
                "8765\n" +
                "9876";

        Vertex v0 = new Vertex(0,0);
        Vertex v1 = new Vertex(1,1);
        Vertex v2 = new Vertex(4,1);
        List<Vertex> expected = Arrays.asList(v1,v2);

        TopoMap map = new TopoMap(ascii);
        Graph graph = map.createGraph();
        List<Vertex> actual = graph.getEdges(v0 );
        assertTrue(actual.containsAll(expected));
    }

    @Test
    void getAlsoConnected() {
        String ascii =
                "0123\n" +
                        "1234\n" +
                        "8765\n" +
                        "9876";

        Vertex v0 = new Vertex(8,8);
        Vertex v1 = new Vertex(12,9);
        List<Vertex> expected = List.of(v1);

        TopoMap map = new TopoMap(ascii);
        Graph graph = map.createGraph();
        List<Vertex> actual = graph.getEdges(v0 );
        assertTrue(actual.containsAll(expected));
    }

    @Test
    void getPaths() {
        String ascii =
                "0123\n" +
                        "1234\n" +
                        "8765\n" +
                        "9876";
        TopoMap map = new TopoMap(ascii);
        Graph graph = map.createGraph();
        Vertex v0 = new Vertex(0, 0);

        assertEquals(1, graph.findPathTo(v0, 9).size());
    }

    @Test
    void getScore() {
        String ascii =
                "5550555\n" +
                        "5551555\n" +
                        "7772778\n" +
                        "6543456\n" +
                        "7222227\n" +
                        "8222228\n" +
                        "9222229";

        TopoMap map = new TopoMap(ascii);
        Graph graph = map.createGraph();
        Set<Vertex> trailheads = map.getTrailheads();
        int score = 0;
        for (Vertex v : trailheads) {
            score += graph.findPathTo(v, 9).size();
        }

        assertEquals(2, score);
    }

    @Test
    void getScoreComplex() {
        String ascii =
                "89010123\n" +
                        "78121874\n" +
                        "87430965\n" +
                        "96549874\n" +
                        "45678903\n" +
                        "32019012\n" +
                        "01329801\n" +
                        "10456732";

        TopoMap map = new TopoMap(ascii);
        Graph graph = map.createGraph();
        Set<Vertex> trailheads = map.getTrailheads();
        int score = 0;
        for (Vertex v : trailheads) {
            score += graph.findPathTo(v, 9).size();
        }

        assertEquals(36, score);
    }
}