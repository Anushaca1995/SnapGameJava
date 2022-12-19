package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
    static public String name = "";
    static ArrayList<Card> deck = new ArrayList<>();
    static ArrayList<Card> field = new ArrayList<>();
    static String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static int[] cardValues = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private final String[] suits = new String[]{"❤", "♠", "♣", "♦"};
    static ArrayList<Player> players = new ArrayList<>();

    public CardGame(String name) {
        this.name = name;
    }

    public static void generateDeck() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < symbols.length; j++) {
                deck.add(new Card(suits[i], 0, symbols[j], cardValues[j]));
            }
        }
    }

}

    public static ArrayList<Card> getDeck() {
        return deck;
    }

    public static void dealCard() {
        field.add(deck.get(0));
        System.out.println("Field card:" + field);
        deck.remove(0);
    }

    public static Card getFieldTopCard() {
        return field.get(field.size() - 1);
    }

    public static void sortDeckInNumberOrder() {
        return Collections.sort(deck, new SortDeckInNumber());
    }

    public static void sortDeckIntoSuits() {
        return Collections.sort(deck, new SortDeckInNumber());
    }

    public static void shuffleDeck() {
        return Collections.sort(deck, new ShuffleInRandom());
    }

    public static void emptyField() {
        field.clear();
    }

    public static void prepareGame() {
        emptyField();
        generateDeck();
        shuffleDeck();
    }

    public static void generatePlayers(int amount) {
        for (int i = 0; i < amount; i++) {
            players.add(new Player(i + 1));
        }
    }


}
