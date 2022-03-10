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
public class Time {

    public static void main(String[] args) {
        int hour = 15;
        int minute = 29;
        int second = 34;

        System.out.println("Time I started: " + hour + ":" + minute + ":" + second);

        secsSinceMid(hour, minute, second);
        now();
    }

    private static void secsSinceMid(int hour, int minute, int second) {
        int hSecs = hour * 60 * 60;
        int mSecs = minute * 60;
        int totalSecs = hSecs + mSecs + second;
        System.out.println("Secs pased until now:" + totalSecs);
        secsLeft(totalSecs);

    }

    private static void secsLeft(int totalSecs) {
        int hSecs = 24 * 60 * 60;
        int secsLeft = hSecs - totalSecs;
        System.out.println("Secs left from the day: " + secsLeft);
        percentage(hSecs, totalSecs);
    }

    private static void percentage(int hSecs, int totalSecs) {
        float percentage = ((float) totalSecs / (float) hSecs) * 100;
        System.out.println("Percentage of the day passed: " + percentage + "%");
    }

    private static void now() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add your current time: ");
        int currentHour = scanner.nextInt();
        int currentMin = scanner.nextInt();
        int currentSecs = scanner.nextInt();
        System.out.println("-----CURRENT TIME YOU ADDED ----");
        secsSinceMid(currentHour, currentMin, currentSecs);
    }
}
