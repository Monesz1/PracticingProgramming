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
public class SecsToHour {

    public static void main(String[] args) {
        int secs = promtInput();
        calculate(secs);
    }

    private static int promtInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void calculate(int secs) {
        //Get the total hours
        int sec = secs % 60;
        int hour = secs / 60;
        int min = hour % 60;
        hour = hour / 60;
        System.out.println(secs + " seconds = " + hour + " hours, " + min + " minutes, and " + sec + " seconds");
    }
}
