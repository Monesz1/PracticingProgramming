package com.book.thinkjava;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Attila Molnar
 */
public class exercise_6_2 {

    private static double diff = Double.MAX_VALUE;

    public static void main(String[] args) {
        double num = 9;
        double aprox = squareRoot(num);
    }

    private static double squareRoot(double num) {
        Random random = new Random();
        double x = (double) random.nextInt((int) num);

        while (diff >= 0.0001) {
            double xt = x;
            x = (xt + num / xt) / 2;
            diff = xt - x;
        }
        return x;
    }

}
