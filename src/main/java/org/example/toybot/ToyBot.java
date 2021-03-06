package org.example.toybot;

import com.google.common.base.MoreObjects;
import org.example.toybot.api.Bot;

import java.util.Objects;

/**
 * A toy bot
 */
public class ToyBot implements Bot {
    /**
     * Name of toy bot
     */
    private final String name;
    /**
     * Current direction
     */
    private Direction direction;
    /**
     * Current position
     */
    private Position position;

    public ToyBot(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must be present");
        }
        this.name = name;
        this.position = Position.NONE;
        this.direction = Direction.NORTH;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Direction direction() {
        return direction;
    }

    @Override
    public Position position() {
        return position;
    }

    @Override
    public Bot move(int d) {
        if (position.equals(Position.NONE))
        {
            // Not placed
            return this;
        }
        switch (direction) {
            case NORTH:
                position.setY(position.getY() + d);
                break;
            case SOUTH:
                position.setY(position.getY() - d);
                break;
            case EAST:
                position.setX(position.getX() + d);
                break;
            case WEST:
                position.setX(position.getX() - d);
                break;
            default:
                break;
        }
        return this;
    }

    @Override
    public Bot faceTo(Direction direction) {
        this.direction = direction;
        return this;
    }

    @Override
    public Bot moveTo(Position position) {
        this.position = position;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToyBot) {
            ToyBot that = (ToyBot) obj;
            return Objects.equals(name, that.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("name", name).toString();
    }
}
