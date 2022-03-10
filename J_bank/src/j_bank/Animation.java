/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_bank;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Attila Molnar
 */
public class Animation {

    private static final String CLASS_NAME = Animation.class.getSimpleName();
    Logger logger = Logger.getLogger(CLASS_NAME);

    public void sendEmailText() {

        StringBuilder sb = new StringBuilder("Sending");

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 5; i++) {
                sb.append(" ");
                sb.append(".");
                logger.log(Level.SEVERE, sb.toString());
            }
            sb.delete(sb.length() - 10, sb.length());
        }

    }

    public void loading() {

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < 10; j++) {

            sb.append("▓");
            logger.log(Level.SEVERE, sb.toString());

            for (int i = 0; i < j; i++) {
                sb.insert(i, "▒");
                logger.log(Level.SEVERE, sb.toString());
                sb.insert(i, "░");
                logger.log(Level.SEVERE, sb.toString());
            }
        }
    }

    public void UIframeGeneration() {
    }

    public void run() {

    }
}
