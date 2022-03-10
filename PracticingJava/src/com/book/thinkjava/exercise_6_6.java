package com.book.thinkjava;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Attila Molnar
 */
public class exercise_6_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the tiles what you get: ");
        String tiles = scanner.next();
        System.out.print("Type the word you are looking for: ");
        String word = scanner.next();
        boolean isFound = canSpell(tiles, word);
        System.out.println("Word is found: " + isFound);
    }

    private static boolean canSpell(String tiles, String word) {
        char[] tileschs = tiles.toLowerCase().toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < tileschs.length; j++) {
                char ch = tileschs[j];
                if (c == ch) {
                    tileschs[j] = ' ';
                    break;
                } else if (j == tileschs.length - 1 && c != ch) {
                    return false;
                }
            }
        }
        return true;
    }

}
