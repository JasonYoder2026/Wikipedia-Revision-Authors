package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private final Button searchButton = new Button("Search");
    private final TextField searchBox = new TextField("Enter the name of an article");
    private final TextArea resultsBox = new TextArea();


    @Override
    public void start(Stage mainStage) {
        resultsBox.setEditable(false);
        configureStage(mainStage);
        configureSearchButton();
    }

    private void configureStage(Stage stage) {
        stage.setTitle("WikiMedia Revisions App");
        stage.setScene(new Scene(createRoot()));
        stage.setMaxHeight(650.0);
        stage.setMaxWidth(600.0);
        stage.show();
    }

    private Pane createRoot() {
        VBox root = new VBox();
        root.getChildren().addAll(
                searchBox,
                searchButton,
                resultsBox
            );
        return root;
    }

    private void configureSearchButton() {
        searchButton.setOnAction(event -> fetchResults());
    }

    private void fetchResults() {
        RunApplication runApplication = new RunApplication();
        String results = runApplication.runApplication(searchBox.getText());
        resultsBox.setText(results);
    }

}
