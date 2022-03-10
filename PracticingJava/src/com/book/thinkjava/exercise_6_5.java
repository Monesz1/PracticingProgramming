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
public class exercise_6_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.println("Word is doubloon?:" + isDoubloon(word));

    }

    private static boolean isDoubloon(String word) {
        int len = word.length() - 1;
        int[] count = new int[word.length()];
        for (int i = 0; i <= len; i++) {
            char c = word.charAt(i);
            for (int j = i + 1; j <= len; j++) {
                char ch = word.charAt(j);
                if (c == ch) {
                    count[i] = 1;
                    count[j] = 1;
                }
            }
        }
        for (int i : count) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

}
