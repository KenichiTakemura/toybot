package org.example.toybot;

import org.example.toybot.api.BotController;
import org.example.toybot.api.BotTable;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    @Test
    public void test() {
        String commands = "PLACE 0,0,NORTH\nLEFT\nREPORT";
        BotController botController = new DefaultBotController(new ByteArrayInputStream(commands.getBytes()));
        BotTable botTable = new DefaultBotTable(5, 5);
        botController.registerBot(new ToyBot("myToy"));
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        Pilot pilot = new Pilot(botController, botTable, baout);
        pilot.start();
        assertEquals("0,0,WEST", baout.toString());
    }

}