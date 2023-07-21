package page;

import java.util.Scanner;

import main.Home;
import user.User;
import util.Msg;

// page class containing all page calling methods
public class Page {
    // profile page shows details of the user
    public static void profilePage(User user) {
        user.details();
        ;
    }

    // calls homepage page method
    public static void homePage(User user) {
        HomePage.page(user);
    }

    public static void shop() {

    }

    public static void accountInfo() {

    }

    public static void hunt() {

    }

    public static void updateAccountDetails() {

    }

}
