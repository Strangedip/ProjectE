package user;

import main.Home;
import util.Msg;
import util.TakeInput;
import util.Validate;

//class for creating new account or user which extends Members class to inherit all members inside Members
public class CreateAccount extends Member {
    // take input and call validation method if valid store in inherited members
    public void createAccount() {
        try {
            // Upcasting & 100% abstraction
            TakeInput validate = new Validate();

            Msg.newSection();

            Msg.createAccount();

            // generate unique id
            eliteID = 111;

            postion = validate.position();

            name = validate.fullName();

            age = validate.age();

            gender = validate.gender();

            mobileNumber = validate.mobileNumber();

            email = validate.email();

            username = validate.username();

            // if both psw and confirmpassword are same it returns password
            password = validate.confirmPassword(validate.psw());

            // creating user with entered value in same class
            createUser();
            Msg.accountCreated();
        } catch (Exception e) {
            Msg.error();
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
            Home.menu();
        }
    }

    // user creating method which returns an User object with all the entered values
    public User createUser() {
        // returns object with formal argument constructor
        return new User(eliteID, postion, name, age, gender, email, mobileNumber, username, password);
    }
}
