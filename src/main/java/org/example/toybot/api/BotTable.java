package org.example.toybot.api;

import org.example.toybot.Direction;
import org.example.toybot.Position;

public interface BotTable {

    /**
     * Check if a position is on table
     *
     * @param position A position
     * @return {@code true} if position is on table otherwise {@code false}
     */
    boolean onTable(Position position);

    /**
     * Check if a bot is on table
     *
     * @param bot A bot
     * @return {@code true} if in table otherwise {@code false}
     */
    boolean onTable(Bot bot);

    /**
     * Place a bot into table at given a position facing given direction
     *
     * @param bot       A bot
     * @param position  A position to be placed
     * @param direction A facing direction
     */
    void placeABot(Bot bot, Position position, Direction direction);
}
