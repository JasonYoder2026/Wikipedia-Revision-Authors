package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private final Button searchButton = new Button("Search");
    private final Label searchLabel = new Label("Enter the name of an article: ");
    private final TextField searchBox = new TextField();
    private final TextArea resultsBox = new TextArea();


    @Override
    public void start(Stage mainStage) {
        mainStage.setWidth(600);
        mainStage.setHeight(550);
        mainStage.setResizable(false);
        resultsBox.setEditable(false);
        configureStage(mainStage);
        configureSearchButton();
    }

    private void configureStage(Stage stage) {
        stage.setTitle("WikiMedia Revisions App");
        stage.setScene(new Scene(createRoot()));
        stage.show();
    }

    private GridPane createRoot() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setAlignment(Pos.CENTER);
        resultsBox.setPrefHeight(350);
        gridPane.add(searchLabel, 0, 0);
        gridPane.add(searchBox, 1, 0);
        gridPane.add(searchButton, 1, 1);
        gridPane.add(resultsBox, 0, 2, 2, 1);

        return gridPane;
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
