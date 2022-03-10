/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_bank;

/**
 * This class helps to return a categorised menu set label options.
 *
 * @author Attila Molnar
 */
public final class MenuOption {

    public enum BankMenuOptions {

        CREATE_ACCOUNT("1.Create Account"),
        MY_ACCOUNT("2.My Account"),
        BANK_INFORMATION("3.Bank Information"),
        USE_ATM("4.Use The ATM");

        private String option;

        BankMenuOptions(String option) {
            this.option = option;
        }

        public String getOption() {
            return option;
        }
    };

    enum BankAccountMenuOptions {

        SHOW_BALANCE("1.Show my balance"),
        SEND_MONEY("2.Send Money"),
        CHANGE_ACCOUNT_INFO("3.Change Account Info"),
        CREATE_SAVINGS_ACCOUNT("4.Create Savings Account"),
        REPORT_FRAUD("5.Report Fraud");

        private String option;

        BankAccountMenuOptions(String option) {
            this.option = option;
        }

        public String getOption() {
            return option;
        }
    };

    enum ATMMenuoptions {

        WITHDRAW_MONEY("1.Withdraw Money"),
        DEPOSIT_MONEY("2.Deposit Money"),
        CHANGE_PIN("3.Change PIN");

        private String option;

        ATMMenuoptions(String option) {
            this.option = option;
        }

        public String getOption() {
            return option;
        }
    };

    enum BankInfoMenuOptions {

        CHOOSE_LOCATION("Choose Location"),
        SHOW_OPENING_TIME("Show Opening Time"),
        SHOW_CONTACT("Show Contact"),
        SHOW_CAREER("Show Career"),
        SIGN_IN("Sign In");

        private String option;

        BankInfoMenuOptions(String option) {
            this.option = option;
        }

        public String getOption() {
            return option;
        }
    };

    enum WithdrawMenuoptions {

        WITHDRAW_50$("50$"),
        WITHDRAW_100$("100$"),
        WITHDRAW_250$("250$"),
        WITHDRAW_500$("500$"),
        WITHDRAW_1000$("1000$"),
        WITHDRAW_2500$("2500$"),
        WITHDRAW_OTHER("Other Ammount");

        private String option;

        WithdrawMenuoptions(String option) {
            this.option = option;
        }

        public String getOption() {
            return option;
        }
    };

}
