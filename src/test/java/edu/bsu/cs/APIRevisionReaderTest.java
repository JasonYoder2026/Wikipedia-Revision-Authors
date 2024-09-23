package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;


public class APIRevisionReaderTest {

    @Test
    public void testCreateURL() throws IOException {
        APIRevisionReader reader = new APIRevisionReader();
        String result = String.valueOf(reader.createURL("Zappa"));
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Zappa" +
                "&redirects=1&formatversion=2&rvprop=timestamp%7Cuser&rvlimit=15", result);
    }


    @Test
    public void testRetrieveRevisionsFromAPI() throws IOException {
        APIRevisionReader reader = new APIRevisionReader();
        String search = "Zappa";
        InputStream stream = reader.retrieveRevisionsFromAPI(search);
        Assertions.assertNotNull(stream);
    }
}

