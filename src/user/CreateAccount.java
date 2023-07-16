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

        Msg.border();
        System.out.print("Enter age: ");
        age = Action.inputInt();

        gender = Validate.gender();

        Msg.border();
        System.out.print("Enter email: ");
        email = Action.inputStr();

        mobileNumber = Validate.mobileNumber();

        Msg.border();
        System.out.print("Enter Username: ");
        username = Action.inputStr();

        Msg.border();
        System.out.print("Enter Password: ");
        String password = Action.inputStr();

        Msg.border();
        System.out.print("Enter Re-enter Password: ");
        String confPassword = Action.inputStr();
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
        Msg.border();
    }
}
