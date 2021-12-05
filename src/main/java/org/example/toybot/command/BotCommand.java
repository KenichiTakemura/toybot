package org.example.toybot.command;

import org.example.toybot.AbstractControlCommand;

/**
 * A command to select a bot
 * <pre>{@code
 *     BOT name
 * }</pre>
 */
public class BotCommand extends AbstractControlCommand {

    private String name;

    @Override
    public String getCommand() {
        return "BOT";
    }

    @Override
    public void execute() {
        getContext().setCurrentBot(name);
    }

    @Override
    public BotCommand decode(String argument) throws IllegalArgumentException {
        this.name = argument;
        return this;
    }

}
