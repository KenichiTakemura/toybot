package org.example.toybot.api;

/**
 * A reporting formatter
 */
public interface ReportingFormatter {

    /**
     * Format a reporting date into a byte array to to sent to an output stream
     *
     * @return A byte array
     */
    byte[] format();
}
