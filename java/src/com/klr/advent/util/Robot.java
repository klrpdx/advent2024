package com.klr.advent.util;

import java.util.Objects;

public class Robot {

    private final int id;
    private final Point position;
    private final Velocity velocity;

    public Robot(int x, int y, int vX, int vY, int id) {
        this.id = id;
        position = new Point(x, y);
        velocity = new Velocity(vX, vY);
    }

    public int getId() {
        return id;
    }

    public Point getPosition() {
        return position;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public boolean atPosition(Point p) {
        return position.equals(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot robot)) return false;
        return id == robot.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
