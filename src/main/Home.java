package main;

import user.User;
import util.Action;
import util.Msg;

// Home class containing 2 start menu
// menu method overloading with no formal argument and User obj as formal argument
public class Home {

    //menu method with no formal argument for new program initiation
    public static void menu() {
        Msg.newSection();
        Msg.header();
        System.out.println();
        System.out.println(" 1. User Login");
        System.out.println(" 2. Create new account");
        System.out.println(" 3. Admin Login");
        System.out.println(" Enter any other key to exit program");
        Msg.border();
        System.out.print("Enter Choice -> ");
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

    // menu with User obj as formal argument to retrieve User obj members when logging in
    public static void menu(User user) {
        Msg.newSection();
        Msg.header();
        System.out.println();
        System.out.println(" 1. User Login");
        System.out.println(" 2. Create new account");
        System.out.println(" 3. Admin Login");
        System.out.println(" Enter any other key to exit program");
        Msg.border();
        System.out.print("Enter Choice -> ");
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