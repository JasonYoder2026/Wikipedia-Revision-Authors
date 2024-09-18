package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class JSONParserTest {

    @Test
    public void testParser() throws IOException {
        JSONParser testParser = new JSONParser();
        File testData = new File("JsonData.json");
        String timeStamp = testParser.parseTimestampData(testData);
        Assertions.assertEquals("2024-09-15T22:53:03Z", timeStamp);
    }

    @Test
    public void testUserParser() throws IOException {
        JSONParser testParser = new JSONParser();
        File testData = new File("JsonData.json");
        String user = testParser.parseUsernameData(testData);
        Assertions.assertEquals("Aaw1989", user);
    }

}
