/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book.thinkjava;

import java.util.Random;

/**
 *
 * @author Attila Molnar
 */
public class Deck {

    private Card[] cards;

    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    public Deck(int n) {
        this.cards = new Card[n];
    }

    public Card[] getCards() {
        return cards;
    }

    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int randomNum = randomInt(i, cards.length);
            swapCards(i, randomNum);
        }
    }

    private static int randomInt(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }

    private void swapCards(int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

}
