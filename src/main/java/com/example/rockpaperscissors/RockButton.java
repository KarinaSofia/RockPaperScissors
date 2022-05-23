package com.example.rockpaperscissors;

public class RockButton implements Button{
    @Override
    public char returnValue() {
        return 1;
    }

    @Override
    public String press() {
        String str = "src/main/java/com/example/images/rock_press.png";
        return str;
    }
}
