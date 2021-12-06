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
    private Position position;
    // The direction to be faced
    private Direction direction;

    @Override
    public String getCommand() {
        return "PLACE";
    }

    @Override
    public void execute() {
        if (getContext().currentBot() != null) {
            if (getContext().getBotTable().onTable(position)) {
                getContext().getBotTable().placeABot(getContext().currentBot(),
                        position, direction);
            }
        }
    }

    @Override
    public PlaceCommand decode(String argument) throws IllegalArgumentException {
        String[] args = argument.split(",");
        if (args.length == 3) {
            try {
                position = new Position(Integer.parseInt(args[0]),
                        Integer.parseInt(args[1]));
                direction = Direction.valueOf(args[2]);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
        return this;
    }

}
