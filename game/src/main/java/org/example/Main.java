package org.example;

public class Main {
    public static void main(String[] args) {
//        CardGame.generateDeck();
//        System.out.println(CardGame.getDeck());
//        CardGame.dealCard();
//        CardGame.sortDeckInNumberOrder();
//        System.out.println(CardGame.getDeck());
//        CardGame.sortDeckIntoSuits();
//        System.out.println(CardGame.getDeck());
//        CardGame.shuffleDeck();
//        System.out.println(CardGame.getDeck());
        try {
            Snap.playGame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}