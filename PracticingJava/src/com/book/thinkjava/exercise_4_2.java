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
public class exercise_4_2 {

    public static void main(String[] args) {
        zippo("rattle", 13);
        System.out.print("1");
    }

    public static void baffle(String blimp) {
        System.out.print("2");
        System.out.println(blimp);
        zippo("ping", -5);
    }

    public static void zippo(String quince, int flag) {
        if (flag < 0) {
            System.out.println(quince + " zoop");
        } else {
            System.out.println("ik");
            baffle(quince);
            System.out.println("boo-wa-ha-ha");
        }
    }

    //What is the value of the parameter blimp when baffle gets invoked? rattle
    /*
    What is the output of this program?
    ik
    2rattle
    ping zoop
    boo-wa-ha-ha
     */
}
