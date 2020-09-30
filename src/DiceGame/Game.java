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
    boolean previousTurnRolled12 = false;
    boolean gameInProgress = true;

    public void startGame() {
        while (gameInProgress) { //Keeps game going until gameWon is called
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
                if (previousTurnRolled12) {
                    gameWon();
                }
                break;
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
        checkForWin(); //checks for win BEFORE adding points to the total

        currentPlayer.changePoints(dice1.getEyeValue() + dice2.getEyeValue()); //adds points to players' totals here.

        if (dice1.getEyeValue() == dice2.getEyeValue()) {
            checkRules(); //Runs when both dice are equal and checks for behavior for different pairs.
        }

    }
    public boolean checkForWin() {
        boolean a;
        a = currentPlayer.getPoints() >= 40;
        return a;

    }
    public void gameWon() {
        gameInProgress = false;
        //do stuff when the game is won
    }
}


