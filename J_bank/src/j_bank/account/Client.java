/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_bank.account;

/**
 * This class creates client objects. When a user creates a bank account will be
 * automatically treated as a client.
 *
 * @author Attila Molnar
 */
public class Client {

    /*comments on the variables are redundant because the name of the variable
     (identifier) is quite readable in code but as a code convention is recommended
     */
    private int salary;             //client salary
    private String nationality;     //client nationality
    private String mobileNumber;    //client mobile number
    private String email;           //client email
    private String gender;          //client gender
    private String dateOfBirth;     //client birthday
    private int age;                //client age
    private String Id;              //client ID
    private String firstName;       //client first name
    private String lastName;        //client last name
    private String midName;         //client middle name
    private String address;         //client address
    private String PIN;             //client pin code
    private String cardNumber;      //client card number
    private boolean working;        //client is working or not
    private String password;        //client password
    private boolean firstSignIn;   //client signs in first time

    /**
     * This constructor helps to collect client information implicitly
     */
    public Client() {
    }

    /**
     * This constructor helps to store the object fields on the array
     * explicitly.
     *
     * @param salary Client salary.
     * @param nationality Client nationality
     * @param mobileNumber Client mobileNumber
     * @param email Client email
     * @param gender Client gender
     * @param dateOfBirth Client birthday
     * @param age Client age
     * @param Id Client Id
     * @param firstName Client first name
     * @param lastName Client last name
     * @param midName Client middle name
     * @param address Client address
     * @param PIN Client pin code
     * @param cardNumber Client card number (16 digits)
     * @param isWorking Client is working or not?
     */
    public Client(int salary, String nationality, String mobileNumber,
            String email, String gender, String dateOfBirth, int age, String Id,
            String firstName, String lastName, String midName, String address,
            String PIN, String cardNumber, boolean isWorking, String password,
            boolean firstSignIn) {
        this.salary = salary;
        this.nationality = nationality;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.midName = midName;
        this.address = address;
        this.PIN = PIN;
        this.cardNumber = cardNumber;
        this.working = isWorking;
        this.password = password;
        this.firstSignIn = firstSignIn;
    }

    public void setFirstSignIn(boolean firstSignIn) {
        this.firstSignIn = firstSignIn;
    }

    public boolean isFirstSignIn() {
        return firstSignIn;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
