package edu.bsu.cs;

public class RevisionFormatter {
    public String format(Revision revision){
        return revision.getTimeofchange() + " " + revision.getUsername();
    }
}
