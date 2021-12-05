package org.example.toybot;

import org.example.toybot.api.BotController;
import org.example.toybot.api.BotField;
import org.example.toybot.api.ControlCommand;
import org.example.toybot.command.BotCommand;
import org.example.toybot.command.PlaceCommand;
import org.example.toybot.command.ReportCommand;

import java.io.OutputStream;

public class AutoPilot {

    private final BotController controller;
    private final BotField field;
    private final OutputStream outputStream;

    public AutoPilot(BotController controller, BotField field, OutputStream outputStream) {
        this.controller = controller;
        this.field = field;
        this.outputStream = outputStream;
    }

    public void start() {
        controller.registerBotField(field);
        controller.registerControlCommand(new BotCommand());
        controller.registerControlCommand(new PlaceCommand());
        controller.registerControlCommand(new ReportCommand(outputStream));
        var commands = controller.commands();
        do {
            commands.forEach(ControlCommand::execute);
            commands = controller.commands();
        }
        while (!commands.isEmpty());
        stop();
    }

    private void stop() {
        controller.controlCommands().forEach(controller::unregisterControlCommand);
    }

}
