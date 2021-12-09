package org.example.toybot;

import org.example.toybot.api.Bot;
import org.example.toybot.api.BotTable;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class DefaultBotTableTest {

    @Test
    public void testTable() {
        BotTable table = new DefaultBotTable(5, 6);
        assertEquals(5, table.getHeight());
        assertEquals(6, table.getLength());
        assertEquals(table, table);
        assertEquals(table, new DefaultBotTable(5, 6));
        assertEquals(table.hashCode(), new DefaultBotTable(5, 6).hashCode());
        assertNotEquals(table, null);
        assertNotEquals(table, new Object());
        assertNotEquals(table, new ToyBot("test1"));
        assertEquals("DefaultBotTable{height=5, length=6}", table.toString());

        assertTrue(table.onTable(new Position(1, 2)));
        assertFalse(table.onTable(Position.NONE));
        assertFalse(table.onTable(new Position(1, 7)));

        Bot bot = mock(Bot.class);
        expect(bot.position()).andReturn(new Position(1, 2));
        expect(bot.faceTo(Direction.WEST)).andReturn(bot);
        expect(bot.moveTo(new Position(3, 4))).andReturn(bot);
        replay(bot);
        assertTrue(table.onTable(bot));
        table.placeABot(bot, new Position(3, 4), Direction.WEST);
        verify(bot);


    }
}