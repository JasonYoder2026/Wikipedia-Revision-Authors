package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class UserInterface {


    public static void main(String[] args) throws IOException {
        UserInterface revisionsApp = new UserInterface();
        revisionsApp.runApplication();

    }

    public void runApplication() throws IOException {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the title of an article:");
        String articleName = userInput.nextLine();

        if (articleName.isEmpty()) {
            System.out.println("System Error: No Article Name Submitted");
            System.exit(0);
        }

        String jsonData = getRevisionData(articleName);

        if (jsonData.isEmpty()) {
            System.out.println("System Error: Connection Failure");
            System.exit(0);
        }

        System.out.println();
        System.out.println(printRevisionsData(jsonData));
    }

    public String getRevisionData(String articleName) throws IOException {
        APIRevisionReader revisionReader = new APIRevisionReader();
        InputStream jsonStream = revisionReader.retrieveRevisionsFromAPI(articleName);
        return new String(jsonStream.readAllBytes());
    }

    public String printRevisionsData(String jsonData) {
        JSONHandler handler = new JSONHandler();
        return handler.printData(jsonData);
    }
}
