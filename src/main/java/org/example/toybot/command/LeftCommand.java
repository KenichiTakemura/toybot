package org.example.toybot.command;

import org.example.toybot.AbstractControlCommand;
import org.example.toybot.Direction;

/**
 * A command to rotate the robot 90 degrees in the specified direction without changing the position of the robot.
 * <pre>{@code
 *     LEFT
 * }</pre>
 */
public class LeftCommand extends AbstractControlCommand {

    @Override
    public String getCommand() {
        return "LEFT";
    }

    @Override
    public void execute() {
        if (getContext().currentBot() != null &&
                getContext().getBotTable().onTable(getContext().currentBot())) {
            getContext().currentBot().faceTo(leftOf(getContext().currentBot().direction()));
        }
    }

    @Override
    public LeftCommand decode(String argument) throws IllegalArgumentException {
        return this;
    }

    Direction leftOf(Direction direction) {
        int degree = ((direction.getDegree() - 90) + 360) % 360;
        return Direction.valueFrom(degree);
    }

}
