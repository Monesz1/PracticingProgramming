/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_bank.account;

import j_bank.Animation;
import j_bank.ErrorLabel;
import j_bank.JBankUI;
import j_bank.UILabel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Attila Molnar
 */
public final class BankAccount extends AccountManager {

    private final static String CLASS_NAME = BankAccount.class.getSimpleName();

    private final static String CREATE_ACCOUNT_QUESTION1 = "What is your first name?";
    private final static String CREATE_ACCOUNT_QUESTION2 = "What is your last name?";
    private final static String CREATE_ACCOUNT_QUESTION3 = "Do you have a middle name? (Type 'Y' for yes and 'N' for no)";
    private final static String CREATE_ACCOUNT_QUESTION4 = "What is your middle name?";
    private final static String CREATE_ACCOUNT_QUESTION5 = "What is your date of birth?(Format: YYYYMMDD)";
    private final static String CREATE_ACCOUNT_QUESTION6 = "What is your gender?";
    private final static String CREATE_ACCOUNT_QUESTION7 = "What is your email?";
    private final static String CREATE_ACCOUNT_QUESTION8 = "What is your mobile number?";
    private final static String CREATE_ACCOUNT_QUESTION9 = "What is your nationality?";
    private final static String CREATE_ACCOUNT_QUESTION10 = "Are you currently working? (Type 'Y' for yes and 'N' for no)";
    private final static String CREATE_ACCOUNT_QUESTION11 = "What is your current salary? ($)";
    private final static String CREATE_ACCOUNT_QUESTION12 = "What is your current address?";
    private final static String FIRST_PIN = "0000";

    private final static String SUBJECT = "To create a new account we'll need some information: ";
    private final static String SET_UP_NEW_PASSWORD = "Please, set up your new password";

    private Scanner scanner = new Scanner(System.in);
    private Logger logger = Logger.getLogger(CLASS_NAME);
    private Client client = new Client();
    private GetResponse response = new Response();
    private Animation animation = new Animation();
    private JBankUI ui;
    private int index;

    private List<Client> clientList = new ArrayList<Client>();

    boolean isIdInList(String id) {

        logger.log(Level.INFO, "clientList size " + clientList.size());

        if (!clientList.isEmpty()) {
            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).getId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkPassword(String password, String id) {

        if (!clientList.isEmpty()) {
            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).getId().equals(id)
                        && clientList.get(i).getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void signIn() {

        getAccount(response.getId(UILabel.ID));

    }

    private int attempts = 0;

    private void getAccount(String id) {

        if (response.getPassword(UILabel.PASSWORD, id) && attempts < 4) {
            if (isFirstTimeSignIn(id)) {
                logger.log(Level.INFO, SET_UP_NEW_PASSWORD);
                changePassword(id);
            }
            ui.createBankAccountIntro();
        } else {
            ++attempts;

        }

    }

    private boolean isFirstTimeSignIn(String id) {

        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getId().equals(id)
                    && clientList.get(i).isFirstSignIn()) {
                clientList.get(i).setFirstSignIn(false);
                index = i;
                return true;
            }
        }
        return false;
    }

    private void changePassword(String id) {
        logger.log(Level.INFO, UILabel.PASSWORD);
        String password = scanner.nextLine();
        logger.log(Level.INFO, UILabel.CONFIRM_PASSWORD);
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            logger.log(Level.INFO, ErrorLabel.TRY_AGAIN);
            changePassword(id);
        } else {
            clientList.get(index).setPassword(confirmPassword);
        }
    }

    @Override
    public void createAccount() {
        create();
    }

    private void create() {

//        clearClientList();

        /*Your one time password is: 0BOqqBoX
        Your account ID is: nc841909*/
        logger.log(Level.INFO, SUBJECT);
        client.setFirstName(response.getFirstName(CREATE_ACCOUNT_QUESTION1));
        client.setLastName(response.getLastName(CREATE_ACCOUNT_QUESTION2));
        client.setMidName(response.getMidName(CREATE_ACCOUNT_QUESTION4,
                response.hasMidName(CREATE_ACCOUNT_QUESTION3)));
        client.setDateOfBirth(response.getDOB(CREATE_ACCOUNT_QUESTION5));
        client.setAge(response.getAge(
                Integer.parseInt(client.getDateOfBirth().substring(0, 4)),
                Integer.parseInt(client.getDateOfBirth().substring(4, 6)),
                Integer.parseInt(client.getDateOfBirth().substring(6, 8))));
        client.setGender(response.getGender(CREATE_ACCOUNT_QUESTION6));
        client.setEmail(response.getEmail(CREATE_ACCOUNT_QUESTION7));
        client.setMobileNumber(response.getMobileNumber(CREATE_ACCOUNT_QUESTION8));
        client.setNationality(response.getNationality(CREATE_ACCOUNT_QUESTION9));
        client.setWorking(response.hasWorkplace(CREATE_ACCOUNT_QUESTION10));
        client.setSalary(response.getSalary(CREATE_ACCOUNT_QUESTION11, client.isWorking()));
        client.setAddress(response.getAddress(CREATE_ACCOUNT_QUESTION12));
        client.setId(createId());
        client.setCardNumber(createCardNumber());
        client.setPIN(FIRST_PIN);
        client.setPassword(createOTP());

        storeAccountInfo();
        sendEmail(client.getPassword(), client.getId());

    }

    private void sendEmail(String otp, String id) {

        animation.sendEmailText();
        animation.loading();
        logger.log(Level.SEVERE, "You've received a new email!");
        System.out.println("Your one time password is: " + otp);
        System.out.println("Your account ID is: " + id);
        logger.log(Level.INFO, "clientList size " + clientList.size());
        ui.createBankIntro();
    }

    /**
     * This method creates a one time password for the client.
     *
     * @return String
     */
    private String createOTP() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lower = upper.toLowerCase(Locale.ROOT);
        final String digits = "0123456789";
        final String alphanum = upper + lower + digits;

        final char[] symbols = alphanum.toCharArray();
        final char[] buf = new char[8];

        Random random = new Random();

        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

    private String createCardNumber() {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            sb.append(String.valueOf(random.nextInt(9999)));
        }

        if (!clientList.isEmpty()) {
            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).getCardNumber().equals(sb.toString())) {
                    createCardNumber();
                }
            }
        }

        return sb.toString();
    }

    private String createId() {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int nr = random.nextInt(999_999);

        for (int i = 0; i < 2; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        sb.append(nr);

        if (!clientList.isEmpty()) {
            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).getId().equals(sb.toString())) {
                    createId();
                }
            }
        }

        return sb.toString();
    }

    private void storeAccountInfo() {

        clientList.add(new Client(client.getSalary(), client.getNationality(),
                client.getMobileNumber(), client.getEmail(), client.getGender(),
                client.getDateOfBirth(), client.getAge(), client.getId(), client.getFirstName(),
                client.getLastName(), client.getMidName(), client.getAddress(),
                client.getPIN(), client.getCardNumber(), client.isWorking(),
                client.getPassword(), true));
    }

    private void clearClientList() {
        clientList.clear();
    }

    @Override
    void deleteAccount(String id) {
        delete(id);
    }

    private void delete(String id) {

        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getId().equals(id)) {
                clientList.remove(i);
            }
        }
    }

    @Override
    void findAccount(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
