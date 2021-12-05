package org.example.toybot.api;

import java.io.OutputStream;
import java.util.List;
import java.util.Set;

public interface BotController {

    Set<Bot> bots();

    BotField botField();

    List<ControlCommand> commands();

    BotController registerBot(Bot bot);

    BotController registerBotField(BotField botField);

    BotController registerControlCommand(ControlCommand controlCommand);

    Set<ControlCommand> controlCommands();

    BotController unregisterControlCommand(ControlCommand controlCommand);
}
