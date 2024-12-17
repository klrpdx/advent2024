package com.klr.advent.util;

import java.awt.Point;
import java.util.Map;

public class WarehouseRobot extends WarehouseObject {


    public WarehouseRobot(Point location, Map<Point, WarehouseObject> locationMap) {
        super(location,locationMap);
        icon = "@";
        fatIcon = "@.";
    }


    public boolean moveFat(char direction) {
        boolean moved = true;
        Point newLocation = new Point(location);
        switch (direction) {
            case '^':
                newLocation.translate(0, -1);
                break;
            case '>':
                newLocation.translate(1, 0);
                break;
            case 'v':
                newLocation.translate(0, 1);
                break;
            case '<':
                newLocation.translate(-1, 0);
                break;
        }


        WarehouseObject newLocationObject = map.get(newLocation);

        if (newLocationObject instanceof WarehouseWall) {
            return false;
        }
        if (newLocationObject instanceof WarehouseBox) {
            moved = newLocationObject.moveFat(direction);
        }

        if (moved) {
            map.remove(location);
            map.put(newLocation, this);
            location.move(newLocation.x, newLocation.y);
        }
        return moved;
    }

}
