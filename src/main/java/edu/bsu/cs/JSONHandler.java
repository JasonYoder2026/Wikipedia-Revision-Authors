package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JSONHandler {

    public String parseAndPrintData(InputStream jsonStream) throws IOException {
        StringBuilder outputBuilder = new StringBuilder();
        String jsonData = new String(jsonStream.readAllBytes());

        if(JsonPath.read(jsonData, "$..missing")){
            outputBuilder.append("System error: No wikipedia page with that title.\n");
                    return outputBuilder.toString();
        }
        String Redirection = JsonPath.read(jsonData, "$..title");
        if(Redirection != null && !Redirection.isEmpty()){
            outputBuilder.append("Redirected to").append(Redirection).append("\n");
        }

        JSONArray timestampsArray = JsonPath.read(jsonData, "$..timestamp");
        JSONArray usernamesArray = JsonPath.read(jsonData, "$..user");

        if(timestampsArray.size() < 15) {
            outputBuilder.append("There are only ").append(timestampsArray.size()).append(" revisions.\n");
        }

        for (int i = 0; i < timestampsArray.size(); i++) {
            String formattedOutput = formatTimeAndUsername(timestampsArray.get(i).toString(), usernamesArray.get(i).toString());
            outputBuilder.append(formattedOutput);
        }

        return outputBuilder.toString();
    }

    public String formatTimeAndUsername(String timestamp, String username) {
        return(timestamp + "  " + username + "\n");
    }
}
