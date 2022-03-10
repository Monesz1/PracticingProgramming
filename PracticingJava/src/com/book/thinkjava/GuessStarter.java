package com.book.thinkjava;


import java.util.Random;
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
public class GuessStarter {

    static int chance = 1;

    public static void main(String[] args) {
        // pick a random number
        pickNum();
    }

    private static void pickNum() {
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("I'm thinking of a number between 1 and 100\n"
                + "(including both). Can you guess what it is?");
        int guessedNum = promptGuess("Type a number:", scanner);
        System.out.println("Your guess is:" + guessedNum);
        System.out.println("The number I was thinking of is:" + num);
        if (guessedNum > num) {
            System.out.println("Guess is too high. Try one more time.");
            if (chance < 3) {
                chance++;
                pickNum();
            };
            int offBy = guessedNum - num;
            System.out.println("You were off by:" + offBy);
        } else if (guessedNum == num) {
            System.out.println("Congratulations! You guessed the number!");
        } else {
            System.out.println("Guess is too low. Try one more time");
            if (chance < 3) {
                chance++;
                pickNum();
            };
            int offBy = num - guessedNum;
            System.out.println("You were off by:" + offBy);
        }

    }

    private static int promptGuess(String text, Scanner scanner) {
        System.out.print(text);
        return scanner.nextInt();
    }
}
