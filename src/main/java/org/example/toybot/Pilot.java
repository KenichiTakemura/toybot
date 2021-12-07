package org.example.toybot;

import org.example.toybot.api.Bot;
import org.example.toybot.api.BotController;
import org.example.toybot.api.BotTable;
import org.example.toybot.api.ControlCommand;
import org.example.toybot.command.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * A pilot class is an entry point to a toy bot world. Create a class using {@link BotController},
 * {@link BotTable} and {@link OutputStream}.
 */
public class Pilot {

    private final Bot bot;
    private final BotController controller;
    private final BotTable table;
    private final OutputStream outputStream;

    public Pilot(Bot bot, BotController controller, BotTable table, OutputStream outputStream) {
        this.bot = bot;
        this.controller = controller;
        this.table = table;
        this.outputStream = outputStream;
    }

    /**
     * Start a pilot
     */
    public void start() {
        // Register a bot
        controller.registerBot(bot);
        // Register a table into controller
        controller.registerBotTable(table);
        // Register BOT command
        controller.registerControlCommand(new BotCommand());
        // Register PLACE command
        controller.registerControlCommand(new PlaceCommand());
        // Register LEFT command
        controller.registerControlCommand(new LeftCommand());
        // Register RIGHT command
        controller.registerControlCommand(new RightCommand());
        // Register MOVE command
        controller.registerControlCommand(new MoveCommand());
        // Register REPORT command with an output stream
        controller.registerControlCommand(new ReportCommand(outputStream));
        // Get commands and execute commands until all commands are fetched
        List<ControlCommand> commands = null;
        try {
            commands = controller.commands();
            do {
                commands.forEach(ControlCommand::execute);
                commands = controller.commands();
            }
            while (!commands.isEmpty());
        } catch (IOException e) {
            // Error
        }
    }
}
