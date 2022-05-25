package com.example.rockpaperscissors;

public class Evaluation {
    private String player1;
    private computerChoice player2 = new computerChoice();
    private String gameVerdict;
    private String player2Choice = player2.computersPick();

    public Evaluation(String uI){
        this.player1 = uI;
    }

    //game verdict
    public String playGame() {

        if (getPlayer1().equals(getPlayer2Choice())) {
            gameVerdict = "Draw";
        }
        else if(getPlayer1().equals("R") && getPlayer2Choice().equals("P")){
            gameVerdict = "Challenger Wins";
        }
        else if(getPlayer1().equals("P") && getPlayer2Choice().equals("R")){
            gameVerdict = "Player 1 Wins";
        }
        else if(getPlayer1().equals("S") && getPlayer2Choice().equals("P")){
            gameVerdict = "Player 1 Wins";
        }
        else if(getPlayer1().equals("P") && getPlayer2Choice().equals("S")){
            gameVerdict = "Challenger Wins";
        }
        else if(getPlayer1().equals("S") && getPlayer2Choice().equals("R")){
            gameVerdict = "Challenger Wins";
        }
        else if(getPlayer1().equals("R") && getPlayer2Choice().equals("S")){
            gameVerdict = "Player 1 Wins";
        }

        return gameVerdict;
    }

    //game counter
    public int counter(){
        int counter = 0;
        counter++;
        return counter;
    }

    //getting the computer's generated move
    public String getPlayer2Choice(){
        return player2Choice;
    }

    //getting the player 1' choice
    public String getPlayer1() {
        return player1;
    }

}
