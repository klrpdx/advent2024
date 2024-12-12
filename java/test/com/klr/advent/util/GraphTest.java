package com.klr.advent.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {


    @Test
    void addVertex() {
        List<Vertex> expected = new ArrayList<>();
        Vertex v0 = new Vertex(0,0);
        Vertex v1 = new Vertex(1,0);
        Vertex v2 = new Vertex(2,0);
        expected.add(v0);
        expected.add(v1);
        expected.add(v2);

        Graph graph = new Graph();
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);

        assertEquals(expected, graph.getAllVertices());
    }

    @Test
    void edges() {

        Vertex v0 = new Vertex(0,0);
        Vertex v1 = new Vertex(1,0);
        Vertex v2 = new Vertex(2,0);
        Vertex v3 = new Vertex(3,0);
        Vertex v4 = new Vertex(4,0);

        List<Vertex> expected = new ArrayList<>();
        expected.add(v1);
        expected.add(v4);

        Graph graph = new Graph();
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
        Vertex v0 = new Vertex(0,0);
        Vertex v1 = new Vertex(1,1);
        Vertex v2 = new Vertex(2,2);
        Vertex v3 = new Vertex(3,3);
        Vertex v4 = new Vertex(4,1);
        Vertex v5 = new Vertex(5,2);
        Vertex v6 = new Vertex(6,3);
        Vertex v7 = new Vertex(7,4);
        Vertex v8 = new Vertex(8,8);
        Vertex v9 = new Vertex(9,7);
        Vertex v10 = new Vertex(10,6);
        Vertex v11 = new Vertex(11,5);
        Vertex v12 = new Vertex(12,9);
        Vertex v13 = new Vertex(13,8);
        Vertex v14 = new Vertex(14,7);
        Vertex v15 = new Vertex(15,6);


        Graph graph = new Graph();
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


        int numPaths = graph.findPathTo(v0,9).size();
        assertEquals(1, numPaths);

    }

}