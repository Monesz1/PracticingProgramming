/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocaexam_practice;

import java.util.Scanner;

/**
 *
 * @author Attila Molnar
 */
public class StartAgainNQuees {

    private static long count;

    public static void main(String[] args) {

        StartAgainNQuees start = new StartAgainNQuees();
        System.out.println("Enter Number of Queens");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int board[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        start.oneMoreTime(board, 0, 0, 0, 0);
        System.out.println("All solutions: " + count);
    }

    public void oneMoreTime(int[][] board, int row, int s, int leftDiag,
            int rightDiag) {

        int rowWithOnes = (1 << board.length) - 1;

        if (s == rowWithOnes) {
            count++;
            System.out.println("Solution: " + count);
            printBoard(board);
            System.out.println();
        }

        int safe = rowWithOnes & (~(s
                | leftDiag | rightDiag));
        while (safe > 0) {

            int position = safe & (-safe);
            int col = (int) (Math.log(position) / Math.log(2));

            board[row][col] = 1;

            oneMoreTime(board, row + 1, s | position, (leftDiag | position) << 1, (rightDiag | position) >> 1);

            safe = safe & (safe - 1);

            board[row][col] = 0;
        }
    }

    public void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
