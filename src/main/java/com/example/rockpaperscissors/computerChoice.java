package com.example.rockpaperscissors;


public class computerChoice {

    //generate random number which translates into a move
    public String computersPick(){

        double number = Math.random();
        String computersChoice;

        if(number <0.333){
            computersChoice = "R";
        }
        else if(number <0.666 && number >0.333){
            computersChoice = "P";
        }
        else{
            computersChoice = "S";
        }

        return computersChoice;
    }
}
