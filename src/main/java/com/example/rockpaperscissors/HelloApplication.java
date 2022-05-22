package com.example.rockpaperscissors;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
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
        //adding the images
        //rock
        FileInputStream rock = new FileInputStream("src/main/java/com/example/images/rock_press.png");
        Image rockImage = new Image(rock);
        ImageView rockImageView = new ImageView(rockImage);
        rockImageView.setFitHeight(150);
        rockImageView.setFitWidth(150);
        //rock button
        Button rockButton = new Button("Rock");

        //paper
        FileInputStream paper = new FileInputStream("src/main/java/com/example/images/paper_press.png");
        Image paperImage = new Image(paper);
        ImageView paperImageView = new ImageView(paperImage);
        paperImageView.setFitHeight(150);
        paperImageView.setFitWidth(150);
        //paper button
        Button paperButton = new Button("Paper");

        //scissors
        FileInputStream scissors = new FileInputStream("src/main/java/com/example/images/scissors_press.png");
        Image scissorsImage = new Image(scissors);
        ImageView scissorsImageView = new ImageView(scissorsImage);
        scissorsImageView.setFitHeight(150);
        scissorsImageView.setFitWidth(150);
        //scissors button
        Button scissorsButton = new Button("Scissors");

        //gridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        //alignment
        GridPane.setHalignment(rockButton, HPos.CENTER);
        GridPane.setHalignment(paperButton, HPos.CENTER);
        GridPane.setHalignment(scissorsButton, HPos.CENTER);
        //sizing
        gridPane.setHgap(100);
        gridPane.setVgap(20);
        //placement
        gridPane.addColumn(0, rockImageView, rockButton);
        gridPane.addColumn(1, paperImageView, paperButton);
        gridPane.addColumn(2, scissorsImageView, scissorsButton);

        //getting gameBoard content
        gameBoard.getChildren().addAll(
                gridPane
        );

        //setting the stage
        stage.setScene(new Scene(root, 900, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}