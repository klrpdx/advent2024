package com.klr.advent.util;

import java.awt.Point;
import java.util.Map;

public class WarehouseBox extends WarehouseObject {

    public WarehouseBox(Point p,  Map<Point, WarehouseObject> locationMap) {
        super(p, locationMap);
        icon = "O";
    }

}
