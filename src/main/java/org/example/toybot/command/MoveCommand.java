package org.example.toybot.command;

import org.example.toybot.AbstractControlCommand;
import org.example.toybot.Position;

/**
 * A command to move a bot by 1 distance towards the current direction
 * <pre>{@code
 *     MOVE
 * }</pre>
 */
public class MoveCommand extends AbstractControlCommand {

    @Override
    public String getCommand() {
        return "MOVE";
    }

    @Override
    public void execute() {
        if (getContext().currentBot() != null &&
                getContext().getBotTable().onTable(getContext().currentBot())) {
            // Get current position of the bot
            Position currentPosition = getContext().currentBot().position();
            if (!getContext().getBotTable().onTable(getContext().currentBot().move(1).position())) {
                // Cannot move
                getContext().currentBot().moveTo(currentPosition);
            }
        }
    }

    @Override
    public MoveCommand decode(String argument) throws IllegalArgumentException {
        return this;
    }

}
