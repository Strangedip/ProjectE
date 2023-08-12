package page.student;

import main.Home;
import user.User;
import util.Actions;
import util.Msg;

//Home Page class containing format and action of home page 
public class HomePage implements PageTemplate {

    // home page Page details method
    public void page(User user) {
        Msg.newSection();
        Msg.homePageHeader();

        if (user.gender.equals("Male")) {
            System.out.println("Welcome to Elite School Mr. " + user.name);
        } else if (user.gender.equals("Female")) {
            System.out.println("Welcome to Elite School Ms. " + user.name);
        } else {
            System.out.println("Welcome to Elite School " + user.name);
        }
        System.out.println();
    }

    // options available at every page
    public void pageOptions() {
        Msg.border();
        System.out.println("1.View Profile    2.Shopping         3.Reward Hunt");
        System.out.println("4.Update Profile  5.Account Details  6.Log out");
    }

    // input for pageOptions
    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter Choice -> ");
        try {
            switch (Actions.inputInt()) {
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
                    Home.menu();
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
