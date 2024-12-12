package com.klr.advent.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {


    @Test
    void addVertex() {
        List<TrailVertex> expected = new ArrayList<>();
        TrailVertex v0 = new TrailVertex(0,0);
        TrailVertex v1 = new TrailVertex(1,0);
        TrailVertex v2 = new TrailVertex(2,0);
        expected.add(v0);
        expected.add(v1);
        expected.add(v2);

        TrailGraph graph = new TrailGraph();
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);

        assertEquals(expected, graph.getAllVertices());
    }

    @Test
    void edges() {

        TrailVertex v0 = new TrailVertex(0,0);
        TrailVertex v1 = new TrailVertex(1,0);
        TrailVertex v2 = new TrailVertex(2,0);
        TrailVertex v3 = new TrailVertex(3,0);
        TrailVertex v4 = new TrailVertex(4,0);

        List<TrailVertex> expected = new ArrayList<>();
        expected.add(v1);
        expected.add(v4);

        TrailGraph graph = new TrailGraph();
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v0,v1);
        graph.addEdge(v0,v4);

        assertEquals(expected, graph.getEdges(v0));
    }

    @Test
    void followEdge() {
        TrailVertex v0 = new TrailVertex(0,0);
        TrailVertex v1 = new TrailVertex(1,1);
        TrailVertex v2 = new TrailVertex(2,2);
        TrailVertex v3 = new TrailVertex(3,3);
        TrailVertex v4 = new TrailVertex(4,1);
        TrailVertex v5 = new TrailVertex(5,2);
        TrailVertex v6 = new TrailVertex(6,3);
        TrailVertex v7 = new TrailVertex(7,4);
        TrailVertex v8 = new TrailVertex(8,8);
        TrailVertex v9 = new TrailVertex(9,7);
        TrailVertex v10 = new TrailVertex(10,6);
        TrailVertex v11 = new TrailVertex(11,5);
        TrailVertex v12 = new TrailVertex(12,9);
        TrailVertex v13 = new TrailVertex(13,8);
        TrailVertex v14 = new TrailVertex(14,7);
        TrailVertex v15 = new TrailVertex(15,6);


        TrailGraph graph = new TrailGraph();
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);
        graph.addVertex(v9);
        graph.addVertex(v10);
        graph.addVertex(v11);
        graph.addVertex(v12);
        graph.addVertex(v13);
        graph.addVertex(v14);
        graph.addVertex(v15);

        graph.addEdge(v0,v1);
        graph.addEdge(v0,v4);
        graph.addEdge(v1,v2);
        graph.addEdge(v1,v5);
        graph.addEdge(v2,v3);
        graph.addEdge(v2,v6);
        graph.addEdge(v3,v7);
        graph.addEdge(v4,v5);
        graph.addEdge(v5,v6);
        graph.addEdge(v6,v7);
        graph.addEdge(v7,v11);
        graph.addEdge(v8,v12);
        graph.addEdge(v9,v8);
        graph.addEdge(v9,v13);
        graph.addEdge(v10,v9);
        graph.addEdge(v10,v14);
        graph.addEdge(v11,v10);
        graph.addEdge(v11,v15);
        graph.addEdge(v13,v12);
        graph.addEdge(v14,v13);
        graph.addEdge(v15,v14);


        int numPaths = graph.findUniquePathTo(v0,9).size();
        assertEquals(1, numPaths);

    }

}