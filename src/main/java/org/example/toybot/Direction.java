package org.example.toybot;

import java.util.Arrays;

public enum Direction {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);
    private int degree;

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
