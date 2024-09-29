package edu.bsu.cs;

public class ConnectionErrorHandler {

    public static void handleConnectionError(String message) {
        System.err.println("System Error: " + message);
        System.exit(0);
    }
}
