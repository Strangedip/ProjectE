package user;

import java.util.ArrayList;

import util.Msg;

abstract class Member {
    public int eliteID;
    public String name;
    public int age;
    public String gender;
    public String email;
    public long mobileNumber;
    public String username="user";
    public String password="pass";

    public String accountType = "Saving Account";

    private long accountNumber=0;
    private int accountLevel = 0;
    private int accountBal = 0;

    void generateAcoountNumber() {
        this.accountNumber = 111l;

    }

    void setPassword(String password) {
        this.password = password;
    }

    String getPsw() {
        return password;
    }
}

public class User extends Member {
    public static ArrayList<Member> members=new ArrayList<>();
    public User(){
    }
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
    public void details() {
        Msg.success();
        Msg.welcome();
        System.out.println("new User");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("gender : " + gender);
        System.out.println("Mobile : " + mobileNumber);
        System.out.println("Email  : " + email);
        // System.out.println("Psw : " + getPsw());
        Msg.border();
    }

}