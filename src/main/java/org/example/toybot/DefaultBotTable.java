package org.example.toybot;

import org.example.toybot.api.Bot;
import org.example.toybot.api.BotTable;

public class DefaultBotTable implements BotTable {

    private final int maxX;
    private final int maxY;

    public DefaultBotTable(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public boolean onTable(Position position) {
        int x = position.getX();
        int y = position.getY();
        return 0 <= x && x <= maxX && 0 <= y && y <= maxY;
    }

    @Override
    public boolean onTable(Bot bot) {
        return onTable(bot.position());
    }

    @Override
    public void placeABot(Bot bot, Position position, Direction direction) {
        bot.moveTo(position);
        bot.faceTo(direction);
    }
}
