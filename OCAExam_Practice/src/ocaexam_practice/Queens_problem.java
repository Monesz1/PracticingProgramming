/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocaexam_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Attila Molnar
 */
public class Queens_problem {

    private static int max_queens = 1;

    private int N = 2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Queens_problem queens_problem = new Queens_problem();
        System.out.print(queens_problem.getQueensNumber(16, 16));
    }

    private int getQueensNumber(int x, int y) {

        ArrayList<String> queens_coord = new ArrayList<>();
        ArrayList<Integer> queens = new ArrayList<>();

        //key, Value // Queens number, Queens position
        HashMap<Integer, Integer> map = new HashMap();

        HORIZONTAL:
        for (int i = 0; i < x; i++) {
            VERTICAL:
            for (int j = 0; j < y; j++) {

                if (j != i && !map.containsKey(i) && !map.containsValue(j) && !queens.contains(j + i)) { // check if horizontal is not equal to vertical index, check horizontal, check vertical

                    int h = i - 1;
                    int b = j - 1;

                    while (h > 0) {
                        if (queens_coord.contains(h + "," + b)) {
                            continue VERTICAL;
                        }
                        --b;
                        --h;
                    }
                    map.put(i, j);
                    queens_coord.add(i + "," + j);
                    queens.add(i + j);

                }
            }
        }

        int number = queens_coord.size();
        queens_coord.clear();

        return max_queens + number;
    }

    private int getQeensNr(int x) {

        int remainder = x % 6;
        int even = 2;
        int odd = 1;

        ArrayList<Integer> even_list = new ArrayList<Integer>();
        ArrayList<Integer> odd_list = new ArrayList<Integer>();
        ArrayList<Integer> queens = new ArrayList<Integer>();

        if (remainder != 2 || remainder != 3) {
            while (even < x) {
                queens.add(even);
                even += 2;
            }
            while (odd < x) {
                queens.add(odd);
                odd += 2;
            }
        } else if (remainder == 2) {
            while (even < x) {
                even_list.add(even);
                even += 2;
            }
            while (odd < x) {
                odd_list.add(odd);
                odd += 2;
            }
            Collections.swap(odd_list, 0, 1);
            odd_list.add(odd_list.get(2));
            odd_list.remove(2);
            queens.addAll(even_list);
            queens.addAll(odd_list);
        } else if (remainder == 3) {
            while (even < x) {
                even_list.add(even);
                even += 2;
            }
            while (odd < x) {
                odd_list.add(odd);
                odd += 2;
            }
            even_list.add(even_list.get(0));
            even_list.remove(0);

            Collections.swap(odd_list, 0, even);

            queens.addAll(even_list);
            queens.addAll(odd_list);
        }

        return queens.size();
    }

    int count = 0;

    public int totalNQueens(int n) {
        int[] queue = new int[n];
        backtrack(0, queue, n);
        return count;
    }

    private void backtrack(int row, int[] queue, int n) {
        if (row == n) {
            count++;
        } else {
            for (int i = 0; i < n; i++) {
                if (isOk(row, i, queue)) {
                    queue[row] = i;
                    backtrack(row + 1, queue, n);
                }
            }
        }
    }

    private boolean isOk(int row, int col, int[] queue) {
        int leftup = col - 1, rightup = col + 1;
        int n = queue.length;
        for (int i = row - 1; i >= 0; i--) {
            if (queue[i] == col) {
                return false;
            }
            if (leftup >= 0 && queue[i] == leftup) {
                return false;
            }
            if (rightup < n && queue[i] == rightup) {
                return false;
            }
            leftup--;
            rightup++;
        }
        return true;
    }
}
