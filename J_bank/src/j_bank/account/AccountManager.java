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
public abstract class AccountManager {

    public abstract void signIn();

    public abstract void createAccount();

    abstract void deleteAccount(String id);

    abstract void findAccount(String id);
}
