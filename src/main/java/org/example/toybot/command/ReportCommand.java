package org.example.toybot.command;

import org.example.toybot.AbstractControlCommand;
import org.example.toybot.Direction;
import org.example.toybot.Position;
import org.example.toybot.api.ReportingFormatter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * A command to report a bot position to an output stream as byte array.
 * The reporting format also needs to be specified with {@link ReportingFormatter}
 * <pre>{@code
 *     REPORT
 * }</pre>
 */
public class ReportCommand extends AbstractControlCommand {

    private final OutputStream outputStream;

    public ReportCommand(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public String getCommand() {
        return "REPORT";
    }

    @Override
    public void execute() {
        if (getContext().currentBot() != null &&
                getContext().getBotTable().onTable(getContext().currentBot())) {
            Position position = getContext().currentBot().position();
            Direction direction = getContext().currentBot().direction();
            try {
                outputStream.write(new PositionFormatter(position, direction).format());
            } catch (IOException e) {
                // error
            }
        }
    }

    @Override
    public ReportCommand decode(String argument) throws IllegalArgumentException {
        return this;
    }

    /**
     * An example of reporting formatter, which reports a position and direction separated by commas.
     */
    private static class PositionFormatter implements ReportingFormatter {
        private final Position position;
        private final Direction direction;

        public PositionFormatter(Position position, Direction direction) {
            this.position = position;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return String.format("%d,%d,%s", position.getX(), position.getY(), direction);
        }

        @Override
        public byte[] format() {
            try {
                return toString().getBytes(StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
                return new byte[0];
            }
        }
    }
}
