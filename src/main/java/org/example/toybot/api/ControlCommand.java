package org.example.toybot.api;

public interface ControlCommand {

    /**
     * Get a list of control commands read from the stream
     */
    String getCommand();

    /**
     * Execute command
     */
    default void execute() {
    }

    /**
     * Create a control command using given argument
     *
     * @param argument An argument including spaces
     * @param <T>      A type of control command
     * @return A control command
     * @throws IllegalArgumentException On validation failure
     */
    <T extends ControlCommand> T decode(String argument) throws IllegalArgumentException;
}
