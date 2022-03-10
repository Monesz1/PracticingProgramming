package com.book.thinkjava;


import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Attila Molnar
 */
public class Big { // excercise 9.2, excercise 9.3, excercise 9.6

    public static void main(String[] args) {

        factorial(20);
        int count = checkString("dsfsd");
        System.out.println("" + count);
    }

    private static BigInteger factorial(int i) {
        BigInteger num = BigInteger.ONE;
        for (long j = 1; j < i; j++) {
            num = num.multiply(BigInteger.valueOf(j));
            System.out.println(num);

        }
        return num;
    }

    public static BigInteger pow(int x, int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }
// find x to the n/2 recursively
        BigInteger t = pow(x, n / 2);
// if n is even, the result is t squared
// if n is odd, the result is t squared times x
        if (n % 2 == 0) {
            return t.multiply(t);
        } else {
            return t.multiply(t).multiply(BigInteger.valueOf((long) x));
        }
    }

    private static int checkString(String str) {
        String s = "((3 + 7) * 2)";
        int count = 0;
        s = str;
        char leftPar = '(';
        char rightPar = ')';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == leftPar) {
                count++;
            } else if (c == rightPar) {
                count--;
            }
        }
        System.out.println(count);
        return count;
    }

}
