package org.example.toybot;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public static Position NONE = new Position(-1, -1);

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Position) {
            Position that = (Position) obj;
            return x == that.x && y == that.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("x", x).add("y", y).toString();
    }
}
