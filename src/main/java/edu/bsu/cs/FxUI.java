package edu.bsu.cs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.io.InputStream;

public class FxUI {
    @FXML
    private TextField searchBox;

    @FXML
    private void handleSearch() {
        if (searchBox.getText().isEmpty()) {
            showNoPageRequestedPopup();
        } else {
            String articleTitle = searchBox.getText();
            if (fetchArticleRevisions(articleTitle) == null) {
                showNetworkErrorPopup();
            }
        }
    }

    private InputStream fetchArticleRevisions(String articleTitle) {
        APIRevisionReader revisionReader = new APIRevisionReader();
        try {
            return revisionReader.retrieveRevisionsFromAPI(articleTitle);
        } catch (IOException e) {
            return null; 
        }
    }

    private void showNoPageRequestedPopup() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NoPageRequested.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("No Page Requested");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNetworkErrorPopup() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NetworkError.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Network Error");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


