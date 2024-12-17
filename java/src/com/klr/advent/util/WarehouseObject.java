package com.klr.advent.util;

import java.awt.Point;

public abstract class WarehouseObject {

    private final Point location;

    public WarehouseObject(Point location) {
        this.location = location;
    }

    public Point getLocation() {
        return this.location;
    }

    public abstract boolean move();

}
