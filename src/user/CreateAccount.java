package user;

import util.Msg;
import util.TakeInput;
import util.Validate;

public class CreateAccount extends Member {
    public void createAccount() {

        TakeInput validate = new Validate(); // Upcasting & 100% abstraction

        name = validate.fullName();

        age = validate.age();

        gender = validate.gender();

        mobileNumber = validate.mobileNumber();

        email = validate.email();

        
        username = validate.username();

        setPassword(validate.confirmPassword(validate.psw()));
    }

    public void details() {
        Msg.success();
        Msg.border();
        Msg.welcome();
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("gender : " + gender);
        System.out.println("Mobile : " + mobileNumber);
        System.out.println("Email  : " + email);
        System.out.println("Psw    : " + getPsw());
        Msg.border();
    }
}
