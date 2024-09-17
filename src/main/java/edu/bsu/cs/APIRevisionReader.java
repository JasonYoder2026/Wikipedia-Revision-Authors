package edu.bsu.cs;

public class APIRevisionReader {
    private String Username;
    private String timeofchange;

    public APIRevisionReader(String Username, String timeofchange) {
        this.Username = Username;
        this.timeofchange = timeofchange;
    }
    public String getTimeofchange(){
        return timeofchange;
    }
    public String getUsername(){
        return Username;
    }
}