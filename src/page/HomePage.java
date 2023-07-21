package page;

import java.util.Scanner;

import main.Home;
import user.User;
import util.Msg;

//Home Page class containing format and action of home page 
public class HomePage {

    // home page Page details method
    public static void page(User user) {
        Msg.header();
        user.details();
        pageOptions();
        pageInput(user);
    }

    // options available at every page
    public static void pageOptions() {
        System.out.println("1.View Profile    2.Shopping         3.Reward Hunt");
        System.out.println("4.Update Profile  5.Account Details  6.Log out");
    }

    // input for pageOptions
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
