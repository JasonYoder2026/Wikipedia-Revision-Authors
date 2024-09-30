package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JSONHandler {

    public String returnData(String jsonData) {
        JSONExceptionsHandler handler = new JSONExceptionsHandler();
        StringBuilder outputBuilder = new StringBuilder();

        JSONArray revisions = JsonPath.read(jsonData, "$..timestamp");
        int numOfRevisions = revisions.size();

        if(handler.checkForArticle(jsonData)){
            return "No Wikipedia page with that title.\n";
        }

        outputBuilder.append(handler.checkForRedirection(jsonData));
        outputBuilder.append(handler.checkForLessThan15Revisions(numOfRevisions));
        outputBuilder.append(readRevisions(jsonData));

        return outputBuilder.toString();
    }

    public String readRevisions(String jsonData) {
        StringBuilder revisionsBuilder = new StringBuilder();
        JSONArray timestampsArray = JsonPath.read(jsonData, "$..timestamp");
        JSONArray usernamesArray = JsonPath.read(jsonData, "$..user");

        for (int i = 0; i < timestampsArray.size(); i++) {
            String formattedOutput = formatTimeAndUsername(timestampsArray.get(i).toString(), usernamesArray.get(i).toString());
            revisionsBuilder.append(formattedOutput);
        }
        return revisionsBuilder.toString();
    }


    public String formatTimeAndUsername(String timestamp, String username) {
        return(timestamp + "  " + username + "\n");
    }
}
