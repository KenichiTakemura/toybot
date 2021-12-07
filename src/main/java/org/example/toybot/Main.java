package org.example.toybot;

import org.example.toybot.api.BotController;
import org.example.toybot.api.BotTable;

import java.io.BufferedInputStream;

public class Main {

    /**
     * A sample main class to demonstrate a toy bot on a table using {@link System#in} and
     * {@link System#out}
     */
    public static void main(String[] args) {
        // Create an input stream to get commands
        var inputStream = new BufferedInputStream(System.in);
        // Create a bot controller
        BotController botController = new DefaultBotController(inputStream);
        // Create a table 5 x 5
        BotTable botTable = new DefaultBotTable(5, 5);
        // Register a bot into the controller
        // Pass controller, table and output stream into a pilot class
        Pilot pilot = new Pilot(new ToyBot("toyBot"), botController, botTable, System.out);
        // Start pilot
        pilot.start();
    }
}
