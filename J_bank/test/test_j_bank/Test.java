/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_j_bank;

import j_bank.MenuOption.BankMenuOptions;
import java.util.logging.Logger;

/**
 *
 * @author Attila Molnar
 */
public class Test {

    BankMenuOptions bm;
    private static final String CLASS_NAME = Test.class.getSimpleName();
    Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] x = new int[]{};

        int i = 0;

        while (i < 5) {
            System.out.print("" + i);
        }
        i++;

        //        int Y = 10;
        //        increase(Y);
        //        System.out.println(x[0]);
        //        BankAccount ba = new BankAccount();
        //        MenuOption menu = new MenuOption();
        //        Test test = new Test();
        //        try {
        //            test.updateProgress();
        //        } catch (Exception ex) {
        //            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        //        }
    }

    static void increase(int in) {

        in++;
    }

    public void loading() throws Exception {

        String anim = "|/-\\";
        for (int x = 0; x < 100; x++) {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
            System.out.write(data.getBytes());
            Thread.sleep(100);
        }

//        StringBuilder sb = new StringBuilder();
//
//        for (int j = 0; j < 10; j++) {
//
//            sb.append("▓");
//            logger.log(Level.SEVERE, sb.toString());
//
//            for (int i = 0; i <; i++) {
//                sb.insert(i, "▒");
//                logger.log(Level.SEVERE, sb.toString());
//                sb.insert(i, "░");
//                logger.log(Level.SEVERE, sb.toString());
//            }
//        }
    }

    void updateProgress() throws Exception {
        final int width = 50; // progress bar width in chars

        System.out.print("[");
        int i = 0;
        for (; i <= width; i++) {
            System.out.print(".");
            Thread.sleep(100);
        }
        for (; i < width; i++) {
            System.out.print(" ");
        }
        System.out.print("]");
    }

}

class x {

    int hello = 0x010ab;

    x() {
    }

    x(int num) {
    }
}

class more extends x {

    more(int hello
    ) {

    }

    public void lolo() {
        return;
    }

    x bab = new x();
    x babo = new more(5);
    static more ma = new more(5);

    public static void main(String[] args) {

        ma.lolo();
    }

}
