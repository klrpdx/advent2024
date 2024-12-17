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
        warehouse.moveRobotOneStep();
        warehouse.moveRobotOneStep();
        warehouse.moveRobotOneStep();
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
        warehouse.moveRobotOneStep();
        warehouse.moveRobotOneStep();
        warehouse.moveRobotOneStep();
        assertFalse(warehouse.moveRobotOneStep());
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
        warehouse.moveRobotOneStep();
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
        warehouse.moveRobotOneStep();
        warehouse.moveRobotOneStep();
        assertFalse(warehouse.moveRobotOneStep());

        WarehouseObject object =  warehouse.getAt(new Point(1,4));
        assertInstanceOf(WarehouseBox.class, object);
        warehouse.print();
    }

    @Test
    void moveBoxesIntoWall() {
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
                "v<^^^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        Point robot = warehouse.findRobot();
        warehouse.moveRobotOneStep();
        warehouse.moveRobotOneStep();
        warehouse.moveRobotOneStep();
        assertFalse(warehouse.moveRobotOneStep());

        WarehouseObject object =  warehouse.getAt(new Point(3,2));
        WarehouseObject object2 =  warehouse.getAt(new Point(3,3));
        WarehouseObject object3 =  warehouse.getAt(new Point(3,1));
        assertInstanceOf(WarehouseBox.class, object);
        assertInstanceOf(WarehouseBox.class, object2);
        assertInstanceOf(WarehouseBox.class, object3);
        warehouse.print();
    }

    @Test
    void getScore() {
        String asciiMap = "##########\n" +
                "#.....O.O#\n" +
                "#........#\n" +
                "#........#\n" +
                "#...@..O.#\n" +
                "#.#..O...#\n" +
                "#...O....#\n" +
                "#........#\n" +
                "#........#\n" +
                "##########\n" +
                "\n" +
                "v<^^^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        long score = warehouse.getScore();
        assertEquals(1730L, score);
    }

    @Test
    void getScoreSmall() {
        String asciiMap = "########\n" +
                "#..O.O.#\n" +
                "##@.O..#\n" +
                "#...O..#\n" +
                "#.#.O..#\n" +
                "#...O..#\n" +
                "#......#\n" +
                "########\n" +
                "\n" +
                "<^^>>>vv<v>>v<<";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        warehouse.startRobot();
        warehouse.print();
        long score = warehouse.getScore();
        assertEquals(2028L, score);
    }

    @Test
    void getScoreLarge() {
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
                "<vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^" +
                "vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v" +
                "><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<" +
                "<<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^" +
                "^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><" +
                "^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^" +
                ">^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^" +
                "<><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>" +
                "^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>" +
                "v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.create();
        warehouse.startRobot();
        warehouse.print();
        long score = warehouse.getScore();
        assertEquals(10092L, score);
    }

    @Test
    void fatMap() {
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
                "v<^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.createFat();
        warehouse.printWide();
        warehouse.startRobotWide();
        warehouse.printWide();
        Point robot = warehouse.findRobot();
        System.out.println(robot.getLocation());
        assertEquals(new Point(7,4), robot);
        WarehouseObject object =  warehouse.getAt(new Point(6,2));
        assertInstanceOf(WarehouseBox.class, object);
    }


    @Test
    void fatMapRight() {
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
                "v<^<<<^<^>>>>>>>>";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.createFat();
        warehouse.printWide();
        warehouse.startRobotWide();
        //warehouse.printWide();
        Point robot = warehouse.findRobot();
        System.out.println(robot.getLocation());
        assertEquals(new Point(11,2), robot);
        WarehouseObject object =  warehouse.getAt(new Point(16,2));
        assertInstanceOf(WarehouseBox.class, object);
    }

    @Test
    void fatMapUpBlocked() {
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
                "v<^<<<^<^>vv>>^^^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.createFat();
        warehouse.printWide();
        warehouse.startRobotWide();
        //warehouse.printWide();
        Point robot = warehouse.findRobot();
        System.out.println(robot.getLocation());
        //assertEquals(new Point(11,2), robot);
        //WarehouseObject object =  warehouse.getAt(new Point(16,2));
        //assertInstanceOf(WarehouseBox.class, object);
    }

    @Test
    void fatScore() {
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
                "<vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^" +
                "vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v" +
                "><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<" +
                "<<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^" +
                "^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><" +
                "^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^" +
                ">^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^" +
                "<><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>" +
                "^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>" +
                "v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.createFat();
        warehouse.printWide();
        warehouse.startRobotWide();
        warehouse.printWide();
        long score = warehouse.getScore();
        assertEquals(9021L, score);
    }

    @Test
    void boxStack() {
        String asciiMap = "##########\n" +
                "#.....O.O#\n" +
                "#..@...O.#\n" +
                "#..O..O.O#\n" +
                "#..OO..O.#\n" +
                "#..O.....#\n" +
                "#........#\n" +
                "#.......O#\n" +
                "#....O...#\n" +
                "##########\n" +
                "\n" +
                "<v><vv><^^^>vvvv";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.createFat();
        warehouse.printWide();
        warehouse.startRobotWide();
        //warehouse.printWide();
        Point robot = warehouse.findRobot();
        System.out.println(robot.getLocation());
        //assertEquals(new Point(11,2), robot);
        //WarehouseObject object =  warehouse.getAt(new Point(16,2));
        //assertInstanceOf(WarehouseBox.class, object);
    }

    @Test
    void edgeCase() {
        String asciiMap = "######\n" +
                "#....#\n" +
                "#..#.#\n" +
                "#....#\n" +
                "#.O..#\n" +
                "#.OO@#\n" +
                "#.O..#\n" +
                "#....#\n" +
                "######\n" +
                "\n" +
                "<vv<<^^^";


        Warehouse warehouse = new Warehouse(asciiMap);
        warehouse.createFat();
        warehouse.printWide();
        warehouse.startRobotWide();
        Point robot = warehouse.findRobot();
        System.out.println(robot.getLocation());
        assertEquals(1216, warehouse.getScore());
    }
}