package com.klr.advent.util;

import org.junit.jupiter.api.Test;
import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;

class CompassTest {

    @Test
    void inline() {
        Point origin = new Point(11, 24);
        Point north = new Point(11, 23);
        Point east = new Point(12, 24);
        Point south = new Point(11, 25);
        Point west = new Point(10, 24);

        assertTrue(Compass.EAST.inLine(origin, east));
        assertTrue(Compass.WEST.inLine(origin, west));
        assertTrue(Compass.NORTH.inLine(origin, north));
        assertTrue(Compass.SOUTH.inLine(origin, south));

    }
}