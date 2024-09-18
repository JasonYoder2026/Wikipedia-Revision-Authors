package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class JSONParserTest {

    @Test
    public void testParseAndPrintData() throws IOException {
        JSONHandler testParser = new JSONHandler();
        File testData = new File("JsonData.json");
        String result = testParser.parseAndPrintData(testData);
        Assertions.assertEquals("2024-09-15T22:53:03Z  Aaw1989\n2024-09-15T20:04:58Z  2A00:23C5:E212:D01:9D11:46F1:12D5:47DB\n2024-09-15T19:47:56Z  Aaw1989\n", result);
    }

    @Test
    public void testFormatTimeAndUsername(){
        JSONHandler testParser = new JSONHandler();
        String output = testParser.formatTimeAndUsername("2024-09-15T22:53:03Z", "Aaw1989");
        Assertions.assertEquals("2024-09-15T22:53:03Z  Aaw1989\n", output);
    }
}
