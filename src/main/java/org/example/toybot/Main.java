package org.example.toybot;

import org.example.toybot.api.BotController;
import org.example.toybot.api.BotField;

import java.io.BufferedInputStream;

public class Main {

    public static void main(String[] args) {
        var inputStream = new BufferedInputStream(System.in);
        BotController botController = new DefaultBotController(inputStream);
        BotField botField = new DefaultBotField(5, 5);
        botController.registerBot(new ToyBot("toyBot"));
        AutoPilot autoPilot = new AutoPilot(botController, botField, System.out);
        autoPilot.start();
    }
}
