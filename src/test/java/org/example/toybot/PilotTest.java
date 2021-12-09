package org.example.toybot;

import org.example.toybot.api.BotController;
import org.example.toybot.api.BotTable;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class PilotTest {

    @Test
    public void test() {
        String commands = "PLACE 0,0,NORTH\nLEFT\nLEFT\nLEFT\nMOVE\nRIGHT\nREPORT";
        BotController botController = new DefaultBotController(new ByteArrayInputStream(commands.getBytes()));
        BotTable botTable = new DefaultBotTable(5, 5);
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        Pilot pilot = new Pilot(new ToyBot("myToy"), botController, botTable, baout);
        pilot.start();
        assertEquals("1,0,SOUTH", baout.toString());
    }

    @Test
    public void testCoverage() throws IOException {
        InputStream inputStream = mock(InputStream.class);
        BotController botController = new DefaultBotController(inputStream);
        BotTable botTable = new DefaultBotTable(5, 5);
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        Pilot pilot = new Pilot(new ToyBot("myToy"), botController, botTable, baout);

        expect(inputStream.read(anyObject(byte[].class), anyInt(), anyInt()))
                .andThrow(new IOException());
        inputStream.close();
        replay(inputStream);
        pilot.start();
        verify(inputStream);
    }

}