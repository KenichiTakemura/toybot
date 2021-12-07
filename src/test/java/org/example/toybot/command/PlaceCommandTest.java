package org.example.toybot.command;

import org.example.toybot.Direction;
import org.example.toybot.Position;
import org.example.toybot.TestAbstractControlCommand;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class PlaceCommandTest extends TestAbstractControlCommand {

    private PlaceCommand command;

    @Before
    public void before() {
        command = new PlaceCommand();
    }

    @Test
    public void testGetCommand() {
        assertEquals("PLACE", command.getCommand());
    }

    @Test
    public void testDecode() {
        assertEquals("Position{x=0, y=0}", command.decode("0,0,NORTH").getPosition().toString());
        assertEquals("SOUTH", command.decode("0,0,SOUTH").getDirection().toString());
    }

    @Test
    public void testExecute() {
        setCommandContext(command);
        expect(commandContext.currentBot())
                .andReturn(null)
                .andReturn(bot).anyTimes();
        expect(commandContext.getBotTable())
                .andReturn(null)
                .andReturn(botTable).anyTimes();
        expect(botTable.onTable(Position.NONE)).andReturn(false);
        Position position = new Position(2, 1);
        expect(botTable.onTable(position)).andReturn(true);
        botTable.placeABot(bot, position, Direction.WEST);
        replay(commandContext, bot, botTable);
        // Bot was not registered
        command.execute();
        // BotTable was not registered
        command.execute();
        // Not on table
        command.execute();
        // Should be placed
        command.decode(String.format("%d,%d,%s", position.getX(), position.getY(), Direction.WEST));
        command.execute();
        verify(commandContext, bot, botTable);
    }


    @Test(expected = IllegalArgumentException.class)
    public void invalidArgument() {
        PlaceCommand command = new PlaceCommand().decode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidX() {
        PlaceCommand command = new PlaceCommand().decode("a,1,North");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidY() {
        PlaceCommand command = new PlaceCommand().decode("1,a,North");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidDirection() {
        PlaceCommand command = new PlaceCommand().decode("1,2,Up");
    }

}