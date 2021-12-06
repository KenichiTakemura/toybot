package org.example.toybot;

import org.example.toybot.api.Bot;
import org.example.toybot.api.BotController;
import org.example.toybot.api.BotTable;
import org.example.toybot.api.CommandContext;

public class DefaultCommandContext implements CommandContext {

    private final BotController controller;
    private Bot currentBot;

    public DefaultCommandContext(BotController controller) {
        this.controller = controller;
    }

    @Override
    public BotTable getBotTable() {
        return controller.getBotTable();
    }

    @Override
    public Bot currentBot() {
        if (currentBot != null) {
            return currentBot;
        }
        if (!controller.getBots().isEmpty()) {
            return controller.getBots().iterator().next();
        }
        return null;
    }

    @Override
    public CommandContext setCurrentBot(String name) {
        currentBot = controller.getBots().stream()
                .filter(bot -> bot.name().equalsIgnoreCase(name)).findAny().orElse(null);
        return this;
    }
}
