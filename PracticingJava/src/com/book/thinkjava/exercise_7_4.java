package com.book.thinkjava;


import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Attila Molnar
 */
public class exercise_7_4 {

    public static void main(String[] args) {

        System.out.println("" + Arrays.toString(sieve(100)));
    }

    private static boolean[] sieve(int num) {
        int[] nums = new int[num];
        for (int i = 0; i <= nums.length - 1; i++) {
            nums[i] = i + 1;
        }

        boolean[] arePrimes = new boolean[num];

        ArrayList<Integer> primes = new ArrayList();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 2 && nums[j] % 2 == 0) {
                nums[j] = 0;
                arePrimes[j] = false;
            } else if (nums[j] != 3 && nums[j] % 3 == 0) {
                nums[j] = 0;
                arePrimes[j] = false;
            } else if (nums[j] != 5 && nums[j] % 5 == 0) {
                nums[j] = 0;
                arePrimes[j] = false;
            } else if (nums[j] != 7 && nums[j] % 7 == 0) {
                nums[j] = 0;
                arePrimes[j] = false;
            } else {
                if (nums[j] != 1) {
                    primes.add(nums[j]);
                    arePrimes[j] = true;
                }
            }
        }
        System.out.println("" + primes.toString());
        return arePrimes;
    }

}
