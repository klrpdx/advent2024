package com.klr.advent.util;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private final String asciiMap;
    private final Map<Point, WarehouseObject> locationMap = new HashMap<Point, WarehouseObject>();

    public Warehouse(String asciiMap) {
        this.asciiMap = asciiMap;
    }


    public void create() {
        String[] lines = asciiMap.split("\n");
        int row = 0;
        for (String line : lines) {
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                WarehouseObject object = null;
                Point p = new Point(i,row);
                object = switch (chars[i]) {
                    case '#' -> new WarehouseWall(p);
                    case 'O' -> new WarehouseBox(p);
                    case '@' -> new WarehouseRobot(p);
                    default -> null;
                };
                if (object != null) {
                    locationMap.put(object.getLocation(), object);
                }
            }
            row++;
        }
    }

    public Point findRobot() {
        for (Map.Entry<Point, WarehouseObject> entry : locationMap.entrySet()) {
            if (entry.getValue() instanceof WarehouseRobot) {
                return entry.getKey();
            }
        }
        return null;
    }
}
