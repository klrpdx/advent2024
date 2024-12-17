package com.klr.advent.util;

import java.awt.Point;

public class WarehouseBox extends WarehouseObject {
    public WarehouseBox(Point p) {
        super(p);
    }

    @Override
    public boolean move() {
        return false;
    }
}
