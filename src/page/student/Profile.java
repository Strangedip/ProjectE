package page.student;


import main.Home;
import user.User;
import util.Actions;
import util.Msg;

public class Profile implements PageTemplate {
    // view details of user page
    public void page(User user) {
        profile(user);
    }
    void profile(User user){
        user.profile();
    }

    // options available at every page
    public void pageOptions() {
        Msg.border();
        System.out.println("1.Home Page       2.Shopping         3.Reward Hunt");
        System.out.println("4.Update Profile  5.Account Details  6.Log out");
    }

    // input for pageOptions
    public void pageInput(User user) {
        Msg.border();
        System.out.print("Enter Choice -> ");
        try {
            switch (Actions.inputInt()) {
                case 1:
                    Page.homePage(user);
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
