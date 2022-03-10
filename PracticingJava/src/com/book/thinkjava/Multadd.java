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
public class Multadd {

    public static void main(String[] args) {
        multadd(1.0, 2.0, 3.0);
    }

    private static double multadd(double num1, double num2, double num3) {
        calculateSin();
        calculateLog();
        calculateExp(num1);
        return num1 * num2 + num3;
    }

    ;

    private static void calculateSin() {
        double result = Math.sin(Math.PI / 4) + (Math.cos(Math.PI / 4) / 2);
        System.out.println("" + result);
    }

    private static void calculateLog() {
        double result = Math.log(10.0) + Math.log(20.0);
        System.out.println("" + result);
    }

    private static void calculateExp(double num1) {

        double result = (num1 * Math.exp(-num1)) + (Math.sqrt(1 - Math.exp(-num1)));
        System.out.println("" + result);
    }

    private void expSum(double num) {
        multadd(num, 0.0, 0.0);
    }

}
