package org.example.toybot;

import org.example.toybot.api.Bot;
import org.example.toybot.api.BotController;
import org.example.toybot.api.BotField;
import org.example.toybot.api.CommandContext;

public class DefaultCommandContext implements CommandContext {

    private final BotController controller;
    private Bot currentBot;

    public DefaultCommandContext(BotController controller) {
        this.controller = controller;
    }

    @Override
    public BotField getBotField() {
        return controller.botField();
    }

    @Override
    public Bot currentBot() {
        return currentBot;
    }

    @Override
    public CommandContext setCurrentBot(String name) {
        currentBot = controller.bots().stream()
                .filter(bot -> bot.name().equalsIgnoreCase(name)).findAny().orElse(null);
        return this;
    }
}
