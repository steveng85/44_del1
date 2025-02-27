package DiceGame;

import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    Scanner PlayerName = new Scanner(System.in);

    Dice dice1 = new Dice();
    Dice dice2 = new Dice();
    Player player1 = new Player();
    Player player2 = new Player();
    Player currentPlayer;
    boolean previousTurnRolled12 = false;
    boolean gameInProgress = true;

    public void startGame() {
        // Welcome the players
        printWelcomeMessage();
        //Player1 gives a name
        System.out.println("Input a name for Player1");
        String name1 = input.nextLine();
        player1.setName(name1);
        //player2 gives a name
        System.out.println("Input a name for Player2");
        String name2 = input.nextLine();
        player2.setName(name2);
        //Tells Who is who
        System.out.println("Player1 is " + player1.getName());
        System.out.println("Player2 is " + player2.getName());
        //Telling the players how to start the game
        System.out.println("Press enter to start and continue the game");


        while (gameInProgress) { //Keeps game going until gameWon is called
            Round();
        }
    }
    public void printWelcomeMessage() {
        System.out.println("Welcome to DiceGame!\n\n" +
                "The players each roll a set of dice, where the value of the roll is converted into points." +
                "\n\nYou win the game if you roll double when you have 40 points.\n\nIf you roll double 1s, your " +
                "points will be reset.\n\nRolling a double gives an extra turn.\n\nFor the 40 point + scenario, " +
                "where you hit double 1s, you do not win. Since the rule of waived points applies here instead.\n\n" +
                "Press enter to start a new game");
        input.nextLine();
    }
    public void checkRules() {
        if (dice1.getEyeValue() != dice2.getEyeValue()) return;

        switch (dice1.getEyeValue()) {
            case 1 -> {
                currentPlayer.setPoints(0);
                System.out.println("Unlucky double ones! Roll again!");
                Turn();
            }
            case 2, 3, 4, 5 -> {
                System.out.println(currentPlayer.getName() + " rolled doubles and gets to go again!");
                Turn();
            }
            case 6 -> {
                if (currentPlayer.getLastRoll() == 12) {
                    gameWon(1);
                }
                Turn();
            }
        }
    }

    public void Round() {
        currentPlayer = player1;
        System.out.println(currentPlayer.getName() + " press enter to roll");
        input.nextLine();
        Turn();
        System.out.println(currentPlayer.getName() + " rolled the dice and now has " + currentPlayer.getPoints() + " points!\n");

        currentPlayer = player2;
        System.out.println(currentPlayer.getName() + " press enter to roll");
        input.nextLine();
        Turn();
        System.out.println(currentPlayer.getName() + " rolled the dice and now has " + currentPlayer.getPoints() + " points!\n");
    }

    public void Turn() {
        dice1.Roll();
        dice2.Roll();
        System.out.println("You rolled a " + dice1.getEyeValue() + " and " + dice2.getEyeValue());
        checkForWin(); //checks for win BEFORE adding points to the total

        currentPlayer.changePoints(dice1.getEyeValue() + dice2.getEyeValue()); //adds points to players' totals here.
        currentPlayer.setRoll(dice1.getEyeValue() + dice2.getEyeValue()); //save the roll.

        checkRules();
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
                    System.out.println(player1.getName() + " rolled doubles and won!");
                } else if (currentPlayer == player2) {
                    System.out.println(player2.getName() + " rolled doubles and won!");
                }
                System.exit(0);
            }
            case 1 -> {
                if (currentPlayer == player1) {
                    System.out.println(player1.getName() + " rolled double sixes twice in a row and won.\nHow lucky!");
                } else if (currentPlayer == player2) {
                    System.out.println(player2.getName() + " rolled double sixes twice in a row and won.\nHow lucky!");
                }
                System.exit(0);
            }
        }

    }

}


