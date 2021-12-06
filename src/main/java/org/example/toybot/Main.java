package org.example.toybot;

import org.example.toybot.api.BotController;
import org.example.toybot.api.BotTable;

import java.io.BufferedInputStream;

public class Main {

    public static void main(String[] args) {
        var inputStream = new BufferedInputStream(System.in);
        BotController botController = new DefaultBotController(inputStream);
        BotTable botTable = new DefaultBotTable(5, 5);
        botController.registerBot(new ToyBot("toyBot"));
        Pilot pilot = new Pilot(botController, botTable, System.out);
        pilot.start();
    }
}
