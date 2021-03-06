package org.example.toybot.command;

/**
 * A command to rotate the robot - 90 degrees
 * <pre>{@code
 *     LEFT
 * }</pre>
 */
public class LeftCommand extends AbstractRotateCommand {

    @Override
    public String getCommand() {
        return "LEFT";
    }

    @Override
    protected int rotateDegree() {
        return -90;
    }
}
