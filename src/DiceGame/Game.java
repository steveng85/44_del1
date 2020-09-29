package DiceGame;

import java.util.Scanner;

import DiceGame.Dice;

public class Game {
    Scanner input = new Scanner(System.in);
    Dice dice1 = new Dice();
    Dice dice2 = new Dice();
    Player player1 = new Player();
    Player player2 = new Player();
    Player currentPlayer;

    public void startGame() {
        while (true) { //spillet
            Round();
        }
    }

    public void checkRules(){
        switch (dice1.getEyeValue()){
            case 1 :
                currentPlayer.setPoints(0);
                break;
            case 2 :
            case 3 :
            case 4 :
            case 5 :
                break;
            case 6 :
                currentPlayer.changePoints(12);
                dice1.Roll();
                dice2.Roll();

        }
    }

    public void Round() {
        currentPlayer = player1;
        Turn();
        currentPlayer = player2;
        Turn();
        //check for possible winner?
    }

    public void Turn() {
        dice1.Roll();
        dice2.Roll();
        currentPlayer.changePoints(dice1.getEyeValue() + dice2.getEyeValue());
        //method check if won (check for double ones)
        if (dice1.getEyeValue() == dice2.getEyeValue()) {
            if (dice1.getEyeValue() == 1) {
                //set points to 0
            } else if (dice1.getEyeValue() == 6) {
                //check if player points > 40
                currentPlayer.changePoints(12);
                dice1.Roll();
                dice2.Roll();
                if (dice1.getEyeValue() == dice2.getEyeValue() && dice1.getEyeValue() == 6) {
                    //win game :)
                } else {
                } //find a way to run the Turn again without re-rolling dice.
            }
            else {
                Turn();
            }

        }
    }
}


