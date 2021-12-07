package org.example.toybot;

import org.example.toybot.api.BotController;
import org.example.toybot.command.PlaceCommand;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

import static org.junit.Assert.assertEquals;

public class DefaultBotControllerTest {

    @Test
    public void commands() throws Exception {

        ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
        ByteArrayInputStream bin = new ByteArrayInputStream(byteBuffer.array());

        BotController controller = new DefaultBotController(bin)
                .registerControlCommand(new PlaceCommand());
        int count = 500;
        for (int j = 0; j < count; j++) {
            byteBuffer.put("PLACE 1,1,NORTH\n".getBytes());
        }
        // Get first 256 commands
        assertEquals(256, controller.commands().size());
        // Get remaining 244 commands
        assertEquals(244, controller.commands().size());
    }

}