package user;

import util.Action;
import util.Msg;

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

        Msg.border();
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other");
        System.out.print("Enter gender: ");
        switch (Action.inputInt()) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            case 3:
                gender = "Other";
                break;
            default:
                System.out.println("Invalid Input, try Again");
        }

        Msg.border();
        System.out.print("Enter email: ");
        email = Action.inputStr();

        Msg.border();
        System.out.print("Enter Mobile Number: ");
        mobileNumber = Action.inputLong();

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
