package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) throws IOException {
        Scanner userInterface = new Scanner(System.in);
        APIRevisionReader revisionReader = new APIRevisionReader();
        JSONHandler jsonHandler = new JSONHandler();

        System.out.println("Enter the title of an article: ");
        String articleTitle = userInterface.nextLine();

        InputStream dataStream = revisionReader.retrieveRevisionsFromAPI(articleTitle);

        System.out.println();
        System.out.println(jsonHandler.printData(dataStream));

    }
}
