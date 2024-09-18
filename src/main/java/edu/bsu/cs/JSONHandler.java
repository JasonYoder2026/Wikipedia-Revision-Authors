package edu.bsu.cs;

import java.io.File;
import java.io.IOException;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JSONHandler {

    public String parseAndPrintData(File jsonData) throws IOException {
        StringBuilder builder = new StringBuilder();
        JSONArray timestamps = JsonPath.read(jsonData, "$..timestamp");
        JSONArray usernames = JsonPath.read(jsonData, "$..user");

        for (int i = 0; i < timestamps.size(); i++) {
            String formattedTimeAndUser = formatTimeAndUsername(timestamps.get(i).toString(), usernames.get(i).toString());
            builder.append(formattedTimeAndUser);
        }

        return builder.toString();
    }

    public String formatTimeAndUsername(String timestamp, String username) {
        return(timestamp + "  " + username + "\n");
    }
}
