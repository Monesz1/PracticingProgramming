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
interface GetResponse {

    int getBankMenuOption();

    String getFirstName(String question);

    String getId(String UILabel);

    String getLastName(String question);

    String getMidName(String question, boolean hasMidName);

    String getDOB(String question);

    String getGender(String question);

    String getEmail(String question);

    String getMobileNumber(String question);

    String getNationality(String question);

    String getAddress(String question);

    int getSalary(String question, boolean hasWorkplace);

    int getAge(int year, int month, int day);

    boolean hasMidName(String question);

    boolean hasWorkplace(String question);

    boolean getPassword(String UILabel, String Id);
}
