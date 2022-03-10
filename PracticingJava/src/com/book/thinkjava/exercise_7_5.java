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
public class exercise_7_5 { // and exercise_7_6

    public static void main(String[] args) {
        int num = 2;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        boolean isFact = areFactors(num, nums);
        System.out.println("" + isFact);
        boolean isPrimeFact = arePrimeFactors(num, nums);
        System.out.println("" + isPrimeFact);
        String word = "dskfnsdfndsdf";
        String histogram = letterHist(word);
        System.out.println(histogram);
        String w1 = "stop";
        String w2 = "pots";
        boolean isAnagramm = checkAnagram(w1, w2);
        System.out.println("Anagram: " + isAnagramm);

    }

    private static boolean areFactors(int num, int[] nums) {
        for (int n : nums) {
            if (num % n != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean arePrimeFactors(int num, int[] nums) {

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 2 && nums[j] % 2 == 0) {
                return false;
            } else if (nums[j] != 3 && nums[j] % 3 == 0) {
                return false;
            } else if (nums[j] != 5 && nums[j] % 5 == 0) {
                return false;
            } else if (nums[j] != 7 && nums[j] % 7 == 0) {
                return false;
            }
        }
        for (int o : nums) {
            if (o == num) {
                return true;
            }
        }
        return true;
    }

    private static String letterHist(String word) {
        char[] letters = word.toCharArray();
        char[] alpha = new char[26];
        int[] counter = new int[26];
        for (char c = 'a'; c <= 'z'; c++) {
            alpha[c - 'a'] = c;
        }

        for (int i = 0; i < letters.length - 1; i++) {
            char letter = letters[i];
            for (int j = 0; j < alpha.length - 1; j++) {
                if (alpha[j] == letter) {
                    counter[j]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alpha.length - 1; i++) {
            sb.append(alpha[i]);
            sb.append(counter[i]);
        }

        return sb.toString();
    }

    private static boolean checkAnagram(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        char[] letters = w2.toCharArray();
        for (char c : w1.toCharArray()) {
            for (int i = 0; i < letters.length; i++) {
                char letter = letters[i];
                if (c == letter) {
                    letters[i] = ' ';
                }
            }
        }
        for (char letter : letters) {
            if (letter != ' ') {
                return false;
            }
        }
        return true;
    }

}
