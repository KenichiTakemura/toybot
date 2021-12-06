package org.example.toybot.command;

import org.example.toybot.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeftCommandTest {

    @Test
    public void leftOf() {
        LeftCommand leftCommand = new LeftCommand();
        assertEquals(Direction.WEST, leftCommand.leftOf(Direction.NORTH));
        assertEquals(Direction.SOUTH, leftCommand.leftOf(Direction.WEST));
        assertEquals(Direction.EAST, leftCommand.leftOf(Direction.SOUTH));
        assertEquals(Direction.NORTH, leftCommand.leftOf(Direction.EAST));
    }

}