package DiceGame;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @org.junit.jupiter.api.Test
/*En linje der fortæller IntelliJ at det er en test, som gør IntelliJ kan behandle koden som en test.  */
    void roll() {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        int[] sumOfDiceCount = new int[11];
        int sameEyesOnDice = 0;

        int i = 0;
        do {

            //Rolls two dices and get the sum
            int dice1Roll = dice1.RollTest();
            int dice2Roll = dice2.RollTest();

            int sum = dice1Roll + dice2Roll;
            sumOfDiceCount[sum-2] += 1;
            // System.out.print(sum + " ");    //PT1


            //Counts how many times both dice are the same ones
            if (dice1Roll == dice2Roll) {
                sameEyesOnDice = sameEyesOnDice + 1;
            }


            i = i + 1;     // Can also be written as: i = i + 1  =>  i += 1    =>  i++   => ++i
        } while (i < 1000);

        // System.out.println();     //PT2
        System.out.println("Number of eyes from 2 to 12 starting lowest to highest:\t\t\t" + Arrays.toString(sumOfDiceCount));
        System.out.println("Number of dice rolls with the same number of eyes on each die:\t" + sameEyesOnDice);

        // Comparing probabilities

        double[] actualProbabilities = new double[11];
        int j = 0;
        while(j < sumOfDiceCount.length) {
            actualProbabilities[j] = (double) sumOfDiceCount[j]/1000*100;
            j = j + 1;
        }
        System.out.println("\n");
        System.out.println("Expected probabilities for number of eyes:\t[2.78, 5.56, 8.33, 11.11, 13.89, 16.67, 13.89, 11.11, 8.33, 5.56, 2.78]" );
        System.out.println("Actual probabilities for number of eyes:\t" + Arrays.toString(actualProbabilities));

        System.out.println();
        System.out.println("Expected probability for same number of eyes on each die:\t" + 16.667);
        System.out.println("Actual probability for same number of eyes on each die:\t\t" + (double) sameEyesOnDice/1000*100);

    }
}