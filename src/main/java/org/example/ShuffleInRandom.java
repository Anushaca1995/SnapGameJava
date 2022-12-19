package org.example;

import java.util.Comparator;

public class ShuffleInRandom implements Comparator<Card> {


    @Override
    public int compare(Card o1, Card o2) {
        return (Math.random() >Math.random())? 1 : -1;
    }
}
