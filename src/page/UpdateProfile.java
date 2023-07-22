package page;

import java.util.Scanner;

import main.Home;
import user.User;
import util.Msg;

public class UpdateProfile implements PageTemplate {
    public void page(User user) {
        Msg.header();
        update(user);
    }
    void update(User user){
        System.out.println("Update Profile Page");
    }

    // options available at every page
    public void pageOptions() {
        Msg.border();
        System.out.println("1.View Profile    2.Shopping         3.Reward Hunt");
        System.out.println("4.Home Page       5.Account Details  6.Log out");
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
                Page.homePage(user);
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
