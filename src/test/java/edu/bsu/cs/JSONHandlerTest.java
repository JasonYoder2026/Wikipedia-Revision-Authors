package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;

public class JSONHandlerTest {

    @Test
    public void testParseAndPrintData(){
        JSONHandler testParser = new JSONHandler();
        String jsonData = getJsonData();
        String result = testParser.printData(jsonData);
        Assertions.assertEquals("""
                Redirected to Frank Zappa.
                There are only 3 revisions.
                2024-09-15T22:53:03Z  Aaw1989
                2024-09-15T20:04:58Z  2A00:23C5:E212:D01:9D11:46F1:12D5:47DB
                2024-09-15T19:47:56Z  Aaw1989
                """, result);
    }

    public String getJsonData() {
        try {
            InputStream testStream = JSONHandlerTest.class.getClassLoader().getResourceAsStream("JsonData.json");
            if(testStream == null) {
                throw new IllegalArgumentException("File not found!");
            }
            return new String(testStream.readAllBytes());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Test
    public void testMissingArticle() {
        JSONHandler testHandler = new JSONHandler();
        String jsonData = getMissingArticleStream();
        String result = testHandler.printData(jsonData);
        Assertions.assertEquals("System error: No Wikipedia page with that title.\n", result);
    }

    public String getMissingArticleStream() {
        try {
            InputStream testStream = JSONHandlerTest.class.getClassLoader().getResourceAsStream("Missing.json");
            if(testStream == null) {
                throw new IllegalArgumentException("File not found!");
            }
            return new String(testStream.readAllBytes());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Test
    public void testFormatTimeAndUsername(){
        JSONHandler testParser = new JSONHandler();
        String output = testParser.formatTimeAndUsername("2024-09-15T22:53:03Z", "Aaw1989");
        Assertions.assertEquals("2024-09-15T22:53:03Z  Aaw1989\n", output);
    }


}
