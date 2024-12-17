package com.klr.advent.util;

import java.awt.Point;
import java.util.Map;

public class WarehouseRobot extends WarehouseObject {


    public WarehouseRobot(Point location, Map<Point, WarehouseObject> locationMap) {
        super(location, locationMap);
        icon = "@";
        fatIcon = "@.";
    }

    @Override
    public boolean checkMove(char direction) {
        return false;
    }


    public boolean moveFat(char direction) {
        boolean moved = true;
        Point checkLocation = new Point(location);
        Point checkLocationLeft = new Point(location);
        Point newLocation = new Point(location);
        switch (direction) {
            case '^':
                checkLocation.translate(0, -1);
                checkLocationLeft.translate(-1, -1);
                newLocation.translate(0, -1);
                break;
            case '>':
                checkLocation.translate(1, 0);
                checkLocationLeft.translate(1, 0);
                newLocation.translate(1, 0);
                break;
            case 'v':
                checkLocation.translate(0, 1);
                checkLocationLeft.translate(-1, 1);
                newLocation.translate(0, 1);
                break;
            case '<':
                checkLocation.translate(-2, 0);
                checkLocationLeft.translate(-2, 0);
                newLocation.translate(-1, 0);
                break;
        }


        WarehouseObject objectInPath = map.get(checkLocation);
        WarehouseObject objectInPathLeft = map.get(checkLocationLeft);

        if (objectInPath instanceof WarehouseWall || (objectInPathLeft instanceof WarehouseWall)) {
            return false;
        }
        if (objectInPath instanceof WarehouseBox) {
            moved = objectInPath.moveFat(direction);
        }
        if ((direction == '^' || direction == 'v') && objectInPathLeft instanceof WarehouseBox) {
            moved = objectInPathLeft.moveFat(direction);
        }


        if (moved) {
            map.remove(location);
            map.put(newLocation, this);
            location.move(newLocation.x, newLocation.y);
        }
        return moved;
    }

}
