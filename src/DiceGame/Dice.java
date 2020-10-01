package DiceGame;
import java.util.Scanner;

public class Dice {
    private final int MAX = 6;
    private int eyeValue;

    public int Roll(){
        for (int i = 0; i < (int)(Math.random() * 7) + 1; i++) {
            System.out.print(textValue((int)(Math.random() * MAX) + 1) + ".");
            try
            {
                Thread.sleep(100);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        eyeValue = (int)(Math.random() * MAX) + 1;
        System.out.print(" --> [" + textForm() + "]\n");
        return eyeValue;
    }

    public int getEyeValue() {
        return eyeValue;
    }
    public String textValue(int value) {
        return switch (value) {
            case 1 -> "\u2680";
            case 2 -> "\u2681";
            case 3 -> "\u2682";
            case 4 -> "\u2683";
            case 5 -> "\u2684";
            default -> "\u2685";
        };
    }
    public String textForm(){
        return textValue(eyeValue);
    }
}
