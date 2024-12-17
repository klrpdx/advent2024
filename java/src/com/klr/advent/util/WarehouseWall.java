package com.klr.advent.util;

import java.awt.Point;
import java.util.Map;

public class WarehouseWall extends WarehouseObject {

    public WarehouseWall(Point p, Map<Point, WarehouseObject> locationMap) {
        super(p, locationMap);
        icon = "#";
        fatIcon = "##";
    }

    @Override
    public boolean checkMove(char direction) {
        return false;
    }

    @Override
    public boolean moveFat(char direction) {
        return false;
    }

    @Override
    public boolean move(char direction) {
        return false;
    }
}
