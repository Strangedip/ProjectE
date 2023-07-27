package main;

import user.Admin;
import user.School;
import user.User;
import util.Action;
import util.Msg;

// Home class containing 2 start menu
// menu method overloading with no formal argument and User obj as formal argument
public class Home {
    // default user
    static User defaultUser = new User();

    // admin
    static User adminUser = new Admin("Admin", "Sandip Gupta", 20, "Male", "test@test.com", 9987978402L, "admin",
            "admin", 9999);

    // menu method new program initiation
    public static void menu() {
        User.userList.add(adminUser);
        User.addNewMember(defaultUser);

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