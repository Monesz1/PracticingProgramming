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
public class Recurse {

    public static void main(String[] args) {

        testingMethods();
        System.out.println("" + isPalindrome("otsmo"));
    }

    /**
     * Returns the first character of the given String.
     */
    public static char first(String s) {
        return s.charAt(0);
    }

    /**
     * Returns all but the first letter of the given String.
     */
    public static String rest(String s) {
        return s.substring(1);
    }

    /**
     * Returns all but the first and last letter of the String.
     */
    public static String middle(String s) {
        return s.substring(1, s.length() - 1);
    }

    /**
     * Returns the length of the given String.
     */
    public static int length(String s) {
        return s.length();
    }

    public static void printString(String s) {
        for (char c : s.toCharArray()) {
            System.out.println("%c" + c);
        }
    }

    public static void printBackward(String s) {
        char[] letters = s.toCharArray();
        for (int i = letters.length - 1; i > 0; i--) {
            char letter = letters[i];
            System.out.println("%c" + letter);
        }
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] letters = s.toCharArray();
        for (int i = letters.length - 1; i > 0; i--) {
            char letter = letters[i];
            sb.append(letter);
        }
        return sb.toString();
    }

    private static void testingMethods() {
        String word = "apple";
        char first = first(word);
        if (first == 'a') {
            System.out.println("first method passed");
        }
        String rest = rest(word);
        if (rest.equals("pple")) {
            System.out.println("rest method passed");
        }
        String middle = middle(word);
        if (middle.equals("ppl")) {
            System.out.println("middle method passed");
        }
        int length = length(word);
        if (length == 5) {
            System.out.println("length method passed");
        }
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return false;
    }
}
