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

        String jsonData = getRevisionData(articleName);

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
