package page;

import java.util.Scanner;

import main.Home;
import user.User;
import util.Msg;

//Home Page class containing format and action of home page 
public class HomePage implements PageTemplate {

    // home page Page details method
    public void page(User user) {
        Msg.header();
        System.out.println("---------------  HOME PAGE  -----------------");
        System.out.println("An Economy Independent place for Economy Dependent Students");
        if (user.gender.equals("male")) {
            System.out.println("Welcome to Elite School Mr." + user.name);
        } else if (user.gender.equals("female")) {
            System.out.println("Welcome to Elite School Ms." + user.name);
        } else {
            System.out.println("Welcome to Elite School " + user.name);
        }
        System.out.println("Money does not but skills Matter");
    }

    // options available at every page
    public void pageOptions() {
        System.out.println("1.View Profile    2.Shopping         3.Reward Hunt");
        System.out.println("4.Update Profile  5.Account Details  6.Log out");
    }

    // input for pageOptions
    public void pageInput(User user) {
        System.out.print("Action Input -> ");
        Scanner in = new Scanner(System.in);
        try {
            switch (in.nextInt()) {
                case 1:
                    Page.profilePage(user);
                    break;
                case 2:
                    Page.shop(user);
                    break;
                case 3:
                    Page.hunt(user);
                    break;
                case 4:
                    Page.updateProfile(user);
                    break;
                case 5:
                    Page.accountInfo(user);
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
