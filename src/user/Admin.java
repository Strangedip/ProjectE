package user;

//admin account class same as USer class (not in use)
// *** use DB 
public class Admin extends Member {
    // creating User obj with set admin creds
    static User admin1 = new User(1, "admin1", 20, "make", "test@test.com", 9987978402L, "admin", "admin");

    Admin(int eliteID, String name, int age, String gender, String email, long mobileNumber, String username,
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

    public static void adminDetails() {
        admin1.details();
    }
}