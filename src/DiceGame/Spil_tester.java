package DiceGame;

import java.util.*;

public class Spil_tester
{

    public static void main ( String[] args )
    {
        Scanner scan = new Scanner( System.in );
        Random rand = new Random();

        for ( int count=1; count<=1000;count++ )
        {
            System.out.println("Du Slog " + (rand.nextInt(6)+1 + rand.nextInt(6)+1) );
            System.out.println(count + " Gang");


        }
    }

}




