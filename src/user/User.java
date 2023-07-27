package user;

import java.util.ArrayList;
import java.util.HashSet;

import util.Msg;
import page.Hunt;
import page.Task;

// default abstract class for members with minimum required details declared 
abstract class Member {

    // list of members created are strored in an ArrayList for reference (not in
    // use)
    public static ArrayList<Member> members = new ArrayList<>();

    public int eliteID = -1;
    public String name = "Default User";
    public int age = -1;
    public String gender = "Not Set";
    public String email = "default@email.com";
    public long mobileNumber = -1l;
    public String postion = "Visitor";

    // default username n password
    public String username = "user";
    public String password = "pass";

    public String accountType = "Elite Student Account";

    public int accountLevel = -1;
    public long accountNumber = -1l;
    private int accountBal = 100;

    public int getAccountBal() {
        return accountBal;
    }

    public void setAccountBal(int newBal) {
        this.accountBal = newBal;
    }

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

    // list of tasks user is assigned with
    public HashSet<Task> tasks = new HashSet<>();

    // no formal argument constructor to create a default user at start // visitor
    // account
    public User() {
    }

    // constructor to initialize User with all required details inherited from
    // Members
    User(int eliteID,String position, String name, int age, String gender, String email, long mobileNumber, String username,
            String password) {
        this.eliteID = eliteID;
        this.postion=position;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.username = username;
        setPassword(password);
        generateAcoountNumber();
        this.accountLevel = 1;
        setAccountBal(100);
    }

    // method to print some information of the user
    public void details() {
        Msg.newSection();
        Msg.profilePageHeader();
        System.out.println("EliteID   : " + eliteID);
        System.out.println("Position  : " + postion);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("gender    : " + gender);
        System.out.println("Mobile    : " + mobileNumber);
        System.out.println("Email     : " + email);
        // System.out.println("Psw : " + getPsw());
    }

}