package user;

import util.Action;

public class CreateAccount extends Member {
    public void createAccount() {
        Action.clscr();
        System.out.println("           Create new Account");
        Action.clscr();
        System.out.print("Enter First Name: ");
        String fname = Action.inputStr();

        Action.clscr();
        System.out.print("Enter Last Name: ");
        String sname = Action.inputStr();

        name = fname + " " + sname;

        Action.clscr();
        System.out.print("Enter age: ");
        age = Action.inputInt();

        Action.clscr();
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

        Action.clscr();
        System.out.print("Enter email: ");
        email = Action.inputStr();

        Action.clscr();
        System.out.print("Enter Mobile Number: ");
        mobileNumber = Action.inputLong();

        Action.clscr();
        System.out.print("Enter Username: ");
        username = Action.inputStr();

        Action.clscr();
        System.out.print("Enter Password: ");
        String password = Action.inputStr();

        Action.clscr();
        System.out.print("Enter Re-enter Password: ");
        String confPassword = Action.inputStr();
    }

    public void details() {
        System.out.println("#######################");
        System.out.println("        Welcome        ");
        System.out.println("#######################");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("gender : " + gender);
        System.out.println("Mobile : " + mobileNumber);
        System.out.println("Email  : " + email);
        System.out.println("#######################");
    }
}
