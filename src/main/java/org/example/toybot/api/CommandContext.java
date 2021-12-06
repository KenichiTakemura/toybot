package org.example.toybot.api;

public interface CommandContext {

    /**
     * Get bot table
     *
     * @return The bot table
     */
    BotTable getBotTable();

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
