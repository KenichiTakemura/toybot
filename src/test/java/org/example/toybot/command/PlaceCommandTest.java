package org.example.toybot.command;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceCommandTest {

    @Test
    public void test() {
        PlaceCommand command = new PlaceCommand();
        assertEquals("PLACE", command.getCommand());
        assertEquals("Position{x=0, y=0}", command.decode("0,0,NORTH").getPosition().toString());
        assertEquals("SOUTH", command.decode("0,0,SOUTH").getDirection().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgument()
    {
        PlaceCommand command = new PlaceCommand().decode("a,b,c");
    }

}