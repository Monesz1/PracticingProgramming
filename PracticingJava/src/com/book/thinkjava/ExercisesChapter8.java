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
public class ExercisesChapter8 {

    public static void main(String[] args) {

//        bottles(99);
//        oddSum(5);
//        System.out.println(prod(1, 4));
//        System.out.println("Ackermann: " + ack(3, 5));
//        System.out.println("" + power(2.0, 4));
        int[] nums = {2, 3, 4, 5, 6, 11, 8, 9};
//        System.out.println("" + maxInRange(nums, 0, nums.length - 1));

    }

    private static void bottles(int counter) {
        System.out.println(counter + " bottles of beer on the wall,");
        System.out.println(counter + " bottles of beer,");
        System.out.println("ya’ take one down, ya’ pass it around,");
        if (counter == 1) {
            System.out.println("No bottles of beer on the wall,");
            System.out.println("no bottles of beer,");
            System.out.println("ya’ can’t take one down, ya’ can’t pass it around,");
            System.out.println("’cause there are no more bottles of beer on the wall!");
        } else {
            bottles(--counter);
        }
    }
    private static int oddSum;

    private static void oddSum(int num) {
        if (num <= 0) {
            System.out.println("" + oddSum);
            System.out.println("Number should be positive and bigger than zero");
            return;
        }
        if (num % 2 != 0) {
            oddSum += num;
        }
        oddSum(--num);
    }

//    prod(1, 4) method called
//    prod(1, 3) method called
//    prod(1, 2) method called
//    prod(1, 1) method called
//    recurse = 1
//    result = 2 * 1
//    recurse = 2
//    result = 3 * 2
//    recurse = 6
//    result = 4 * 6
//    end result is 24
//    prod method calls himself each time if the condition is not met
    public static int prod(int m, int n) {
        if (m == n) {
            return n;
        } else {
//            int recurse = prod(m, n - 1);
//            int result = n * recurse;
//            return result;
            return n * prod(m, n - 1);
        }
    }

    private static int ack(int m, int n) {
        if (m == 0) {
            return n += 1;
        } else if (m > 0 && n == 0) {
            return ack(m - 1, 1);
        } else if (m > 0 && n > 0) {
            return ack(m - 1, ack(m, n - 1));
        } else {
            return 0;
        }
    }

    private static int power(double x, int n) {
        if (n > 1) {
            return power(x * x, n - 1);
        } else if (n == 0) {
            return 1;
        }
        return (int) x;

    }

//    private static int maxInRange(int[] nums, int lowIndex, int highIndex) {
//        if (lowIndex < highIndex && nums[lowIndex++] > nums[lowIndex]) {
//            return maxInRange(nums, lowIndex++, highIndex);
//        } else if (lowIndex == highIndex) {
//            return nums[lowIndex];
//        } else {
//            return maxInRange(nums, lowIndex, highIndex);
//        }
//    }
}
