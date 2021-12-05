package org.example.toybot.api;

import org.example.toybot.Direction;
import org.example.toybot.Position;

public interface BotField {

    /**
     * Check if a bot is in a filed at give position.
     *
     * @param position A position
     * @return
     */
    boolean onField(Position position);

    /**
     * Check if a bot is in field
     * @param bot
     * @return
     */
    boolean inField(Bot bot);

    BotField placeBot(Bot bot, Position position, Direction direction);
}
