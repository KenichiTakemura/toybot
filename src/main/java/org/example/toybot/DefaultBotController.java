package org.example.toybot;

import com.google.common.collect.ImmutableSet;
import org.example.toybot.api.Bot;
import org.example.toybot.api.BotController;
import org.example.toybot.api.BotTable;
import org.example.toybot.api.ControlCommand;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DefaultBotController implements BotController {

    private final Map<String, AbstractControlCommand> controlCommands = new HashMap<>();
    private final DefaultCommandContext commandContext;
    private BotTable botTable;
    private Set<Bot> bots = new HashSet<>();
    private InputStream inputStream;

    public DefaultBotController(InputStream inputStream) {
        this.inputStream = inputStream;
        commandContext = new DefaultCommandContext(this);
    }

    @Override
    public Set<Bot> getBots() {
        return ImmutableSet.copyOf(bots);
    }

    @Override
    public BotTable getBotTable() {
        return botTable;
    }

    @Override
    public List<ControlCommand> commands() {
        List<ControlCommand> commands = new ArrayList<>();
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())
                .useDelimiter(System.lineSeparator())) {
            while (scanner.hasNextLine()) {
                try {
                    String line = scanner.next();
                    if (!line.trim().isEmpty()) {
                        // Extract command separated by the first space, rests will be arguments if present
                        String command = line.split(" ")[0];
                        if (controlCommands.containsKey(command)) {
                            ControlCommand controlCommand = controlCommands.get(command).decode(
                                    line.substring(line.length() > command.length() ?
                                            command.length() + 1 : command.length()));
                            commands.add(controlCommand);
                        }
                    }
                } catch (Exception e) {
                    // Ctrl-D
                }
            }
        }
        return commands;
    }

    @Override
    public BotController registerBot(Bot bot) {
        bots.add(bot);
        return this;
    }

    @Override
    public BotController registerBotTable(BotTable botTable) {
        this.botTable = botTable;
        return this;
    }

    @Override
    public BotController registerControlCommand(ControlCommand controlCommand) {
        controlCommands.put(controlCommand.getCommand(),
                ((AbstractControlCommand) controlCommand).setCommandContext(commandContext));
        return this;
    }

}
