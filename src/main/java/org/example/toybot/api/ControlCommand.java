package org.example.toybot.api;

public interface ControlCommand {

    String getCommand();

    default void execute() {
    }

    <T extends ControlCommand> T decode(String argument) throws IllegalArgumentException;
}
