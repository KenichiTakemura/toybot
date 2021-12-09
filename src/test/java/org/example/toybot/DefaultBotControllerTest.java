package org.example.toybot;

import org.easymock.Capture;
import org.example.toybot.api.Bot;
import org.example.toybot.api.BotController;
import org.example.toybot.api.BotTable;
import org.example.toybot.command.PlaceCommand;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

import static org.easymock.EasyMock.*;
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

    @Test
    public void testCoverage() {
        InputStream in = mock(InputStream.class);
        Bot bot = mock(Bot.class);
        BotTable botTable = mock(BotTable.class);
        BotController controller = new DefaultBotController(in);
        controller.registerBot(bot);
        controller.registerBotTable(botTable);
        assertEquals(bot, controller.getBots().iterator().next());
        assertEquals(botTable, controller.getBotTable());
    }
}