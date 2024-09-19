package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner userInterface = new Scanner(System.in);
        APIRevisionReader revisionReader = new APIRevisionReader();
        JSONHandler jsonHandler = new JSONHandler();

        System.out.println("Enter the title of an article: ");
        String articleTitle = userInterface.nextLine();

        if (articleTitle.isEmpty()) {
            System.err.println("error: no title provided.");
            userInterface.close();
        }

        try {
            InputStream dataStream = revisionReader.retrieveRevisionsFromAPI(articleTitle);
            String output = jsonHandler.parseAndPrintData(dataStream);
            System.out.println(output);
        } catch (IOException e) {
            System.err.println("error: could not retrieve data check internet connection or article title. ");
        }
    }
}