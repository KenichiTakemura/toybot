package org.example.toybot.api;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BotController {

    /**
     * Get registered bots
     *
     * @return Registered bots
     */
    Set<Bot> getBots();

    /**
     * Get a filed of bots
     *
     * @return A filed of bots
     */
    BotTable getBotTable();

    /**
     * Get control commands supplied from an input stream
     *
     * @return control commands
     */
    List<ControlCommand> commands() throws IOException;

    /**
     * Register a bot
     *
     * @param bot A bot to be registered
     * @return self
     */
    BotController registerBot(Bot bot);

    /**
     * Register a bot table
     *
     * @param botTable A bot table to be registered
     * @return self
     */
    BotController registerBotTable(BotTable botTable);

    /**
     * Register a control command
     *
     * @param controlCommand A control command to be registered
     * @return self
     */
    BotController registerControlCommand(ControlCommand controlCommand);
}
