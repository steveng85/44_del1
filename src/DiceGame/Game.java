package DiceGame;

import java.util.Scanner;

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
            if (input.nextLine().equals("")) {
                Round();
            }
        }
    }

    public void checkRules() {
        switch (dice1.getEyeValue()) {
            case 1:
                currentPlayer.setPoints(0);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            case 6:
                if (previousTurnRolled12) {
                    gameWon(1);
                }
                break;
        }
    }

    public void Round() {
        currentPlayer = player1;
        Turn();
        System.out.println("Player 1 rolled the dice and now has " + currentPlayer.getPoints() + " points!");
        checkIfLostPoints();

        currentPlayer = player2;
        Turn();
        System.out.println("Player 2 rolled the dice and now has " + currentPlayer.getPoints() + " points!");
        checkIfLostPoints();

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

    public void checkForWin() {
        if (currentPlayer.getPoints() >= 40 && (dice1.getEyeValue() == dice2.getEyeValue()) && dice1.getEyeValue() != 1) {
            gameWon(0);
        }

    }

    public void gameWon(int a) {
        gameInProgress = false;
        switch (a) {
            case 0 -> {
                if (currentPlayer == player1) {
                    System.out.println("Player 1 rolled doubles and won!");
                } else if (currentPlayer == player2) {
                    System.out.println("Player 2 rolled doubles and won!");
                }
                System.exit(0);
            }
            case 1 -> {
                if (currentPlayer == player1) {
                    System.out.println("Player 1 rolled double sixes twice in a row and won.\nHow lucky!");
                } else if (currentPlayer == player2) {
                    System.out.println("Player 1 rolled double sixes twice in a row and won.\nHow lucky!");
                }
                System.exit(0);
            }
        }

    }

    public void checkIfLostPoints() {
        if (currentPlayer.getPoints() == 0) {
            System.out.println("Unlucky double ones!");
        }
    }
}


