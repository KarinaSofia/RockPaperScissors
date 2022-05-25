package com.example.rockpaperscissors;

public class Evaluation {
    private String player1;
    private computerChoice player2 = new computerChoice();
    private String gameVerdict;

    String player2Choice = player2.computersPick();

    public Evaluation(String uI){
        this.player1 = uI;
    }

    //game verdict
    public String playGame() {

        if (getPlayer1().equals(getPlayer2Choice())) {
            gameVerdict = "Draw";
        }
        else if(getPlayer1().equals("R") && getPlayer2Choice().equals("P")){
            gameVerdict = "Computer Wins";
        }
        else if(getPlayer1().equals("P") && getPlayer2Choice().equals("R")){
            gameVerdict = "You Win";
        }
        else if(getPlayer1().equals("S") && getPlayer2Choice().equals("P")){
            gameVerdict = "You Win";
        }
        else if(getPlayer1().equals("P") && getPlayer2Choice().equals("S")){
            gameVerdict = "Computer Wins";
        }
        else if(getPlayer1().equals("S") && getPlayer2Choice().equals("R")){
            gameVerdict = "Computer Wins";
        }
        else if(getPlayer1().equals("R") && getPlayer2Choice().equals("S")){
            gameVerdict = "You Win";
        }

        return gameVerdict;
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
