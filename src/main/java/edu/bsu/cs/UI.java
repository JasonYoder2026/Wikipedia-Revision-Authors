package edu.bsu.cs;

import javafx.application.Application;
import javafx.stage.Stage;

public class UI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        mainStage.setTitle("WikiMedia Revisions App");
        mainStage.show();
    }
}
