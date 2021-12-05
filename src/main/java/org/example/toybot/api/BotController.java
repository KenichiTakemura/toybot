package org.example.toybot.api;

import java.util.List;
import java.util.Set;

public interface BotController {

    /**
     * Get registered bots
     *
     * @return Registered bots
     */
    Set<Bot> bots();

    /**
     * Get a filed of bots
     *
     * @return A filed of bots
     */
    BotField botField();

    /**
     * Get control commands supplied from
     *
     * @return control commands
     */
    List<ControlCommand> commands();

    /**
     * Register a bot
     *
     * @param bot A bot to be registered
     * @return self
     */
    BotController registerBot(Bot bot);

    /**
     * Register a bot filed
     *
     * @param botField A bot filed to be registered
     * @return self
     */
    BotController registerBotField(BotField botField);

    /**
     * Register a control command
     *
     * @param controlCommand A control command to be registered
     * @return self
     */
    BotController registerControlCommand(ControlCommand controlCommand);

    Set<ControlCommand> controlCommands();

    BotController unregisterControlCommand(ControlCommand controlCommand);
}
