package com.klr.advent;

import com.klr.advent.util.FileLoader;
import com.klr.advent.util.TrailGraph;
import com.klr.advent.util.TopoMap;
import com.klr.advent.util.TrailVertex;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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
    void getConnected() {
        String ascii =
                "0123\n" +
                "1234\n" +
                "8765\n" +
                "9876";

        TrailVertex v0 = new TrailVertex(0,0);
        TrailVertex v1 = new TrailVertex(1,1);
        TrailVertex v2 = new TrailVertex(4,1);
        List<TrailVertex> expected = Arrays.asList(v1,v2);

        TopoMap map = new TopoMap(ascii);
        TrailGraph graph = map.createGraph();
        List<TrailVertex> actual = graph.getEdges(v0 );
        assertTrue(actual.containsAll(expected));
    }

    @Test
    void getAlsoConnected() {
        String ascii =
                "0123\n" +
                        "1234\n" +
                        "8765\n" +
                        "9876";

        TrailVertex v0 = new TrailVertex(8,8);
        TrailVertex v1 = new TrailVertex(12,9);
        List<TrailVertex> expected = List.of(v1);

        TopoMap map = new TopoMap(ascii);
        TrailGraph graph = map.createGraph();
        List<TrailVertex> actual = graph.getEdges(v0 );
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
        TrailGraph graph = map.createGraph();
        TrailVertex v0 = new TrailVertex(0, 0);

        assertEquals(1, graph.findUniquePathTo(v0, 9).size());
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
        TrailGraph graph = map.createGraph();
        Set<TrailVertex> trailheads = map.getTrailheads();
        int score = 0;
        for (TrailVertex v : trailheads) {
            score += graph.findUniquePathTo(v, 9).size();
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
        TrailGraph graph = map.createGraph();
        Set<TrailVertex> trailheads = map.getTrailheads();
        int score = 0;
        for (TrailVertex v : trailheads) {
            score += graph.findUniquePathTo(v, 9).size();
        }

        assertEquals(36, score);
    }

    @Test
    void getScoreAllPaths() {
        String ascii =
                "5550555\n" +
                        "5551555\n" +
                        "7772778\n" +
                        "6543456\n" +
                        "7222227\n" +
                        "8222228\n" +
                        "9222229";

        TopoMap map = new TopoMap(ascii);
        TrailGraph graph = map.createGraph();
        Set<TrailVertex> trailheads = map.getTrailheads();
        int score = 0;
        for (TrailVertex v : trailheads) {
            score += graph.findAllPathsTo(v, 9).size();
        }

        assertEquals(2, score);
    }

    @Test
    void getScoreAllPathsHarder() {
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
        TrailGraph graph = map.createGraph();
        Set<TrailVertex> trailheads = map.getTrailheads();
        int score = 0;
        for (TrailVertex v : trailheads) {
            score += graph.findAllPathsTo(v, 9).size();
        }

        assertEquals(81, score);
    }

}