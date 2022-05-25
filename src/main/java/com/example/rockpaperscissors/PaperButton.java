package com.example.rockpaperscissors;

public class PaperButton implements ButtonInterface{
    @Override
    //returning that the move is paper
    public String returnValue() {
        return "P";
    }
}
