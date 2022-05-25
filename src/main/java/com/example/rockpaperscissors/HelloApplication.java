package com.example.rockpaperscissors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    private Label winLogTitle;
    private String userInput;
    private ImageView loadImageView;
    private ImageView loadImageView2;
    private int counter = 0;

    @Override
    public void start(Stage stage) throws IOException {

        //creating the different sections of the scene and adding tem to the scene
        Group root = new Group();
        Group winLog = new Group();
        Group gameBoard = new Group();

        HBox screen = new HBox(winLog, gameBoard);
        root.getChildren().addAll(screen);

        //image imports
        Image loadImage = new Image("https://raw.githubusercontent.com/KarinaSofia/RockPaperScissors/master/src/main/java/com/example/images/player_load.png");
        Image loadImage2 = new Image("https://raw.githubusercontent.com/KarinaSofia/RockPaperScissors/master/src/main/java/com/example/images/player_load.png");

        Image rockImage = new Image("https://raw.githubusercontent.com/KarinaSofia/RockPaperScissors/master/src/main/java/com/example/images/rock_press.png");
        Image paperImage = new Image("https://raw.githubusercontent.com/KarinaSofia/RockPaperScissors/master/src/main/java/com/example/images/paper_press.png");
        Image scissorsImage = new Image("https://raw.githubusercontent.com/KarinaSofia/RockPaperScissors/master/src/main/java/com/example/images/scissors_press.png");

        //winLog
        winLogTitle = new Label("Win Log");
        winLogTitle.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 15));
        winLogTitle.setMinWidth(200);
        VBox vBox = new VBox(winLogTitle);

        //getting winLog content
        winLog.getChildren().addAll(vBox);

        //pick move
        //headers
        Label gameHeader = new Label("Rock Paper Scissors");
        gameHeader.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 30));

        Label player1Header = new Label("Player 1 (you)");
        player1Header.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 15));

        Label player2Header = new Label("Challenger");
        player2Header.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 15));

        //player one choice visual
        loadImageView = new ImageView();
        loadImageView.setImage(loadImage);
        loadImageView.setFitHeight(150);
        loadImageView.setFitWidth(150);

        //computer choice visual
        loadImageView2 = new ImageView(loadImage2);
        loadImageView2.setImage(loadImage2);
        loadImageView2.setFitHeight(150);
        loadImageView2.setFitWidth(150);

        //Start button
        Button startButton = new Button("Start");
        startButton.setStyle("-fx-font-size: 15; -fx-background-color: #acd1af; ");

        //start button action
        startButton.setOnAction((ActionEvent event) -> {
                if(userInput != null){
                    Evaluation evaluate = new Evaluation(userInput);
                    //setting the computer visual
                    if(evaluate.getPlayer2Choice().equals("R")){
                        loadImageView2.setImage(rockImage);
                    }
                    else if(evaluate.getPlayer2Choice().equals("P")){
                        loadImageView2.setImage(paperImage);
                    }
                    else if(evaluate.getPlayer2Choice().equals("S")){
                        loadImageView2.setImage(scissorsImage);
                    }
                    counter++;
                    //adding to gameLog
                    vBox.getChildren().add(new Label( "Game " + counter + ": " + evaluate.playGame()));
                    //message to clearly view the results of the game
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Game Results");
                    alert.setHeaderText("Looks like...");
                    alert.setContentText(evaluate.playGame());
                    alert.showAndWait();
                }
                else{
                    //message for if the user presses start without picking a move
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Watch out!");
                    alert.setContentText("You must select a move first");
                    alert.showAndWait();
                }
        });

        //Quit button styling/action
        Button quitButton = new Button("Quit");
        quitButton.setStyle("-fx-font-size: 15; -fx-background-color: #f47174; ");
        quitButton.setOnAction((ActionEvent event) -> { Platform.exit(); });

        //player1 choices
        //rock imageView
        ImageView rockImageView = new ImageView(rockImage);
        rockImageView.setFitHeight(150);
        rockImageView.setFitWidth(150);
        //rock button styling
        Button rockButton = new Button("Rock");
        rockButton.setStyle("-fx-font-size: 15; -fx-background-color: #ffffbf; ");
        //button action
        rockButton.setOnAction((ActionEvent event) -> {
            loadImageView.setImage(rockImage);
            RockButton pickedRock = new RockButton();
            userInput = pickedRock.returnValue();
        });

        //paper ImageView
        ImageView paperImageView = new ImageView(paperImage);
        paperImageView.setFitHeight(150);
        paperImageView.setFitWidth(150);
        //paper button styling
        Button paperButton = new Button("Paper");
        paperButton.setStyle("-fx-font-size: 15; -fx-background-color: #ffffbf; ");
        //button action
        paperButton.setOnAction((ActionEvent event) -> {
            loadImageView.setImage(paperImage);
            PaperButton pickedPaper = new PaperButton();
            userInput = pickedPaper.returnValue();
        });

        //scissors imageView
        ImageView scissorsImageView = new ImageView(scissorsImage);
        scissorsImageView.setFitHeight(150);
        scissorsImageView.setFitWidth(150);
        //scissors button styling
        Button scissorsButton = new Button("Scissors");
        scissorsButton.setStyle("-fx-font-size: 15; -fx-background-color: #ffffbf; ");
        //button action
        scissorsButton.setOnAction((ActionEvent event) -> {
            loadImageView.setImage(scissorsImage);
            ScissorsButton pickedScissors = new ScissorsButton();
            userInput = pickedScissors.returnValue();
        });

        //gridPane initialization/centering
        GridPane playerInteractionGridPane = new GridPane();
        playerInteractionGridPane.setAlignment(Pos.CENTER);

        GridPane gameStageGridPane = new GridPane();
        gameStageGridPane.setAlignment(Pos.CENTER);

        GridPane buttonGridPane = new GridPane();
        buttonGridPane.setAlignment(Pos.CENTER);

        GridPane gameHeaderGridPane = new GridPane();
        gameHeaderGridPane.setAlignment(Pos.CENTER);

        //additional element alignment
        GridPane.setHalignment(rockButton, HPos.CENTER);
        GridPane.setHalignment(paperButton, HPos.CENTER);
        GridPane.setHalignment(scissorsButton, HPos.CENTER);

        GridPane.setHalignment(player1Header, HPos.CENTER);
        GridPane.setHalignment(player2Header, HPos.CENTER);

        //sizing HGaps and VGaps
        playerInteractionGridPane.setHgap(100);
        playerInteractionGridPane.setVgap(20);

        buttonGridPane.setHgap(50);
        buttonGridPane.setVgap(20);

        gameStageGridPane.setHgap(120);

        //GridPane placement
        gameHeaderGridPane.add(gameHeader, 0, 0);

        gameStageGridPane.add(player1Header, 0, 0);
        gameStageGridPane.add(player2Header, 1, 0);
        gameStageGridPane.add(loadImageView, 0, 1);
        gameStageGridPane.add(loadImageView2, 1, 1);

        buttonGridPane.add(startButton, 0, 1);
        buttonGridPane.add(quitButton, 1, 1);

        playerInteractionGridPane.add(rockImageView, 0, 2);
        playerInteractionGridPane.add(paperImageView, 1, 2);
        playerInteractionGridPane.add(scissorsImageView, 2, 2);

        playerInteractionGridPane.add(rockButton, 0, 3);
        playerInteractionGridPane.add(paperButton, 1, 3);
        playerInteractionGridPane.add(scissorsButton, 2, 3);

        //gameStage VBox
        VBox gameStage = new VBox(gameHeaderGridPane, gameStageGridPane,buttonGridPane, playerInteractionGridPane);

        //getting gameBoard content
        gameBoard.getChildren().addAll(gameStage);

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