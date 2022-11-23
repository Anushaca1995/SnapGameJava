package com.nology.snapgame;

import java.util.ArrayList;

public class CardGame {
    static public String name = "";
    static ArrayList<Card> deck = new ArrayList<>();
    static ArrayList<Card> field = new ArrayList<>();
    static String[] symbols = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    static int[] cardValues = {14,2,3,4,5,6,7,8,9,10,11,12,13};

    public CardGame(String name) {
        this.name = name;
    }

    public static ArrayList<Card> getDeck() {
        return deck;
    }


}
