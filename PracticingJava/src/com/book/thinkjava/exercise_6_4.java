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
public class exercise_6_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type word: ");
        String word = scanner.nextLine();
        System.out.println("The word is is abecedarian?" + isAbecedarian(word));
    }

    private static boolean isAbecedarian(String word) {
        int counter = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (word.charAt(counter) == c) {
                counter++;
                if (counter + 1 == word.length()) {
                    return true;
                }
            }
        }
        return false;
    }

}
