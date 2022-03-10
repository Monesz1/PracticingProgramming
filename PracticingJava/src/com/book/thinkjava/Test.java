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
public class Test {

    public static void main(String[] args) {
        String t1 = "add" + 'c'; //string concatenation
//      true + false; //invalid types to add them together
//      true + 'c'; //invalid types to add them together
//      true + 3; //invalid types to add them together
//      true + 3.0; //invalid types to add them together
        String t2 = true + " yes"; //operation is performed
        char c = 'a' + 'b'; //operation is performed
//        char c = 'a' + 2; //invalid types to add them together
//        char c = 'a' + 2.0; //invalid types to add them together
        String t3 = 'c' + "ec"; //operation is performed
//        int i = 3 + 3.0; // incompatible data types and there can be a lossy conversion
        String t4 = 3 + "three"; //operation is performed
        double d = 2.3 + 2.4;//operation is performed
        String t5 = 3.0 + " double";//operation is performed
        //primitive char type data can be user to add together or increment them
        //but it cannot be performed adding primitive int to it

        //when you add empty string to other data types, the compiler will perform srtring concatenation
    }

}
