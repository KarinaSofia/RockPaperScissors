package com.example.rockpaperscissors;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {
    private Label winLogTitle;
    private Label winLogContent;
    String baseImage = "src/main/java/com/example/images/player_load.png";
    String computerBaseImage = "src/main/java/com/example/images/player_load.png";

    ImageView loadImageView;

    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Group winLog = new Group();
        Group gameBoard = new Group();

        HBox screen = new HBox(winLog, gameBoard);

        root.getChildren().addAll(screen);

        //winLog
        winLogTitle = new Label("Win Log");
        winLogTitle.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 15));
        winLogTitle.setMinWidth(200);
        winLogContent = new Label("test");
        VBox vBox = new VBox(winLogTitle, winLogContent);

        //getting winLog content
        winLog.getChildren().addAll(
                vBox
        );

        //pick move
        //header
        Label gameHeader = new Label("Rock Paper Scissors");
        gameHeader.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 30));

        //stage

        //shown image initialization


        //player one choice
        FileInputStream load = new FileInputStream(baseImage);
        Image loadImage = new Image(load);
        loadImageView = new ImageView();
        loadImageView.setImage(loadImage);
        loadImageView.setFitHeight(150);
        loadImageView.setFitWidth(150);

        //computer choice
        FileInputStream load2 = new FileInputStream(computerBaseImage);
        Image loadImage2 = new Image(load2);
        ImageView loadImageView2 = new ImageView(loadImage2);
        loadImageView2.setFitHeight(150);
        loadImageView2.setFitWidth(150);

        //player1 choices
        //rock
        FileInputStream rock = new FileInputStream("src/main/java/com/example/images/rock_press.png");
        Image rockImage = new Image(rock);
        ImageView rockImageView = new ImageView(rockImage);
        rockImageView.setFitHeight(150);
        rockImageView.setFitWidth(150);
        //rock button
        Button rockButton = new Button("Rock");
        rockButton.setStyle("-fx-font-size: 15; -fx-background-color: #ffffbf; ");
        //button action
        rockButton.setOnAction((ActionEvent event) -> {
            System.out.println("its working");
            loadImageView.setImage(rockImage);
        });

        //paper
        FileInputStream paper = new FileInputStream("src/main/java/com/example/images/paper_press.png");
        Image paperImage = new Image(paper);
        ImageView paperImageView = new ImageView(paperImage);
        paperImageView.setFitHeight(150);
        paperImageView.setFitWidth(150);
        //paper button
        Button paperButton = new Button("Paper");
        paperButton.setStyle("-fx-font-size: 15; -fx-background-color: #ffffbf; ");
        //button action
        paperButton.setOnAction((ActionEvent event) -> {
            System.out.println("class paper button");
        });

        //scissors
        FileInputStream scissors = new FileInputStream("src/main/java/com/example/images/scissors_press.png");
        Image scissorsImage = new Image(scissors);
        ImageView scissorsImageView = new ImageView(scissorsImage);
        scissorsImageView.setFitHeight(150);
        scissorsImageView.setFitWidth(150);
        //scissors button
        Button scissorsButton = new Button("Scissors");
        scissorsButton.setStyle("-fx-font-size: 15; -fx-background-color: #ffffbf; ");
        //button action
        scissorsButton.setOnAction((ActionEvent event) -> {
            System.out.println("class scissors button");
        });


        //gridPane
        GridPane playerInteractionGridPane = new GridPane();
        playerInteractionGridPane.setAlignment(Pos.CENTER);

        GridPane gameStageGridPane = new GridPane();
        gameStageGridPane.setAlignment(Pos.CENTER);

        GridPane gameHeaderGridPane = new GridPane();
        gameHeaderGridPane.setAlignment(Pos.CENTER);

        //button alignment
        GridPane.setHalignment(rockButton, HPos.CENTER);
        GridPane.setHalignment(paperButton, HPos.CENTER);
        GridPane.setHalignment(scissorsButton, HPos.CENTER);

        //sizing
        playerInteractionGridPane.setHgap(100);
        playerInteractionGridPane.setVgap(30);

        gameStageGridPane.setHgap(120);
        gameStageGridPane.setVgap(70);

        //placement

        gameHeaderGridPane.add(gameHeader, 0, 0);

        gameStageGridPane.add(loadImageView, 0, 1);
        gameStageGridPane.add(loadImageView2, 1, 1);

        playerInteractionGridPane.add(rockImageView, 0, 2);
        playerInteractionGridPane.add(paperImageView, 1, 2);
        playerInteractionGridPane.add(scissorsImageView, 2, 2);

        playerInteractionGridPane.add(rockButton, 0, 3);
        playerInteractionGridPane.add(paperButton, 1, 3);
        playerInteractionGridPane.add(scissorsButton, 2, 3);

        //hBox
        VBox gameStage = new VBox(gameHeaderGridPane, gameStageGridPane, playerInteractionGridPane);

        //getting gameBoard content
        gameBoard.getChildren().addAll(
                gameStage
        );

        //setting the stage
        stage.setTitle("Rock Paper Scissors!");
        stage.setScene(new Scene(root));
        stage.setMinHeight(600);
        stage.setMinWidth(1000);
        stage.setMaxHeight(600);
        stage.setMaxWidth(1000);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}