package edu.bsu.cs;

import java.io.File;
import java.io.IOException;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JSONParser {

    public String parseTimestampData(File testDataStream) throws IOException {
        JSONArray result = (JSONArray)JsonPath.read(testDataStream, "$..timestamp");
        return result.getFirst().toString();
    }

    public String parseUsernameData(File testData) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(testData, "$..user");
        return result.getFirst().toString();
    }
}
