package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class RunApplication {

    public static void main(String[] args) {
        RunApplication run = new RunApplication();
        try {
            String articleName = run.getArticleName();
            String results = run.runApplication(articleName);
            System.out.println(results);
        } catch (Exception e) {
            handleConnectionError(e.getMessage());
        }
    }

    public String getArticleName() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the title of an article:");
        return userInput.nextLine();
    }

    public String runApplication(String articleName) throws IOException {
        checkForArticleName(articleName);

        String jsonData = getRevisionData(articleName);
        checkForFailedConnection(jsonData);

        return printRevisionsData(jsonData);

    }

    public String getRevisionData(String articleName) {
        try {
            APIRevisionReader revisionReader = new APIRevisionReader();
            InputStream jsonStream = revisionReader.retrieveRevisionsFromAPI(articleName);
            return new String(jsonStream.readAllBytes());
        } catch (IOException e) {
            return ("System Error: " + e.getMessage());
        }

    }

    public String printRevisionsData(String jsonData) {
        JSONHandler handler = new JSONHandler();
        return handler.returnData(jsonData);
    }

    public void checkForArticleName(String articleName) {
        if(articleName.isEmpty()) {
            System.err.println("System Error: No Article Name Submitted");
            System.exit(0);
        }
    }

    public void checkForFailedConnection(String data) throws IOException {
        if (data.contains("Error:")) {
            throw new IOException("Connection Failure");
        }
    }

    public static void handleConnectionError(String message) {
        System.err.println("System Error: " + message);
        System.exit(0);
    }

}
