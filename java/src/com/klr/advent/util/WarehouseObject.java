package com.klr.advent.util;

import java.awt.Point;
import java.util.Map;

public abstract class WarehouseObject {

    protected final Point location;
    protected String icon = "?";
    protected Map<Point, WarehouseObject> map;

    public WarehouseObject(Point location, Map<Point, WarehouseObject> map) {
        this.location = location;
        this.map = map;
        this.map.put(this.location, this);
    }

    public Point getLocation() {
        return this.location;
    }

    public boolean move(char direction) {
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
            moved = newLocationObject.move(direction);
        }

        if (moved) {
            map.remove(location);
            map.put(newLocation, this);
            location.move(newLocation.x, newLocation.y);
        }
        return moved;
    }

    public String toString() {
        return icon;
    }
}
