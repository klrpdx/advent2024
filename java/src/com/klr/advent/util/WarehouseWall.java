package com.klr.advent.util;

import java.awt.Point;

public class WarehouseWall extends WarehouseObject {

    public WarehouseWall(Point p) {
        super(p);
    }

    @Override
    public boolean move() {
        return false;
    }
}
