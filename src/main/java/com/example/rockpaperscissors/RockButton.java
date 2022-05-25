package com.example.rockpaperscissors;

public class RockButton implements ButtonInterface {
    @Override
    //returning that the move is rock
    public String returnValue() {
        return "R";
    }
}
