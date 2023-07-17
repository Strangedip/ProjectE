package user;



import util.Action;
import util.Msg;
import util.Validate;

public class CreateAccount extends Member {
    public void createAccount() {
        Msg.createAccount();
        System.out.print("Enter First Name: ");
        String fname = Action.inputStr();

        Msg.border();
        System.out.print("Enter Last Name: ");
        String sname = Action.inputStr();

        name = fname + " " + sname;

        age=Validate.age();

        gender = Validate.gender();

        mobileNumber = Validate.mobileNumber();

     
        email = Validate.email();

        Msg.border();
        System.out.print("Enter Username: ");
        username = Action.inputStr();

        String temp=Validate.psw();
        setPassword(Validate.confirmPassword(temp));
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
