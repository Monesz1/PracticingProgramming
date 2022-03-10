package com.book.thinkjava;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Attila Molnar
 */
public class Tile { // Exercise 11.2 

    private char letter;
    private int value;

    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public char getLetter() {
        return letter;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Letter: " + letter + "\n"
                + "Value: " + value;
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

}

class Scrabble {

    public static void main(String[] args) {
        Tile tile1 = new Tile('Z', 10);
        printTile(tile1);
        System.out.println("Using toString method: " + "\n" + tile1.toString());
        Tile tile2 = tile1;
        Tile tile3 = new Tile('Z', 10);
        System.out.println("tile1 equals tile2? " + tile1.equals(tile2));
        System.out.println("tile1 equals tile3? " + tile1.equals(tile3));

    }

    private static void printTile(Tile tile) {
        System.out.println("Letter: " + tile.getLetter() + "\n"
                + "Value: " + tile.getValue());
    }
}
