package com.klr.advent.util;

import java.awt.*;

public class Path {

    private Point location;
    private Direction direction;

    public Path(Direction direction, int x, int y) {
        this.location = new Point(x, y);
        this.direction = direction;
    }

    public Point getLocation() {
        return location;
    }
    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Path other = (Path) obj;
        return direction == other.direction && location.equals(other.location);
    }

}
