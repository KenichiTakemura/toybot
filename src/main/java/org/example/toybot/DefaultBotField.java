package org.example.toybot;

import org.example.toybot.api.Bot;
import org.example.toybot.api.BotField;

public class DefaultBotField implements BotField {

    private final int maxX;
    private final int maxY;

    public DefaultBotField(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public boolean onField(Position position) {
        int x = position.getX();
        int y = position.getY();
        return 0 <= x && x <= maxX && 0 <= y && y <= maxY;
    }

    @Override
    public boolean inField(Bot bot) {
        return !bot.position().equals(Position.NONE);
    }

    @Override
    public BotField placeBot(Bot bot, Position position, Direction direction) {
        bot.moveTo(position).faceTo(direction);
        return this;
    }
}
