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
interface ValidateData {

    boolean validateSalary(String salary);

    boolean validatePassword(String password, String Id);

    boolean validateNationality(String nationality);

    boolean validateMobileNumber(String mobileNumber);

    boolean validateEmail(String email);

    boolean validateGender(String gender);

    boolean validateDOB(String dob);

    boolean validateAge(int age);

    boolean valiadateId(String id);

    boolean validateFirstName(String firstName);

    boolean validateLastName(String lastName);

    boolean validateMidName(String midName);

    boolean validateAddress(String address);

    boolean validatePIN(String pin);

    boolean validateCardNumber(String cardNumber);

    boolean validateYesOrNo(String response);

}
