package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class JSONParserTest {

    @Test
    public void testParser() throws IOException {
        JSONParser parser = new JSONParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("JsonData.json");
        String timeStamp = parser.parse(testDataStream);
        Assertions.assertEquals("2024-09-15T22:53:03Z", timeStamp);
    }

}
