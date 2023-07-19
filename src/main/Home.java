package main;

import user.User;
import util.Action;
import util.Msg;

public class Home {
    public static void menu() {
        Msg.header();
        System.out.println(" 1. User Login");
        System.out.println(" 2. Create new account");
        System.out.println(" 3. Admin Login");
        System.out.println(" Enter any other key to exit program");
        Msg.border();
        System.out.print("Enter you Choice -> ");
        try {
            int userInput = Action.inputInt();
            switch (userInput) {
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
                    Msg.thankyou();
                    System.exit(0);
            }
        } catch (Exception e) {
            Msg.thankyou();
            System.exit(0);
        }
    }

    public static void menu(User user) {
        Msg.header();
        System.out.println(" 1. User Login");
        System.out.println(" 2. Create new account");
        System.out.println(" 3. Admin Login");
        System.out.println(" Enter any other key to exit program");
        Msg.border();
        System.out.print("Enter you Choice -> ");
        try {
            int userInput = Action.inputInt();
            switch (userInput) {
                case 1:
                    Action.login(user);
                    break;
                case 2:
                    Action.createAccount();
                    break;
                case 3:
                    Action.adminLogin();
                    break;
                default:
                    Msg.thankyou();
                    System.exit(0);
            }
        } catch (Exception e) {
            Msg.thankyou();
            System.exit(0);
        }
    }
}