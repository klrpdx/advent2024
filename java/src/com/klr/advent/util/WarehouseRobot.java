package com.klr.advent.util;

import java.awt.Point;
import java.util.Map;

public class WarehouseRobot extends WarehouseObject {


    public WarehouseRobot(Point location, Map<Point, WarehouseObject> locationMap) {
        super(location,locationMap);
        icon = "@";
    }


}
