package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JSONParser {

    public String parse(InputStream testDataStream) throws IOException {
        JSONArray result = (JSONArray)JsonPath.read(testDataStream, "$..timestamp");
        return result.getFirst().toString();
    }
}
