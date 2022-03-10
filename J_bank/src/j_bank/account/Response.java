/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_bank.account;

import j_bank.DialogLabel;
import j_bank.ErrorLabel;
import j_bank.JBankUI;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Attila Molnar
 */
public class Response implements GetResponse {

    private final static String CLASS_NAME = Response.class.getSimpleName();

    private Logger logger = Logger.getLogger(CLASS_NAME);
    private Scanner scanner = new Scanner(System.in);
    private ValidateData validator = new Validator();

    @Override
    public String getFirstName(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine();
        response = validator.validateFirstName(response) ? response : "";

        if (response.isEmpty()) {
            getFirstName(question);
        }

        return response;
    }

    @Override
    public String getLastName(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine();
        response = validator.validateLastName(response) ? response : "";

        if (response.isEmpty()) {
            getLastName(question);
        }

        return response;
    }

    @Override
    public String getMidName(String question, boolean hasMidName) {

        String response = "";

        if (hasMidName) {

            logger.log(Level.INFO, question);
            response = scanner.nextLine();
            response = validator.validateMidName(response) ? response : "";

            if (response.isEmpty()) {
                getMidName(question, hasMidName);
            }
        } else {
            response = null;
        }

        return response;
    }

    @Override
    public String getDOB(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine();
        response = validator.validateDOB(response) ? response : "";

        if (response.isEmpty()) {
            getDOB(question);
        }

        return response;
    }

    @Override
    public String getGender(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine();
        response = validator.validateGender(response) ? response : "";

        if (response.isEmpty()) {
            getGender(question);
        }

        return response;
    }

    @Override
    public String getEmail(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine();
        response = validator.validateEmail(response) ? response : "";

        if (response.isEmpty()) {
            getEmail(question);
        }

        return response;
    }

    @Override
    public String getMobileNumber(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine();
        response = validator.validateMobileNumber(response) ? response : "";

        if (response.isEmpty()) {
            getMobileNumber(question);
        }

        return response;
    }

    @Override
    public String getNationality(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine();
        response = validator.validateNationality(response) ? response : "";

        if (response.isEmpty()) {
            getNationality(question);
        }

        return response;
    }

    @Override
    public int getSalary(String question, boolean hasWorkplace) {

        if (hasWorkplace) {

            logger.log(Level.INFO, question);
            String response = scanner.nextLine();

            response = validator.validateSalary(response) ? response : "";

            if (response.isEmpty()) {
                getSalary(question, hasWorkplace);
            }

            return Integer.parseInt(response);
        }

        return -1;
    }

    @Override
    public String getAddress(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine();
        response = validator.validateAddress(response) ? response : "";

        if (response.isEmpty()) {
            getAddress(question);
        }

        return response;
    }

    @Override
    public boolean hasMidName(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine().trim();
        response = validator.validateYesOrNo(response) ? response : "";

        if (response.equalsIgnoreCase("y")) {
            return true;
        }

        if (response.isEmpty()) {
            hasMidName(question);
        }

        return false;
    }

    @Override
    public boolean hasWorkplace(String question) {

        logger.log(Level.INFO, question);
        String response = scanner.nextLine();
        response = validator.validateYesOrNo(response) ? response : "";

        if (response.isEmpty()) {
            hasWorkplace(question);
        }

        if (response.equalsIgnoreCase("y")) {
            return true;
        }

        return false;
    }

    @Override
    public int getAge(int year, int month, int day) {

        JBankUI ui = new JBankUI();

        int age = Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears();

        age = validator.validateAge(age) ? age : 0;

        if (age == 0) {
            ui.createBankIntro();
        }

        return age;
    }

    @Override
    public int getBankMenuOption() {

        int response = 0;

        try {
            response = scanner.nextInt();
        } catch (Exception e) {
            logger.log(Level.WARNING, ErrorLabel.INVALID_RESPONSE_NR);
            logger.log(Level.WARNING, e.toString());
            exitApplication(scanner.nextLine());
        }

        return response;
    }

    private void exitApplication(String e) {
        logger.log(Level.INFO, DialogLabel.EXIT_APP);
        if (e.equals("exit")) {
            System.exit(0);
        }

    }

    @Override
    public String getId(String UILabel) {

        logger.log(Level.INFO, UILabel);
        String response = scanner.nextLine();
        response = validator.valiadateId(response) ? response : "";

        if (response.isEmpty()) {
            getId(UILabel);
        }

        return response;
    }

    @Override
    public boolean getPassword(String UILabel, String id) {

        logger.log(Level.INFO, UILabel);
        String response = scanner.nextLine().trim();

        if (response.isEmpty()) {
            getPassword(UILabel, id);
        }

        return validator.validatePassword(response, id);
    }

}
