package org.example.toybot.api;

import com.fasterxml.jackson.databind.JsonNode;

public interface ControlCommand {

    String getCommand();

    default void execute() {
    }

    <T extends ControlCommand> T decode(String argument) throws IllegalArgumentException;
}
