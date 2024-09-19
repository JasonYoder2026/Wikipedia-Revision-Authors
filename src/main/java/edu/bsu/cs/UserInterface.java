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

        InputStream dataStream = getRevisionStream(articleName);

        System.out.println();
        System.out.println(printRevisionsData(dataStream));
    }

    public InputStream getRevisionStream(String articleName) throws IOException {
        APIRevisionReader revisionReader = new APIRevisionReader();
        return revisionReader.retrieveRevisionsFromAPI(articleName);
    }

    public String printRevisionsData(InputStream dataStream) throws IOException {
        JSONHandler handler = new JSONHandler();
        return handler.printData(dataStream);
    }
}
