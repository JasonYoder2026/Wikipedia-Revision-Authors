package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JSONHandlerTest {

    @Test
    public void testParseAndPrintData() throws IOException {
        JSONHandler testParser = new JSONHandler();
        InputStream testStream = new FileInputStream("JsonData.json");
        String result = testParser.printData(testStream);
        Assertions.assertEquals("Redirected to Frank Zappa.\n" +
                "There are only 3 revisions.\n" +
                "2024-09-15T22:53:03Z  Aaw1989\n2024-09-15T20:04:58Z  2A00:23C5:E212:D01:9D11:46F1:12D5:47DB\n" +
                "2024-09-15T19:47:56Z  Aaw1989\n", result);
    }

    @Test
    public void testMissingArticle() throws IOException {
        JSONHandler testHandler = new JSONHandler();
        InputStream testStream = new FileInputStream("Missing.json");
        String result = testHandler.printData(testStream);
        Assertions.assertEquals("System error: No Wikipedia page with that title.\n", result);
    }

    @Test
    public void testFormatTimeAndUsername(){
        JSONHandler testParser = new JSONHandler();
        String output = testParser.formatTimeAndUsername("2024-09-15T22:53:03Z", "Aaw1989");
        Assertions.assertEquals("2024-09-15T22:53:03Z  Aaw1989\n", output);
    }
}
