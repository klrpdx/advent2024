package com.klr.advent;

import com.klr.advent.util.Garden;
import com.klr.advent.util.Graph;
import com.klr.advent.util.Plot;
import com.klr.advent.util.Vertex;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
        Vertex upperLeft = graph.getLocation(new Point(0, 0));
        assertEquals("A", upperLeft.getLabel());

        Point right = new Point(1, 0);
        Point below = new Point(0, 1);
        List<Vertex> connections = upperLeft.getConnections();
        assertTrue(connections.contains(new Vertex(right, "A")));
        assertTrue(connections.contains(new Vertex(below, "B")));
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
        Vertex middleC = graph.getLocation(new Point(2, 2));
        assertEquals("C", middleC.getLabel());

        Point left = new Point(1, 2);
        Point right = new Point(3, 2);
        Point up = new Point(2, 1);
        Point below = new Point(2, 3);
        List<Vertex> connections = middleC.getConnections();
        assertEquals(8, connections.size());
        assertTrue(connections.contains(new Vertex(left, "B")));
        assertTrue(connections.contains(new Vertex(right, "C")));
        assertTrue(connections.contains(new Vertex(up, "C")));
        assertTrue(connections.contains(new Vertex(below, "E")));
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
        Vertex upperLeft = graph.getLocation(new Point(0, 0));
        List<Vertex> vertices = upperLeft.getSiblings();
        Point s1 = new Point(1, 0);
        Point s2 = new Point(2, 0);
        Point s3 = new Point(3, 0);
        assertEquals(4, vertices.size());
        assertTrue(vertices.contains(upperLeft));
        assertTrue(vertices.contains(new Vertex(s1, "A")));
        assertTrue(vertices.contains(new Vertex(s2, "A")));
        assertTrue(vertices.contains(new Vertex(s3, "A")));
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
        Vertex me = graph.getLocation(new Point(3, 3));
        List<Vertex> vertices = me.getSiblings();
        Point s1 = new Point(2, 2);
        Point s2 = new Point(2, 2);
        Point s3 = new Point(3, 2);
        assertEquals(4, vertices.size());
        assertTrue(vertices.contains(me));
        assertTrue(vertices.contains(new Vertex(s1, "C")));
        assertTrue(vertices.contains(new Vertex(s2, "C")));
        assertTrue(vertices.contains(new Vertex(s3, "C")));
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

    @Test
    void plotAreas() {
        final String ascii =
                "AAAA\n" +
                        "BBCD\n" +
                        "BBCC\n" +
                        "EEEC";


        Map<String, Long> expected = new HashMap<>();
        expected.put("A", 4L);
        expected.put("B", 4L);
        expected.put("C", 4L);
        expected.put("D", 1L);
        expected.put("E", 3L);

        Garden garden = new Garden(ascii);
        Graph graph = garden.getGardenGraph();
        List<Plot> plots = garden.getPlots();
        assertEquals(5, plots.size());

        for (Plot plot : plots) {
            Vertex v = plot.getVertex();
            assertEquals(expected.get(v.getLabel()), plot.getArea());
        }
    }

    @Test
    void plotPerimeter() {
        final String ascii =
                "AAAA\n" +
                        "BBCD\n" +
                        "BBCC\n" +
                        "EEEC";


        Map<String, Long> expected = new HashMap<>();
        expected.put("A", 10L);
        expected.put("B", 8L);
        expected.put("C", 10L);
        expected.put("D", 4L);
        expected.put("E", 8L);

        Garden garden = new Garden(ascii);
        Graph graph = garden.getGardenGraph();
        List<Plot> plots = garden.getPlots();
        for (Plot plot : plots) {
            Vertex v = plot.getVertex();
            assertEquals(expected.get(v.getLabel()), plot.getPerimeter());
        }
    }

    @Test
    void price() {
        final String ascii =
                "AAAA\n" +
                        "BBCD\n" +
                        "BBCC\n" +
                        "EEEC";


        Garden garden = new Garden(ascii);
        long price = garden.getFencePrice();
        assertEquals(140, price);
    }

    @Test
    void priceXOs() {
        final String ascii =
                "OOOOO\n" +
                        "OXOXO\n" +
                        "OOOOO\n" +
                        "OXOXO\n" +
                        "OOOOO";


        Garden garden = new Garden(ascii);
        long price = garden.getFencePrice();
        assertEquals(772, price);
    }

    @Test
    void priceLargeGarden() {
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
        long price = garden.getFencePrice();
        assertEquals(1930, price);
    }

    @Test
    void findCousins() {
        final String ascii =
                "AAAA\n" +
                "BBCD\n" +
                "BBCC\n" +
                "EEEC";


        Garden plot = new Garden(ascii);
        Graph graph = plot.getGardenGraph();
        Vertex b = graph.getLocation(new Point(0, 1));
        List<Vertex> vertices = b.getCousins();
        Point c1 = new Point(1, 2);
        assertEquals(1, vertices.size());
        assertFalse(vertices.contains(b));
        assertTrue(vertices.contains(new Vertex(c1, "B")));
    }

    @Test
    void findMoreCousins() {
        final String ascii =
                "AAAA\n" +
                "BBCD\n" +
                "BBCC\n" +
                "EEEC";


        Garden plot = new Garden(ascii);
        Graph graph = plot.getGardenGraph();
        Vertex c = graph.getLocation(new Point(3, 2));
        List<Vertex> vertices = c.getCousins();
        Point cousin = new Point(2, 1);
        assertEquals(1, vertices.size());
        assertTrue(vertices.contains(new Vertex(cousin, "C")));
    }

    @Test
    void getCorners() {
        final String ascii =
                "AAAA\n" +
                "BBCD\n" +
                "BBCC\n" +
                "EEEC";

        Garden plot = new Garden(ascii);
        Graph graph = plot.getGardenGraph();
        Vertex aEnd = graph.getLocation(new Point(0, 0));
        Vertex aMiddle = graph.getLocation(new Point(1, 0));

        assertEquals(2, aEnd.numCorners());
        assertEquals(0, aMiddle.numCorners());
    }

    @Test
    void getCornersSquare() {
        final String ascii =
                "AAAA\n" +
                "BBCD\n" +
                "BBCC\n" +
                "EEEC";

        Garden plot = new Garden(ascii);
        Graph graph = plot.getGardenGraph();
        Vertex B = graph.getLocation(new Point(1, 2));

        assertEquals(1, B.numCorners());
    }

    @Test
    void getCornersOffset() {
        final String ascii =
                        "AAAA\n" +
                        "BBCD\n" +
                        "BBCC\n" +
                        "EEEC";

        Garden plot = new Garden(ascii);
        Graph graph = plot.getGardenGraph();
        Vertex C = graph.getLocation(new Point(2, 2));

        assertEquals(2, C.numCorners());
    }

    @Test
    void plotNumSides() {
        final String ascii =
                        "AAAA\n" +
                        "BBCD\n" +
                        "BBCC\n" +
                        "EEEC";


        Map<String, Long> expected = new HashMap<>();
        expected.put("A", 4L);
        expected.put("B", 4L);
        expected.put("C", 8L);
        expected.put("D", 4L);
        expected.put("E", 4L);

        Garden garden = new Garden(ascii);
        garden.getGardenGraph();
        List<Plot> plots = garden.getPlots();
        assertEquals(5, plots.size());

        for (Plot plot : plots) {
            Vertex v = plot.getVertex();
            assertEquals(expected.get(v.getLabel()), plot.getNumSides());
        }
    }

}