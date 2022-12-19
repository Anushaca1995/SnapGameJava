package org.example;


public class Player {
    int playerNumber;
    int victories = 0;

    public void addVictory() {
        victories++;
    }

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }
}
