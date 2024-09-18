package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class APIRevisionReader {

    public InputStream retrieveRevisionsFromAPI(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();

        return inputStream;
    }

    public HttpURLConnection connectToAPI(URL url) throws IOException {
        HttpURLConnection stableConnection = (HttpURLConnection) url.openConnection();
        stableConnection.setRequestMethod("GET");
        stableConnection.setRequestProperty("User-Agent", "Revision Reporter/0.1 jason/yoder2@bsu.edu");

        return stableConnection;
    }

    public URL createURL(String articleSearch) throws IOException{
        String encodedSearch = URLEncoder.encode(articleSearch, "UTF-8");
        String apiSearchUrl = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                encodedSearch + "&redirects=1&formatversion=2&rvprop=timestamp%7Cuser&rvlimit=15";

        URL validURL = new URL(apiSearchUrl);
        return validURL;
    }
}