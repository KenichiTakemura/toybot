package org.example.toybot.command;

import org.example.toybot.AbstractControlCommand;
import org.example.toybot.Direction;
import org.example.toybot.Position;

/**
 * A command to place a bot on a position facting a direction
 * <pre>{@code
 *     PLACE x-position,y-position,direction
 * }</pre>
 */
public class PlaceCommand extends AbstractControlCommand {

    // The position to be placed
    private Position position = Position.NONE;
    // The direction to be faced
    private Direction direction;

    @Override
    public String getCommand() {
        return "PLACE";
    }

    @Override
    public void execute() {
        if (getContext().currentBot() != null && getContext().getBotTable() != null) {
            if (getContext().getBotTable().onTable(position)) {
                getContext().getBotTable().placeABot(getContext().currentBot(),
                        position, direction);
            }
        }
    }

    @Override
    public PlaceCommand decode(String argument) throws IllegalArgumentException {
        if (argument == null) {
            throw new IllegalArgumentException("argument is required.");
        }
        String[] args = argument.split(",");
        // Expect X,Y,direction
        if (args.length == 3) {
            try {
                position = new Position(Integer.parseInt(args[0]),
                        Integer.parseInt(args[1]));
                direction = Direction.valueOf(args[2]);
            } catch (Exception e) {
                // Failed to parse as integer
                // Direction is out of range
                throw new IllegalArgumentException(e);
            }
        }
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
