package com.example.rockpaperscissors;

public class Evaluation {
    private String player1;
    private computerChoice player2 = new computerChoice();
    String player2Choice = player2.computersPick();

    public Evaluation(String uI){
        this.player1 = uI;
    }

    public String playGame(){
        return getPlayer1();
    }

    //getting the computer's generated move
    public String getPlayer2Choice(){
        return player2Choice;
    }

    //getting the player 1' choice

    public String getPlayer1() {
        return player1;
    }

    public void Draw(){

    }

    public void player1Wins(){

    }

    public void player2Wins(){

    }

}
