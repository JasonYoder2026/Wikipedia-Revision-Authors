package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JSONHandler {

    public String printData(String jsonData) {
        StringBuilder outputBuilder = new StringBuilder();

        JSONArray revisions = JsonPath.read(jsonData, "$..timestamp");
        int numOfRevisions = revisions.size();

        if(checkForArticle(jsonData)){
            return "System error: No Wikipedia page with that title.\n";
        }

        outputBuilder.append(checkForRedirection(jsonData));
        outputBuilder.append(checkForLessThan15Revisions(numOfRevisions));
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

    public String checkForLessThan15Revisions(int length) {
        if (length < 15) {
            return "There are only " + length + " revisions.\n";
        } else {
            return "";
        }
    }

    public String checkForRedirection(String jsonData) {
        JSONArray redirection = JsonPath.read(jsonData, "$.query.redirects[*].to");
        if (!redirection.isEmpty()) {
            return"Redirected to " + redirection.getFirst().toString() + ".\n";
        } else {
            return "";
        }
    }

    public boolean checkForArticle(String jsonData) {
        JSONArray missingArray = JsonPath.read(jsonData, "$.query.pages[*].missing");
        return !missingArray.isEmpty();
    }


    public String formatTimeAndUsername(String timestamp, String username) {
        return(timestamp + "  " + username + "\n");
    }
}
