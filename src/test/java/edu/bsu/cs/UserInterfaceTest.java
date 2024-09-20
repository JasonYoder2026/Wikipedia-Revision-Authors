package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class UserInterfaceTest {

    @Test
    public void testGetRevisionData() {
        UserInterface ui = new UserInterface();
        String articleName = "Zappa";
        String data = ui.getRevisionData(articleName);
        Assertions.assertEquals(data, "{\"continue\":{\"rvcontinue\":\"20240913172140|1245554050\",\"continue\":\"||\"},\"query\":{\"redirects\":[{\"from\":\"Zappa\",\"to\":\"Frank Zappa\"}],\"pages\":[{\"pageid\":10672,\"ns\":0,\"title\":\"Frank Zappa\",\"revisions\":[{\"user\":\"2A00:23C5:E212:D01:4523:A371:376:EB17\",\"anon\":true,\"timestamp\":\"2024-09-18T04:13:02Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T22:53:03Z\"},{\"user\":\"2A00:23C5:E212:D01:9D11:46F1:12D5:47DB\",\"anon\":true,\"timestamp\":\"2024-09-15T20:04:58Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T19:47:56Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T19:44:41Z\"},{\"user\":\"2A00:23C5:E212:D01:6C47:DA76:1B3A:6B89\",\"anon\":true,\"timestamp\":\"2024-09-15T06:14:26Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T05:33:37Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T05:27:34Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T05:17:25Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T05:15:37Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T05:13:53Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T05:12:42Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T02:46:21Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T02:45:27Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T01:12:01Z\"}]}]}}");
    }

    @Test
    public void testPrintRevisionsData() {
        UserInterface ui = new UserInterface();
        String jsonData = ui.getRevisionData("Frank Zappa");
        String result = ui.printRevisionsData(jsonData);
        Assertions.assertEquals(result, """
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
                2024-09-15T05:13:53Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                2024-09-15T05:12:42Z  Aaw1989
                2024-09-15T02:46:21Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                2024-09-15T02:45:27Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                2024-09-15T01:12:01Z  Aaw1989
                """);
    }

    //This test only can be used is runApplication method is modified to accept a string parameter instead of user input. It does pass
    /*
    @Test
    public void testRunApplication() throws IOException{
        UserInterface ui = new UserInterface();
        String userInput = "Frank Zappa";
        String result = ui.runApplication(userInput);
        Assertions.assertEquals(result, """
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
                2024-09-15T05:13:53Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                2024-09-15T05:12:42Z  Aaw1989
                2024-09-15T02:46:21Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                2024-09-15T02:45:27Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                2024-09-15T01:12:01Z  Aaw1989
                """);
    }
    */


}
