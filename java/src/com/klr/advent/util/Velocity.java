package com.klr.advent.util;

import java.util.Objects;

public record Velocity(int vX, int vY) {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Velocity velocity)) return false;
        return vX == velocity.vX && vY == velocity.vY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vX, vY);
    }
}
