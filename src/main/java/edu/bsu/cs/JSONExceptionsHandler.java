package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JSONExceptionsHandler {
    public String checkForLessThan15Revisions(int length) {
        if (length < 15) {
            return "There are only " + length + " revisions.\n";
        } else {
            return "";
        }
    }

    public String checkForRedirection(String jsonData) {
        if (jsonData.contains("\"redirects\"")) {
            JSONArray redirection = JsonPath.read(jsonData, "$.query.redirects[*].to");
            return"Redirected to " + redirection.getFirst().toString() + ".\n\n";
        } else {
            return "";
        }
    }

    public boolean checkForArticle(String jsonData) {
        JSONArray missingArray = JsonPath.read(jsonData, "$.query.pages[*].missing");
        return !missingArray.isEmpty();
    }
}
