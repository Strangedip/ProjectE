package main;

import util.Action;
import util.Msg;

public class Home {
    public static void menu() {
        Msg.border();
        System.out.println(" 1. User Login");
        System.out.println(" 2. Create new account");
        System.out.println(" 3. Admin Login");
        System.out.println(" 0. to exit program");
        Msg.border();
        System.out.print("Enter you Choice -> ");
        int userInput = Action.inputInt();
        switch (userInput) {
            case 0:
                Msg.thankyou();
                System.exit(0);
                break;
            case 1:
                Action.login();
                break;
            case 2:
                Action.createAccount();
                break;
            case 3:
                Action.adminLogin();
                break;
            default:
                Msg.border();
                System.out.println("Invalid Input, Enter valid option");
                menu();
        }
    }

}