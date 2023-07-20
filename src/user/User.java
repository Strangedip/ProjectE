package user;

import java.util.ArrayList;

import util.Msg;

// default abstract class for members with minimum required details declared 
abstract class Member {
    public int eliteID;
    public String name;
    public int age;
    public String gender;
    public String email;
    public long mobileNumber;

    //defaul username n password
    public String username = "user";
    public String password = "pass";

    public String accountType = "Saving Account";

    private long accountNumber = 0;
    private int accountLevel = 0;
    private int accountBal = 0;

    // ***generate random account number for each user
    void generateAcoountNumber() {
        this.accountNumber = 111l;
    }

    // setter method for password (not in user currently)
    void setPassword(String password) {
        this.password = password;
    }
    
    // getter method for password (not in user currently)
    String getPsw() {
        return password;
    }
}

// User class to inherit all members of Member class for initializing new user
public class User extends Member {
    //list of members created are strored in an ArrayList for reference (not in use)
    public static ArrayList<Member> members = new ArrayList<>();

    // no formal argument constructor to create a default user at start
    public User() {
    }

    // constructor to initialize User with all required details inherited from Members
    User(int eliteID, String name, int age, String gender, String email, long mobileNumber, String username,
            String password) {
        this.eliteID = eliteID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.username = username;
        setPassword(password);
        generateAcoountNumber();
    }

    // method to print some information of the user
    public void details() {
        Msg.welcome();
        System.out.println("--------------- USER PROFILE ----------------");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("gender : " + gender);
        System.out.println("Mobile : " + mobileNumber);
        System.out.println("Email  : " + email);
        // System.out.println("Psw : " + getPsw());
        Msg.border();
    }

}