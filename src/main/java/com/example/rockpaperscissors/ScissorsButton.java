package com.example.rockpaperscissors;

public class ScissorsButton implements ButtonInterface{

    @Override
    //returning that the move is scissors
    public String returnValue() {
        return "S";
    }
}
