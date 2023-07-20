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

    // options available at every page
    public static void homePageOptions() {
        System.out.println("1.View Profile    2.Shopping         3.Reward Hunt");
        System.out.println("4.Update Profile  5.Account Details  6.Log out");
    }

    // input for homePageOptions
    public static void pageInput(User user) {
        System.out.print("Action Input -> ");
        Scanner in = new Scanner(System.in);
        try {
            switch (in.nextInt()) {
                case 1:
                    Page.profilePage(user);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    Msg.loggedOut();
                    Home.menu(user);
                    break;
                default:
                    System.out.println("Invalid Option");
                    pageInput(user);
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
            pageInput(user);
        }
    }
}
