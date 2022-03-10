/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_bank;

/**
 *
 * @author Attila Molnar
 */
public final class WarningMessage extends Message {

    private static final String ACC_PASSWORD_TRY_THREE_MORE_TIME = "The password is incorrect. You can try three more times.";
    private static final String ACC_PASSWORD_TRY_TWO_MORE_TIME = "The password is incorrect. You can try two more times.";
    private static final String ACC_PASSWORD_TRY_ONE_MORE_TIME = "The password is incorrect. You can try one more time.";

    private static final String DEPOSIT_MONEY_THREE_MONTHS = "If you deposit money on your savings account for 3 months, you cannot access it only through the local bank";
    private static final String DEPOSIT_MONEY_SIX_MONTHS = "If you deposit money on your savings account for 6 months, you cannot access it only through the local bank";
    private static final String DEPOSIT_MONEY_TWELVE_MONTHS = "If you deposit money on your savings account for 12 months, you cannot access it only through the local bank";

    private static final String SEND_MONEY = "Are you sure you want to send money to the acc. nr: ";
    private static final String NOT_ENOUGH_MONEY = "You have not enough money on your account";
    private static final String NOT_ENOUGH_MONEY_SAVINGS_ACC = "Your balance is to low to open a savings account.";

    @Override
    public String getMessage(int code) {

        String message = "";

        switch (code) {
            case 1:
                message = ACC_PASSWORD_TRY_TWO_MORE_TIME;
                break;
            case 2:
                message = ACC_PASSWORD_TRY_ONE_MORE_TIME;
                break;
            case 3:
                message = DEPOSIT_MONEY_THREE_MONTHS;
                break;
            case 4:
                message = DEPOSIT_MONEY_SIX_MONTHS;
                break;
            case 5:
                message = DEPOSIT_MONEY_TWELVE_MONTHS;
                break;
            case 6:
                message = SEND_MONEY;
                break;
            case 7:
                message = NOT_ENOUGH_MONEY;
                break;
            case 8:
                message = NOT_ENOUGH_MONEY_SAVINGS_ACC;
                break;
        }

        return message;
    }

}
