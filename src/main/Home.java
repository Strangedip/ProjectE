package main;

import user.School;
import util.Actions;
import util.Msg;

// Home class containing 2 start menu
// menu method overloading with no formal argument and User obj as formal argument
public class Home {
    
    // menu method new program initiation
    public static void menu() {

        Msg.newSection();
        Msg.header();
        System.out.println();
        System.out.println(" 1. User Login");
        System.out.println(" 2. Create new account");
        System.out.println(" 3. Admin Login");
        System.out.println(" 4. School Introduction");
        System.out.println(" Enter any other key to exit program");
        Msg.border();
        System.out.print("Enter Choice -> ");
        try {
            int userInput = Actions.inputInt();
            switch (userInput) {
                case 1:
                    Actions.login();
                    break;
                case 2:
                    Actions.createAccount();
                    break;
                case 3:
                    Actions.adminLogin();
                    break;
                case 4:
                    School.schoolIntro();
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