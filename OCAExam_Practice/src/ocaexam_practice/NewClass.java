/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocaexam_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Attila Molnar
 */
class Solution {

    List<List<String>> res;

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solveNQueens(14).size());
    }

    public List<List<String>> solveNQueens(int n) {
        res = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new ArrayList<Thread>(n);
        for (int i = 0; i < n; i++) {
            threads.add(new MultiThreadNQueens(i, n));
        }
        for (Thread t : threads) { // run threads in parallel
            t.start();
        }
        for (Thread t : threads) { // block until all threads done
            try {
                t.join();
            } catch (Exception e) {
            }
        }
        return res;
    }

    class MultiThreadNQueens extends Thread {

        Set<Integer> vertical;
        Set<Integer> posDiagonal;
        Set<Integer> negDiagonal;
        List<Integer> currSol;
        int col;
        int n;

        MultiThreadNQueens(int col, int n) {
            vertical = new HashSet<>();
            posDiagonal = new HashSet<>();
            negDiagonal = new HashSet<>();
            currSol = new LinkedList<>();
            this.col = col;
            this.n = n;
        }

        public void run() {
            try {
                vertical.add(col);
                negDiagonal.add(col);
                posDiagonal.add(col);
                currSol.add(col);
                solveNQueens(n, vertical, posDiagonal, negDiagonal, 1, res, currSol);
            } catch (Exception e) {
                // Throwing an exception
                System.out.println("Exception is caught");
            }
        }
    }

    private void solveNQueens(int n, Set<Integer> vertical, Set<Integer> posDiagonal, Set<Integer> negDiagonal, int row, List<List<String>> res, List<Integer> currSol) {
        if (row == n) {
            res.add(formatRes(currSol, n));
        } else {
            for (int col = 0; col < n; col++) {
                if (vertical.contains(col) || negDiagonal.contains(col - row) || posDiagonal.contains(col + row)) {
                    continue;
                }
                vertical.add(col);
                negDiagonal.add(col - row);
                posDiagonal.add(col + row);
                currSol.add(col);
                solveNQueens(n, vertical, posDiagonal, negDiagonal, row + 1, res, currSol);
                vertical.remove(col);
                negDiagonal.remove(col - row);
                posDiagonal.remove(col + row);
                currSol.remove(currSol.size() - 1);
            }
        }
    }

    private List<String> formatRes(List<Integer> currSol, int n) {
        List<String> res = new LinkedList<>();
        for (int solCol : currSol) {
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < n; index++) {
                if (index == solCol) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }

            }
            res.add(sb.toString());
        }
        return res;
    }
}
