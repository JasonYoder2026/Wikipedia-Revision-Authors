package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class RunApplication {

    public static void main(String[] args) {
        RunApplication run = new RunApplication();
        String articleName = run.getArticleName();
        String results = run.runApplication(articleName);
        System.out.println(results);
    }

    public String getArticleName() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the title of an article:");
        return userInput.nextLine();
    }

    public String runApplication(String articleName){
        checkForArticleName(articleName);

        String jsonData = getRevisionData(articleName);
        checkForConnection(jsonData);

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
        return handler.printData(jsonData);
    }

    public void checkForArticleName(String articleName) {
        if(articleName.isEmpty()) {
            System.err.println("System Error: No Article Name Submitted");
            System.exit(0);
        }
    }

    public void checkForConnection(String data) {
        if (data.contains("Error:")) {
            System.err.println("System Error: Connection Failure");
            System.exit(0);
        }
    }

}
