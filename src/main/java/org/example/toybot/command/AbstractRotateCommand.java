package org.example.toybot.command;

import org.example.toybot.AbstractControlCommand;
import org.example.toybot.Direction;

/**
 * A command to rotate the robot 90 degrees in the specified direction without changing the position of the robot.
 */
public abstract class AbstractRotateCommand extends AbstractControlCommand {

    @Override
    public void execute() {
        if (getContext().currentBot() != null &&
                getContext().getBotTable().onTable(getContext().currentBot())) {
            getContext().currentBot().faceTo(rotate(getContext().currentBot().direction()));
        }
    }

    @Override
    public AbstractRotateCommand decode(String argument) throws IllegalArgumentException {
        return this;
    }

    protected abstract int rotateDegree();

    private Direction rotate(Direction direction) {
        int degree = ((direction.getDegree() + rotateDegree()) + 360) % 360;
        return Direction.valueFrom(degree);
    }

}
