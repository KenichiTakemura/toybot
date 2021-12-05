package org.example.toybot.api;

public interface CommandContext {

    BotField getBotField();

    /**
     * Get currently selected Bot
     *
     * @return The selected bot
     */
    Bot currentBot();

    /**
     * Select a bot
     *
     * @param name A name of a bot
     * @return self
     */
    CommandContext setCurrentBot(String name);
}
