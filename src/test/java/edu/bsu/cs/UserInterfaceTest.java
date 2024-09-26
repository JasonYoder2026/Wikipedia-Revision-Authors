package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserInterfaceTest {

    @Test
    public void testGetRevisionData() {
        RunApplication ui = new RunApplication();
        String articleName = "Zappa";
        String data = ui.getRevisionData(articleName);
        Assertions.assertEquals(data, "{\"continue\":{\"rvcontinue\":\"20240915051242|1245799421\",\"continue\":\"||\"},\"query\":{\"redirects\":[{\"from\":\"Zappa\",\"to\":\"Frank Zappa\"}],\"pages\":[{\"pageid\":10672,\"ns\":0,\"title\":\"Frank Zappa\",\"revisions\":[{\"user\":\"♥Golf\",\"timestamp\":\"2024-09-24T11:11:05Z\"},{\"user\":\"♥Golf\",\"timestamp\":\"2024-09-24T11:07:28Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-22T22:34:59Z\"},{\"user\":\"109.245.227.66\",\"anon\":true,\"timestamp\":\"2024-09-21T20:52:23Z\"},{\"user\":\"2A00:23C5:E212:D01:4523:A371:376:EB17\",\"anon\":true,\"timestamp\":\"2024-09-18T04:13:02Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T22:53:03Z\"},{\"user\":\"2A00:23C5:E212:D01:9D11:46F1:12D5:47DB\",\"anon\":true,\"timestamp\":\"2024-09-15T20:04:58Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T19:47:56Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T19:44:41Z\"},{\"user\":\"2A00:23C5:E212:D01:6C47:DA76:1B3A:6B89\",\"anon\":true,\"timestamp\":\"2024-09-15T06:14:26Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-15T05:33:37Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T05:27:34Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T05:17:25Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T05:15:37Z\"},{\"user\":\"2A00:23C5:E212:D01:45BB:6B02:C2F7:E796\",\"anon\":true,\"timestamp\":\"2024-09-15T05:13:53Z\"}]}]}}");
    }

    @Test
    public void testPrintRevisionsData(){
        RunApplication ui = new RunApplication();
        String jsonData = ui.getRevisionData("Frank Zappa");
        String result = ui.printRevisionsData(jsonData);
        Assertions.assertEquals(result, """
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
                2024-09-15T05:13:53Z  2A00:23C5:E212:D01:45BB:6B02:C2F7:E796
                """);
    }


}
