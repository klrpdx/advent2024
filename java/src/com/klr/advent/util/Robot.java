package com.klr.advent.util;

import java.util.Objects;
import java.awt.Point;

public class Robot {

    private final int id;
    private Point position;
    private final Velocity velocity;
    private int maxX;
    private int maxY;

    public Robot(int x, int y, int vX, int vY, int maxX, int maxY, int id) {
        this.id = id;
        position = new Point(x, y);
        velocity = new Velocity(vX, vY);
        this.maxX = maxX;
        this.maxY = maxY;
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

    public void click() {
        position.x += velocity.vX();
        position.y += velocity.vY();
        if (position.x < 0) {
            position.x = position.x + maxX;
        }
        if (position.x > maxX) {
            position.x = position.x - maxX;
        }
        if (position.y < 0) {
            position.y = position.y + maxY;
        }
        if (position.y > maxY) {
            position.y = position.y - maxY;
        }
    }
}
