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
public class Date { //Exercise 11.3

    private int year;
    private int month;
    private int day;

    public Date() {
        //default bday
        this.year = 1993;
        this.month = 1;
        this.day = 28;

    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static void main(String[] args) {

        String day = "Thursday";
        String month = "February";
        int date = 24;
        int year = 2022;

        simpleDisplay(day, date, month, year);
        display(day, date, month, year);
        printAmerican(day, date, month, year);

        Date birthday = new Date();
        System.out.println("My birthday is: "
                + birthday.getYear()
                + "."
                + birthday.getMonth()
                + "."
                + birthday.getDay());
        Date annaBirthday = new Date(1999, 6, 12);
        System.out.println("Anna's birthday is: "
                + annaBirthday.getYear()
                + "."
                + annaBirthday.getMonth()
                + "."
                + annaBirthday.getDay());

    }

    private static void simpleDisplay(String day, int date, String month, int year) {
        System.out.println("Day: " + day + " Date: " + date + " Month: " + month + " Year: " + year);
    }

    private static void display(String day, int date, String month, int year) {
        System.out.println("American Format: " + day + ", " + month + " " + date + ", " + year);
        System.out.println("European Format: " + day + " " + date + " " + month + " " + year);
    }

    private static void printAmerican(String day, int date, String month, int year) {
        System.out.println("American Format: " + day + ", " + month + " " + date + ", " + year);

    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

}
