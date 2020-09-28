package DiceGame;
import java.util.Scanner;

public class Dice {
    private final int MAX = 6;
    private int eyeValue;

    public int Roll(){
        eyeValue = (int)(Math.random() * MAX) + 1;
        return eyeValue;
    }

    public int getEyeValue() {
        return eyeValue;
    }

    public String textForm(){
        String result = "You rolled a " + eyeValue;
        return result;
    }
}
