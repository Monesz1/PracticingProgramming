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
public interface BankerFunctions extends CustomerFunctions {

    void createAccount();

    void lendMoney(int amount);

    void giveAdvice(String advice);

    void promoteService(String advertisment);

}
