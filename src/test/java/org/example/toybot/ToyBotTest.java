package org.example.toybot;

import org.example.toybot.api.Bot;
import org.junit.Test;

import javax.lang.model.type.NoType;

import static org.example.toybot.Direction.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ToyBotTest {

    @Test
    public void testBot() {
        Bot bot = new ToyBot("test");
        assertEquals(Position.NONE, bot.position());
        assertEquals(Position.NONE, bot.position());
        assertEquals("test", bot.name());
        assertEquals(Position.NONE, bot.move(1).position());
        bot.moveTo(new Position(1,2));
        assertEquals(3, bot.move(1).position().getY());
        bot.faceTo(EAST);
        assertEquals(2, bot.move(1).position().getX());
        assertEquals(EAST, bot.direction());
        bot.faceTo(WEST);
        assertEquals(1, bot.move(1).position().getX());
        assertEquals(WEST, bot.direction());
        bot.faceTo(SOUTH);
        assertEquals(2, bot.move(1).position().getY());
        assertEquals(SOUTH, bot.direction());
        assertEquals(bot, bot);
        assertEquals(bot, new ToyBot("test"));
        assertEquals(bot.hashCode(), new ToyBot("test").hashCode());
        assertNotEquals(bot, null);
        assertNotEquals(bot, new Object());
        assertNotEquals(bot, new ToyBot("test1"));
        assertEquals("ToyBot{name=test}", bot.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoName() {
        new ToyBot(null);
    }
}