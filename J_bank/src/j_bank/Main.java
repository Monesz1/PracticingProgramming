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
public class Main {

    private static final String CLASS_NAME = Main.class.getSimpleName();

    private static MenuOption menuOption = new MenuOption();
    private static Logger logger = Logger.getLogger(CLASS_NAME);
    private static JBankUI ui = new JBankUI();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        logger.log(Level.INFO, DialogLabel.GREETING1);
        ui.createBankIntro();
    }

}
