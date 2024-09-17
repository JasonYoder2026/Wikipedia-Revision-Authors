package edu.bsu.cs;

public class RevisionFormatter {
    public String format(APIRevisionReader revision){
        return revision.getTimeofchange() + " " + revision.getUsername();
    }
}
