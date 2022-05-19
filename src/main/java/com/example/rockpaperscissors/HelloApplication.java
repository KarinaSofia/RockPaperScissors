package com.example.rockpaperscissors;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Label winLogTitle;
    private Label winLogContent;

    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Group winLog = new Group();
        Group gameBoard = new Group();

        HBox screen = new HBox(winLog, gameBoard);

        root.getChildren().addAll(screen);

        //winLog
        winLogTitle = new Label("Win Log");
        winLogTitle.setMaxWidth(150);
        winLogContent = new Label("test");
        VBox vBox = new VBox(winLogTitle, winLogContent);

        //getting winLog content
        winLog.getChildren().addAll(
                vBox
        );

        //pick move


        //getting gameBoard content

        //setting the stage
        stage.setScene(new Scene(root, 900, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}