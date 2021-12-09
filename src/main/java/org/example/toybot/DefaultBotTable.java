package org.example.toybot;

import com.google.common.base.MoreObjects;
import org.example.toybot.api.Bot;
import org.example.toybot.api.BotTable;

import java.util.Objects;

/**
 * A default implementation of {@link BotTable}
 */
public class DefaultBotTable implements BotTable {

    /**
     * The height of table
     */
    private final int height;
    /**
     * The length of table
     */
    private final int length;

    public DefaultBotTable(int height, int length) {
        this.height = height;
        this.length = length;
    }

    @Override
    public boolean onTable(Position position) {
        int x = position.getX();
        int y = position.getY();
        return 0 <= x && x <= height && 0 <= y && y <= length;
    }

    @Override
    public boolean onTable(Bot bot) {
        return onTable(bot.position());
    }

    @Override
    public void placeABot(Bot bot, Position position, Direction direction) {
        bot.moveTo(position).faceTo(direction);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getLength() {
        return length;
    }


    @Override
    public int hashCode() {
        return Objects.hash(height, length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultBotTable) {
            DefaultBotTable that = (DefaultBotTable) obj;
            return height == that.height && length == that.length;
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("height", height).add("length", length).toString();
    }
}
