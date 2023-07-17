package user;

import main.Home;
import util.Msg;
import util.TakeInput;
import util.Validate;

public class CreateAccount extends Member {
    public void createAccount() {
        try {
            TakeInput validate = new Validate(); // Upcasting & 100% abstraction

            Msg.createAccount();

            // generate unique id 
            eliteID=111;

            name = validate.fullName();

            age = validate.age();

            gender = validate.gender();

            mobileNumber = validate.mobileNumber();

            email = validate.email();

            username = validate.username();

            password=validate.confirmPassword(validate.psw());

            createUser().details();;
        } catch (Exception e) {
            Msg.error();
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
            Home.menu();
        }
    }
    public User createUser(){
        return new User(eliteID, name, age, gender, email, mobileNumber, username, password);
    }

    // public void details() {
    //     Msg.success();
    //     Msg.welcome();
    //     System.out.println("Name   : " + name);
    //     System.out.println("Age    : " + age);
    //     System.out.println("gender : " + gender);
    //     System.out.println("Mobile : " + mobileNumber);
    //     System.out.println("Email  : " + email);
    //     // System.out.println("Psw : " + getPsw());
    //     Msg.border();
    // }
}
