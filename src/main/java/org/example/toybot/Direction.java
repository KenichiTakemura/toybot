package org.example.toybot;

import java.util.Arrays;

/**
 * A supporting direction with a degree (0&lt;=degree&lt;360)
 */
public enum Direction {
    // North 0 degree
    NORTH(0),
    // East, 90 degree
    EAST(90),
    // South, 180 degree
    SOUTH(180),
    // West, 270 degree
    WEST(270);
    private final int degree;

    Direction(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public static Direction valueFrom(int degree) {
        return Arrays.stream(values()).filter(value -> value.getDegree() == degree).findFirst().
                orElseThrow(IllegalArgumentException::new);
    }
}
