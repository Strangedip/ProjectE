package user;

class Member {
    int eliteID;
    String name;
    int age;
    String gender;
    String email;
    long mobileNumber;
    String username;
    private String password;

    String accountType = "Saving Account";
    private long accountNumber;
    private int accountLevel = 0;
    private int accountBal = 0; 

    void generateAcoountNumber() {
        this.accountNumber = 111l;
        
    }

    void setPassword(String password) {
        this.password = password;
    }
}

public class User extends Member {
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

}