package org.example.toybot.api;

import org.example.toybot.Direction;
import org.example.toybot.Position;

public interface Bot {

    /**
     * Get name of this bot
     *
     * @return A name of bot
     */
    String name();

    /**
     * Get current direction
     *
     * @return Current direction
     */
    Direction direction();

    /**
     * Get current position
     *
     * @return Current position
     */
    Position position();

    /**
     * Move by distance towards current direction
     *
     * @param d distance
     */
    Bot move(int d);

    /**
     * Change to new direction without a move
     *
     * @param direction New direction
     */
    Bot faceTo(Direction direction);

    /**
     * Move to the given position
     *
     * @param position The position to move
     */
    Bot moveTo(Position position);
}
