/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book.thinkjava;

/**
 *
 * @author Attila Molnar
 */
public class Card { //Exercise 12.1 , Exercise 12.2, Exercise 12.3

    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

    private final int rank;
    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if ((that.rank < 2 && this.rank != that.rank) || this.rank < that.rank) {
            return -1;
        }
        if ((this.rank < 2 && this.rank != that.rank) || this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    public static void printDeck(Card[] cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public static int search(Card[] cards, Card target) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Card[] cards, Card target) {
        int low = 0;
        int high = cards.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comp = cards[mid].compareTo(target);

            if (comp == 0) {
                return mid;
            } else if (comp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }

    public static int[] suitHist(Card[] cards) {
        int[] counts = new int[4];

        for (Card card : cards) {
            counts[card.suit]++;
        }
        return counts;
    }

    public static boolean hasFlush(Card[] cards) {
        int suitTemp = cards[0].suit;
        for (Card card : cards) {
            if (card.suit != suitTemp) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasRoyal(Card[] cards) {
        int[] royal = {1, 13, 12, 11, 10};
        boolean hasFlush = false;
        if (hasFlush(cards)) {
            target:
            for (int i : royal) {
                for (Card card : cards) {
                    if (i == card.rank) {
                        hasFlush = true;
                        continue target;
                    }
                }
            }
            return hasFlush;
        }
        return hasFlush;
    }

}
