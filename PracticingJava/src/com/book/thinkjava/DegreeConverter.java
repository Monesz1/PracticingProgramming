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
public class DegreeConverter {

    public static void main(String[] args) {
        double celsius = promtInput();
        calculate(celsius);

    }

    private static double promtInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a temperature in Celsius:");
        return (double) scanner.nextInt();
    }

    private static void calculate(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32.0;
        System.out.printf(celsius + " = %.1f", fahrenheit);
    }

}
