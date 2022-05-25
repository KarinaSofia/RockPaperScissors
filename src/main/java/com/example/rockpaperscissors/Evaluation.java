package com.example.rockpaperscissors;

public class Evaluation {
    private String player1;
    private computerChoice player2 = new computerChoice();
    private String gameVerdict;
    private String player2Choice = player2.computersPick();

    //constructor
    public Evaluation(String uI){
        this.player1 = uI;
    }

    //game verdict (comparing plays and giving back results)
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

    //getting the computer's generated move class
    public String getPlayer2Choice(){
        return player2Choice;
    }

    //getting the player 1' choice class
    public String getPlayer1() {
        return player1;
    }

}
