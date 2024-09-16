package edu.bsu.cs;

public class Revision {
    private String Username;
    private String timeofchange;

    public Revision(String Username, String timeofchange) {
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