package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {
    private static Scanner scObj = new Scanner(System.in);

    public static void playGame() {
        int playerAmt = 0;
        System.out.println("Starting a new game of snap!");
        System.out.println("How many players? 1-2");
        String input = scObj.nextLine();
        try {
            playerAmt = Integer.parseInt(input);
            while (playerAmt > 2 || playerAmt < 1) {
                System.out.println("Invalid amount of players. 1-2");
                playerAmt = scObj.nextInt();
            }
            generatePlayers(playerAmt);
        } catch (NumberFormatException e) {
            System.err.println("Players should be 1 or 2");
        }
        boolean gameOver = false;
        boolean playAgain = true;
        while (playAgain) {
            String winData = "";
            snapStr = "";
            prepareGame();
            while (!gameOver) {
                for (Player player : players) {
                    if (gameOver) {
                        break;
                    }
                    if (deck.size() == 0) {
                        System.out.println("Deck Empty! Game Over!");
                        for (Player p : players) {
                            winData += String.format("Player %d: %d | ", p.playerNumber, p.victories);
                        }
                        System.out.println(String.format("%nVictories: %s", winData));
                        gameOver = true;
                    } else {
                        System.out.printf("Player %d, press enter to deal", player.playerNumber);
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        dealCard();
                        if (field.size() > 1 && field.get(field.size() - 1).symbol.equals(field.get(field.size() - 2).symbol)) {
                            System.out.printf("Quick Player %d, type SNAP in the next 1 seconds to win!", player.playerNumber);
                            try {
                                getSnap();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            if (snapStr.equalsIgnoreCase("snap")) {
                                System.out.println(String.format("%nSnap! Player %d Wins!", player.playerNumber));
                                player.addVictory();
                            } else {
                                System.out.printf("Player %d missed their chance! Game Over.", player.playerNumber);
                            }
                            for (Player p : players) {
                                winData += String.format("Player %d: %d | ", p.playerNumber, p.victories);
                            }
                            System.out.println(String.format("Game Score: %s", winData));
                            gameOver = true;
                        }
                    }
                }
            }
            System.out.println("Dou you want to play again? Y | N");
            String again = scObj.next();
            while (!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("n")) {
                System.out.println("Invalid answer. Play again? Y | N");
                again = scObj.next();
            }
            if (again.equalsIgnoreCase("y")) {
                gameOver = false;
            } else {
                playAgain = false;
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

    static void getSnap() throws Exception {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(createTimerTask(), 2000, 1000);
        BufferedReader buffScan = new BufferedReader(new InputStreamReader(System.in));
        snapStr = buffScan.readLine();
        timer.cancel();
    }


    public Snap(String name) {
        super(name);
    }
}
