/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_bank.account;

import j_bank.ErrorLabel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Attila Molnar
 */
public final class Validator implements ValidateData {

    private static final String CLASS_NAME = Validator.class.getSimpleName();
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private Logger logger = Logger.getLogger(CLASS_NAME);

    @Override
    public boolean validateSalary(String salary) {

        int s = 0;

        try {
            s = Integer.parseInt(salary);
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_SALARY);
        }

        if (s <= 0) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_SALARY);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateNationality(String nationality) {

        if (nationality.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_NATIONALITY);
            return false;
        }

        if (nationality.matches(".*\\d.*")) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_NATIONALITY);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateMobileNumber(String mobileNumber) {

        if (mobileNumber.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_MOBILE_NUMBER);
            return false;
        }

        if (mobileNumber.matches(".*\\D.*")) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_MOBILE_NUMBER);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateEmail(String email) {

        if (email.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_EMAIL);
            return false;
        }

        logger.log(Level.WARNING, ErrorLabel.INVALID_EMAIL);

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    @Override
    public boolean validateGender(String gender) {

        if (gender.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_GENDER);
            return false;
        }

        if (gender.matches(".*\\d.*")) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_GENDER);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateDOB(String dob) {

        if (dob.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_DOB);
            return false;
        }

        if (dob.matches(".*\\D.*") || dob.length() > 8 || dob.length() < 8) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_DOB);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateAge(int age) {

        if (age <= 16) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_AGE);
            return false;
        }

        return true;
    }

    @Override
    public boolean valiadateId(String id) {

        BankAccount acc = new BankAccount();

        logger.log(Level.INFO, "valiadateId: " + !acc.isIdInList(id));

        if (id.length() > 8 || id.length() < 8 || !acc.isIdInList(id)) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_ID);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateFirstName(String firstName) {

        if (firstName.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_FIRST_NAME);
            return false;
        }

        if (firstName.matches(".*\\d.*")) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_FIRST_NAME);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateLastName(String lastName) {

        if (lastName.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_LAST_NAME);
            return false;
        }

        if (lastName.matches(".*\\d.*")) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_LAST_NAME);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateMidName(String midName) {

        if (midName.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_MID_NAME);
            return false;
        }

        if (midName.matches(".*\\d.*")) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_MID_NAME);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateAddress(String address) {

        //TODO check how the address can be validated
        return true;
    }

    @Override
    public boolean validatePIN(String pin) {

        if (pin.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_PIN);
            return false;
        }

        if (pin.length() < 4 || pin.length() > 4) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_PIN);
            return false;
        }
        return true;
    }

    @Override
    public boolean validateCardNumber(String cardNumber) {

        if (cardNumber.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_CARD_NUMBER);
            return false;
        }

        if (cardNumber.length() < 16 || cardNumber.length() > 16) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_CARD_NUMBER);
            return false;
        }
        return true;
    }

    @Override
    public boolean validateYesOrNo(String response) {

        if (response.isEmpty()) {
            logger.log(Level.WARNING, ErrorLabel.EMPTY_RESPONSE_YN);
            return false;
        }

        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n")) {
            return true;
        }
        logger.log(Level.WARNING, ErrorLabel.INVALID_RESPONSE_YN);

        return false;
    }

    @Override
    public boolean validatePassword(String password, String id) {

        BankAccount acc = new BankAccount();

        if (password.length() > 8 || password.length() < 8 || !acc.checkPassword(password, id)) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_ID);
            return false;
        }
        return true;
    }

}
