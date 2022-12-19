package org.example;


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame{
    static Scanner scan = new Scanner(System.in);
    public static void playGame() throws Exception {
        System.out.println("Starting a new game of snap!");
        System.out.println("Would you like to play hard mode? Y | N");
        String hardMode = scan.next();
        while (!hardMode.equalsIgnoreCase("y") && !hardMode.equalsIgnoreCase("n")) {
            System.out.println("Invalid answer. Hard mode? Y | N");
            hardMode = scan.next();
        }
        System.out.println("How many players? 1-4");
        int playerAmt = scan.nextInt();
        while (playerAmt > 3 || playerAmt < 1) {
            System.out.println("Invalid amount of players");
            playerAmt = scan.nextInt();
        }
        generatePlayers(playerAmt);
        boolean gameOver = false;
        boolean keepPlaying = true;
        while (keepPlaying) {
            String victoryList = "";
            snapStr = "";
            prepareGame();
            while (!gameOver) {
                for (Player player : players) {
                    if (gameOver) { // Catches some weird occurrences where the game keeps playing
                        break;
                    }
                    if (deck.size() == 0) {
                        System.out.println("Deck Empty! Game Over!");
                        for (Player p: players) {
                            victoryList += String.format("Player %d: %d | ", p.playerNumber, p.victories);
                        }
                        System.out.printf("%nVictories: %s", victoryList);
                        gameOver = true;
                    } else {
                        System.out.printf("Player %d, press enter to deal", player.playerNumber);
                        System.in.read();
                        dealCard();
                        System.out.println(getFieldTopCard());
                        if (field.size() > 1 && field.get(field.size() - 1).cardValue == field.get(field.size() - 2).cardValue) {
                            if (hardMode.equalsIgnoreCase("y")) {


                                System.out.printf("Quick Player %d, type SNAP in the next 5 seconds to win!%n", player.playerNumber);
                                getInput();
                                if (snapStr.equalsIgnoreCase("snap")) {
                                    System.out.printf("%nSnap! Player %d Wins!", player.playerNumber);
                                    player.addVictory();
                                } else {
                                    System.out.printf("Player %d missed their chance! Game Over.", player.playerNumber);
                                }
                            } else {
                                System.out.printf("%nSnap! Player %d Wins!", player.playerNumber);
                                player.addVictory();
                            }
                            for (Player p: players) {
                                victoryList += String.format("Player %d: %d | ", p.playerNumber, p.victories);
                            }
                            System.out.printf("\nVictories: %s", victoryList);
                            gameOver = true;
                        }
                    }
                }
            }
            System.out.println("\nPlay again? Play again? Y | N");
            String again = scan.next();
            while (!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("n")) {
                System.out.println("Invalid answer. Play again? Y | N");
                again = scan.next();
            }
            if (again.equalsIgnoreCase("y")) {
                gameOver = false;
            } else {
                keepPlaying = false;
            }
        }
    }

    static String snapStr = "";
    static TimerTask createTimerTask() {
        return new TimerTask() {
            public void run() {
                if (!snapStr.equalsIgnoreCase("snap")) {
                    System.out.println("So close! Enter to continue!");
                    cancel();
                }
            }
        };
    }
    static void getInput() throws Exception {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(createTimerTask(), 5000, 1000);
        BufferedReader buffScan = new BufferedReader(new InputStreamReader(System.in));
        snapStr = buffScan.readLine();
        timer.cancel();
    }

    public Snap(String name) {
        super(name);
    }
}