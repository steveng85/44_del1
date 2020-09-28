package DiceGame;

import java.util.*;

public class Spil_tester
{

    public static void main ( String[] args )
    {
        Scanner scan = new Scanner( System.in );
        Random rand = new Random();
        int count = 1;
        while ( count<=1000 )
        {
            System.out.println("Du Slog " + (rand.nextInt(6)+1 + rand.nextInt(6)+1) );
            System.out.println(count + " Gang");
            count++;

        }
    }

}




