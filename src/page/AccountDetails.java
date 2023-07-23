package page;

import java.util.Scanner;

import main.Home;
import user.User;
import util.Action;
import util.Msg;
import util.TakeInput;
import util.Validate;

public class AccountDetails implements PageTemplate {
    public void page(User user) {
        Msg.newSection();
        Msg.accountPageHeader();
        accountInfo(user);
    }

    TakeInput validate = new Validate();

    void accountInfo(User user) {
        if (validate.checkCurrentPassword(user.password)) {
            System.out.println();
            System.out.println("Account Number : "+user.accountNumber);
            System.out.println("Account Type : "+user.accountType);
            System.out.println("Account level : "+user.accountLevel);
            System.out.println("Account Balance : "+user.getAccountBal()+" Elite Points");
            System.out.println();
        }
    }

    // options available at every page
    public void pageOptions() {
        Msg.border();
        System.out.println("1.View Profile    2.Shopping         3.Reward Hunt");
        System.out.println("4.Update Profile  5.Home Page        6.Log out");
    }

    // input for pageOptions
    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter Choice -> ");
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
                    Page.homePage(user);
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
