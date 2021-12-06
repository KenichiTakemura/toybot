package org.example.toybot;

import org.example.toybot.api.Bot;
import org.example.toybot.api.BotTable;
import org.example.toybot.api.CommandContext;

import static org.easymock.EasyMock.mock;

public abstract class TestAbstractControlCommand {

    protected final CommandContext commandContext = mock(CommandContext.class);
    protected final Bot bot = mock(Bot.class);
    protected final BotTable botTable = mock(BotTable.class);

    protected <C extends AbstractControlCommand> void setCommandContext(C command) {
        command.setCommandContext(commandContext);
    }

}
