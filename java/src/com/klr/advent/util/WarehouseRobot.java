package com.klr.advent.util;

import java.awt.Point;

public class WarehouseRobot extends WarehouseObject {


    public WarehouseRobot(Point location) {
        super(location);
    }

    @Override
    public boolean move() {
        return false;
    }
}
