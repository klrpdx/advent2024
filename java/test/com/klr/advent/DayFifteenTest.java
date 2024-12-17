package com.klr.advent;

import com.klr.advent.util.Warehouse;
import com.klr.advent.util.WarehouseBox;
import com.klr.advent.util.WarehouseObject;
import com.klr.advent.util.WarehouseWall;
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
                "##########\n" +
                "\n" +
                "^^^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        Point robot = warehouse.findRobot();
        warehouse.print();
        assertEquals(new Point(4,4), robot);
        assertTrue(warehouse.getAt(new Point(1,5)) instanceof WarehouseBox);
        assertTrue(warehouse.getAt(new Point(2,5)) instanceof WarehouseWall);
    }

    @Test
    void openMove() {
        String asciiMap = "##########\n" +
                "#..O..O.O#\n" +
                "#......O.#\n" +
                "#.OO..O.O#\n" +
                "#..O@..O.#\n" +
                "#O#..O...#\n" +
                "#O..O..O.#\n" +
                "#.OO.O.OO#\n" +
                "#....O...#\n" +
                "##########\n" +
                "\n" +
                "^^^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        Point robot = warehouse.findRobot();
        warehouse.moveRobot();
        warehouse.moveRobot();
        warehouse.moveRobot();
        assertEquals(new Point(4,1), robot);
    }

    @Test
    void hitTheWall() {
        String asciiMap = "##########\n" +
                "#..O..O.O#\n" +
                "#......O.#\n" +
                "#.OO..O.O#\n" +
                "#..O@..O.#\n" +
                "#O#..O...#\n" +
                "#O..O..O.#\n" +
                "#.OO.O.OO#\n" +
                "#....O...#\n" +
                "##########\n" +
                "\n" +
                "^^^^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        Point robot = warehouse.findRobot();
        warehouse.moveRobot();
        warehouse.moveRobot();
        warehouse.moveRobot();
        assertFalse(warehouse.moveRobot());
        assertEquals(new Point(4,1), robot);
        warehouse.print();
    }

    @Test
    void moveBox() {
        String asciiMap = "##########\n" +
                "#..O..O.O#\n" +
                "#......O.#\n" +
                "#.OO..O.O#\n" +
                "#..O@..O.#\n" +
                "#O#..O...#\n" +
                "#O..O..O.#\n" +
                "#.OO.O.OO#\n" +
                "#....O...#\n" +
                "##########\n" +
                "\n" +
                "<<";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        Point robot = warehouse.findRobot();
        warehouse.moveRobot();
        assertEquals(new Point(3,4), robot);
        WarehouseObject object =  warehouse.getAt(new Point(2,4));
        assertInstanceOf(WarehouseBox.class, object);
        warehouse.print();
    }

    @Test
    void moveBoxIntoWall() {
        String asciiMap = "##########\n" +
                "#..O..O.O#\n" +
                "#......O.#\n" +
                "#.OO..O.O#\n" +
                "#..O@..O.#\n" +
                "#O#..O...#\n" +
                "#O..O..O.#\n" +
                "#.OO.O.OO#\n" +
                "#....O...#\n" +
                "##########\n" +
                "\n" +
                "<<<";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        Point robot = warehouse.findRobot();
        warehouse.moveRobot();
        warehouse.moveRobot();
        assertFalse(warehouse.moveRobot());

        WarehouseObject object =  warehouse.getAt(new Point(1,4));
        assertInstanceOf(WarehouseBox.class, object);
        warehouse.print();
    }

}