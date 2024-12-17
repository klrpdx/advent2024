package com.klr.advent.util;

import java.awt.Point;
import java.util.Map;

public class WarehouseBox extends WarehouseObject {

    public WarehouseBox(Point p,  Map<Point, WarehouseObject> locationMap) {
        super(p, locationMap);
        icon = "O";
        fatIcon = "[]";
    }

    public boolean checkMove(char direction) {
        boolean moved = true;
        Point newLocation = new Point(location);
        Point checkLocation = new Point(location);
        Point checkLocationLeft = new Point(location);
        Point checkLocationRight = new Point(location);

        switch (direction) {
            case '^':
                newLocation.translate(0, -1);
                checkLocation.translate(0, -1);
                checkLocationLeft.translate(-1, -1);
                checkLocationRight.translate(1, -1);
                break;
            case '>':
                newLocation.translate(1, 0);
                checkLocation.translate(2, 0);
                checkLocationLeft.translate(2, 0);
                checkLocationRight.translate(2, 0);
                break;
            case 'v':
                newLocation.translate(0, 1);
                checkLocation.translate(0, 1);
                checkLocationLeft.translate(-1, 1);
                checkLocationRight.translate(1, 1);
                break;
            case '<':
                newLocation.translate(-1, 0);
                checkLocation.translate(-2, 0);
                checkLocationLeft.translate(-2, 0);
                checkLocationRight.translate(-2, 0);
                break;
        }


        WarehouseObject objectInPathLeft = map.get(checkLocationLeft);
        WarehouseObject objectInPath = map.get(checkLocation);
        WarehouseObject objectInPathRight = map.get(checkLocationRight);

        if (objectInPathLeft instanceof WarehouseWall || objectInPath instanceof WarehouseWall || objectInPathRight instanceof WarehouseWall) {
            return false;
        }
        if ((direction == '^' || direction == 'v') &&  objectInPathLeft instanceof WarehouseBox &&  objectInPathRight instanceof WarehouseBox) {
            moved = objectInPathLeft.checkMove(direction) && objectInPathRight.checkMove(direction);
        }
        if (moved && objectInPath instanceof WarehouseBox) {
            moved = objectInPath.checkMove(direction);
        }
        if ((direction == '^' || direction == 'v') && moved && objectInPathRight instanceof WarehouseBox && !(objectInPathLeft instanceof WarehouseBox)) {
            moved = objectInPathRight.checkMove(direction);
        }
        if ((direction == '^' || direction == 'v') && moved && objectInPathLeft instanceof WarehouseBox && !(objectInPathRight instanceof WarehouseBox)) {
            moved = objectInPathLeft.checkMove(direction);
        }

        return moved;
    }

    public boolean moveFat(char direction) {
        boolean moved = true;
        Point newLocation = new Point(location);
        Point checkLocation = new Point(location);
        Point checkLocationLeft = new Point(location);
        Point checkLocationRight = new Point(location);

        switch (direction) {
            case '^':
                newLocation.translate(0, -1);
                checkLocation.translate(0, -1);
                checkLocationLeft.translate(-1, -1);
                checkLocationRight.translate(1, -1);
                break;
            case '>':
                newLocation.translate(1, 0);
                checkLocation.translate(2, 0);
                checkLocationLeft.translate(2, 0);
                checkLocationRight.translate(2, 0);
                break;
            case 'v':
                newLocation.translate(0, 1);
                checkLocation.translate(0, 1);
                checkLocationLeft.translate(-1, 1);
                checkLocationRight.translate(1, 1);
                break;
            case '<':
                newLocation.translate(-1, 0);
                checkLocation.translate(-2, 0);
                checkLocationLeft.translate(-2, 0);
                checkLocationRight.translate(-2, 0);
                break;
        }


        WarehouseObject objectInPathLeft = map.get(checkLocationLeft);
        WarehouseObject objectInPath = map.get(checkLocation);
        WarehouseObject objectInPathRight = map.get(checkLocationRight);

        if (objectInPathLeft instanceof WarehouseWall || objectInPath instanceof WarehouseWall || objectInPathRight instanceof WarehouseWall) {
            return false;
        }
        if ((direction == '^' || direction == 'v') &&  objectInPathLeft instanceof WarehouseBox && objectInPathRight instanceof WarehouseBox) {
            moved = objectInPathLeft.checkMove(direction) && objectInPathRight.checkMove(direction);
            if (moved) {
                objectInPathLeft.moveFat(direction);
                objectInPathRight.moveFat(direction);
            }
        }
        if (moved && objectInPath instanceof WarehouseBox) {
            moved = objectInPath.moveFat(direction);
        }
        if ((direction == '^' || direction == 'v') && moved && objectInPathRight instanceof WarehouseBox && !(objectInPathLeft instanceof WarehouseBox)) {
            moved = objectInPathRight.moveFat(direction);
        }
        if ((direction == '^' || direction == 'v') && moved && objectInPathLeft instanceof WarehouseBox && !(objectInPathRight instanceof WarehouseBox)) {
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
