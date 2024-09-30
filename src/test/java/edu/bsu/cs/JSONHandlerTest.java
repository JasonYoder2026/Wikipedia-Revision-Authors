package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;

public class JSONHandlerTest {

    @Test
    public void testParseAndReturnData(){
        JSONHandler testParser = new JSONHandler();
        String jsonData = getJsonData(new File("JsonData.json"));
        String result = testParser.returnData(jsonData);
        Assertions.assertEquals("""
                Redirected to Frank Zappa.
                
                There are only 3 revisions.
                2024-09-15T22:53:03Z  Aaw1989
                2024-09-15T20:04:58Z  2A00:23C5:E212:D01:9D11:46F1:12D5:47DB
                2024-09-15T19:47:56Z  Aaw1989
                """, result);
    }

    @Test
    public void test15Entries() {
        JSONHandler testParser = new JSONHandler();
        String jsonData = getJsonData(new File("JsonDataWith15Entries.json"));
        String result = testParser.returnData(jsonData);
        Assertions.assertEquals(result, """
                Redirected to Frank Zappa.
                
                2024-09-29T18:56:38Z  JJMC89 bot III
                2024-09-24T11:11:05Z  ♥Golf
                2024-09-24T11:07:28Z  ♥Golf
                2024-09-22T22:34:59Z  Aaw1989
                2024-09-21T20:52:23Z  109.245.227.66
                2024-09-18T04:13:02Z  2A00:23C5:E212:D01:4523:A371:376:EB17
                2024-09-15T22:53:03Z  Aaw1989
                2024-09-15T20:04:58Z  2A00:23C5:E212:D01:9D11:46F1:12D5:47DB
                2024-09-15T19:47:56Z  Aaw1989
                2024-09-15T19:44:41Z  Aaw1989
                2024-09-15T06:14:26Z  2A00:23C5:E212:D01:6C47:DA76:1B3A:6B89
                2024-09-15T05:33:37Z  Aaw1989
                2024-09-15T05:27:34Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                2024-09-15T05:17:25Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                2024-09-15T05:15:37Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                """);
    }

    @Test
    public void testNoRedirect() {
        JSONHandler testParser = new JSONHandler();
        String jsonData = getJsonData(new File("JsonDataWithNoRedirect.json"));
        String result = testParser.returnData(jsonData);
        Assertions.assertEquals(result, """
                2024-09-20T10:26:25Z  Annh07
                2024-09-20T10:24:04Z  Labgrowneternityring
                2024-03-17T22:41:57Z  Bkonrad
                2024-03-17T21:38:27Z  203.101.165.230
                2023-12-08T03:39:23Z  Emiya Mulzomdao
                2023-11-10T09:28:45Z  Liberatus
                2023-10-13T09:03:59Z  Jinsha 0982
                2023-05-10T07:57:32Z  Meters
                2023-05-10T07:44:44Z  2600:8803:7D07:4800:582F:8E79:20F7:D93
                2023-03-24T18:49:48Z  Meters
                2023-03-24T18:42:43Z  2A01:5EC0:7006:2188:1:0:D6A1:6C97
                2023-01-22T21:56:24Z  Sergio Macías
                2022-12-31T15:45:34Z  Eejit43
                2022-12-31T10:19:16Z  Adrian619Mysterio
                2022-10-31T16:36:53Z  Lambtron
                """);
    }

    public String getJsonData(File file) {
        try {
            InputStream testStream = JSONHandlerTest.class.getClassLoader().getResourceAsStream(String.valueOf(file));
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
        String result = testHandler.returnData(jsonData);
        Assertions.assertEquals("No Wikipedia page with that title.\n", result);
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
