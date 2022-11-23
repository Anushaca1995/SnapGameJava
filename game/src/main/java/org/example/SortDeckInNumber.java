package org.example;

import java.util.Comparator;

public class SortDeckInNumber implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return card1.cardValue == card2.cardValue ? (card1.suitValue > card2.suitValue ? 1 : -1) : (card1.cardValue > card2.cardValue ? 1 : -1);
    }
}
