package org.example.toybot;

import org.example.toybot.api.BotController;
import org.example.toybot.api.BotField;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class AutoPilotTest {

    @Test
    public void test() {
        String commands = "BOT myToy\nPLACE 0,0,WEST\nREPORT";
        BotController botController = new DefaultBotController(new ByteArrayInputStream(commands.getBytes()));
        BotField botField = new DefaultBotField(5, 5);
        botController.registerBot(new ToyBot("myToy"));
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        AutoPilot autoPilot = new AutoPilot(botController, botField, baout);
        autoPilot.start();
        assertEquals("0,0,WEST", baout.toString());
    }

}