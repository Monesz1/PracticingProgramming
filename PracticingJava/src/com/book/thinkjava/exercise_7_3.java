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
public class exercise_7_3 {

    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 8, 1, 5, 3, 5, 7, 8, 2, 9, 2, 4, 2, 4, 1, 3, 6};
        int max = indexOfMax(nums);
        System.out.println("" + max);
    }

    //Of course it can return the largest number for the array with for each loop
    private static int indexOfMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

}
