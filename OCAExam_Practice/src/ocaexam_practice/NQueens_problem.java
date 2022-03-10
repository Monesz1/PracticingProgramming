/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocaexam_practice;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Attila Molnar
 */
class QueenPosition {

    int row;
    int col;

    public QueenPosition(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }
}

public class NQueens_problem {

    private static int counter;
    private static long count;
    public static PrintWriter out = new PrintWriter(System.out);
    public static QueenPosition[] p;
    private StringBuilder rows = new StringBuilder();
    private int tableSize;

    public static void main(String[] args) {

        NQueens_problem q = new NQueens_problem();
        System.out.println("Enter Number of Queens");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        //This method is printing the solutions on the console
//        System.out.println(q.countAllSolutions(n));
        //This method is base on bitwise logic
//        System.out.print("All solutions: " + q.tricky(n));
//        System.out.println();
        int board[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        q.oneMoreTime(board, 0, 0, 0, 0);
        System.out.println("All solutions: " + count);
    }

    private int countAllSolutions(int n) {

        p = new QueenPosition[n];
        int row = 0;

        while (getSolution(n, 0)) {
            int[][] result = new int[n][n];

            Arrays.stream(p).forEach(po -> result[po.row][po.col] = 1);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(result[i][j] + " ");
                }
                out.println();
            }

            out.println();

//            count++;
//            getSolution(n, row + 1);
        }
        return counter;

    }

    public static boolean getSolution(int n, int row) {
//        if (n == 2 || n == 3) {
//            return false;
//        }

        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            boolean isSafe = true;
            p[row] = new QueenPosition(row, col);

            for (int placedQueen = 0; placedQueen < row; placedQueen++) {
                if (p[placedQueen].col == col || p[placedQueen].row - p[placedQueen].col == row - col
                        || p[placedQueen].row + p[placedQueen].col == row + col) {
                    isSafe = false;
                }
            }

            if (isSafe) {
                if (getSolution(n, row + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private long tricky(int n) {

        //Keeps track of the # of valid solutions
        long[] count = new long[1];

        //Helps to identify valid solutions and stores a bit sequence with 1.  For example, when N=4, done will equal 1111.
        long rowFilledWithOnes = (1 << n) - 1;

        //call the innerRecurse function and pass in 3 all-zero bit sequence,
        //"upperLimit" variable simply allows me to not worry about any bits beyond the n-th value,
        //"count" array allows me to store the count number as the sirst element of the array
        test(0, 0, 0, rowFilledWithOnes, count);

        return count[0];
    }

    private void test(long row, long leftDiagonal, long rightDiagonal, long rowFilledWithOnes, long[] count) {

        if (row < rowFilledWithOnes) {

            //Gets a bit sequence with "1"s
            //whereever there is an open "slot"
            //"position" variable represents the columns in the current row that are not "under attack" from any other queens
            long position = (rowFilledWithOnes & (~(row | leftDiagonal | rightDiagonal)));

            while (position > 0) {

                // stores the first non-zero bit in variable "s". (~position) + 1) is changing the positive variable to negative
                long s = (position & ((~position) + 1));

                //marks that position in the current row as being "taken" by flipping that column in "position" to zero. This way, when the while loop continues, we'll know not to try that location again.
                position -= s;

                //move to the next row by add the "s" variable to he "row" variable;
                //add together the "leftDiagonal" and "s" bits, then move all the bits to the left by one
                //add together the "rightDiagonal" and "s" bits, then move all the bits to the right by one
                test(row + s, ((leftDiagonal + s) << 1), ((rightDiagonal + s) >> 1), rowFilledWithOnes, count);
            }
        } else {
            //stores the number of the solution
            count[0]++;
        }

    }

    public void oneMoreTime(int[][] board, int row, int rowmask, int ldmask,
            int rdmask) {

        int all_rows_filled = (1 << board.length) - 1;

        if (rowmask == all_rows_filled) {
            count++;
            System.out.println("Solution: " + count);
            printBoard(board);
            System.out.println();
        }

        int safe = all_rows_filled & (~(rowmask
                | ldmask | rdmask));
        while (safe > 0) {

            int p = safe & (-safe);
            int col = (int) (Math.log(p) / Math.log(2));

            board[row][col] = 1;

            oneMoreTime(board, row + 1, rowmask | p, (ldmask | p) << 1, (rdmask | p) >> 1);

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

    //All this left is just for exercising and finding solutions
//    private Set<Integer> occupiedColumns = new HashSet<Integer>();
//    private Set<Integer> occupiedDiagonals1 = new HashSet<Integer>();
//    private Set<Integer> occupiedDiagonals2 = new HashSet<Integer>();
//
//    public long numberOfSolutions(int n) {
//        return findSolutions(0, 0, n);
//    }
//
//    private long findSolutions(int row, long count, int n) {
//        for (int col = 0; col < n; col++) {
//            System.out.println("Column: " + col);
//            if (occupiedColumns.contains(col)) {
//                continue;
//            }
//            int diag1 = row - col;
//            System.out.println("Diagonal1: " + diag1);
//            if (occupiedDiagonals1.contains(diag1)) {
//                continue;
//            }
//            int diag2 = row + col;
//            System.out.println("Diagonal2: " + diag2);
//            if (occupiedDiagonals2.contains(diag2)) {
//                continue;
//            }
//
//            if (row == n - 1) {
//                count++;
//                continue;
//            } else {
//                occupiedColumns.add(col);
//                occupiedDiagonals1.add(diag1);
//                occupiedDiagonals2.add(diag2);
//                count = findSolutions(row + 1, count, n);
//
//                occupiedColumns.remove(col);
//                occupiedDiagonals1.remove(diag1);
//                occupiedDiagonals2.remove(diag2);
//            }
//        }
//
//        return count;
//    }
//
//    private int z = 0;
//
//    private int countSolutions(int n) {
//        int solutionsFound = 0;
//
//        int row = 0;
//
//        while (row < n) {
//
//            if (solutionFound(row, n)) {
//
//                System.out.println("Row: " + row + "Solution: " + solutionFound(row, n));
//
//                solutionsFound++;
//            }
//
//            row++;
//        }
//
//        return solutionsFound;
//    }
//
//    private Boolean solutionFound(int row, int n) {
//
//        int[][] pos = new int[n][n];
//        pos[0][row] = 1;
//
//        long queenCounter = 1;
//
//        int i = 1;
//
//        HORIZONTAL:
//        for (; i < n; i++) {
//
//            VERTICAL:
//            for (int j = 0; j < n; j++) {
//
//                //check for row
//                for (int g = i; g >= 1; g--) {
//                    if (pos[g][j] == 1) {
//                        if (j + 1 == n) {
//                            solutionFound(row + 1, n);
//                        }
//                        continue VERTICAL;
//                    }
//                }
//
//                //at this stage you have to check diagonally
//                DIAGONAL_RIGHT_UP:
//                for (int k = i - 1; k >= 1; k--) {
//
//                    if (j >= 1 && pos[k][j - 1] == 1) {
//                        if (j + 1 == n) {
//                            solutionFound(row + 1, n);
//                        }
//                        continue VERTICAL;
//                    }
//
//                }
//
//                DIAGONAL_RIGHT_DOWN:
//                for (int h = i - 1; h >= 1; h--) {
//
//                    if (j < n && pos[h][j + 1] == 1) {
//                        if (j + 1 == n) {
//                            solutionFound(row + 1, n);
//                        }
//                        continue VERTICAL;
//                    }
//
//                }
//
//                pos[i][j] = 1;
//                break;
//            }
//
//        }
//
//        if (i == n) {
//            return true;
//        }
//
////        if (queenCounter == n) {
////            queenCounter = 1;
////            z = row;
////            return true;
////        }
//        return false;
//    }
//
//    public static boolean isAttack(int i, int j, int board[][], int N) {
//        int k, l;
//        // checking for column j
//        for (k = 1; k <= i - 1; k++) {
//            if (board[k][j] == 1) {
//                return true;
//            }
//        }
//
//        // checking upper right diagonal
//        k = i - 1;
//        l = j + 1;
//        while (k >= 1 && l <= N) {
//            if (board[k][l] == 1) {
//                return true;
//            }
//            k = k + 1;
//            l = l + 1;
//        }
//
//        // checking upper left diagonal
//        k = i - 1;
//        l = j - 1;
//        while (k >= 1 && l >= 1) {
//            if (board[k][l] == 1) {
//                return true;
//            }
//            k = k - 1;
//            l = l - 1;
//        }
//
//        return false;
//    }
//
//    public static boolean nQueen(int row, int n, int N, int board[][]) {
//        if (n == 0) {
//            return true;
//        }
//
//        for (int j = 1; j <= N; j++) {
//            if (!isAttack(row, j, board, N)) {
//                board[row][j] = 1;
//
//                if (nQueen(row + 1, n - 1, N, board)) {
//                    return true;
//                }
//
//                board[row][j] = 0; //backtracking
//            }
//        }
//        return false;
//    }
}
