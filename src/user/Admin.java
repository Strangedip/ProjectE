package user;

//admin account class same as USer class (not in use)
// *** use DB 
public class Admin extends User {
    // creating User obj with set admin creds

    public Admin(String position, String name, int age, String gender, String email, long mobileNumber,
            String username, String password, int AccountBal) {
        generateEliteID();
        this.position = position;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.username = username;
        setPassword(password);
        this.accountLevel=99;
        this.accountType="Supreme Admin Account";
        generateAcoountNumber();
        this.setAccountBal(AccountBal);
    }
}