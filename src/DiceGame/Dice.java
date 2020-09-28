package DiceGame;
import java.util.Scanner;

public class Dice {
    private final int MAX = 6;
    private int eyeValue;

    public Dice(int eyes){
        eyeValue = eyes;
    }

    public int Roll(){
        eyeValue = (int)(Math.random() * MAX) + 1;
        return eyeValue;
    }

}
