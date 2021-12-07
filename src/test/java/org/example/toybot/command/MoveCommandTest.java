package org.example.toybot.command;

import org.example.toybot.Direction;
import org.example.toybot.Position;
import org.example.toybot.TestAbstractControlCommand;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class MoveCommandTest extends TestAbstractControlCommand {

    private MoveCommand command;

    @Before
    public void before() {
        command = new MoveCommand();
    }

    @Test
    public void testGetCommand() {
        assertEquals("MOVE", command.getCommand());
    }


    @Test
    public void testDecode() {
        assertEquals(command, command.decode("ignored"));
        assertEquals(command, command.decode(null));
    }

    @Test
    public void testExecute() {
        setCommandContext(command);
        Position position = new Position(2, 1);
        expect(commandContext.currentBot())
                .andReturn(bot).anyTimes();
        expect(commandContext.getBotTable())
                .andReturn(botTable).anyTimes();
        expect(botTable.onTable(bot)).andReturn(false).andReturn(true).anyTimes();
        expect(bot.position()).andReturn(position).anyTimes();
        expect(bot.move(1)).andReturn(bot).anyTimes();
        expect(botTable.onTable(position)).andReturn(true).andReturn(false);
        expect(bot.moveTo(position)).andReturn(bot).anyTimes();
        replay(commandContext, bot, botTable);
        // No PLACE was issued
        command.execute();
        // MOVE succeeds
        command.execute();
        // MOVE failed
        command.execute();
        verify(commandContext, bot, botTable);
    }
}