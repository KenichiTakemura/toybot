package org.example.toybot;

import org.example.toybot.api.CommandContext;
import org.example.toybot.api.ControlCommand;

public abstract class AbstractControlCommand implements ControlCommand {

    private CommandContext commandContext;

    AbstractControlCommand setCommandContext(CommandContext commandContext) {
        this.commandContext = commandContext;
        return this;
    }

    protected CommandContext getContext() {
        return commandContext;
    }

}
