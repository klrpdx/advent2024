package com.klr.advent;

import com.klr.advent.util.Robot;
import com.klr.advent.util.Room;
import com.klr.advent.util.Velocity;
import org.junit.jupiter.api.Test;
import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;

class DayFourteenTest {

    @Test
    void createRoom() {
        String input = "p=0,4 v=3,-3\n" +
                "p=6,3 v=-1,-3\n" +
                "p=10,3 v=-1,2\n" +
                "p=2,0 v=2,-1\n" +
                "p=0,0 v=1,3\n" +
                "p=3,0 v=-2,-2\n" +
                "p=7,6 v=-1,-3\n" +
                "p=3,0 v=-1,-2\n" +
                "p=9,3 v=2,3\n" +
                "p=7,3 v=-1,2\n" +
                "p=2,4 v=2,-3\n" +
                "p=9,5 v=-3,-3";

        Room room = new Room(101,103, input);
        room.populateRoom();
        assertEquals(2,room.getNumberOfRobotsAt(3,0));
    }

    @Test
    void createRobot() {
        int x = 0, y = 0;
        int vX = 3, vY = -3;
        int id = 99;
        int id2 = 9;
        Robot robot1 = new Robot(x,y,vX,vY,1,1, id);
        Robot robot2 = new Robot(x,y,vX,vY,1,2, id2);

        assertAll("Correct robot",
                () -> assertEquals(new Point(x,y), robot1.getPosition()),
                () -> assertEquals(new Velocity(vX,vY), robot1.getVelocity()),
                () -> assertNotEquals(robot1,robot2)
        );
    }

    @Test
    void moveRobot() {
        String input = "p=0,4 v=3,3";
        Room room = new Room(101,103, input);
        room.populateRoom();
        room.click();
        assertEquals(1,room.getNumberOfRobotsAt(3,7));
    }

    @Test
    void moveRobotOffEnd() {
        String input = "p=4,4 v=3,3";
        Room room = new Room(5,5, input);
        room.populateRoom();
        room.click();
        assertEquals(1,room.getNumberOfRobotsAt(2,2));
    }
}