package com.klr.advent;

import com.klr.advent.util.Garden;
import com.klr.advent.util.Graph;
import com.klr.advent.util.Plot;
import com.klr.advent.util.Vertex;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DayTwelveTest {


    @Test
    void makeGraph() {
        final String ascii =
                "AAAA\n" +
                "BBCD\n" +
                "BBCC\n" +
                "EEEC";


        Garden plot = new Garden(ascii);
        Graph graph = plot.getGardenGraph();
        Vertex upperLeft = graph.getLocation(new Point(0,0));
        assertEquals("A", upperLeft.getLabel());

        Point right = new Point(1, 0);
        Point below = new Point(0, 1);
        List<Vertex> connections = upperLeft.getConnections();
        assertTrue(connections.contains(new Vertex(right,"A")));
        assertTrue(connections.contains(new Vertex(below,"B")));
    }

     @Test
     void makeGraphMiddle() {
        final String ascii =
                "AAAA\n" +
                "BBCD\n" +
                "BBCC\n" +
                "EEEC";


        Garden plot = new Garden(ascii);
        Graph graph = plot.getGardenGraph();
        Vertex upperLeft = graph.getLocation(new Point(2,2));
        assertEquals("C", upperLeft.getLabel());

        Point left = new Point(1, 2);
        Point right = new Point(3, 2);
        Point up = new Point(2, 1);
        Point below = new Point(2, 3);
        List<Vertex> connections = upperLeft.getConnections();
        assertEquals(4, connections.size());
        assertTrue(connections.contains(new Vertex(left,"B")));
        assertTrue(connections.contains(new Vertex(right,"C")));
        assertTrue(connections.contains(new Vertex(up,"C")));
        assertTrue(connections.contains(new Vertex(below,"E")));
    }

    @Test
    void findSiblings() {
        final String ascii =
                "AAAA\n" +
                        "BBCD\n" +
                        "BBCC\n" +
                        "EEEC";


        Garden plot = new Garden(ascii);
        Graph graph = plot.getGardenGraph();
        Vertex upperLeft = graph.getLocation(new Point(0,0));
        List<Vertex> vertices = upperLeft.getSiblings();
        Point s1 = new Point(1, 0);
        Point s2 = new Point(2, 0);
        Point s3 = new Point(3, 0);
        assertEquals(4, vertices.size());
        assertTrue(vertices.contains(upperLeft));
        assertTrue(vertices.contains(new Vertex(s1,"A")));
        assertTrue(vertices.contains(new Vertex(s2,"A")));
        assertTrue(vertices.contains(new Vertex(s3,"A")));
    }

    @Test
    void findSiblingsofC() {
        final String ascii =
                "AAAA\n" +
                        "BBCD\n" +
                        "BBCC\n" +
                        "EEEC";


        Garden plot = new Garden(ascii);
        Graph graph = plot.getGardenGraph();
        Vertex me = graph.getLocation(new Point(3,3));
        List<Vertex> vertices = me.getSiblings();
        Point s1 = new Point(2, 2);
        Point s2 = new Point(2, 2);
        Point s3 = new Point(3, 2);
        assertEquals(4, vertices.size());
        assertTrue(vertices.contains(me));
        assertTrue(vertices.contains(new Vertex(s1,"C")));
        assertTrue(vertices.contains(new Vertex(s2,"C")));
        assertTrue(vertices.contains(new Vertex(s3,"C")));
    }

    @Test
    void getAllPlots() {
        final String ascii =
                "AAAA\n" +
                        "BBCD\n" +
                        "BBCC\n" +
                        "EEEC";

        Garden garden = new Garden(ascii);
        Graph graph = garden.getGardenGraph();
        List<Plot> plots = garden.getPlots();
        assertEquals(5, plots.size());
    }

    @Test
    void getAllPlotsXO() {
        final String ascii =
                "OOOOO\n" +
                        "OXOXO\n" +
                        "OOOOO\n" +
                        "OXOXO\n" +
                        "OOOOO";

        Garden garden = new Garden(ascii);
        Graph graph = garden.getGardenGraph();
        List<Plot> plots = garden.getPlots();
        assertEquals(5, plots.size());
    }

    @Test
    void getAllPlotsLarge() {
        final String ascii =
                "RRRRIICCFF\n" +
                        "RRRRIICCCF\n" +
                        "VVRRRCCFFF\n" +
                        "VVRCCCJFFF\n" +
                        "VVVVCJJCFE\n" +
                        "VVIVCCJJEE\n" +
                        "VVIIICJJEE\n" +
                        "MIIIIIJJEE\n" +
                        "MIIISIJEEE\n" +
                        "MMMISSJEEE";

        Garden garden = new Garden(ascii);
        Graph graph = garden.getGardenGraph();
        List<Plot> plots = garden.getPlots();
        assertEquals(11, plots.size());
    }

}