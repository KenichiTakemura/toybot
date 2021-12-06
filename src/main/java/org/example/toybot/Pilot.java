package org.example.toybot;

import org.example.toybot.api.BotController;
import org.example.toybot.api.BotTable;
import org.example.toybot.api.ControlCommand;
import org.example.toybot.command.*;

import java.io.OutputStream;

public class Pilot {

    private final BotController controller;
    private final BotTable table;
    private final OutputStream outputStream;

    public Pilot(BotController controller, BotTable table, OutputStream outputStream) {
        this.controller = controller;
        this.table = table;
        this.outputStream = outputStream;
    }

    public void start() {
        controller.registerBotTable(table);
        controller.registerControlCommand(new BotCommand());
        controller.registerControlCommand(new PlaceCommand());
        controller.registerControlCommand(new LeftCommand());
        controller.registerControlCommand(new RightCommand());
        controller.registerControlCommand(new MoveCommand());
        controller.registerControlCommand(new ReportCommand(outputStream));
        var commands = controller.commands();
        do {
            commands.forEach(ControlCommand::execute);
            commands = controller.commands();
        }
        while (!commands.isEmpty());
    }
}
