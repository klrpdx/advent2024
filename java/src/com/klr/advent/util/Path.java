package com.klr.advent.util;

import java.awt.Point;

public class Path {

    private Point location;
    private Direction direction;

    public Path(Direction direction, Point point) {
        this.location = point;
        this.direction = direction;
    }

    public Point getLocation() {
        return location;
    }
    public Direction getDirection() {
        return direction;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        return result;
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
