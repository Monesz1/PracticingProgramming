/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_bank.account;

/**
 *
 * @author Attila Molnar
 */
public interface ManagerFunctions extends CustomerFunctions, BankerFunctions {

    void aproveNewAccount(boolean aprove);

    void aproveLoan(boolean aprove);

    void updateInterest(int amount);

    void updateService();

}
