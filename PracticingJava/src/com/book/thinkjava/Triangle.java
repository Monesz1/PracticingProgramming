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
public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        int a = scanner.nextInt();
        System.out.print("b = ");
        int b = scanner.nextInt();
        System.out.print("c = ");
        int c = scanner.nextInt();
        compute(a, b, c);

    }

    private static void compute(int a, int b, int c) {
        if (a >= 0 && b >= 0 && c >= 0) {
            if ((a > (b + c)) || (b > (a + c)) || (c > (a + b))) {
                System.out.println("You cannot form a triangle");
            } else {
                System.out.println("You can form a triangle");
            }
        } else {
            System.out.println("ERROR: length should be greater than zero");
        }
    }
}
