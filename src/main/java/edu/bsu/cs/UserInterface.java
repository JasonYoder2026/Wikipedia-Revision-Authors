package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class UserInterface {


    public static void main(String[] args) {
        UserInterface revisionsApp = new UserInterface();
        revisionsApp.runApplication();

    }

    public void runApplication(){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the title of an article:");
        String articleName = userInput.nextLine();

        if (articleName.isEmpty()) {
            System.err.println("System Error: No Article Name Submitted");
            System.exit(0);
        }
        String jsonData = getRevisionData(articleName);

        if (jsonData.contains("Error:")) {
            System.err.println("System Error: Connection Failure");
            System.exit(0);
        }

        System.out.println();
        String results = printRevisionsData(jsonData);
        System.out.println(results);

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
}
