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
public class exercise_7_1 {

    public static void main(String[] args) {
        //Method banana was called with a 10 long int array. Each item in the array has the value 0
        banana(new int[10]);
    }

    //This method declares two varibles kiwi and i. Earch time it itarates, declares new value to kiwi varible and increasing the counter variable with one. In the end will return the kiwi varible.
    public static int banana(int[] a) {
        int kiwi = 1;
        int i = 0;
        while (i < a.length) {
            kiwi = kiwi * a[i];
            i++;
        }
        return kiwi;
    }

    //This method itarates over a int array and when value at index i will be equal to the argument value grape, will return the index of the array, otherwise will return the value -1
    public static int grapefruit(int[] a, int grape) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == grape) {
                return i;
            }
        }
        return -1;
    }

    //This method will itarate over the a int array and each time when the value of pear will be equal to the value of the apple will increase the value of the pear with one. After reached the end of the array pear variable will be returned.
    public static int pineapple(int[] a, int apple) {
        int pear = 0;
        for (int pine : a) {
            if (pine == apple) {
                pear++;
            }
        }
        return pear;
    }
}
