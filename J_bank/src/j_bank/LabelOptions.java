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
public abstract class LabelOptions {

    public abstract String getBankMenuOptionLabel(int optionNr);

    public abstract String getBankAccountMenuOptionLabel(int optionNr);

    public abstract String getATMMenuOptionLabel(int optionNr);

    public abstract String getWithdrawMenuOptionLabel(int optionNr);

    public abstract String getBankInfoMenuOptionLabel(int optionNr);

}
