/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_bank;

import j_bank.MenuOption.BankMenuOptions;
import j_bank.account.BankAccount;
import j_bank.account.Response;
import j_bank.utils.ATM;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Attila Molnar
 */
public class JBankUI implements CreateUI {

    JBankUI() {
    }

    ;

    static public void din() {

        final int yes;

        for (int i = 0; i < 10; i++) {

        }

    }
    ;

        final static public int yi = 1;

    static public int y;

    private static final String CLASS_NAME = Main.class.getSimpleName();

    private Logger logger = Logger.getLogger(CLASS_NAME);
    private MenuOption menuOption = new MenuOption();
    private Response response = new Response();
    private ATM atm;

    private BankMenuOptions bmo;
    Bank bank = new Bank();

    @Override
    public void createBankIntro() {
        logger.log(Level.INFO,
                bmo.CREATE_ACCOUNT.getOption() + " "
                + bmo.MY_ACCOUNT.getOption() + " "
                + bmo.BANK_INFORMATION.getOption() + " "
                + bmo.USE_ATM.getOption()
        );
        selectBankMenuOption(response.getBankMenuOption());
    }

    private void selectBankMenuOption(int menuOption) {

        BankAccount bankAccount = new BankAccount();

        switch (menuOption) {
            case 1:
                bankAccount.createAccount();
                break;
            case 2:
                bankAccount.signIn();
                break;
            case 3:
                bank.showBankInfo();
                break;
            case 4:
                atm.useAtm();
                break;
            default:
                logger.log(Level.WARNING, ErrorLabel.ONLY_FOUR_OPTION);
                createBankIntro();
        }
    }

    @Override
    public void createBankAccountIntro() {

    }

    @Override
    public void createATMIntro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createBankInfoIntro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
