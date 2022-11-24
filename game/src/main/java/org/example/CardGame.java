package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
    static public String name = "";
    static ArrayList<Card> deck = new ArrayList<>();
    static ArrayList<Card> field = new ArrayList<>();
    static String[] symbols = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    static int[] cardValues = {14,2,3,4,5,6,7,8,9,10,11,12,13};

    public CardGame(String name) {
        this.name = name;
    }

    public static void generateDeck() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<13; j++) {
                switch (i) {
                    case 0:
                        deck.add(new Card("❤", 0, symbols[j], cardValues[j]));
                        break;
                    case 1:
                        deck.add(new Card("♠", 1, symbols[j], cardValues[j]));
                        break;
                    case 2:
                        deck.add(new Card("♣", 2, symbols[j], cardValues[j]));
                        break;
                    case 3:
                        deck.add(new Card("♦", 3, symbols[j], cardValues[j]));
                        break;
                }
            }
        }
    }

    public static ArrayList<Card> getDeck() {
        return deck;
    }

    public static void dealCard() {
        field.add(deck.get(0));
        System.out.println("Field card:"+field);
        deck.remove(0);
    }


    public static void sortDeckInNumberOrder() {
        Collections.sort(deck, new SortDeckInNumber());
    }
    public static void sortDeckIntoSuits() {
        Collections.sort(deck, new SortDeckInNumber());
    }

    public static void shuffleDeck() {
        Collections.sort(deck, new ShuffleInRandom());
    }




}
