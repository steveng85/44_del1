package DiceGame;
import java.util.Scanner;

public class Dice {
    private final int MAX = 6;
    private int eyevalue;

    public Dice( int inputvalue){
        eyevalue = inputvalue;
    }

    public int Roll(){
        eyevalue = (int)(Math.random() * MAX) + 1;
        return eyevalue;
    }

}
