package page;

import java.util.Scanner;

import main.Home;
import user.User;
import util.Msg;

public class Shop implements PageTemplate{
    //shop page 
    public void page(User user) {
        Msg.header();
        shop();
    }
    public void shop(){
        System.out.println("Shop");
    }

    // options available at every page
    public void pageOptions() {
        System.out.println("1.View Profile    2.Home page        3.Reward Hunt");
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
                    Page.homePage(user);
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
