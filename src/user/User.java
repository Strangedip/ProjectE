package user;

import java.util.ArrayList;

import page.Task;
import util.Msg;

// default abstract class for members with minimum required details declared 
public class User {

    // list of members created are strored in an ArrayList for reference (not in
    // use)
    public static ArrayList<User> userList = new ArrayList<>();

    //count of users in system
    public static int currentUserCount = userList.size();


    public ArrayList<Task> taskList = new ArrayList<>();

    public int eliteID = -1;
    public String name = "Default User";
    public int age = -1;
    public String gender = "Not Set";
    public String email = "default@email.com";
    public long mobileNumber = -1l;
    public String position = "Visitor";

    // default username n password
    public String username = "user";
    public String password = "pass";

    public String accountType = "Elite Student Account";

    public int accountLevel = -1;
    public long accountNumber = -1l;
    private int accountBal = 100;

    // default constructor for sub class constructors
    public User() {
        this.accountType="Visitor Account";
    }

    // initiating User Object with all details for each object of User class
    User(String position, String name, int age, String gender, String email, long mobileNumber,
            String username,
            String password) {
        generateEliteID();
        this.position = position;
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

    public void generateEliteID() {
        this.eliteID = userList.size() + 100;
    }

    public int getAccountBal() {
        return accountBal;
    }

    public void setAccountBal(int newBal) {
        this.accountBal = newBal;
    }

    // ***generate random account number for each user
    void generateAcoountNumber() {
        this.accountNumber = 100000+eliteID ;
    }

    // setter method for password (not in user currently)
    void setPassword(String password) {
        this.password = password;
    }

    // getter method for password (not in user currently)
    String getPsw() {
        return password;
    }

    public static boolean addNewMember(User user) {
        for (User u : userList) {
            if (u.eliteID == user.eliteID) {
                return false;
            }
        }
        userList.add(user);
        return true;
    }

    // ns task adding method for each user
    public boolean addTask(Task task) {
        for (Task t : taskList) {
            if (t.taskID == task.taskID) {
                return false;
            }
        }
        taskList.add(task);
        return true;
    }

    // method to print some information of the user
    public void details() {
        Msg.newSection();
        Msg.profilePageHeader();
        System.out.println("EliteID   : " + eliteID);
        System.out.println("Position  : " + position);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("gender    : " + gender);
        System.out.println("Mobile    : " + mobileNumber);
        System.out.println("Email     : " + email);
        // System.out.println("Psw : " + getPsw());
    }
}