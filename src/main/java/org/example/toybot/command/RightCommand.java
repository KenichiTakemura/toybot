package org.example.toybot.command;

/**
 * A command to rotate the robot + 90 degrees
 * <pre>{@code
 *     RIGHT
 * }</pre>
 */
public class RightCommand extends AbstractRotateCommand {

    @Override
    public String getCommand() {
        return "RIGHT";
    }

    @Override
    protected int rotateDegree() {
        return 90;
    }
}
