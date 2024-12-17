package com.klr.advent;

import com.klr.advent.util.Warehouse;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DayFifteenTest {

    @Test
    void startingPosition() {
        String asciiMap = "##########\n" +
                "#..O..O.O#\n" +
                "#......O.#\n" +
                "#.OO..O.O#\n" +
                "#..O@..O.#\n" +
                "#O#..O...#\n" +
                "#O..O..O.#\n" +
                "#.OO.O.OO#\n" +
                "#....O...#\n" +
                "##########";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        Point robot = warehouse.findRobot();
        assertEquals(new Point(4,4), robot);
    }

}